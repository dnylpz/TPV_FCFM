package com.fcfm.tienda.servlets;

import com.fcfm.tienda.services.VideoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 12/9/2015.
 */
@WebServlet(name = "ActivaVideoServlet",
            urlPatterns = "/activavideo")
public class ActivaVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("activarVideo!");
        int id = Integer.parseInt(request.getParameter("id"));
        if(id == 1){
            request.getServletContext().removeAttribute("vid");
        }else{
            String dat = request.getParameter("vigencia");
            VideoDAO.activaVideo(id, dat);
            request.getServletContext().setAttribute("vid",VideoDAO.getVideo());
        }
        request.getRequestDispatcher("/admon.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
