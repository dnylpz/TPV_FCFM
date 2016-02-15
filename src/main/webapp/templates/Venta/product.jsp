<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fcfm.tienda.models.Producto" %>

<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/10/2015
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Producto a = (Producto) request.getAttribute("producto"); %>
<style>
    h3{
        padding-top:.8em;
    }
    .hidden{
        display:none;
    }
</style>
<fmt:formatNumber var="prec"
                  value="${precio}"
                  maxFractionDigits="2" />
<div class="product row hidden " >
    <div class="remove-item-area one column">
        <a href="#" class="removeItem" id="${count}"><p>X</p></a>
    </div>
    <div class="two columns product-image">
        <img src="${pageContext.request.contextPath}/imagen?id=${producto.getImagen().getIdImagen()}" alt="producto"/>
    </div>
    <div class="nine columns">
        <p class="two columns">${producto.getNombre()}</p>
        <p class="three columns">Descripcion: ${producto.getDescripcion()}</p>
        <p class="two columns">Precio: ${producto.getPrecio()}</p>
        <p class="two columns">impuestos: ${producto.getImpuesto()}%</p>
        <p class="two columns">total: ${prec} </p>
    </div>
    <input type="hidden" class="totalIn" value="${sessionScope["venta"].getTotal()}"/>
    <input type="hidden" class="stillExists" value="${existe}" />
</div>
