package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Detalle;
import com.fcfm.tienda.models.Producto;
import com.fcfm.tienda.services.ProductoDAO;
import com.fcfm.tienda.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/10/2015.
 */
@WebServlet(name = "com.fcfm.tienda.servlets.VentaServlet",
            urlPatterns = "/agregaproducto")
public class VentaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String articulo = request.getParameter("articulo");
        Detalle venta = (Detalle) request.getSession().getAttribute("venta");
        if(venta == null){
            venta = new Detalle();
        }
        try{
            Producto result;
            long UPC = Long.parseLong(articulo);
            result = ProductoDAO.getProductoWithUPC(UPC);
            double total = venta.getTotal();
            total += result.getPrecio();
            total = Utils.round(total,2);
            venta.setTotal(total);
            venta.getProductos().add(result);
            request.getSession().removeAttribute("venta");
            request.getSession().setAttribute("venta",venta);
            request.setAttribute("producto",result);
            int count = venta.getProductos().size();
            request.setAttribute("count",count);
            request.getRequestDispatcher("templates/Venta/product.jsp").forward(request,response);
        }catch(NumberFormatException nfe){
            List<Producto> result;
            result = ProductoDAO.buscaProducto(articulo);
            request.setAttribute("productos",result);
            request.getRequestDispatcher("templates/search/productlist.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
