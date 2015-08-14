package com.fcfm.tienda.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dany on 8/14/2015.
 */
@WebServlet(name = "ServletPrueba", urlPatterns = "/prueba")
public class ServletPrueba extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("prueba"));
        request.setAttribute("resultado",request.getParameter("prueba"));
        request.getRequestDispatcher("pruebaResultado.xhtml").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
