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
<html>
  <head>
      <title>Buy The Car</title>
  </head>
  <body>
    <div align="center">
      <form method="post" action="buyingcar/buy/car">
        <label for="carSelect">Select car</label>
        <select name="carSelect" id="carSelect">
          <%for (Car car : (List<Car>)request.getAttribute("cars")) {%>
            <%if (car.getDeal() == null) {%>
              <option value="<%=car.getId()%>"><%=car.getBrand()%> <%=car.getName()%> <%=car.getCost()%></option>
            <%}%>
          <%}%>
        </select>

        <label for="managerSelect">Select manager</label>
        <select name="managerSelect" id="managerSelect">
          <%for (Manager manager : (List<Manager>)request.getAttribute("managers")) {%>
            <option value="<%=manager.getId()%>"><%=manager.getFirstName()%> <%=manager.getLastName()%></option>
          <%}%>
        </select>

        <label for="buyingDate">Buying date(yyyy-mm-dd)</label>
        <input type="text" name="buyingDate" id="buyingDate">

        <input type="submit" name="Buy" value="Buy">
      </form>
    </div>

    <% if (request.getAttribute("isBought") != null) {%>
      <h4 align="center" style="color : red">You have a car</h4>
    <%}%>

    <div align="center">
      <a href="/">to general</a>
    </div>
  </body>
</html>
