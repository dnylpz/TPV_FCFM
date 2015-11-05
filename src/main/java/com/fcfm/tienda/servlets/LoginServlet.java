package com.fcfm.tienda.servlets;


import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.services.UsuarioServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 8/25/2015.
 */
@WebServlet(name = "LoginServlet",
        urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private boolean forwarded;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwarded = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Usuario ses;
        if(session.getAttribute("user") != null){
            ses = (Usuario) session.getAttribute("user");
        }else{
            ses = UsuarioServices.getUsuario(username, password);
            if(ses!=null){
                session.setAttribute("user",ses);
                session.setMaxInactiveInterval(30*60);
            } else {
                request.setAttribute("invalid", true);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                forwarded = true;
            }
        }
        if(!forwarded) {
            if (ses != null && ses.isAdministrador()) {
                request.getRequestDispatcher("/admon.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/venta.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
