<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 12/9/2015
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="closepop">
  <a href="#" id="cerrar" >X</a>
</div>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>
<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
  response.setHeader("Pragma","no-cache"); //HTTP 1.0
  response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<div class="content ten columns offset-by-one sResults">
  <table class="table">
    <thead>
    <tr>
      <th>Nombre</th>
      <th>Path</th>
      <th>Vigencia</th>
      <th>Thumbnail</th>
      <th>Nueva Vigencia</th>
      <th>Activar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="x" items="${Videos}">
      <tr>
        <td>${x.getNombre()}</td>
        <td>${x.getPath()}</td>
        <td>${x.getVigencia()}</td>
        <td><video width="320" height="240" muted><source src="/${x.getPath()}" type="${x.getTipo()}">Not Available</video></td>
        <form method="post" action="activavideo" id="form-${x.getId()}"></form>
        <td><input  name="vigencia" class="datePicker  hasDatepicker" type="date" form="form-${x.getId()}"></td>
          <input type="hidden" name="id" value="${x.getId()}" form="form-${x.getId()}"/>
        <td><input type="submit" class="button edVid" value="activar" form="form-${x.getId()}"/></td>

      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>