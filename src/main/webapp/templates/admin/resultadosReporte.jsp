<%--
  Created by IntelliJ IDEA.
  User: jose.espinoza.lopez
  Date: 11/24/2015
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<table  class="row">
  <thead>
  <tr>
    <td>
      Clave Usuario
    </td>
    <td>
      Nombre de usuario
    </td>
    <td>
      Fecha
    </td>
    <td>
      Hora
    </td>
    <td>
      Total
    </td>
    <td>
      Forma de pago
    </td>
    <td>
      Subtotal
    </td>
    <td>
      Productos vendidos
    </td>
  </tr>
  </thead>
  <tbody>
    <c:forEach var="x" items="${reportes}">
        <fmt:formatDate value="${x.getFechaDetalle()}" var="fmtDate" type="date" pattern="MM/dd/yy"></fmt:formatDate>
        <tr>
            <td>
                ${x.getLoginUsuario()}
            </td>
            <td>
                ${x.getNombreUsuario()}
            </td>
            <td>
                ${fmtDate}
            </td>
            <td>
                ${x.getHoraDetalle().toString("HH:mm")}
            </td>
            <td>
                ${x.getTotal()}
            </td>
            <td>
                ${x.getFormaDePago()}
            </td>
            <td>
                ${x.getSubtotal()}
            </td>
            <td>
                ${x.getProductosVendidos()}
            </td>
        </tr>
    </c:forEach>
  </tbody>
</table>