<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:useBean id="resultContent" class="model.domain.MemoBean" scope="request" />
<jsp:useBean id="resultMusic" class="model.domain.MusicBean" scope="request" />
<html>
	<head>
		<title>상세 정보</title>
		<link href = "<%=request.getContextPath()%>/css/write.css" rel="stylesheet">
		<script language=javascript>
		function sendUpdate(){
				document.requestForm.command.value ="updateForm";
				document.requestForm.submit();
		}	
		
		function sendDelete(){
					document.requestForm.command.value ="delete";
					document.requestForm.submit();			
		}	
		</script>
	</head>
	<body>
	  <div class = "container">
		  <div class = "grid_9">
		    <article class = "post post-blog">
		     <br><br><br>
		      <img src = "http://placehold.it/960x250/efefef"/>
		      <div class = "details">
					<div class="meta">
					  <h2>Music <%= resultMusic.getTitle() %></h2>
			          <p>Written by <strong>${member.name}</strong></p>
			        </div>
					<strong><%= resultContent.getTitle()%></strong><br><br>
					<p><%= resultContent.getContent()%></p>
					<div class="intents">
						<span class="icon icon-heart"></span>
						<span class="count"><%= resultContent.getWriteday() %></span>
					</div>
					<form name="requestForm" method=post action="memo.do">
						<input type=hidden name=num value="<%=resultContent.getMemoNum()%>">
						<input type=hidden name="command" value="">
						<div class="btn-group" data-grouptype="OR">
							<input type=button value="Update" onClick="sendUpdate()" class="no-line btn btn-primary btn-large btn-caps">
							<input type=button value="Delete" onClick="sendDelete()" class="no-line btn btn-secondary btn-large btn-caps">
			        	</div>
					</form>
		      </div>
		    </article> 
		  </div>
	  </div>		
	</body>
</html>