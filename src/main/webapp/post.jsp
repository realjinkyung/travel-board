<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>POST</title>
</head>
<body>
<form action="edit.do" method="post">
	<input type="hidden" name="postNo" value="${postview.postNo}"/>
	<input type="text" name="title" value="${postview.title}"><br/>
	<input type="text" name="username" value="${postview.username}"><br/>
	<input type="text" name="content" value="${postview.content}"><br/>
	<input type="text" value="${postview.createdAt}"><br/>
	<input type="submit" value="수정">
</form>
	<a href=""><button>삭제</button></a>
</body>
</html>
