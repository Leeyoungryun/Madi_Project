<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="resultContent" class="model.domain.MemoBean" scope="request" /> 
<jsp:useBean id="resultMusic" class="model.domain.MusicBean" scope="request" /> 

<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>노래추천</title>
        <link rel="stylesheet" href="css/recommend.css">
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
	<div class="audioplayer">
	  <img class="audioplayer__artwork" src="https://unsplash.it/280/130">
	  <div class="audioplayer__trackbar">
	    <div class="audioplayer__trackbar-progress" style="width: 37%"></div>
	  </div>
	  <div class="audioplayer__duration" data-current="1:37" data-total="3:52"></div>
	  <div class="audioplayer__controls">
	    <a href="#" class="audioplayer__play-pause"></a>
	    <div class="audioplayer__track-info">
	      <div class="audioplayer__title" title="Is This Love">Is This Love</div>
	      <div class="audioplayer__artist" title="Bob Marley">Bob Marley</div>
	    </div>
	    <div class="audioplayer__side-controls">
	      <a href="#" class="audioplayer__repeat" title="Toggle repeat"></a>
	      <a href="#" class="audioplayer__prev" title="Previous track"></a>
	      <a href="#" class="audioplayer__next" title="Next track"></a>
	    </div>
	  </div>
	  <audio src="<%= resultMusic.getUrl() %>" volume="75" data-title="<%= resultMusic.getTitle() %>" data-artist="<%= resultMusic.getSinger() %>"></audio>
	</div>
    <a href="memo.do">리스트</a>
	<form name="save" method=post action="memo.do">
		<input type="hidden" name = "command" value= "save">
		<input type="hidden" name = "member" value= "<%= resultContent.getMemberNum() %>">
		<input type="hidden" name = "title" value= "<%= resultContent.getTitle() %>">
		<input type="hidden" name = "content" value= "<%= resultContent.getContent() %>">
		<input type="hidden" name = "hashtag1" value= "<%= resultContent.getHashTag1() %>">
		<input type="hidden" name = "hashtag2" value= "<%= resultContent.getHashTag2() %>">
		<input type="hidden" name = "hashtag3" value= "<%= resultContent.getHashTag3() %>">
		<input type="hidden" name = "back" value= "<%= resultContent.getBack() %>">
		<input type="hidden" name = "musicNum" value= "<%= resultMusic.getMusicNum() %>">
		<input type="submit" value ="save">
	</form>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="js/index.js"></script>    
  </body>
</html>
