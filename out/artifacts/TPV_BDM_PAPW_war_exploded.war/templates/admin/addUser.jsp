<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 10/1/2015
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="closepop">
  <a href="#" id="cerrar" >X</a>
</div>
<div class="container">
  <div class="row">
    <h1 class="twelve columns head">Agregar un usuario</h1>
  </div>
  <div class="row">
    <form action="serveusers" method="POST" id="addUser" class="twelve columns" enctype="multipart/form-data">
      <div class="row">
        <label class="three columns">Nombre*</label>
        <input type="text" name="nombre" class="three columns" required/>
        <label class="three columns">Apellidos*</label>
        <input type="text" name="apellido" class="three columns" required/>
      </div>
      <div class="row">
        <label class="three columns ">Login de usuario* </label>
        <input type="text" name="username" class="three columns" required/>
        <label class="three columns ">Password*</label>
        <input type="password" name="password" class="three columns" required/>
      </div>
      <div class="row">
        <label class="two columns ">Foto</label>
        <input type="file" name="fotoUsuario" class="four columns"/>
        <label class="three columns">Es Administrador</label>
        <input type="checkbox" name="isAdmin" value="true"/>
      </div>
      <div class="row">
        <input type="submit" class="button three columns offset-by-four" value="Agregar"/>
      </div>
    </form>
  </div>
</div>