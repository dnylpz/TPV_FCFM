<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="closepop">
  <a href="#" id="cerrar" >X</a>
</div>
<form action="vid" method="post" class="container" enctype="multipart/form-data">
  <div class="row">
    <label class="one column offset-by-one">video</label>
    <input class="four columns" name="vidName" required="" type="file">
    <label class="two columns">vigencia del video</label>
    <input  name="vigencia" class="datePicker three columns hasDatepicker" required="" type="date">
  </div>
  <div class="row">
    <label class="two columns  offset-by-three">Video Default</label>
    <input class="four columns" name="defVidName" type="file">
  </div>
  <div class="row">
    <input class="two columns offset-by-five" value="Enviar" type="submit">
  </div>
</form>