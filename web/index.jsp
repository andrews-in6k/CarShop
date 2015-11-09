<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/28/15
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html id="indexHtml">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CarShop General</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/styles/style.css">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script>
      function myFunc ()
      {
        document.getElementById ('iframe').style.height = window.frames ['iframe'].document.body.offsetHeight + 50 + 'px';
      }
    </script>
  </head>
  <body id="indexBody" class="indexBody">
    <div class="container">
      <nav class="navbar navbar-default">
        <div class="container-fluid">

          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Car Shop</a>
          </div>

          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="cars" target="iframe">Cars</a></li>
                  <li><a href="managers" target="iframe">Managers</a></li>
                  <li><a href="deals" target="iframe">Deals</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">For customers<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="buyingcar" target="iframe">Buy the car</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Statistic<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="bestmanager" target="iframe">Best manager</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>

    <div id="frameContainer" class="container">
      <iframe src="buyingcar" name="iframe" id="iframe" width="100%" onload="myFunc()"></iframe>
    </div>
  </body>
</html>
