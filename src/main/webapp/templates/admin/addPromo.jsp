<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/25/2015
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="closepop">
  <a href="#" id="cerrar" >X</a>
</div>
<div class="container">
    <form action="promo" method="post" id="addpromo" >
        <div class="row">
            <label class="four columns offset-by-two">Tipo de promocion</label>
            <select name="tPromo" class="three columns" required>
                <option value="combo">x por uno</option>
                <option value="porcentaje">porcentaje de descuento</option>
            </select>
        </div>
        <div class="row">
            <label class="four columns offset-by-two">valor de la promocion</label>
            <input type="number" class="three columns" name="vPromo" required />
        </div>
        <div class="row">
            <label class="four columns offset-by-two">vigencia de la promocion</label>
            <input type="date" name="vigPromo"  class="datePicker three columns" required />
            <input type="hidden" value="${producto.getIdProducto()}" name="idProducto"/>
        </div>
        <div class="row">
            <input type="submit" value="Guardar" class="three columns offset-by-four"/>
        </div>
    </form>
</div>