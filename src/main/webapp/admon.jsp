<%@ page import="com.fcfm.tienda.models.Usuario" %>
<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 8/25/2015
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>Tienda Max Admin</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
    <link href='http://fonts.googleapis.com/css?family=Quicksand|Josefin+Slab' rel='stylesheet' type='text/css'>
    <link href="css/jquery-ui.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/popup.css">
    <% Usuario user = (Usuario)session.getAttribute("user");
        String userName = user.getNombreUsuario() + " " +  user.getApellidoUsuario();
    %>
</head>
<body>
    <div class="wrapper">
        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="five columns">
                        <h1>Administración</h1>
                    </div>
                    <div class="two colums" >
                        <a href="venta.jsp" class="button"><p>ir a venta</p></a>
                        <a class="button" href="index.jsp"><p>Salir</p></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="popup scrolleable"></div>
        <div class="content">
            <div class="container body-content">
                <div class="row">
                    <h2 class="twelve columns">Bienvenido <%= userName%></h2>
                </div>
                <div class="row">
                  <div class="six columns">
                    <h3>Usuarios</h3>
                    <a href="#" class="button ajx-btn" id="addUser">Agregar Usuario</a>
                    <a href="#" class="button ajx-btn" id="editUser">Editar Usuario</a>
                  </div>
                  <div class="six columns">
                    <h3>Productos</h3>
                    <a href="#" class="button ajx-btn" id="addProduct">Agregar Producto</a>
                    <a href="#" class="button ajx-btn" id="editProduct">Editar Producto</a>
                  </div>
                </div>
                <div class="row">
                  <div class="six columns">
                    <h3>Cajas</h3>
                      <a href="#" class="button ajx-btn" id="editCashier">Editar Caja</a>
                  </div>
                  <div class="six columns">
                    <h3>Reportes</h3>
                      <a href="#" class="button ajx-btn" id="hourlyReport">Reporte de Hora</a>
                      <a href="#" class="button ajx-btn" id="shiftReport">Reporte de Turno</a>
                      <a href="#" class="button ajx-btn" id="dailyReport">Reporte de Dia</a>
                      <a href="#" class="button ajx-btn " id="weekleReport">Reporte de Semana</a>
                  </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jQuery.js" type="text/javascript"></script>
    <script src="js/jquery.validate.js" type="text/javascript"></script>
    <script src="js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="js/admon.js" type="text/javascript"></script>
    <script src="js/search.js" type="text/javascript"></script>
</body>
</html>
