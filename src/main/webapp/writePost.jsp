<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>WritePost</title>
</head>
<body>
  <h2>test page</h2>
  <form action="makePost.do" method="post">
	  <input type="hidden" name="postNo" value="${postNo}">
<input type="text" name="title" value="${title}"/>
<input type="text" name="content" value="${content}"/>
<%--<input type="hidden" name="content" value="${}"> FIXME session에서 id값 받아서 입력해 줄 곳--%>
<input type="hidden" name="userNo" value=1>
<%--<input type="hidden" name="boardNo" value=게시판 번호>--%>
<input type="hidden" name="boardNo" value=1>
	  <input type="submit" value="작성">
  </form>

</body>
</html>
