<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/13/2015
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
      <form class="six columns offset-by-three" action="pagar" id="fpago" method="post">
        <div class="row">
          <input type="radio" name="formadepago" value="1" class="three columns"/> Efectivo
        </div>
        <div class="row">
          <input type="radio" name="formadepago" value="2" class="three columns"/> Tarjeta de debito
        </div>
        <div class="row">
          <input type="radio" name="formadepago" value="1" class="three columns"/> Tarjeta de credito
        </div>
        <div class="row">
          <input type="submit" value="seleccionar"/>
        </div>
      </form>
</div>