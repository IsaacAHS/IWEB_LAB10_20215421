package com.example.lab9_20215421.Servlet;

import com.example.lab9_20215421.Beans.Jugador;
import com.example.lab9_20215421.Daos.DaoJugador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="ServletJugador", value="/ServletJugador")
public class ServletJugador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        response.setContentType("text/html");

        String action= request.getParameter("action")==null? "lista":request.getParameter("action");
        DaoJugador daoJugador= new DaoJugador();
        switch(action){
            case "lista":
                ArrayList<Jugador> listaJugador = daoJugador.listarJugador();

                request.setAttribute("lista", listaJugador);
                RequestDispatcher rd= request.getRequestDispatcher("vistas/listaJugador.jsp");
                rd.forward(request,response);
                break;

            case "new":
                request.getRequestDispatcher("vistas/nuevoJugador.jsp").forward(request,response);
                break;

            case "del":
                String ide = request.getParameter("id");
                Jugador jugador= daoJugador.buscarPorId(ide);
                if(jugador!=null){
                    try{
                        daoJugador.borrar(ide);
                    }catch(SQLException e){
                        System.out.println("Log:exception"+e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath()+"/ServletJugador");
                break;

        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html");
        DaoJugador daoJugador= new DaoJugador();
        String action = request.getParameter("action")==null ? "crear" : request.getParameter("action");

        switch(action){
            case "crear":
                String nombre= request.getParameter("nombre");
                String edad= request.getParameter("edad");
                String posicion= request.getParameter("posicion");
                String club= request.getParameter("club");
                String seleccion= request.getParameter("seleccion");

                Jugador jugador1= new Jugador();

                jugador1.setNombre(nombre);
                jugador1.setEdad(Integer.parseInt(edad));
                jugador1.setPosicion(posicion);
                jugador1.setClub(club);
                jugador1.setSnIdSeleccion(Integer.parseInt(seleccion));

                daoJugador.crear(jugador1);
                response.sendRedirect(request.getContextPath()+"/ServletJugador");
                request.getRequestDispatcher("vistas/nuevoJugador.jsp");
                break;



        }

    }
}
