<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="resultMusic" class="model.domain.MusicBean" scope="request" />

<html>
	<head>
		<title>추천</title>
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
		<br>음악 추천<br>
		<a href="memo.do">리스트</a>
		노래제목 <%= resultMusic.getTitle() %>
		가수 <%= resultMusic.getSinger() %>
		<audio src="<%= resultMusic.getUrl() %>" controls aoutoplay></audio>  
	</body>
</html>