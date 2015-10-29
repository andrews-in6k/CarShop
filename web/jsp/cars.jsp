<%@ page import="carShop.core.entity.Car" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/29/15
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
  <body>
    <table border="1">
      <%for (Car car : (List<Car>)request.getAttribute("cars")) {%>
        <tr>
          <td><%=car.getBrand()%></td>
          <td><%=car.getName()%></td>
          <td><%=car.getCost()%></td>
        </tr>
      <%}%>
    </table>

  </body>
</html>
