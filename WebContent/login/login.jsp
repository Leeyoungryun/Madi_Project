<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		 <link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">
		<script language="JavaScript">
		function signup(){
			document.location.href="<%=request.getContextPath()%>/signup/signup.jsp"
		}
		</script>
	</head>
	<body>
		<c:choose>
			<c:when test="${empty member}">
				<a name="5"><%@include file="../header.jsp"%></a>
			</c:when>
			<c:otherwise>
				<a name="5"><%@include file="../header2.jsp"%></a>
			</c:otherwise>
		</c:choose>
		<form action="<%=request.getContextPath()%>/login.do" method="post" class="form form--login framed">
			<p style="margin-top: 0px; margin-bottom: 0px;">Madi</p>
			<input type="email" name="email" id="Email" placeholder="Email address" class="input input--top" required autofocus/>
			<input type="password" name="pw" id="pw" placeholder="Password" class="input" required/>
			<input type="hidden" name="command" value="login">
			<input type="submit" value="Log in" class="input input--submit" />
			<a href="<%=request.getContextPath()%>/signup/signup.jsp">Sign up now</a> 
		</form>
		 
		<div class="fullscreen-bg"></div>
	</body>
</html>