<%@ page import="carShop.core.entity.Manager" %>
<%@ page import="java.util.List" %>
<%@ page import="carShop.core.entity.Deal" %>
<%@ page import="java.time.ZoneId" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/29/15
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Managers</title>
</head>
<body>
  <table border="1" align="center">
    <th colspan="3">Managers</th>

    <%for (Manager manager : (List<Manager>)request.getAttribute("managers")) {%>
      <tr>
        <td><%=manager.getFirstName()%></td>
        <td><%=manager.getLastName()%></td>
        <td><a href="?deals=<%=manager.getId()%>">Deals</a></td>
        <td><a href="?managerId=<%=manager.getId()%>"><img src="resources/images/icon-delete.gif" alt="del"></a></td>

        <%if (request.getAttribute("dealsManagerId") != null &&
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
      </tr>
    <%}%>

  </table>

  <br>

  <div align="center">
    <form method="post" action="managers">
      <label for="tfFirstName">Name</label>
      <input type="text" name="textFieldFirstName" id="tfFirstName">
      <label for="tfLastName">Surname</label>
      <input type="text" name="textFieldLastName" id="tfLastName">

      <input type="submit" name="addManager" value="Add">
    </form>
  </div>

  <div align="center">
    <a href="index.jsp">to general</a>
  </div>
</body>
</html>
