<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:useBean id="resultContent" class="model.domain.MemoBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href = "<%=request.getContextPath()%>/css/write.css" rel="stylesheet">
		<title>수정</title>
		<script>
			function checkValid() {
			    var f = window.document.updateForm;
			
				if ( f.title.value == "" ) {
					alert( "제목을 입력해 주세요." );
					return false;
				}
				return true;
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
		      <br><br><p class="title">Update</p><br>
		      <img src="http://photo.toast.com/aaaadc/abc/head.png"/>
		      <div class="details">    
			      <form name="updateForm" method="post" action="memo.do" onSubmit="return checkValid()">
			      	<input type="hidden" value="update" name="command">
			      	<input type="hidden" name="num" value="<%=resultContent.getMemoNum()%>">
			      	<input type="hidden" name="member" size="30" value="<%=resultContent.getMemberNum()%>">
			      	<input type="hidden" name="title" value="<%=resultContent.getTitle()%>">
	
					<div class="meta">
			          <p><i class="fa fa-user icolor"></i> Written by <strong>${member.name}</strong></p>
			        </div>
			        
			        <textarea name="content" cols="48" rows="4" class="no-line textback"><%=resultContent.getContent()%></textarea><br><br><br>
		      		<i class="fa fa-tags icolor"></i> <input type="text" class="hash no-line" value="#" readonly><input type="text" name="hashtag1" class="btn no-line width" value="<%=resultContent.getHashTag1()%>" readonly>&nbsp;&nbsp;
		        	<input type="text" class="hash no-line" value="#" readonly><input type="text" name="hashtag2" class="btn no-line width" value="<%=resultContent.getHashTag2()%>" readonly>&nbsp;&nbsp;
		        	<input type="text" class="hash no-line" value="#" readonly><input type="text" name="hashtag3" class="btn no-line width" value="<%=resultContent.getHashTag3()%>" readonly><br><br>
			        <div class="intents">
						<span class="count"><i class="fa fa-calendar-check-o"></i> <%=resultContent.getWriteday()%></span>
			        </div>
					<div class="btn-group" data-grouptype="OR">
						<input type="submit" value="Update" class="no-line btn btn-primary btn-large btn-caps">
						<input type="reset" value="Delete" class="no-line btn btn-secondary btn-large btn-caps">
			        </div>
				  </form>
		      </div>
		    </article> 
	  </div>
	  <div id="bg" class="fullscreen-bg"></div>
	</body>
</html>