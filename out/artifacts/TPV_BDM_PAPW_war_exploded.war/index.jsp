<%--
  Created by IntelliJ IDEA.
  User: dany
  Date: 8/14/2015
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
        uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>tienda max</title>
    <link rel="stylesheet" type="text/css" href="css/960.css">
    <link href='http://fonts.googleapis.com/css?family=Quicksand|Josefin+Slab' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="container_16" >
    <div class="header-container grid_16">
        <!--logo <img src="logo">  --><h1 class="grid_5 push_1">TIENDA MAX</h1>
    </div>
    <div class="login-container grid_5 push_5">
        <h1>Acceso a usuarios</h1>
         <form method="post" action="./login">
                <label>Nombre de usuario</label><br/>
                <input type="text" name="username"><br/>
                <label>Password</label><br/>
                <input type="password" name="password"  id="password"><br/>
                <input type="submit" value="Ingresar" class="button">
         </form>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jQuery.js"></script>
</html>
