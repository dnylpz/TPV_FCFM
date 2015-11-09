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
    <h3 class="four columns offset-by-four">Agregar Producto</h3>
  </div>
  <div class="row">
    <form class="twelve columns" action="serveproductos" method="POST" enctype="multipart/form-data">
      <div class="row">
        <div class="three columns offset-by-one">
          <label>Nombre del Producto</label>
          <input type="text" name="nombre" required/>
        </div>
        <div class="three columns offset-by-one">
          <label>Descripcion</label>
          <textarea cols="20" rows="5" name="descripcion"></textarea>
        </div>
        <div class="three columns offset-by-one">
          <label>UPC</label>
          <input type="text" name="upc" required/>
        </div>
      </div>
      <div class="row">
        <div class="three columns offset-by-two">
          <label>Imagen</label>
          <input type="file" name="imagen">
        </div>
        <div class="three columns offset-by-two">
          <label>Precio</label>
          <input type="text" name="precio" required>
        </div>
        <div class="three columns offset-by-four">
          <input type="submit" value="Enviar"/>
        </div>
      </div>
    </form>
  </div>
</div>