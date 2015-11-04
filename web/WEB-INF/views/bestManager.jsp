<%@ page import="carShop.core.entity.Manager" %>
<%@ page import="carShop.core.entity.Deal" %>
<%@ page import="java.time.ZoneId" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/30/15
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Best Manager</title>
</head>
<body>
  <div align="center">
    <form method="post" action="bestmanager">
      <label for="start">Start date</label>
      <input type="date" name="startDate" id="start">

      <label for="end">End date</label>
      <input type="date" name="endDate" id="end">

      <input type="submit" name="show" value="Show">
    </form>
  </div>

  <%if (request.getAttribute("bestManager") != null) {
    Manager manager = (Manager) request.getAttribute("bestManager");
  %>
    <table align="center" border="1">
      <tr>
        <td><%=manager.getFirstName()%></td>
        <td><%=manager.getLastName()%></td>
      </tr>
      <tr>
        <td>Deals:</td>
      </tr>
      <%for (Deal deal : manager.getDeals()) {%>
        <tr>
          <td><%=deal.getBuyingDate().toString()%></td>
          <td><%=deal.getSoldCar().getBrand()%></td>
          <td><%=deal.getSoldCar().getName()%></td>
          <td><%=deal.getSoldCar().getCost()%>$</td>
        </tr>
      <%}%>
    </table>
  <%}%>
  <div align="center">
    <a href="/">to general</a>
  </div>
</body>
</html>
