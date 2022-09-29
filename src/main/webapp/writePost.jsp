<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>WritePost</title>
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="footer.css">
<style>
.footer {
	margin-left: 0;
}

html {
	display: flex;
	justify-content: center;
}

.title {
	width: 640px;
}

.content {
	margin-top: 10px;
	border: 1px black solid;
	width: 100%;
	height: 600px;
	resize: none;
	padding: 15px;
	outline: none;
}

h2 {
	font-size: 1.5rem;
	margin: 20px 0;
	font-weight: bold;
}

input[type=text] {
	width: 100%;
	padding: 5px 15px;
	font-size: 0.8rem;
	outline: none;
}

input[type=submit]{
	border: none;
	background-color: #03c75a;
	color: white;
	padding: 5px 15px;
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="wrap">
		<div style="width: 1000px; margin: 0 auto;">
			<h2>게시글 작성</h2>
			<div style="border-top: 2px solid gray; padding: 10px 0; border-bottom: 1px solid gray;">
				<form action="makePost.do" method="post">
					<input type="hidden" name="postNo" value="${postNo}" /> <input
						type="text" class="title" name="title" value="${title}"
						placeholder="제목을 입력하세요." />  <br />
					<%--	  <input type="text" class="content" name="content" value="${content}" placeholder="내용"/><br/>--%>
					<textarea name="content" class="content" placeholder="내용을 입력하세요.">${content}</textarea>
					<%--<input type="hidden" name="content" value="${}"> FIXME session에서 id값 받아서 입력해 줄 곳--%>
					<input type="hidden" name="userNo" value=1>
					<%--	FIXME 아이디 세션에서 받아와서 value에 넣어 줄것  --%>
					<%--<input type="hidden" name="boardNo" value=게시판 번호>--%>
					<input type="hidden" name="boardNo" value=1>
					<%--	  FIXME 이거는... 방법 생각해 볼것.   --%>
					<div style="text-align: right; padding: 10px 0;">
						<input type="submit" value="작성">
					</div>
					
					<!-- 
						<input type="file" name="file" class="file" value="찾아보기" />
					 -->
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
