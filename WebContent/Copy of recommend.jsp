<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="model.domain.MemoBean" %> 
<%
 	MemoBean [] list=(MemoBean[])request.getAttribute("list");
 %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Music Player</title>
       <link rel="stylesheet" href="<%=request.getContextPath()%>/css/recommend.css">
       <link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
  </head>

  <body>
	<div class="player">
	  <div class="featureImg"></div>
	  <div class="controller">
	    <div class="duration">
	      <div class="currPos animate"></div>
	    </div>
	    <div class="timeLogs">
	      <p class="currTime"></p>
	      <p class="totalDuration"></p>
	    </div>
	    <div class="controls">
	      <div class="playPauseBtn play"></div>
	      <div class="titleArtist">
	        <p class="title"></p>
	        <p class="artist"></p>
	      </div>
	      <div class="addtControls">
	        <div class="next"></div>
	        <div class="prev"></div>
	        <div class="loop"></div>
	      </div>
	    </div>
	  </div>
	</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='http://cdn.jsdelivr.net/jquery.marquee/1.3.1/jquery.marquee.min.js'></script>

    <script src="<%=request.getContextPath()%>/js/index.js"></script>
  </body>
</html>
