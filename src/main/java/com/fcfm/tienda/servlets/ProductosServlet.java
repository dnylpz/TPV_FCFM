package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.services.ImagenDAO;
import com.fcfm.tienda.services.ProductoDAO;

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
            ProductoDAO.deleteProducto(idProducto);
        }else {
            String nombre;
            String descripcion;
            long UPC;
            Part imagen;
            double precio;
            Imagen prImg;
            int existencia;
            String depto;
            String uMedida;
            int impuesto;

            nombre = request.getParameter("nombre");
            descripcion = request.getParameter("descripcion");
            UPC = Long.parseLong(request.getParameter("upc"));
            imagen = request.getPart("imagen");
            precio = Double.parseDouble(request.getParameter("precio"));
            existencia = Integer.parseInt(request.getParameter("existencia"));
            prImg = ImagenDAO.parseImage(imagen);
            depto = request.getParameter("depto");
            uMedida = request.getParameter("uMedida");
            impuesto = Integer.parseInt(request.getParameter("impuesto"));
            if (servicio.equals("editar")) {
                int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                ProductoDAO.updateProducto(idProducto, nombre, descripcion,
                        UPC, prImg, precio, existencia,depto,uMedida,impuesto);
            } else {
                ProductoDAO.agregarProducto(nombre, descripcion, UPC, prImg, precio, existencia,depto,uMedida,impuesto);
            }
        }
        request.getRequestDispatcher("/admon.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
