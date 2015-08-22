<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="resultContent" class="model.domain.MemoBean" scope="request" /> 
<jsp:useBean id="resultMusic" class="model.domain.MusicBean" scope="request" /> 

<!DOCTYPE html>
<html style="background: #F9F9F9;">
  <head>
    <meta charset="UTF-8">
    <title>노래추천</title>
        <link href = "<%=request.getContextPath()%>/css/index.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/recommend.css" rel="stylesheet" >
		<link href="<%=request.getContextPath()%>/css/write.css" rel="stylesheet">
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
	<br><br>
	<p class="title" style="color:#e95353">Music</p>
	
	<div class="TAPEmain sideA">
        	<div class="TAPEscrew" id="TAPEscrew01"></div>
        	<div class="TAPEscrew" id="TAPEscrew02"></div>
        	<div class="TAPEscrew" id="TAPEscrew03"></div>
        	<div class="TAPEscrew" id="TAPEscrew04"></div>

        	<div class="TAPElabel">
                <div class="TAPEmecha">
                    <div class="TAPEgearhole" id="TAPEgearhole01">
                        <div class="TAPEgear">
                            <div class="TAPEcog"></div>
                        </div>
                    </div>
                    <div class="TAPEgearhole" id="TAPEgearhole02">
                        <div class="TAPEgear">
                            <div class="TAPEcog"></div>
                        </div>
                    </div>

                    <div class="TAPEwindow">
                        <div class="TAPEwheel" id="TAPEwheel01"></div>
                        <div class="TAPEwheel" id="TAPEwheel02"></div>
                    </div>

                    <div class="TAPErule"></div>
                    <div class="TAPEscale">
                        <span>100</span>
                        <span>50</span>
                        <span>0</span>
                    </div>
                </div>
            </div>
        	<div class="TAPEbump">
        		<div class="TAPEscrew" id="TAPEscrew05"></div>
           		<div class="TAPEhole" id="TAPEhole01"></div>
                <div class="TAPEhole" id="TAPEhole02"></div>
        	</div>
        	<div class="audioplayer" style="position: absolute; left: 22px; top: 10px">
			  <div class="audioplayer__controls">
			    <a href="#" class="audioplayer__play-pause"></a>
			    <div class="audioplayer__track-info">
			      <div class="audioplayer__title" title=""></div>
			      <div class="audioplayer__artist" title=""></div>
			    </div>
			  </div>
			  <audio src="<%= resultMusic.getUrl() %>" volume="75" data-title="<%= resultMusic.getTitle() %>" data-artist="<%= resultMusic.getSinger() %>"></audio>
			</div><br><br><br><br>
			<center>
			<form name="save" method="post" action="memo.do">
				<input type="hidden" name="command" value= "save">
				<input type="hidden" name="member" value= "<%= resultContent.getMemberNum() %>">
				<input type="hidden" name="title" value= "<%= resultContent.getTitle() %>">
				<input type="hidden" name="content" value= "<%= resultContent.getContent() %>">
				<input type="hidden" name="hashtag1" value= "<%= resultContent.getHashTag1() %>">
				<input type="hidden" name="hashtag2" value= "<%= resultContent.getHashTag2() %>">
				<input type="hidden" name="hashtag3" value= "<%= resultContent.getHashTag3() %>">
				<input type="hidden" name="back" value= "<%= resultContent.getBack() %>">
				<input type="hidden" name="musicNum" value= "<%= resultMusic.getMusicNum() %>">
				<input type="submit" value="save" class="no-line btn btn-secondary">
			</form>
			</center>
    </div>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="js/index.js"></script>    
  </body>
</html>
