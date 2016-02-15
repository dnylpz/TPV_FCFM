package com.fcfm.tienda.servlets;


import com.fcfm.tienda.models.Domicilio;
import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.services.DomicilioDAO;
import com.fcfm.tienda.services.ImagenDAO;
import com.fcfm.tienda.services.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 10/13/2015.
 */
@WebServlet(name = "UsersServlet",
            urlPatterns = "/serveusers")
@MultipartConfig
public class UsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //LOCALS
        Imagen usrImg;
        int idUser;
        Domicilio dir;
        //END LOCALS
        if(request.getParameter("servicio").equals("borrar")){
            UsuarioDAO.deleteUsuario(Integer.parseInt(request.getParameter("itemId")));
        }else {
            //parameters
            try {
                idUser = Integer.parseInt(request.getParameter("idUser"));
            }catch(NumberFormatException nfe){
                nfe.printStackTrace();
                idUser = 0;
            }
            String username = request.getParameter("username");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String password = request.getParameter("password");
            boolean admin = false;
            boolean sex = false;
            if (request.getParameter("isAdmin") != null) {
                admin = true;
            }
            if(request.getParameter("sexo").equals("H")){
                sex = true;
            }
            String dateString = request.getParameter("fNan");
            Date fNacimiento = new Date();
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                fNacimiento = sdf.parse(dateString);
            }catch(ParseException pe){
                pe.printStackTrace();
            }
            String nDEstudios = request.getParameter("nDEs");
            String pais = request.getParameter("pais");
            String estado = request.getParameter("estado");
            String ciudad = request.getParameter("ciudad");
            int cp = 0;
            try {
                 cp = Integer.parseInt(request.getParameter("zipcode"));
            }catch(NumberFormatException nfe){
                nfe.printStackTrace();
            }
            String colonia = request.getParameter("colonia");
            String calle = request.getParameter("calle");
            String numero = request.getParameter("numero");
            String RFC = request.getParameter("RFC");
            String CURP = request.getParameter("CURP");


            dir = DomicilioDAO.saveDomicilio(pais,estado,ciudad,cp,colonia,calle,numero);
            Part fotoPart = request.getPart("fotoUsuario");

            usrImg = ImagenDAO.parseImage(fotoPart); //generates BLOB, construct and save an image

            if (request.getParameter("servicio").equals("editar")) {
                if (UsuarioDAO.updateUsuario(idUser, username, nombre, apellido, password, usrImg, admin,sex,fNacimiento,nDEstudios,dir,RFC,CURP)) {
                    request.getRequestDispatcher("/admon.jsp").forward(request, response);
                } else {
                    response.setStatus(500);
                }
            } else {
                if (UsuarioDAO.agregarUsuario(username, nombre, apellido, password, usrImg, admin,sex,fNacimiento,nDEstudios,dir,RFC,CURP)) {
                    request.getRequestDispatcher("/admon.jsp").forward(request, response);
                } else {
                    response.setStatus(500);

                }
            }
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
