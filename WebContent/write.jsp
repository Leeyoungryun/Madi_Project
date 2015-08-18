<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="model.domain.MemoBean" %>
<!DOCTYPE html>
<html>
	<head>
	  	<link href = "<%=request.getContextPath()%>/css/write.css" rel="stylesheet">
	    <meta charset="UTF-8">
	    <title>write</title>
	    <script language = 'JavaScript'>
	    function bgChange(select){
	   		document.getElementById("back").style.background="url('http://static.naver.net/header/h1/bi_naver.gif')";
	   		document.getElementById("bg").value=select;
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
  <div class = "container">
	  <div class = "grid_9">
	    <article class = "post post-blog">
	      <p class = "title">Write</p>
	      <img src = "http://placehold.it/960x250/efefef"/>
	      <div class = "details">
	      <button onclick = "bgChange('1');">1</button>
	      <button onclick = "bgChange('2');">2</button>
	      <button onclick = "bgChange('3');">3</button>
		      <form name = "writeForm" method = "post" action = "memo.do">
				<input type = "hidden" name = "command" value = "write">
				<input type ="hidden" name = "member" size = "30" value = "${member.memberNum}">	
				<div class="meta">
		          <p>Written by <strong>${member.name}</strong></p>
		        </div>
				<input type = "text" name = "title" cols = "30" rows = "1" class = "no-line" placeholder = "제목을 입력하세요"><br><br>
				<p>Content</p><textarea name = "content" cols = "30" rows="10" class = "no-line"></textarea><br><br><br>
		        <input type = "text" class = "hash no-line" value = "#" readonly><input type = "text" name = "hashtag1" class = "btn no-line width" value = "tag1">&nbsp;&nbsp;
		        <input type = "text" class = "hash no-line" value = "#" readonly><input type = "text" name = "hashtag2" class = "btn no-line width" value = "tag2">&nbsp;&nbsp;
		        <input type = "text" class = "hash no-line" value = "#" readonly><input type = "text" name = "hashtag3" class = "btn no-line width" value = "tag3">
		        <div class="intents">
		        	<input type = submit class="btn btn-quaternary btn-caps no-line" value="Save"> 
		        </div>
		        <input type = "text" id = "bg" name = "bg">
			  </form>
	      </div>
	    </article> 
	  </div>
  </div>
  <div id = "back" class="fullscreen-bg"></div>
  </body>
</html>
