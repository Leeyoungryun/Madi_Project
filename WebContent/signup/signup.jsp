<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="model.domain.MemberBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="<%=request.getContextPath()%>/css/signup.css" rel="stylesheet">
		<title>회원가입</title>
		<script>
		function msub(){
			if(document.f.password2.length == 0){
				alert("패스워드를 한번 더 적어주세요!");
				document.f.password2.focus();
				return false;
			}
			if((document.f.password.value) != (document.f.password2.value)){
				alert("패스워드가 일치하지 않습니다.!");
				document.f.password.focus();
				return false;
			}	
			return true;
		}
		</script>
	</head>
	<body class="align">
	  <div class="site__container">
	    <div class="grid__container">
	      <p style="margin-top: 0px; margin-bottom: 30px;">SingUp</p>
	      <form method="post" action="<%=request.getContextPath()%>/member.do" name="f" class="form form--login">
	     	 <input type="hidden" value="signup" name="command">
	        <div class="form__field">
	          <label class="fontawesome-envelope"><span class="hidden">Email Address</span></label>
	          <input type="text" name="email" class="form__input" placeholder="Email Address" required>
	          <input type="hidden" id="reEamil" name="reEamil" value="">
	        </div>
	
	        <div class="form__field">
	          <label class="fontawesome-lock"><span class="hidden">Password</span></label>
	          <input type="password" name="password" class="form__input" placeholder="Password" required>
	        </div>
	        
	        <div class="form__field">
	          <label class="fontawesome-check"><span class="hidden">Password Confirm</span></label>
	          <input type="password" name="password2" class="form__input" placeholder="Password Confirm" required>
	        </div>
	        
	        <div class="form__field">
	          <label class="fontawesome-user"><span class="hidden">Name</span></label>
	          <input type="text" name="name" class="form__input" placeholder="Name" required>
	        </div> 
	        
	        <div class="form__field">
	          <label class="fontawesome-phone"><span class="hidden">Phone Number</span></label>
	          <input type="text" name="phone" class="form__input" placeholder="Phone Number" required>
	        </div>
	        
	        <div class="form__field">
	          <label class="fontawesome-map-marker"><span class="hidden">Local</span></label>
	          <input type="text" name="local" class="form__input" placeholder="Local" required>
	        </div>
	        <br><br>        
	        <div class="form__field">
	          <input type="submit" onclick="return msub()" value="Sign In">
	        </div>        
	      </form>
	    </div>
	  </div>
	  <div class="fullscreen-bg"></div>
	</body>
</html>