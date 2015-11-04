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
<html>
<head>
    <title>Deals</title>
</head>
<body>
  <table border="1" align="center">
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

  <div align="center">
    <a href="/">to general</a>
  </div>
</body>
</html>
