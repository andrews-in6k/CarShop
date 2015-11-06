<%@ page import="carShop.core.entity.Deal" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Deals</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body id="framebody">
  <table border="1" align="center" class="table">
    <th colspan="3">Deals</th>

    <%for (Deal deal : (List<Deal>)request.getAttribute("deals")) {%>
    <tr>
      <td><%=deal.getBuyingDate().toString()%></td>
      <td><%=deal.getSoldCar().getBrand() +
              " " + deal.getSoldCar().getName() +
              " " + deal.getSoldCar().getCost()%>$</td>
      <td><%=deal.getManager().getFirstName() +
              " " + deal.getManager().getLastName()%></td>
    </tr>
    <%}%>

  </table>
</body>
</html>
