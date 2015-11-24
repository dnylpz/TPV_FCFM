package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Detalle;
import com.fcfm.tienda.models.Producto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
@WebServlet(name = "RemoveItemServlet",
            urlPatterns = "/removeIt")
public class RemoveItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        Detalle a = (Detalle) request.getSession().getAttribute("venta");
        Producto b = a.getProductos().get(index-1);
        a.setTotal(a.getTotal() - (b.getPrecio()+(b.getPrecio()*(b.getImpuesto()/100))));
        a.getProductos().remove(index-1);
        request.getSession().setAttribute("venta",a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
