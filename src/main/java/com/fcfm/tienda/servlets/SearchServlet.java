package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Producto;
import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.services.ProductoDAO;
import com.fcfm.tienda.services.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/5/2015.
 */
@WebServlet(name = "SearchServlet",
            urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchFor= request.getParameter("searchFor");
        String param = request.getParameter("searchParam");
        if(searchFor.equals("Usuario")) {
            List<Usuario> resultado;
            resultado = UsuarioDAO.searchUsuarios(param);
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("templates/search/userlist.jsp").forward(request, response);
        }
        if(searchFor.equals("Producto")){
            List<Producto> resultado;
            resultado = ProductoDAO.buscaProducto(param);
            request.setAttribute("resultado", resultado);
            request.setAttribute("venta",false);
            request.getRequestDispatcher("templates/search/productlist.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
