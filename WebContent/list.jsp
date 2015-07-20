<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="model.domain.MemoBean" %> 
<%
 	MemoBean [] list=(MemoBean[])request.getAttribute("list");
 %>
	<c:choose>
		<c:when test="${empty member}">
			<a name="5"><%@include file="../header.jsp"%></a>
		</c:when>
		<c:otherwise>
			<a name="5"><%@include file="../header2.jsp"%></a>
		</c:otherwise>
	</c:choose>
	
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#336699">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">번호</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">제목</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">작 성 일</span></b></font></p>
        </td>
    </tr>
<%
	if(list==null || list.length==0){
%>

	<tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 메모가 없습니다.</span></b></p>
        </td>
    </tr>
<%
	}else{
		MemoBean gBookContent = null;
		for(int i = 0; i <list.length ; i++){
	 gBookContent = list[i];
%>
		    <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <%=gBookContent.getMemoNum()%></span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="memo.do?command=read&num=<%=gBookContent.getMemoNum()%>">
					<%=gBookContent.getTitle() %></a></span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <%= gBookContent.getWriteday()%></span></p>
		        </td>
		    </tr>
		<% 
			} 
				}
		%>
 	
    <tr>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;"></span></p>
        </td>
        <td bgcolor="">
			<p><span style="font-size:9pt;"><a href="ReadAContent.jsp?num= "></a></span></p>
        </td>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;">
				<a href="mailto:"></a>
			</span></p>
        </td>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;"></span></p>
        </td>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;"></span></p>
        </td>
    </tr>

</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="write.jsp">글쓰기</a>&gt;</span></div>

