package com.fcfm.tienda.servlets;


import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.services.ImagenServices;
import com.fcfm.tienda.services.UsuarioServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

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
        if(request.getParameter("servicio").equals("borrar")){
            UsuarioServices.deleteUsuario(Integer.parseInt(request.getParameter("itemId")));
        }else {
            //parameters
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            String username = request.getParameter("username");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String password = request.getParameter("password");
            boolean admin = false;
            if (request.getParameter("isAdmin") == "true") {
                admin = true;
            }

            Part fotoPart = request.getPart("fotoUsuario");

            usrImg = ImagenServices.parseImage(fotoPart); //generates BLOB, construct and save an image

            if (request.getParameter("servicio").equals("Editar")) {
                if (UsuarioServices.updateUsuario(idUser, username, nombre, apellido, password, usrImg, admin)) {
                    request.getRequestDispatcher("/admon.jsp").forward(request, response);
                } else {
                    response.setStatus(500);
                }
            } else {
                if (UsuarioServices.agregarUsuario(username, nombre, apellido, password, usrImg, admin)) {
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
