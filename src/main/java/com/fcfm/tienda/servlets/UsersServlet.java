package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Usuario;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jose.espinoza.lopez on 10/13/2015.
 */
@WebServlet(name = "UsersServlet",
            urlPatterns = "/serveusers")
@MultipartConfig
public class UsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String password = request.getParameter("password");
        Part foto = request.getPart("fotoUsuario");
        InputStream fileContent = foto.getInputStream();
        byte[] fotoBytes = IOUtils.readFully(fileContent,-1,true);
        String isAdmin = request.getParameter("isAdmin");
        System.out.println(username);
        System.out.println(name);
        System.out.println(apellido);
        System.out.println(password);
        System.out.println(isAdmin);
        System.out.println(fotoBytes.toString());


        //if(username != null){
         //   Usuario us = new Usuario()
       // }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
