package com.fcfm.tienda.servlets;


import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.services.UsuarioProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 8/25/2015.
 */
@WebServlet(name = "LoginServlet",
        urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Usuario ses;
        ses = UsuarioProvider.getUsuario(username,password);
        if(ses != null){
            request.setAttribute("username",ses.getNombreUsuario() + " " +ses.getApellidoUsuario());
            if(ses.isAdministrador()){
                request.getRequestDispatcher("/admon.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/venta.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("invalid",true);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
