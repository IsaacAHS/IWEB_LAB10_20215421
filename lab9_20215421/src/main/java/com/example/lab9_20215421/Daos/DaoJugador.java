package com.example.lab9_20215421.Daos;

import com.example.lab9_20215421.Beans.Jugador;

import java.sql.*;
import java.util.ArrayList;

public class DaoJugador {
    public static ArrayList<Jugador> listarJugador(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        ArrayList<Jugador> listaJugador= new ArrayList<Jugador>();
        String url= "jdbc:mysql://localhost:3306/lab7";
        String username= "root";
        String password= "root";

        String sql="select idJugador,nombre,edad,posicion,club,sn_idSeleccion from jugador";

        try(Connection conn= DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery()){
            while (rs.next()){
                Jugador jugador= new Jugador ();

                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));
                jugador.setSnIdSeleccion(rs.getInt(6));

                listaJugador.add(jugador);

            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listaJugador;
    }

    public Jugador buscarPorId(String id){
        Jugador jugador= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";

        String sql = "select * from jugador where idJugador = ?";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    jugador = new Jugador();

                    jugador.setIdJugador(rs.getInt(1));
                    jugador.setNombre(rs.getString(2));
                    jugador.setEdad(rs.getInt(3));
                    jugador.setPosicion(rs.getString(4));
                    jugador.setClub(rs.getString(5));
                    jugador.setSnIdSeleccion(rs.getInt(6));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jugador;
    }

    public void borrar(String id) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";

        String sql = "delete from jugador where idJugador = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,id);
            pstmt.executeUpdate();

        }
    }

    public void crear(Jugador jugador){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";
        String sql="INSERT INTO jugador (nombre,edad,posicion, club, sn_idSeleccion)"+
                "VALUES (?,?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,jugador.getNombre());
            pstmt.setInt(2,jugador.getEdad());
            pstmt.setString(3,jugador.getPosicion());
            pstmt.setString(4,jugador.getClub());
            pstmt.setInt(5,jugador.getSnIdSeleccion());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
