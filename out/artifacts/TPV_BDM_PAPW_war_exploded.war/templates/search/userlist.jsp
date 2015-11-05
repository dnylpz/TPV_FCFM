<%@ page import="com.fcfm.tienda.models.Usuario" %>
<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/5/2015
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content twelve columns">
  <table>
    <thead>
    <tr>
      <th>Nombre</th>
      <th>Apellido</th>
      <th>Login</th>
      <th>Ultimo Acceso</th>
      <th>editar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="x" items="${usuarios}">
        <tr>
            <td>${x.getNombreUsuario()}</td>
            <td>${x.getApellidoUsuario()}</td>
            <td>${x.getLoginUsuario()}</td>
            <td>${x.getUltimoAccesoUsuario()}</td>
            <td><a href="#" class="button">Editar</a></td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
</div>