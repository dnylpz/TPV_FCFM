package com.fcfm.tienda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 10/1/2015.
 */
@WebServlet(name = "AdmonAjaxServlet",
            urlPatterns= "/adminajax"
)
public class AdmonAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to =  request.getParameter("to");
        if(to.equals("users")){
            request.getRequestDispatcher("templates/admin/users.jsp").forward(request,response);
        }
        if( to.equals("home")){
            request.getRequestDispatcher("templates/admin/home.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
