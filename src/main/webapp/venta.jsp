<%@ page import="com.fcfm.tienda.models.Usuario" %>
<%--
  Created by IntelliJ IDEA.
  User: dany
  Date: 8/14/2015
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>TiendaMax</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
    <link href='http://fonts.googleapis.com/css?family=Quicksand|Josefin+Slab' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/popup.css">

    <% Usuario user = (Usuario)session.getAttribute("user");
        String userName = user.getNombreUsuario() + " " +  user.getApellidoUsuario();
        int idFoto = user.getFotoUsuario().getIdImagen();
    %>
</head>
<body>
<div class="wrapper">
    <div class="section header">
        <div class="container">
            <div class="row">
                <div class="four columns">
                    <img src="${pageContext.request.contextPath}/imagen?id=${applicationScope["empresa"].getLogo().getIdImagen()}">
                </div>
                <h1 class="four columns">Venta</h1>
                <div class="two columns offset-by-two">
                    <% if(user.isAdministrador()){%>
                        <a class="button" href="./login" ><p>Ir a admin</p></a>
                    <%}%>
                <a class="button" href="logout"><p>Salir</p></a>
                </div>
            </div>
        </div>
    </div>
    <div class="popup metodos"></div>
    <div class="popup resultlist"></div>
    <div class="main">
        <div class="products scrolleable">
            <div class="container" id="product-list">
            </div>
        </div>
        <div class="sidebar">
            <div class="container">
                <div class="row">
                    <p class="four columns offset-by-four">Le Atiende</p>
                </div>
                <div class="row">
                    <div class="two columns">
                        <img  class="circle" heigh="150px" width="150px" src="${pageContext.request.contextPath}/imagen?id=<%=idFoto%>" />
                    </div>
                </div>
                <div class="row">
                    <p class="six columns offset-by-three"><%= userName%></p>
                </div>
                <div class="row addform">
                    <form id="addproduct" action="agregaproducto" method="POST" >
                        <label>INGRESE ARTICULO</label>
                        <input type="text" name="arti" id="articulo"/>
                        <input type="submit" value="Agregar"/>
                    </form>
                </div>
                <div class="row">
                    <img class="video" src="img/video_placeholder.jpg" alt="video"  height="100px" width="150px"/>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="container footer-content">
            <div class="row">
                <h2 class="five columns">TOTAL A PAGAR:</h2>
                <div id="totalOut"></div>
                <a href="#" id="closeSale" class="two columns button">Pagar</a>
            </div>
            <div class="row">
                <div class="two columns">
                    <img src="" alt="cliente"/>
                </div>
                <div class="four columns">
                    <p>
                        No Cliente:00000
                        Nombre: Juan Martinez
                        Puntos: 09923
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jQuery.js"></script>
<script src="js/search.js"></script>
<script src="js/venta.js"></script>
</body>
</html>
