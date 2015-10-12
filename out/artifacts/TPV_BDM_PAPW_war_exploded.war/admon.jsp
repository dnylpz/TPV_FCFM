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
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/popup.css"
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
                <div class="five columns">
                    <nav class="navigation">
                        <ul>
                            <li><a href="#" id="home">Home</a></li>
                            <li><a href="#" id="users">Usuarios</a></li>
                            <li><a href="#">Cajas</a></li>
                            <li><a href="#">Reportes</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="two colums" >
                    <a href="venta.jsp" class="button"><p>ir a venta</p></a>
                    <a class="button" href="index.jsp"><p>Salir</p></a>
                </div>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="popup"></div>
        <div class="container">
            <div class="row">
                <h2 class="twelve columns">Bienvenido <%= userName%></h2>
            </div>
            <div class="row">
                <div class="six columns">
                    <h3 class="twelve columns">Cajas Disponibles</h3>
                    <table class="twelve columns">
                        <thead>
                        <tr>
                            <td>Disponibles</td>
                            <td>Activas</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>15</td>
                            <td>8</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="six columns">
                    <h3 class="twelve columns">Usuarios</h3>
                    <table class="tweleve columns">
                        <thead>
                        <tr>
                            <td>Nombre</td>
                            <td>Login</td>
                            <td>Status</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Daniel Espinoza</td>
                            <td>dnylpz</td>
                            <td>Activo en Consola</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="six columns">
                    <h3 class="twelve columns">Video Activo</h3>
                    <div class="twelve columns"><img src="img/video_placeholder.jpg" alt="vide" style=" height:120px; width: 150px"/></div>
                </div>
                <div class="six columns">
                    <h3 class="twelve columns">Imagen Activa</h3>
                    <div class="twelve columns"><img src="img/video_placeholder.jpg" alt="img" style=" height:120px; width: 150px"/></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jQuery.js" type="text/javascript"></script>
<script src="js/admon.js" type="text/javascript"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js" type="text/javascript"></script>
</body>
</html>
