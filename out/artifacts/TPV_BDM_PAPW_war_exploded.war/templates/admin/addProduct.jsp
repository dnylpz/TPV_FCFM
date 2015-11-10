<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/9/2015
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="closepop">
  <a href="#" id="cerrar" >X</a>
</div>
<div class="content">
  <div class="row">
    <h3 class="four columns offset-by-four">${action} Producto</h3>
  </div>
  <div class="row">
    <form class="twelve columns" action="serveproductos" method="POST" enctype="multipart/form-data">
      <div class="row">
        <div class="three columns offset-by-one">
          <label>Nombre del Producto</label>
          <input type="text" name="nombre" value="${producto.getNombre()}" required/>
        </div>
        <div class="three columns offset-by-one">
          <label>Descripcion</label>
          <textarea cols="20" rows="5" name="descripcion">${producto.getDescripcion()}</textarea>
        </div>
        <div class="three columns offset-by-one">
          <label>UPC</label>
          <input type="text" name="upc" value="${producto.getUPC()}" required/>
        </div>
      </div>
      <div class="row">
        <div class="three columns offset-by-one">
          <label>Imagen</label>
          <input type="file" name="imagen">
        </div>
        <div class="three columns offset-by-one">
          <label>Precio</label>
          <input type="text" name="precio" value="${producto.getPrecio()}" required>
        </div>
        <div class="three columns offset-by-one">
          <label>Existencias</label>
          <input type="number" name="existencia" value="${producto.getExistencia()}" required>
        </div>
        <div class="three columns offset-by-two">
          <input type="hidden" name="servicio" value="${action}">
          <input type="hidden" name="idProducto" value="${producto.getIdProducto()}">
          <input type="submit" value="${action}"/>
        </div>
      </div>
    </form>
  </div>
</div>