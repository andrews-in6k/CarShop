<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <table border="1" align="center">
      <th colspan="3">Available cars</th>

      <%for (Car car : (List<Car>)request.getAttribute("cars")) {%>
        <%if (car.getDeal() == null) {%>
          <tr>
            <td><%=car.getBrand()%></td>
            <td><%=car.getName()%></td>
            <td><%=car.getCost()%></td>
            <td><a href="cars/<%=car.getId()%>/delete"><img src="resources/images/icon-delete.gif" alt="del"></a></td>
          </tr>
        <%}%>
      <%}%>

    </table>

    <br>

    <div align="center">
      <form method="post" action="cars">
        <label for="brand">Brand</label>
        <input type="text" name="brand" id="brand">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="cost">Cost</label>
        <input type="number" name="cost" id="cost">

        <input type="submit" name="addCar" value="Add">
      </form>
    </div>

    <div align="center">
      <a href="/">to general</a>
    </div>
  </body>
</html>
