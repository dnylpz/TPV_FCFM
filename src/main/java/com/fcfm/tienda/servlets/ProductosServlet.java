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
        String nombre;
        String descripcion;
        long UPC;
        Part imagen;
        float precio;
        Imagen prImg;

        nombre = request.getParameter("nombre");
        descripcion = request.getParameter("descripcion");
        UPC = Long.parseLong(request.getParameter("upc"));
        imagen = request.getPart("imagen");
        precio = Float.parseFloat(request.getParameter("precio"));
        prImg = ImagenServices.parseImage(imagen);
        ProductoServicios.agregarProducto(nombre,descripcion,UPC,prImg,precio);
        request.getRequestDispatcher("/admon.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
