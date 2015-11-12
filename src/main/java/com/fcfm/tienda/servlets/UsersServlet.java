package com.fcfm.tienda.servlets;


import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.services.ImagenDAO;
import com.fcfm.tienda.services.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 10/13/2015.
 */
@WebServlet(name = "UsersServlet",
            urlPatterns = "/serveusers")
@MultipartConfig
public class UsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //locals
        Imagen usrImg;
        int idUser;
        if(request.getParameter("servicio").equals("borrar")){
            UsuarioDAO.deleteUsuario(Integer.parseInt(request.getParameter("itemId")));
        }else {
            //parameters
            try {
                idUser = Integer.parseInt(request.getParameter("idUser"));
            }catch(NumberFormatException nfe){
                nfe.printStackTrace();
                idUser = 0;
            }
            String username = request.getParameter("username");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String password = request.getParameter("password");
            boolean admin = false;
            if (request.getParameter("isAdmin").equals("true")) {
                admin = true;
            }

            Part fotoPart = request.getPart("fotoUsuario");

            usrImg = ImagenDAO.parseImage(fotoPart); //generates BLOB, construct and save an image

            if (request.getParameter("servicio").equals("editar")) {
                if (UsuarioDAO.updateUsuario(idUser, username, nombre, apellido, password, usrImg, admin)) {
                    request.getRequestDispatcher("/admon.jsp").forward(request, response);
                } else {
                    response.setStatus(500);
                }
            } else {
                if (UsuarioDAO.agregarUsuario(username, nombre, apellido, password, usrImg, admin)) {
                    request.getRequestDispatcher("/admon.jsp").forward(request, response);
                } else {
                    response.setStatus(500);

                }
            }
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
