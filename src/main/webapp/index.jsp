<%--
  Created by IntelliJ IDEA.
  User: dany
  Date: 8/14/2015
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
        uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>tienda max</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
    <link href='http://fonts.googleapis.com/css?family=Quicksand|Josefin+Slab' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="section header">
    <div class="container">
        <div class="row">
            <div class="one-half column logo">
                <img src="${pageContext.request.contextPath}/imagen?id=${applicationScope["empresa"].getLogo().getIdImagen()}" alt="logo"/>
            </div>
            <div class="one-half column column">
                <h1 class="Title">${applicationScope["empresa"].getNombre()}</h1>
            </div>
        </div>
    </div>
</div>
<div class="section login">
    <div class="container">
        <div class="row">
            <h2 class="twelve rows">Acceso a usuarios</h2>
        </div>
        <div class="row">
            <form class="twelve columns" method="post" action="login">
                <div class="row">
                    <label class="four columns offset-by-four" >Nombre de usuario</label>
                </div>
                <div class="row">
                    <input class="four columns offset-by-four" type="text" name="username">
                </div>
                <div class="row">
                    <label class="four columns offset-by-four" >Password</label>
                </div>
                <div class="row">
                    <input class="four columns offset-by-four" type="password" name="password"  id="passwordUsuario">
                </div>
                <div class="row">
                  <input type="submit" value="Ingresar" class="button-primary four columns offset-by-four">
                </div>
            </form>
        </div>
    </div>
</div>
<div class="section footer">
    <div class="container">
        <div class="row">
            <div class="three columns offset-by-nine">
                <p>&copy Derechos Reservados</p>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="isPasswordWrong" value="${invalid}">
</body>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</html>
