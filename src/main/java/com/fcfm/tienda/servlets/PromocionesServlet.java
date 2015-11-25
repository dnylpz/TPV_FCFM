package com.fcfm.tienda.servlets;

import com.fcfm.tienda.services.PromocionDAO;

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
 * Created by jose.espinoza.lopez on 11/25/2015.
 */
@WebServlet(name = "PromocionesServlet",
            urlPatterns = "/promo")
public class PromocionesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int prodId = Integer.parseInt(request.getParameter("idProducto"));
            String tipoPromo = request.getParameter("tPromo");
            float valorPromo = Float.parseFloat(request.getParameter("vPromo"));
            Date vigencia = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            vigencia = sdf.parse(request.getParameter("vigPromo"));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        PromocionDAO.savePromo(tipoPromo,valorPromo,vigencia,prodId);
        request.getRequestDispatcher("admon.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
