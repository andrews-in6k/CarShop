<%@ page import="carShop.core.entity.Manager" %>
<%@ page import="java.util.List" %>
<%@ page import="carShop.core.entity.Deal" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.util.Objects" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/29/15
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Managers</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body id="framebody">
  <table border="1" align="center">
    <th colspan="3">Managers</th>

    <%for (Manager manager : (List<Manager>)request.getAttribute("managers")) {%>
      <tr>
        <td><%=manager.getFirstName()%></td>
        <td><%=manager.getLastName()%></td>
        <td><a href="/managers/<%=manager.getId()%>/deals">Deals</a></td>
        <form method="post" action="/managers/<%=manager.getId()%>">
          <input type="hidden" name="_method" value="DELETE">
          <td><input type="image" src="/resources/images/icon-delete.gif" alt="del"></td>
        </form>

        <%if ((request.getAttribute("dealsManagerId") != null) &&
          request.getAttribute("dealsManagerId").equals(manager.getId())) {%>
          <%for (Deal deal : manager.getDeals()) {%>
            <tr>
              <td><%=deal.getBuyingDate().toString()%></td>
              <td><%=deal.getSoldCar().getBrand()%></td>
              <td><%=deal.getSoldCar().getName()%></td>
              <td><%=deal.getSoldCar().getCost()%>$</td>
            </tr>
          <%}%>
        <%}%>
    <%}%>

  </table>

  <br>


  <div align="center">
    <form method="post" action="/managers">
      <label for="firstName">Name</label>
      <input type="text" name="firstName" id="firstName">
      <label for="lastName">Surname</label>
      <input type="text" name="lastName" id="lastName">

      <input type="submit" name="addManager" value="Add">
    </form>
  </div>
</body>
</html>
