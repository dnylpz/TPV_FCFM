<%@ page import="com.fcfm.tienda.models.Producto" %>
<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/10/2015
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    h3{
        padding-top:.8em;
    }
    .hidden{
        display:none;
    }
</style>
<div class="product row hidden">
    <div class="two columns product-image">
        <img src="${pageContext.request.contextPath}/imagen?id=${producto.getImagen().getIdImagen()}" alt="producto"/>
    </div>
    <div class="ten columns">
        <p class="three columns">${producto.getNombre()}</p>
        <p class="four columns">Descripcion: ${producto.getDescripcion()}</p>
        <p class="three columns">Precio: ${producto.getPrecio()}</p>
    </div>
    <input type="hidden" id="totalIn${count}" value="${sessionScope["venta"].getTotal()}"/>
</div>
