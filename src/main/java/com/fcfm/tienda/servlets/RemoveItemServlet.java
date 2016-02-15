package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Detalle;
import com.fcfm.tienda.models.Producto;
import com.fcfm.tienda.models.Promocion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
@WebServlet(name = "RemoveItemServlet",
            urlPatterns = "/removeIt")
public class RemoveItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        Detalle d = (Detalle) request.getSession().getAttribute("venta");
        Producto b = d.getProductos().get(index-1);
        double imp = (b.getPrecio()*(b.getImpuesto()/100));
        double descuento = 0;
        if (b.getPromociones()!= null) {
            for (Promocion a : b.getPromociones()) {
                if (a.getVigencia().after(new Date())) {
                    if (a.getTipo().equals("porcentaje")) {
                        descuento = b.getPrecio()*(a.getValor()/100);

                    }
                    if (a.getTipo().equals("combo")) {
                        descuento = b.getPrecio() + imp;
                    }
                }
            }
        }
        double total = (b.getPrecio()+imp-descuento);
        d.setTotal(d.getTotal() - total);
        d.getProductos().remove(index-1);
        d.getProductos().size();
        request.getSession().setAttribute("venta",d);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
