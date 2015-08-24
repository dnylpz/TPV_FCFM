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
    <title>TiendaMax</title>
</head>
<body>
<form method="post" action="./login">
    <label>Nombre de usuario</label><br/>
    <input type="text" name="username"><br/>
    <label>Password</label><br/>
    <input type="password" name="password"  id="password"><br/>
    <input type="submit" value="Ingresar">
</form>
</body>
</html>
