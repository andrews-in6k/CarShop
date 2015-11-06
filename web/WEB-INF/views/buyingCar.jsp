<%@ page import="carShop.core.entity.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="carShop.core.entity.Manager" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/30/15
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Buy The Car</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  </head>
  <body id="framebody">
    <div align="center">
      <h3>Buying car</h3>
      <form method="post" action="buyingcar" class="form-inline">
        <label for="carSelect">Select car</label>
        <select name="carSelect" id="carSelect" class="form-control">
          <%for (Car car : (List<Car>)request.getAttribute("cars")) {%>
            <%if (car.getDeal() == null) {%>
              <option value="<%=car.getId()%>"><%=car.getBrand()%> <%=car.getName()%> <%=car.getCost()%></option>
            <%}%>
          <%}%>
        </select>

        <label for="managerSelect">Select manager</label>
        <select name="managerSelect" id="managerSelect" class="form-control">
          <%for (Manager manager : (List<Manager>)request.getAttribute("managers")) {%>
            <option value="<%=manager.getId()%>"><%=manager.getFirstName()%> <%=manager.getLastName()%></option>
          <%}%>
        </select>

        <div class="form-group">
          <label for="buyingDate">Buying date(yyyy-mm-dd)</label>
          <input type="date" name="buyingDate" class="form-control" id="buyingDate">
        </div>

        <input type="submit" name="Buy" value="Buy" class="btn btn-default">
      </form>
    </div>

    <% if (request.getAttribute("isBought") != null) {%>
      <h4 align="center" style="color : red">You have a car</h4>
    <%}%>
  </body>
</html>
