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
	   		document.getElementById("bg").style.background="url(http://photo.toast.com/aaaadc/abc/" + select + ".jpg)";
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
	  <div class = "size">
	    <article class = "post post-blog">
	      <p class = "title">Write</p>
	      <img id = head src = "http://photo.toast.com/aaaadc/abc/head.png"/>
	      <div class = "details">
		      <form name = "writeForm" method = "post" action = "memo.do">
				<input type = "hidden" name = "command" value = "write">
				<input type ="hidden" name = "member" size = "30" value = "${member.memberNum}">
				<input type = "hidden" id = "back" name = "back">
				<div class="meta">
		          <p><i class="fa fa-user icolor"></i> Written by <strong>${member.name}</strong></p>
		        </div><br>
		        <i class="fa fa-angle-double-right icolor"></i> <input type = "text" name = "title" cols = "30" rows = "1" class = "no-line" placeholder = "제목을 입력하세요 "><br><br>
				<p><i class="fa fa-pencil-square-o icolor"></i> Content</p><textarea name = "content" cols = "80" rows="5" class = "no-line"></textarea><br><br><br>
		        <i class="fa fa-tags icolor"></i> <input type = "text" class = "hash no-line" value = "#" readonly><input type = "text" name = "hashtag1" class = "btn no-line width" value = "tag1">&nbsp;&nbsp;
		        <input type = "text" class = "hash no-line" value = "#" readonly><input type = "text" name = "hashtag2" class = "btn no-line width" value = "tag2">&nbsp;&nbsp;
		        <input type = "text" class = "hash no-line" value = "#" readonly><input type = "text" name = "hashtag3" class = "btn no-line width" value = "tag3">
		        <div class="intents">
		        	<input type = submit class="btn btn-quaternary btn-caps no-line" value="Save"> 
		        </div><br>
		        <button onclick = "bgChange('happy');">1</button>
		        <button onclick = "bgChange('angry');">2</button>
		        <button onclick = "bgChange('sad');">3</button>
		        <button onclick = "bgChange('joy');">4</button>
		        <button onclick = "bgChange('love');">5</button>
		        <button onclick = "bgChange('hate');">6</button>
		        <button onclick = "bgChange('expect');">7</button>
			  </form>
	      </div>
	    </article> 
	  </div>
  <div id = "bg" class="fullscreen-bg"></div>
  </body>
</html>
