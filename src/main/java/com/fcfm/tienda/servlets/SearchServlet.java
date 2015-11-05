package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.services.UsuarioServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/5/2015.
 */
@WebServlet(name = "SearchServlet",
            urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in the search post");
        String param = request.getParameter("searchParam");
        List<Usuario> resultado = UsuarioServices.searchUsuarios(param);
        request.setAttribute("usuarios", resultado);
        request.getRequestDispatcher("templates/search/userlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
