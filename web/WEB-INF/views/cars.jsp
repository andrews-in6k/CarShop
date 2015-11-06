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
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Cars</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/styles/style.css">
</head>
  <body id="framebody">
    <table align="center" class="table table-striped table-bordered">
      <th colspan="4">Available cars</th>

      <tr>
        <th>Brand</th>
        <th>Name</th>
        <th>Cost</th>
      </tr>

      <%for (Car car : (List<Car>)request.getAttribute("cars")) {%>
        <%if (car.getDeal() == null) {%>
          <tr>
            <td><%=car.getBrand()%></td>
            <td><%=car.getName()%></td>
            <td><%=car.getCost()%>$</td>
            <form method="post" action="cars/<%=car.getId()%>">
              <input type="hidden" name="_method" value="DELETE">
              <td><input type="image" src="/resources/images/icon-delete.gif" alt="del"></td>
            </form>
          </tr>
        <%}%>
      <%}%>

    </table>

    <br>

    <div align="center">
      <form method="post" action="cars" class="form-inline">
        <div class="form-group">
          <label for="brand">Brand</label>
          <input type="text" class="form-control" name="brand" id="brand" value="">
        </div>

        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" class="form-control" name="name" id="name" value="">
        </div>

        <div class="form-group">
          <label for="cost">Cost</label>
          <input type="number" class="form-control" name="cost" id="cost" value="0">
        </div>

        <input type="submit" name="addCar" value="Add" class="btn btn-default">
      </form>
    </div>
  </body>
</html>
