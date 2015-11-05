<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/4/2015
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core"%>

<div class="closepop">
  <a href="#" id="cerrar" >X</a>
</div>
<div class="title">
  <h2>Busca ${searchFor} a editar.</h2>
</div>
<div class="row">
  <form action="searchServlet" method="POST" id="${searchFor}" class="twelve columns">
    <input type="text" name="searchParam" />
    <input type="submit" value="buscar" />
  </form>
</div>