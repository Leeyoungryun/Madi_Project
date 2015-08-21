<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">
		<script language="JavaScript">
		function signup(){
			document.location.href = "<%=request.getContextPath()%>/signup/signup.jsp"
		}
		</script>
	</head>
	<body class="align">	
	  <div class="site__container">
	    <div class="grid__container">
	      <p style="margin-top: 0px; margin-bottom: 30px;">Login</p>
	      <form action="<%=request.getContextPath()%>/login.do" method="post" class="form form--login">
	     	 <input type="hidden" name="command" value="login">
	        <div class="form__field">
	          <label class="fontawesome-envelope"><span class="hidden">Email Address</span></label>
	          <input type="text" name="email" id="Email" placeholder="Email address" class="form__input" placeholder="Email Address" required autofocus/>
	        </div>
	
	        <div class="form__field">
	          <label class="fontawesome-lock"><span class="hidden">Password</span></label>
	          <input type="password" name="pw" id="pw" class="form__input" placeholder="Password" required>
	        </div>
	        <br><br>        
	        <div class="form__field">
	          <input type="submit" value="Log In">
	        </div>
			<a href="<%=request.getContextPath()%>/signup/signup.jsp">Sign up now</a>         
	      </form>
	    </div>
	  </div>
	  <div class="fullscreen-bg"></div>
	</body>

</html>