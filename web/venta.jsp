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
                    <img src="img/tLogo.png">
                </div>
                <h1 class="four columns">Venta</h1>
                <div class="two columns offset-by-two">
                <a class="button" href="./login" <% if(!user.isAdministrador()){%> style="visibility:hidden" <%}%>><p>Ir a admin</p></a>
                <a class="button" href="index.jsp"><p>Salir</p></a>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="products">
            <div class="container" id="product-list">
                <div class="product row">
                    <div class="two columns offset-by-two columns product-image">
                        <img src="img/product_placeholder.jpg" alt="producto"/>
                    </div>
                    <p class="eight columns">
                        descripcion producto
                        UPC:0000000000000
                        Precio Normal: $00.00 Promocion: 000000
                        Ahorra:$00.00 Precio a pagar: $00
                    </p>
                </div>
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
                <div class="row">
                    <form action="/search" method="post" >
                        <label>INGRESE ARTICULO</label>
                        <input type="text" name="articulo">
                        <input type="submit" value="Agregar">
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
                <h2 class="two columns offset-by-two"> $00.00</h2>
                <a href="pagar" class="two columns offset-by-one button">Pagar</a>
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
</body>
</html>
