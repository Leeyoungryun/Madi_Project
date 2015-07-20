<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>MyPuppy</title>
</head>

<script language="JavaScript">
function signin(){
	document.location.href="<%=request.getContextPath()%>/signin/signin.jsp"
}
</script>
<body>
	<c:choose>
		<c:when test="${empty member}">
			<a name="5"><%@include file="../header.jsp"%></a>
		</c:when>
		<c:otherwise>
			<a name="5"><%@include file="../header2.jsp"%></a>
		</c:otherwise>
	</c:choose>
	<form action="<%=request.getContextPath()%>/login.do" class="form-signin" method="post">
		<label for="inputEmail" class="sr-only">Email address</label> 
		<input type="email" name="email" id="Email" placeholder="Email address" required autofocus>
		<label for="inputPassword">Password</label>
		<input type="password" name="pw" id="pw" placeholder="Password" required>
		<input type="hidden" name="command" value="login">
		<input value="login" type="submit">
		<input value="Sing In" type="button" onclick="location.href='<%=request.getContextPath()%>/signin/signin.jsp'">
	</form>
</body>
</html>