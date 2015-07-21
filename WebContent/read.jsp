<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:useBean id="resultContent" class="model.domain.MemoBean" scope="request" />
<html>
	<head>
		<title>상세 정보</title>
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
	작성일  <%= resultContent.getWriteday() %><br>
	추천노래 <%= resultContent.getMusicNum() %><br>
	제 목 <%= resultContent.getTitle()  %><br>
	내 용<%= resultContent.getContent()%><br><br>
	
	<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
	<form name="requestForm" method=post action="memo.do">
		<input type=hidden name=num value="<%=resultContent.getMemoNum()%>">
		<input type=hidden name="command" value="">
		<input type=button value="수정하기" onClick="sendUpdate()">
		<input type=button value="삭제하기" onClick="sendDelete()">
	</form>
	<br>
	<a href="memo.do">리스트로 돌아가기</a>&gt;</span></div>
	</body>
</html>