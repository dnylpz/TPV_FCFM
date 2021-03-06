<%@ page import="com.fcfm.tienda.models.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Usuario user = (Usuario) session.getAttribute("user");
String userName = user.getNombreUsuario() + " " + user.getApellidoUsuario();%>
<div class="container body-content">
  <div class="row">
    <h2 class="twelve columns">Bienvenido <%= userName%></h2>
  </div>
  <div class="row">
    <div class="six columns">
      <h3 class="twelve columns">Cajas Disponibles</h3>
      <table class="twelve columns">
        <thead>
        <tr>
          <td>Disponibles</td>
          <td>Activas</td>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>15</td>
          <td>8</td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="six columns">
      <h3 class="twelve columns">Usuarios</h3>
      <table class="tweleve columns">
        <thead>
        <tr>
          <td>Nombre</td>
          <td>Login</td>
          <td>Status</td>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>Daniel Espinoza</td>
          <td>dnylpz</td>
          <td>Activo en Consola</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
  <div class="row">
    <div class="six columns">
      <h3 class="twelve columns">Video Activo</h3>
      <div class="twelve columns"><img src="img/video_placeholder.jpg" alt="vide" style=" height:120px; width: 150px"/></div>
    </div>
    <div class="six columns">
      <h3 class="twelve columns">Imagen Activa</h3>
      <div class="twelve columns"><img src="img/video_placeholder.jpg" alt="img" style=" height:120px; width: 150px"/></div>
    </div>
  </div>
