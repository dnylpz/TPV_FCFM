package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.services.ImagenDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by jose.espinoza.lopez on 10/27/2015.
 */
@WebServlet(name = "com.fcfm.tienda.servlets.ImageServlet",
            urlPatterns = "/imagen")
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Imagen a = ImagenDAO.getImagen(id);
        if(a!=null) {
            response.setContentType(a.getTipoImagen());
            ServletOutputStream out = response.getOutputStream();
            int length = 0;
            InputStream in = null;
            try {
                response.setContentLength((int) a.getBytes().length());
                in = a.getBytes().getBinaryStream();
                length = (int) a.getBytes().length();
                int bufferSz = 1024;
                byte[] buffer = new byte[bufferSz];
                while ((length = in.read(buffer)) != -1) {
                    System.out.println("writting " + length + " bytes");
                    out.write(buffer, 0, length);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.setContentLength(length);
            response.setContentType(a.getTipoImagen());
            if (in != null) {
                in.close();
            }
            out.flush();
        }else{
            response.setStatus(404);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
