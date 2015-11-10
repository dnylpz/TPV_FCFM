package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.services.ImagenServices;
import com.fcfm.tienda.services.ProductoServicios;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 11/9/2015.
 */
@WebServlet(name = "ProductosServlet",
            urlPatterns = "/serveproductos")
@MultipartConfig
public class ProductosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servicio = request.getParameter("servicio");

        if(servicio.equals("borrar")){
            int idProducto = Integer.parseInt(request.getParameter("itemId"));
            ProductoServicios.deleteProducto(idProducto);
        }else {
            String nombre;
            String descripcion;
            long UPC;
            Part imagen;
            double precio;
            Imagen prImg;
            int existencia;

            nombre = request.getParameter("nombre");
            descripcion = request.getParameter("descripcion");
            UPC = Long.parseLong(request.getParameter("upc"));
            imagen = request.getPart("imagen");
            precio = Double.parseDouble(request.getParameter("precio"));
            existencia = Integer.parseInt(request.getParameter("existencia"));
            prImg = ImagenServices.parseImage(imagen);
            if (servicio.equals("editar")) {
                int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                ProductoServicios.updateProducto(idProducto, nombre, descripcion,
                        UPC, prImg, precio, existencia);
            } else {
                ProductoServicios.agregarProducto(nombre, descripcion, UPC, prImg, precio, existencia);
            }
        }
        request.getRequestDispatcher("/admon.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
