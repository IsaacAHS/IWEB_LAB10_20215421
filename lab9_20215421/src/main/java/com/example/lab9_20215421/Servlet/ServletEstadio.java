package com.example.lab9_20215421.Servlet;

import com.example.lab9_20215421.Beans.Estadio;
import com.example.lab9_20215421.Daos.DaoEstadio;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="ServletEstadio", value="/ServletEstadio")

public class ServletEstadio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String action= request.getParameter("action")==null? "lista":request.getParameter("action");
        DaoEstadio daoEstadio= new DaoEstadio();
        switch(action){
            case "lista":
                ArrayList<Estadio> listaEstadio = daoEstadio.listarEstadio();

                request.setAttribute("lista", listaEstadio);
                RequestDispatcher rd= request.getRequestDispatcher("vistas/listaEstadio.jsp");
                rd.forward(request,response);
                break;

            case "new":
                request.getRequestDispatcher("vistas/nuevoEstadio.jsp").forward(request,response);
                break;

            case "del":
                String ide = request.getParameter("id");
                Estadio estadio= daoEstadio.buscarPorId(ide);
                if(estadio!=null){
                    try{
                        daoEstadio.borrar(ide);
                    }catch(SQLException e){
                        System.out.println("Log:exception"+e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath()+"/ServletEstadio");
                break;

        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        DaoEstadio daoEstadio= new DaoEstadio();
        String action = request.getParameter("action")==null ? "crear" : request.getParameter("action");

        switch(action){
            case "crear":
                String nombre= request.getParameter("nombre");
                String provincia= request.getParameter("provincia");
                String club= request.getParameter("club");

                Estadio estadio1= new Estadio();

                estadio1.setNombre(nombre);
                estadio1.setProvincia(provincia);
                estadio1.setClub(club);

                daoEstadio.crear(estadio1);


                response.sendRedirect(request.getContextPath()+"/ServletEstadio");
                request.getRequestDispatcher("vistas/nuevoEstadio.jsp");
                break;



        }

    }

}
