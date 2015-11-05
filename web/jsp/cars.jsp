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
            <td><a href="?carId=<%=car.getId()%>"><img src="resources/images/icon-delete.gif" alt="del"></a></td>
          </tr>
        <%}%>
      <%}%>

    </table>

    <br>

    <div align="center">
      <form method="post" action="cars">
        <label for="tfBrand">Brand</label>
        <input type="text" name="textFieldBrand" id="tfBrand">
        <label for="tfName">Name</label>
        <input type="text" name="textFieldName" id="tfName">
        <label for="tfCost">Cost</label>
        <input type="text" name="textFieldCost" id="tfCost">

        <input type="submit" name="addCar" value="Add">
      </form>
    </div>

    <div align="center">
      <a href="index.jsp">to general</a>
    </div>
  </body>
</html>
