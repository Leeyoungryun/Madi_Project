<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="resultContent" class="model.domain.MemoBean" scope="request" /> 
<jsp:useBean id="resultMusic" class="model.domain.MusicBean" scope="request" /> 

<html>
	<head>
		<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet">
		<title>Madi</title>
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
        <br><br><br>
        <a style="text-decoration: none;" href="<%=request.getContextPath()%>/login/login.jsp"><p style="margin-top: 10px;">Music</p></a>
        <div class="TAPEmain sideA">

        	<div class="TAPEscrew" id="TAPEscrew01"></div>
        	<div class="TAPEscrew" id="TAPEscrew02"></div>
        	<div class="TAPEscrew" id="TAPEscrew03"></div>
        	<div class="TAPEscrew" id="TAPEscrew04"></div>

        	<div class="TAPElabel">
                <div class="TAPEdescription"></div>

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
		노래제목 <%= resultMusic.getTitle() %><!-- bean객체에서 title 빼오는거 -->
		가수 <%= resultMusic.getSinger() %>
		<audio src="<%= resultMusic.getUrl() %>" controls aoutoplay></audio>  
	</body>
</html>