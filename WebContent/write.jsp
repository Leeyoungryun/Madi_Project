<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="model.domain.MemoBean" %>
<!DOCTYPE html>
<html>
	<head>
	  	<link href="<%=request.getContextPath()%>/css/write.css" rel="stylesheet">
	    <meta charset="UTF-8">
	    <title>write</title>
	    <script language = 'JavaScript'>
	    function tmpAlert(msg, duration) { 
	    	   var el = document.createElement("div"); 
	    	   el.setAttribute("style","font-size: 12px; position:absolute; top:50%; left:50%; width:200px; height:25px; margin-left:-100px; margin-top:-50px; line-height:100px; text-align:center; background-color:rgba(82, 189, 236, 0.67);"); 
	    	   el.innerHTML = msg; 
	    	   setTimeout(function(){ 
	    	      el.parentNode.removeChild(el); 
	    	   }, duration * 1000); 
	    	   document.body.appendChild(el); 
	    	} 
	    	window.onload = function() { 
	    	   tmpAlert("배경을 선택해주세요!", 3);
	    	} 

	    function bgChange(select){
	   		document.getElementById("bg").style.background = "url(<%=request.getContextPath()%>/img/" + select + ".jpg)";
	   		document.getElementById("back").value = select;
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
	  <div class="size">
	    <article class="post post-blog">
	      <br><br>
	      <p class="title">Today</p><br>
	      <img id=head src="<%=request.getContextPath()%>/img/head.png"/>
	      <div class="details">
	      	  <center>
	      	  <button class="picBtn" onclick="bgChange('love');">●</button>
		      <button class="picBtn" onclick="bgChange('happy');">●</button>
		      <button class="picBtn" onclick="bgChange('hate');">●</button>
		      <button class="picBtn" onclick="bgChange('sad');">●</button>
		      <button class="picBtn" onclick="bgChange('angry');">●</button>
		      <button class="picBtn" onclick="bgChange('excite');">●</button>
		      <button class="picBtn" onclick="bgChange('expect');">●</button>
		      </center>
		      <form name="writeForm" method="post" action="memo.do">
				<input type="hidden" name="command" value="write">
				<input type="hidden" name="member" size="30" value="${member.memberNum}">
				<input type="hidden" id="back" name="back" value="natural">
				<input type="hidden" name="title" value="title">
				<div class="meta">
		          <p><i class="fa fa-user icolor"></i> Written by <strong>${member.name}</strong></p>
		        </div><br>
				<textarea name="content" cols="48" rows="4" class="no-line textback"></textarea><br><br><br>
		        <i class="fa fa-tags icolor"></i> <input type="text" class="hash no-line" value="#" readonly><input type="text" name="hashtag1" class="btn no-line width" placeholder="tag1" maxlength="10">&nbsp;&nbsp;
		        <input type="text" class="hash no-line" value="#" readonly><input type="text" name="hashtag2" class="btn no-line width" placeholder="tag2" maxlength="10">&nbsp;&nbsp;
		        <input type="text" class="hash no-line" value="#" readonly><input type="text" name="hashtag3" class="btn no-line width" placeholder="tag3" maxlength="10">
		        <div class="intents">
		        	<input type=submit class="btn btn-quaternary btn-caps no-line" value="Save"> 
		        </div><br>
			  </form>
	      </div>
	    </article> 
	  </div>
  <div id="bg" class="fullscreen-bg"></div>
  </body>
</html>