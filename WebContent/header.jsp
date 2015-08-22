<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8">
    <title>login Àü</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" media="screen">
  </head>
  <body>
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a href="../" class="navbar-brand">Madi</a>
          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
          <ul class="nav navbar-nav">
            <li>
              <a href="../help/">home</a>
            </li>
            <li>
              <a href="http://news.bootswatch.com">memo</a>
            </li>
          </ul>

          <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/login/login.jsp" target="_blank">login</a></li>
            <li><a href="<%=request.getContextPath()%>/signup/signup.jsp">sign up</a></li>
          </ul>

        </div>
      </div>
    </div>
  </body>
</html>
