package com.fcfm.tienda.servlets;


import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.services.ImagenServices;
import com.fcfm.tienda.services.UsuarioServices;
import com.fcfm.tienda.utils.Utils;

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
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 10/13/2015.
 */
@WebServlet(name = "UsersServlet",
            urlPatterns = "/serveusers")
@MultipartConfig
public class UsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String password = request.getParameter("password");
        Part fotoPart = request.getPart("fotoUsuario");
        Imagen usrImg = null;
        boolean admin = false;
        if(request.getParameter("isAdmin") == "true"  ){
            admin = true;
        }

        String fileName = getFileName(fotoPart);
        String fileType = fotoPart.getContentType();
        if(fileType.contains("image")) {
            System.out.println(fileName);
            System.out.println(fileType);
            InputStream fileContent = fotoPart.getInputStream();
            int read = 0;
            byte[] foto = new byte[1024];
            while ((read = fileContent.read(foto)) != -1) {
                System.out.println(read);
            }
            try {
                Blob img = new SerialBlob(foto);
                usrImg = ImagenServices.imagenProvider(img, fileName, fileType);
                if (UsuarioServices.saveUsuario(username, nombre, apellido, password, usrImg, admin)) {
                    request.getRequestDispatcher("/admon.jsp").forward(request, response);
                }
                else {
                    response.setStatus(500);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            fileContent.close();
        }else{
            response.setStatus(500);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
