<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 10/1/2015
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value="${usuario.getFechaNacimiento()}" var="fmtDate" type="date" pattern="MM/dd/yyyy"/>
<div class="closepop">
  <a href="#" id="cerrar" >X</a>
</div>
<div class="container">
  <div class="row">
    <h1 class="twelve columns head">${action}  usuario</h1>
  </div>
  <div class="row">
    <form action="serveusers" method="POST" id="addUser" class="twelve columns" enctype="multipart/form-data">
      <div class="row">
        <label class="three columns">Nombre*</label>
        <input type="text" name="nombre" class="three columns" required value="${usuario.getNombreUsuario()}"/>
        <label class="three columns">Apellidos*</label>
        <input type="text" name="apellido" class="three columns" required value="${usuario.getApellidoUsuario()}"/>
      </div>
      <div class="row">
        <label class="three columns ">Login de usuario* </label>
        <input type="text" name="username" class="three columns" required value="${usuario.getLoginUsuario()}"/>
        <label class="three columns ">Password*</label>
        <input type="password" name="password" class="three columns" required value="${usuario.getPasswordUsuario()}"/>
      </div>
      <div class="row">
        <label class="three columns ">Foto</label>
        <input type="file" name="fotoUsuario" class="five columns"/>
        <label class="three columns">Es Administrador</label>
        <input type="checkbox" name="isAdmin" value="true"  class="one column"/>
      </div>
      <div class="row">
        <label class="three columns">Sexo</label>
        <select name="sexo" class="two columns" required>
          <option value="H">H</option>
          <option value="M">M</option>
        </select>
        <label class="three columns">Fecha de nacimiento</label>
        <input type="date" name="fNan" value="${fmtDate}" class="three columns datePicker"/>
      </div>
      <div class="row">
        <label class="three columns">Nivel de estudios</label>
        <select name="nDEs" class="three columns" >
          <option value="primaria">Primaria</option>
          <option value="secundaria">secundaria</option>
          <option value="preparatoria">preparatoria</option>
          <option value="superior">superior</option>
        </select>
      </div>
      <div class="row">
        <label class="three columns">Pais</label>
        <input type="text" name="pais" value="${usuario.getDomicilio().getPais()}" class="three columns"/>
        <label class="three columns">Estado</label>
        <input type="text" name="estado" value="${usuario.getDomicilio().getEstado()}" class="three columns"/>
      </div>
      <div class="row">
        <label class="three columns">Ciudad</label>
        <input type="text" name="ciudad" value="${usuario.getDomicilio().getCiudad()}" class="three columns"/>
        <label class="three columns">Colonia</label>
        <input type="text" name="colonia" value="${usuario.getDomicilio().getColonia()}" class="three columns" />
      </div>
      <div class="row">
        <label class="three columns">Calle</label>
        <input type="text" name="calle" value="${usuario.getDomicilio().getCalle()}" class="three columns"/>
        <label class="three columns">Numero</label>
        <input type="text" name="numero" value="${usuario.getDomicilio().getNumero()}"class="three columns" />
      </div>
      <div class="row">
        <label class="three columns">Codigo Postal</label>
        <input type="text" name="zipcode" value="${usuario.getDomicilio().getCodigoPostal()}" class="three columns"/>
      </div>
      <div class="row">
        <label class="three columns">RFC</label>
        <input type="text" name="RFC" value="${usuario.getRfc()}" class="three columns"/>
        <label class="three columns">CURP</label>
        <input type="text" name="CURP" value="${usuario.getCurp()}"  class="three columns"/>
      </div>
      <div class="row">
        <input type="hidden" name="servicio" value="${action}"/>
        <input type="hidden" name="idUser" value="${usuario.getIdUsuario()}" />
        <input type="submit" class="button three columns offset-by-four" value="${action}"/>
      </div>
    </form>
  </div>
</div>