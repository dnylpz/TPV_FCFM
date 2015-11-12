package com.fcfm.tienda.servlets;

import com.fcfm.tienda.services.ProductoDAO;
import com.fcfm.tienda.services.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jose.espinoza.lopez on 10/1/2015.
 */
@WebServlet(name = "AdmonAjaxServlet",
            urlPatterns= "/adminajax"
)
public class AdmonAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to =  request.getParameter("to");
        System.out.println(to);

        if(to.equals("editUser")){
            request.setAttribute("searchFor","Usuario");
            request.setAttribute("action","Editar");
            request.getRequestDispatcher("templates/admin/search.jsp").forward(request,response);
        }
        if( to.equals("addUser")){
            request.setAttribute("action","agregar");
            request.getRequestDispatcher("templates/admin/addUser.jsp").forward(request,response);
        }
        if(to.equals("doEditUser")){
            request.setAttribute("action","editar");
            request.setAttribute("usuario", UsuarioDAO.getUsuarioById(Integer.parseInt(request.getParameter("itemId"))));
            request.getRequestDispatcher("templates/admin/addUser.jsp").forward(request,response);
        }
        if(to.equals("addProduct")){
            request.setAttribute("action","agregar");
            request.getRequestDispatcher("templates/admin/addProduct.jsp").forward(request,response);
        }
        if(to.equals("editProduct")){
            request.setAttribute("searchFor","Producto");
            request.setAttribute("action","editar");
            request.getRequestDispatcher("templates/admin/search.jsp").forward(request,response);
        }
        if(to.equals("doEditProduct")){
            request.setAttribute("action","editar");
            request.setAttribute("producto", ProductoDAO.getProductoWithId(Integer.parseInt(request.getParameter("itemId"))));
            request.getRequestDispatcher("templates/admin/addProduct.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
