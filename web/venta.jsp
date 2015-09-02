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
</head>
<body>
<div class="section header">
    <div class="container">
        <div class="row">
            <div class="four columns">
                <img src="img/tLogo.png">
            </div>
            <h1 class="four columns">Venta</h1>
            <a class="two columns  offset-by-two button" href="index.jsp">Salir</a>
        </div>
    </div>
</div>
<div class="products">
    <div class="container" id="product-list">
            <div class="product row">
                <div class="two columns offset-by-two columns product-image">
                    <img src="img/product_placeholder.jpg" alt="producto"/>
                </div>
            <p class="eight columns">
                descripción producto
                UPC:0000000000000
                Precio Normal: $00.00 Promocion: 000000
                Ahorra:$00.00 Precio a pagar: $00
            </p>
        </div>
    </div>
</div>
<div class="sidebar">
    <p>Le Atiende</p>
    <img src="" alt="foto"/>
    <p>${username}</p>
    <form action="/search" method="post" >
        <label>INGRESE ARTICULO</label>
        <input type="text" name="articulo">
        <input type="submit" value="Agregar">
    </form>
    <p>video</p>
</div>
<div class="footer">
    <h2>TOTAL A PAGAR:     $00.00</h2>
    <img src="" alt="cliente"/>
    <p>
        No Cliente:00000
        Nombre: Juan Martinez
        Puntos: 09923
    </p>
</div>
</body>
</html>