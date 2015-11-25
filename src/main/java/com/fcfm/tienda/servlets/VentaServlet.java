package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Detalle;
import com.fcfm.tienda.models.Producto;
import com.fcfm.tienda.models.Promocion;
import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.services.ProductoDAO;
import com.fcfm.tienda.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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
            Usuario a = (Usuario)request.getSession().getAttribute("user");
            venta.setUsuario(a);
        }
        try{
            Producto result;
            long UPC = Long.parseLong(articulo);
            result = ProductoDAO.getProductoWithUPC(UPC);
            int counter=0;
            for(Producto x : venta.getProductos()){
                if(x.equals(result)){
                    counter++;
                }
            }
            if(result.getExistencia()>counter) {
                double total = venta.getTotal();
                float porciento = result.getImpuesto()/100;
                double precio = result.getPrecio()+(result.getPrecio() * porciento);
                total +=precio;
                if (result.getPromociones()!= null) {
                    for (Promocion a : result.getPromociones()) {
                        if (a.getVigencia().after(new Date())) {
                            if (a.getTipo().equals("porcentaje")) {
                                double descuento = result.getPrecio()*(a.getValor()/100);
                                total -= descuento;
                                precio -= descuento;
                            }
                            if (a.getTipo().equals("combo")) {
                                float val = (counter+1) % a.getValor();
                                if (val == 0) {
                                    total -= precio;
                                    precio -= precio;
                                }
                            }
                        }
                    }
                }
                venta.getProductos().add(result);

                venta.setTotal(Utils.round(total,2));
                request.setAttribute("existe",true);
                request.setAttribute("precio",precio);
            }else
            {
                request.setAttribute("existe",false);
            }
            request.setAttribute("producto", result);
            request.getSession().setAttribute("venta", venta);
            request.setAttribute("count", venta.getProductos().size());

            request.getRequestDispatcher("templates/Venta/product.jsp").forward(request,response);
        }catch(NumberFormatException nfe){
            List<Producto> result;
            result = ProductoDAO.buscaProducto(articulo);
            request.setAttribute("resultado",result);
            request.setAttribute("venta",true);
            request.getRequestDispatcher("templates/search/productlist.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
