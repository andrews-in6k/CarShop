<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/28/15
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <title>CarShop General</title>
    <link rel="stylesheet" type="text/css" href="/resources/styles/style.css">
  </head>
  <body>
    <div>
      <div id="menu">
        <table border="1" align="center">
          <th>Manage</th>
          <tr>
            <td><a href="cars" target="iframe">1. Cars</a></td>
          </tr>
          <tr>
            <td><a href="managers" target="iframe">2. Managers</a></td>
          </tr>
          <tr>
            <td><a href="deals" target="iframe">3. Deals</a> </td>
          </tr>
          <th>For customers</th>
          <tr>
            <td><a href="buyingcar" target="iframe">1. Buy the car</a></td>
          </tr>
          <th>Statistic</th>
          <tr>
            <td><a href="bestmanager" target="iframe">1. Best manager</a></td>
          </tr>
        </table>
      </div>

      <div id="framediv">
        <iframe src="buyingcar" name="iframe" id="iframe" height="100%" width="100%"></iframe>
      </div>
    </div>
  </body>
</html>
