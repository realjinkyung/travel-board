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
.submit-area{
	font-size: 0.8rem;
	position: relative;
	height: 40px;
}


.submit-area label{
	position: absolute;
	border: none;
	background-color: #03c75a;
	color: white;
	padding: 8px 15px;
	cursor: pointer;
	margin-top: 10px;
	left: 0;
}

input[type=submit]{
	position: absolute;
	border: none;
	background-color: #03c75a;
	color: white;
	padding: 5px 15px;
	cursor: pointer;
	margin-top: 10px;
	right: 0;
}

.category{
	width: 100%;
	padding: 10px 15px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
<!-- 

	<div id="pageTitle"></div>
  <form action="makePost.do" method="post" enctype="multipart/form-data">
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
	  <input type="file" name="image" class="file" value="찾아보기"/> <br/>
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

 -->
	<jsp:include page="header.jsp" />
	<div class="wrap">
		<div style="width: 1000px; margin: 0 auto;">
			<div id="pageTitle"></div>
			<div style="border-top: 2px solid gray; padding: 10px 0; border-bottom: 1px solid gray;">
				<form action="makePost.do" method="post" enctype="multipart/form-data">
					<select name="boardNo" class="category">
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
					<input id="input-file" type="file" name="image" class="file" value="찾아보기" style="display: none"/> <br/>
					
					
					
					
					
					
					
					<input type="hidden" name="postNo" value="${postNo}"/>
					<input type="text" class="title" name="title" value="${title}" placeholder="제목"/>
					
					<%--	  <input type="text" class="content" name="content" value="${content}" placeholder="내용"/><br/>--%>
					<textarea name="content" class="content" placeholder="내용">${content}</textarea>
					<%--<input type="hidden" name="content" value="${}"> FIXME session에서 id값 받아서 입력해 줄 곳--%>
					<input type="hidden" name="userNo" value=1>
					<%--	FIXME 아이디 세션에서 받아와서 value에 넣어 줄것  --%>
					<%--<input type="hidden" name="boardNo" value=게시판 번호>--%>
					<div class="submit-area">
						<label for="input-file">파일 첨부</label>
						<input type="submit" value="작성">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 
						<input type="file" name="file" class="file" value="찾아보기" />
					 -->
	<jsp:include page="footer.jsp" />

<script>
    const status = '${status}';

    if( status === '1'){
        console.log("in status1");
        document.getElementById("pageTitle").innerHTML = "<h2> 게시글 작성 </h2>";
    } else {
        console.log("in status2")
        console.log(status)
        document.getElementById("pageTitle").innerHTML = "<h2> 게시글 수정 </h2>";
    }
</script>

</body>
</html>
