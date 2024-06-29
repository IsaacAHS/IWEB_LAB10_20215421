package com.example.lab9_20215421.Daos;

import com.example.lab9_20215421.Beans.Estadio;

import java.sql.*;
import java.util.ArrayList;

public class DaoEstadio {

    public static ArrayList<Estadio> listarEstadio(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        ArrayList<Estadio> listaEstadio= new ArrayList<Estadio>();
        String url= "jdbc:mysql://localhost:3306/lab7";
        String username= "root";
        String password= "root";

        String sql="select idEstadio, nombre, provincia, club from estadio";

        try(Connection conn= DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery()){
            while (rs.next()){
                Estadio estadio= new Estadio();

                estadio.setIdEstadio(rs.getInt(1));
                estadio.setNombre(rs.getString(2));
                estadio.setProvincia(rs.getString(3));
                estadio.setClub(rs.getString(4));



                listaEstadio.add(estadio);

            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listaEstadio;
    }

    public Estadio buscarPorId(String id){
        Estadio estadio= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";

        String sql = "select * from estadio where idEstadio = ?";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    estadio = new Estadio();

                    estadio.setIdEstadio(rs.getInt(1));
                    estadio.setNombre(rs.getString(2));
                    estadio.setProvincia(rs.getString(3));
                    estadio.setClub(rs.getString(4));


                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estadio;
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

        String sql = "delete from estadio where idEstadio = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,id);
            pstmt.executeUpdate();

        }
    }

    public void crear(Estadio estadio){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";
        String sql="INSERT INTO estadio (nombre,provincia,club)"+
                "VALUES (?,?,?)";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1, estadio.getNombre());
            pstmt.setString(2,estadio.getProvincia());
            pstmt.setString(3, estadio.getClub());




            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
