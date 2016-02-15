package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Detalle;
import com.fcfm.tienda.models.FormaDePago;
import com.fcfm.tienda.services.DetalleDAO;
import com.fcfm.tienda.services.FormaDePagoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 11/12/2015.
 */
@WebServlet(name = "CloseOutServlet",
            urlPatterns = "/pagar")
public class CloseOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pagoId = Integer.parseInt(request.getParameter("formadepago"));
        FormaDePago pago = FormaDePagoDAO.getMetodoDePago(pagoId);
        Detalle ticket = (Detalle)request.getSession().getAttribute("venta");
        ticket.setFormaDePago(pago);
        DetalleDAO.saveDetalle(ticket);
        request.getSession().removeAttribute("venta");
        request.getRequestDispatcher("venta.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
