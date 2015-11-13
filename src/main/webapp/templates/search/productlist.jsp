<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/10/2015
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>
<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<style>
  .hidden{
    display:none;
  }
</style>
<div class="content ten columns offset-by-one sResults hidden">
  <table>
    <thead>
    <tr>
      <th>Nombre</th>
      <th>descripción</th>
      <th>UPC</th>
      <th>Precio</th>
      <th>Existencia</th>
      <% if(request.getAttribute("venta").equals("esVenta")){%>
        <th>Agregar</th>
      <%}else{%>
        <th>Editar</th>
        <th>Borrar</th>
      <%}%>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="x" items="${resultado}">
      <tr>
        <td>${x.getNombre()}</td>
        <td>${x.getDescripcion()}</td>
        <td>${x.getUPC()}</td>
        <td>${x.getPrecio()}</td>
        <td>${x.getExistencia()}</td>
        <%if(request.getAttribute("venta").equals("esVenta")){%>
          <td><a href="#" class="button add" itemId="${x.getUPC()}">Agregar</a></td>
        <%}else{%>
          <td><a href="#" class="button edit"  action="adminajax" servicio="doEditProduct" itemId="${x.getIdProducto()}">Editar</a></td>
          <td><<a href="#" class="button delete"  action="serveproductos" itemType="Producto" style="background-color:red; color:white;"  itemId="${x.getIdProducto()}">Borrar</a></td>
        <%}%>

      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>