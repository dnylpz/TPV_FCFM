package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
@WebServlet(name = "videoServlet",
            urlPatterns = "/vid")
public class videoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("entro al vid");
        String nom1 = request.getParameter("vidName");
        Date vig = new Date();
        String nom2 = request.getParameter("defVidName");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            vig = sdf.parse(request.getParameter("vigencia"));

        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        Video seteado = new Video(nom1,vig);
        if(nom2 != null) {
            Video def = new Video(nom2, null);
            request.getServletContext().setAttribute("vidDef",def);
        }
        request.getServletContext().setAttribute("vid",seteado);
        request.getRequestDispatcher("admon.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
