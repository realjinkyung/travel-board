<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>POST</title>
	<style>
		html {
			display : flex;
			justify-content: center;
			margin-top : 5rem;
		}
		.title-line {
			margin-top : 1rem;
		}
		.content {
			margin-top : 2rem;
			border : 1px black solid;
			width : 642px;
			height: 600px;
		}
		.button {
			text-align: right;
		}
		.username {
			width: 5rem;
			overflow-style: marquee-line;
		}
		.createdAt {
			width : 5rem;
		}
		.title {
			width : 17rem;
		}
		.content {
			resize: none;
			font-size: 1rem;
		}
		.comment-content {
			margin-top : 0.5rem;
			width : 642px;
		}
		.comment-input {
			margin-top : 1rem;
			margin-bottom: 2rem;
			width : 642px;
		}
		.modified {
			opacity: 0.3;
		}
		.image {
			width: 50%;
		}
	</style>
</head>
<body>

<a href="boardList.do"><button>첫페이지로</button></a><br/>
<form action="edit.do" method="post" onsubmit="return TestCheck();">
	<input type="hidden" name="postNo" value="${postview.postNo}" />
	<div class="title-line">
	title : <input type="text" class="title" name="title" value="${postview.title}" readonly>
	username :	<input type="text" class="username" name="username" value="${postview.username}" readonly>
	createdAt : <input type="text" class="createdAt" value="${postview.createdAt}"><br/>
	</div>
	<div>
	<img src = "${path}" class="image"/>
	</div>
	<textarea name="content" class="content" id="content" readonly>${postview.content}</textarea>
	<input type="hidden" name="content" value="${postview.content}" class="content"><br/>
	<input type="submit" value="수정" class="button">
	<a href="deletePost.do?postNo=${postview.postNo}"><button class="button">삭제</button></a>
<%--	FIXME 버튼 오른쪽 정렬 --%>
</form>

<c:forEach var="comments" items="${comments}">
	<div class="comment-content" id="comment${comments.commentNo}">${comments.content} - ${comments.username} / ${comments.createdAt} <span class="modified">${comments.modifiedAt}</span>
<%--		username을 세션에서 받아와서 넘겨주는 로직 추가. username이 같은지 확인. --%>
		<button onclick="modifyComment(${comments.commentNo}, '${comments.username}', ${postview.postNo})">수정</button>
	<a href="deleteComment.do?commentNo=${comments.commentNo}&postNo=${postview.postNo}"><button>삭제</button></a>
	</div>
</c:forEach>

<form action="addComment.do" method="post">
	<input type="text" name="commentContent" class="comment-input"/>
	<input type="hidden" name="postNo" value="${postview.postNo}"/>
	<input type="submit" value="댓글 등록">
</form>


<script>
	function modifyComment(commentNum, username, postNo) {
        const input =
			'<form action="updateComment.do" method="post" id="updateCommentForm '+ commentNum +'" >' +
			'<input type="text" name="updateComment"/>' +
			'<input type="hidden" name="username" value="' + username + '"/> ' +
			'<input type="hidden" name="commentNo" value="'+ commentNum +'"/> ' +
			'<input type="hidden" name="postNo" value="'+ postNo +'"/>' +
			'<input type="submit" value="댓글 수정"/>' +
			'</form>';

        let form = document.getElementById("updateCommentForm "+ commentNum);
        
        if(form == null){
        	document.getElementById("comment" + commentNum).insertAdjacentHTML("beforeend",input);
        } else {
            form.remove();
		}
    
  
	function TestCheck() {
		if("${param.username}" == "${sessionScope.username}"){
			alert("같음");
			retuen true;
		}else{
			alert("권한이 없습니다.")
			return false;
		}
		}
	}
    
  	
  	
	}
</script>
</body>
</html>
