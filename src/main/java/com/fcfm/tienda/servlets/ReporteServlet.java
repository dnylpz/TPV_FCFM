package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Reporte;
import com.fcfm.tienda.services.ReporteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
@WebServlet(name = "ReporteServlet",
            urlPatterns = "/reporte")
public class ReporteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("entro a reporte");
        List<Reporte> r = new ArrayList<Reporte>();
        Date inic = new Date();
        Date fin = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            inic = sdf.parse(request.getParameter("inic"));
            fin = sdf.parse(request.getParameter("fin"));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        r = ReporteDAO.getReporteFechas(inic, fin);
        request.setAttribute("reportes", r);
        System.out.println(r.get(1).getHoraDetalle().toString("HH:mm"));
        request.getRequestDispatcher("templates/admin/resultadosReporte.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
