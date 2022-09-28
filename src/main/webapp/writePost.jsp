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
	<div id="pageTitle"></div>
  <form action="makePost.do" method="post">
	  <select name="boardNo">
		  <option value="1">한경면</option>
		  <option value="2">한림읍</option>
		  <option value="3">애월읍</option>
		  <option value="4">제주시</option>
		  <option value="5">조천읍</option>
		  <option value="6">구좌읍</option>
		  <option value="7">대정읍</option>
		  <option value="8">안덕면</option>
		  <option value="9">서귀포시</option>
		  <option value="10">남원면</option>
		  <option value="11">표선면</option>
		  <option value="12">성산읍</option>
	  </select>
	  <input type="hidden" name="postNo" value="${postNo}"/>
	  <input type="text" class="title" name="title" value="${title}" placeholder="제목"/>
	  <input type="file" name="file" class="file" value="찾아보기"/> <br/>
<%--	  <input type="text" class="content" name="content" value="${content}" placeholder="내용"/><br/>--%>
	  <textarea name="content" class="content" placeholder="내용">${content}</textarea>
<%--<input type="hidden" name="content" value="${}"> FIXME session에서 id값 받아서 입력해 줄 곳--%>
<input type="hidden" name="userNo" value=1>
<%--	FIXME 아이디 세션에서 받아와서 value에 넣어 줄것  --%>
<%--<input type="hidden" name="boardNo" value=게시판 번호>--%>
	  <input type="submit" value="작성">
  </form>
	
	
	<script>
        const status = ${status};

        if( status === 1){
            console.log("in status1");
            document.getElementById("pageTitle").innerHTML = "<h2> 글 작성 </h2>";
        } else {
            document.getElementById("pageTitle").innerHTML = "<h2> 글 수정 </h2>";
        }
	</script>

</body>
</html>
