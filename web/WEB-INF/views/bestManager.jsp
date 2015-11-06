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
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Best Manager</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body id="framebody">
  <div align="center">
    <h3>Best manager</h3>
    <form method="post" action="bestmanager" class="form-inline">
      <div class="form-group">
        <label for="start">Start date(yyyy-mm-dd)</label>
        <input type="date" name="startDate" class="form-control" id="start">
      </div>

      <div class="form-group">
        <label for="end">End date(yyyy-mm-dd)</label>
        <input type="date" name="endDate" class="form-control" id="end">
      </div>

      <input type="submit" name="show" value="Show" class="btn btn-default">
    </form>
  </div>

  <%if (request.getAttribute("bestManager") != null) {
    Manager manager = (Manager) request.getAttribute("bestManager");
  %>
    <table align="center" border="1" class="table">
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
</body>
</html>
