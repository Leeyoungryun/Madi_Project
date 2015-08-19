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
		<div class = "size">
		    <article class = "post post-blog">
		     <br><br><br>
		      <img src = "http://photo.toast.com/aaaadc/abc/head.png"/>
		      <div class = "details">    
			      <form name=updateForm method=post action="memo.do" onSubmit='return checkValid()'>
			      	<input type="hidden" value="update" name="command">
			      	<input type="hidden" name='num' value="<%=resultContent.getMemoNum()%>">
			      	<input type="hidden" name="member" size="30" value="<%=resultContent.getMemberNum()%>">
	
					<div class="meta">
			          <p>Written by <strong><%=resultContent.getMemberNum()%></strong></p>
			        </div>
					<input type = "text" name = "title" cols = "30" rows = "1" class = "no-line" placeholder = "<%=resultContent.getTitle()%>"><br><br>
					<p>Content</p><textarea name = "content" cols = "30" rows="5" class = "no-line"><%=resultContent.getContent()%></textarea><br><br><br>
			        <input type = "text" name = "hashtag1" class = "btn no-line" value = "<%=resultContent.getHashTag1()%>">&nbsp;&nbsp;
			        <input type = "text" name = "hashtag2" class = "btn no-line" value = "<%=resultContent.getHashTag2()%>">&nbsp;&nbsp;
			        <input type = "text" name = "hashtag3" class = "btn no-line" value = "<%=resultContent.getHashTag3()%>"><br><br>
			        <div class="intents">
			        	<span class="icon-heart"></span>
						<span class="count"><%=resultContent.getWriteday()%></span>
			        </div>
					<div class="btn-group" data-grouptype="OR">
						<input type="submit" value="Update" class="no-line btn btn-primary btn-large btn-caps">
						<input type="reset" value="Delete" class="no-line btn btn-secondary btn-large btn-caps">
			        </div>
				  </form>
		      </div>
		    </article> 
	  </div>
	</body>
</html>