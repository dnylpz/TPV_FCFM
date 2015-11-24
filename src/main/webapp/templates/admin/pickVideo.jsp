<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <form action="vid" method="post" class="container">
      <div class="row">
        <label class="two columns offset-by-three">Nombre del video</label>
        <input type="text" name="vidName"  class="three columns" required/>
      </div>
      <div class="row">
        <label class="two columns  offset-by-three">vigencia del video</label>
        <input type="date" name="vigencia" class="datePicker three columns" required/>
      </div>
      <div class="row">
        <label class="two columns  offset-by-three">Video Default</label>
        <input type="text" name="defVidName" class="three columns" />
      </div>
      <div class="row">
        <input type="submit" value="Enviar" />
      </div>
      </form>