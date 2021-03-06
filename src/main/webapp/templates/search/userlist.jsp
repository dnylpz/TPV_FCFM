<%@ page import="com.fcfm.tienda.models.Usuario" %>
<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/5/2015
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<div class="content eight columns offset-by-two">
  <table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Login</th>
        <th>Ultimo Acceso</th>
        <th>Editar</th>
        <th>Borrar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="x" items="${resultado}">
        <fmt:formatDate value="${x.getUltimoAccesoUsuario()}" var="fmtDate" type="date" pattern="hh:mm MM/dd/yy"></fmt:formatDate>
        <tr>
            <td>${x.getNombreUsuario()}</td>
            <td>${x.getApellidoUsuario()}</td>
            <td>${x.getLoginUsuario()}</td>
            <td>${fmtDate}</td>
            <td><a href="#" class="button edit" action="adminajax" servicio="doEditUser" itemId="${x.getIdUsuario()}">Editar</a></td>
            <td><a href="#" class="button delete" action="serveusers" itemType="Usuario" style="background-color:red; color:white;"  itemId="${x.getIdUsuario()}">Borrar</a></td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
</div>