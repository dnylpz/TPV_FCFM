<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core"%>
<div class="content">
          <div class="closepop">
            <a href="#" id="cerrar" >X</a>
          </div>
          <form action="reporte" method="post" class="container">
            <div class="row">
              <label class="two columns">fecha de inicio</label>
              <input type="date" name="fInic"  id="fInic" class="three columns datePicker"/>
              <label class="two columns ">fecha de fin</label>
              <input type="date" name="fFin"  id="fFin" class="three columns datePicker"/>
              <input type="submit" value="generar reporte"/>
            </div>
          </form>
          <div class="reporteResults container"></div>
</div>