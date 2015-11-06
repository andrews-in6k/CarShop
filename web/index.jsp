<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/28/15
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CarShop General</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  </head>
  <body>
    <div>
      <div id="menu">
        <ul>
          <li>
            <h3>Manage</h3>
            <ul>
              <li><a href="cars" target="iframe">Cars</a></li>
              <li><a href="managers" target="iframe">Managers</a></li>
              <li><a href="deals" target="iframe">Deals</a></li>
            </ul>
          </li>
          <li>
            <h3>For customers</h3>
            <ul>
              <li><a href="buyingcar" target="iframe">Buy the car</a></li>
            </ul>
          </li>
          <li>
            <h3>Statistic</h3>
            <ul>
              <li><a href="bestmanager" target="iframe">Best manager</a></li>
            </ul>
          </li>
        </ul>
      </div>

      <div id="framediv">
        <iframe src="buyingcar" name="iframe" id="iframe" height="100%" width="100%"></iframe>
      </div>
    </div>
  </body>
</html>
