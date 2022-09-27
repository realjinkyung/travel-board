<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>WritePost</title>
	<style>
		html {
			display: flex;
			justify-content: center;
		}
		.title {
			width : 640px;
		}
		.content{
            margin-top : 2rem;
            border : 1px black solid;
            width : 642px;
            height: 600px;
			resize: none;
			
		}
        .content::-webkit-input-placeholder {
            text-align: center;
			align-content: center;
        }
	</style>
</head>
<body>
  <h2>글쓰기</h2>
  <form action="makePost.do" method="post">
	  <input type="hidden" name="postNo" value="${postNo}"/>
	  <input type="text" class="title" name="title" value="${title}" placeholder="제목"/>
	  <input type="file" name="file" class="file" value="찾아보기"/> <br/>
<%--	  <input type="text" class="content" name="content" value="${content}" placeholder="내용"/><br/>--%>
	  <textarea name="content" class="content" placeholder="내용">${content}</textarea>
<%--<input type="hidden" name="content" value="${}"> FIXME session에서 id값 받아서 입력해 줄 곳--%>
<input type="hidden" name="userNo" value=1>
<%--	FIXME 아이디 세션에서 받아와서 value에 넣어 줄것  --%>
<%--<input type="hidden" name="boardNo" value=게시판 번호>--%>
<input type="hidden" name="boardNo" value=1>
<%--	  FIXME 이거는... 방법 생각해 볼것.   --%>
	  <input type="submit" value="작성">
  </form>

</body>
</html>
