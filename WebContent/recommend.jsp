<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="model.domain.MemoBean" %> 
<%
 	MemoBean [] list=(MemoBean[])request.getAttribute("list");
 %>
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
	</body>
</html>