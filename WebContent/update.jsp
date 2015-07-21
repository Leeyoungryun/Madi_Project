<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:useBean id="resultContent" class="model.domain.MemoBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
	<form name=updateForm method=post action="memo.do" onSubmit='return checkValid()'>
	    <input type="hidden" value="update" name="command">
	    <input type='hidden' name='num' value="<%=resultContent.getMemoNum()%>">
		작성자 <input type=text name="member" size="30" value="<%=resultContent.getMemberNum()%>"><br>
		제 목<input type=text name="title" size="50" value="<%=resultContent.getTitle()%>"><br>
	       내 용<textarea name="content" cols="50" rows="10"><%=resultContent.getContent()%></textarea><br>
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"><br>
	</form>
	
	<a href="memo.do">리스트로 돌아가기</a>
	
	
	</body>
</html>