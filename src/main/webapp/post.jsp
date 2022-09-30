<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>POST</title>

<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="footer.css">

<style>
.footer {
	margin-left: 0;
}

.modified {
	opacity: 0.3;
}

b {
	font-weight: bold;
}

.post-header {
	border-top: 2px solid gray;
	padding: 10px 0;
	padding-top: 20px;
}

.post-header-content {
	display: flex;
}

.post-header-content div:nth-child(1) {
	width: 8%;
	display: flex;
	align-items: center;
	padding-left: 30px;
}

.post-header-content div:nth-child(1) img {
	width: 40px;
	height: 40px;
	border-radius: 50%;
	border: 1px solid gray;
	overflow: hidden;
}

.post-header-content div:nth-child(2) {
	width: 70%;
	padding: 10px;
	line-height: 20px;
	font-size: 0.8rem;
}

.post-header-content div:nth-child(2) .createdAt-views {
	color: gray;
}

.post-header-content div:nth-child(2) p {
	width: 100%;
}

.post-header-content div:nth-child(3) {
	width: 22%;
	display: flex;
	align-items: center;
	font-size: 0.8rem;
	justify-content: flex-end;
	padding-right: 20px;
}

.post-content {
	border: 1px solid lightgray;
	min-height: 700px;
	padding: 15px;
	font-size: 0.8rem;
	margin-bottom: 15px;
}

.post-btn-area {
	position: relative;
	margin-bottom: 15px;
	height: 50px;
}

.post-btn-area button {
	position: absolute;
}

.post-btn-area .btn-modify {
	right: 65px;
}

.post-btn-area .btn-delete {
	right: 0;
}

.post-btn-area .btn-report {
	left: 0;
}

.comment-write {
	padding: 15px;
}

.comment-h3 {
	padding-left: 0;
	font-size: 1rem;
	margin-bottom: 10px;
}

.comment-write-box {
	height: 100px;
	border: 1px solid lightgray;
	outline: none;
	border-radius: 10px;
	padding: 15px;
}

.comment-write-box h4 {
	margin-bottom: 10px;
}

.comment-write-box b {
	font-size: 0.8rem;
}

.comment-write-box input {
	width: 100%;
	padding: 5px 10px;
	border: none;
	outline: none;
}

.text-align-right {
	text-align: right;
}

.btn-comment-register {
	color: gray;
	font-weight: bold;
	border: none;
	background-color: white;
	cursor: pointer;
}

.comment-list {
	padding: 15px;
}

.comment-item {
	display: flex;
	margin-bottom: 25px;
}

.comment-img {
	width: 8%;
	display: flex;
	padding-left: 30px;
	padding-top: 15px;
}

.comment-img img {
	width: 40px;
	height: 40px;
	border-radius: 50%;
	border: 1px solid gray;
	overflow: hidden;
}

.comment-content-area {
	width: 62%;
	padding: 10px 5px;
	line-height: 20px;
	font-size: 0.8rem;
	padding-top: 0;
}

.comment-username {
	width: 100%;
	margin-bottom: 3px;
}

.comment-content {
	width: 100%;
	color: gray;
	margin-bottom: 5px;
	min-height: 20px;
}

.comment-button-area {
	width: 30%;
	display: flex;
	justify-content: flex-end;
	padding-right: 20px;
	align-items: flex-end;
	align-content: flex-end;
}

.comment-button-area button {
	font-size: 0.6rem;
}

h2 {
	font-size: 1.5rem;
	margin: 20px 0;
	font-weight: bold;
}

h3 {
	font-size: 1.2rem;
	padding-left: 30px;
	font-weight: bold;
}

.btn-modify, .btn-delete, .btn-report {
	border: none;
	color: white;
	padding: 5px 15px;
	cursor: pointer;
}

.btn-modify {
	background-color: dodgerblue;
}

.btn-delete {
	background-color: red;
}

.btn-report {
	background-color: red;
}

.modify-comment-area {
	text-align: right;
}

.modify-comment-area input[type=text] {
	margin: 5px 0;
	padding: 7px 10px;
	width: 100%;
	border: 1px solid lightgray;
	font-size: 0.7rem;
	outline: none;
}

.modify-comment-area input[type=submit] {
	border: none;
	background-color: white;
	color: gray;
	padding: 5px 0;
	cursor: pointer;
	font-size: 0.7rem;
	font-weight: bold;
}
.image{
	width : 500px;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="wrap">
		<div style="width: 1000px; margin: 50px auto;">
			<h2>상세 게시글 조회</h2>
			<div class="post-header">
				<h3>${postview.title}</h3>
				<div class="post-header-content">
					<div>
						<img alt="" src="${profilePath}" style="">
					</div>
					<div>
						<p>
							<b>${postview.username}</b>
						</p>
						<p class="createdAt-views">${postview.createdAt}조회 1234</p>
					</div>

					<div>
						<span><b style="font-weight: bold;">댓글
								${fn:length(comments)}</b></span>
					</div>
				</div>
			</div>
			<div class="image">
				<img src="${path}"/>
			</div>
			<div class="post-content">
				<p>${postview.content}</p>
			</div>
			<div class="post-btn-area">
				<button class="btn-modify post" onclick="modifyPost();">수정</button>
				<button class="btn-delete post">삭제</button>
				<button class="btn-report post"
					onclick="report('${postview.postNo}', 0, '${sessionScope.username}', '${postview.username}', '${postview.content}', 'post');">신고</button>
<%--				onclick="report(0, '${comment.commentNo}', '${sessionScope.username}', '${comment.username}', '${comment.content}', 'comment');">신고</button>--%>
			</div>
			<div class="comment-write">
				<div>
					<h3 class="comment-h3">댓글 작성</h3>
					<div class="comment-write-box">
						<h4>
							<b>${sessionScope.username}</b>
						</h4>
						<input id="input-comment-content" type="text"
							placeholder="댓글을 남겨보세요">
						<div class="text-align-right">
							<button class="btn-comment-register" onclick="addComment();">등록</button>
						</div>
					</div>

				</div>
			</div>

			<div class="comment-list">
				<c:forEach items="${comments}" var="comment">
					<div class="comment-item">
						<div class="comment-img">
							<img alt="" src="${profilePath}">
						</div>
						<div class="comment-content-area">
							<p class="comment-username">
								<b>${comment.username}</b>
							</p>

							<c:choose>
								<c:when test="${comment.commentReportCount >= 5}">
									<p class="comment-content" id="comment${comment.commentNo}">댓글
										신고로 인해 블라인드 된 댓글입니다.</p>
								</c:when>
								<c:otherwise>
									<p class="comment-content" id="comment${comment.commentNo}">${comment.content}<span
											class="modified">${comment.modifiedAt}</span>
									</p>
								</c:otherwise>
							</c:choose>
							<p>${postview.createdAt}</p>
						</div>
						<div class="comment-button-area">
							<div>
								<button class="btn-modify"
									onclick="modifyComment('${comment.commentNo}', '${comment.username}', '${postview.postNo}')">수정</button>
								<button class="btn-delete"
									onclick="deleteComment('${comment.commentNo}');">삭제</button>
								<button class="btn-report"
									onclick="report(0, '${comment.commentNo}', '${sessionScope.username}', '${comment.username}', '${comment.content}', 'comment');">신고</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<form action="edit.do" method="post" id="edit_form">
		<input type="hidden" name="postNo" value="${postview.postNo}" /> <input
			type="hidden" name="title" value="${postview.title}" /> <input
			type="hidden" name="username" value="${postview.username}" /> <input
			type="hidden" name="createdAt" value="${postview.createdAt}" /> <input
			type="hidden" name="content" value="${postview.content}" />

	</form>

	<form action="addComment.do" method="post" id="add_form">
		<input type="hidden" id="comment-content" name="commentContent" /> <input
			type="hidden" name="postNo" value="${postview.postNo}" />
	</form>

	<form action="reportCommentPage.do" method="post" name="reportForm">
		<input type="hidden" name="postNum" /> <input type="hidden"
			name="commentNum" /> <input type="hidden" name="username" /> <input
			type="hidden" name="targetUsername" /> <input type="hidden"
			name="content" /> <input type="hidden" name="report_kinds" />
	</form>

	<script type="text/javascript">
		function modifyPost(){
			document.getElementById("edit_form").submit();
		}
		
		function addComment(){
			let inputContent = document.getElementById("input-comment-content").value;
			let formContent = document.getElementById("comment-content");
			
			formContent.value = inputContent;
	
			document.getElementById("add_form").submit();
		}
		
		function modifyComment(commentNum, username, postNo) {
			
	        const input =
				'<form action="updateComment.do" method="post" id="updateCommentForm '+ commentNum +'" >' +
				'<div class="modify-comment-area">' +
				'<input class="modify-input" type="text" name="updateComment"/>' +
				'<input type="hidden" name="username" value="' + username + '"/> ' +
				'<input type="hidden" name="commentNo" value="'+ commentNum +'"/> ' +
				'<input type="hidden" name="postNo" value="'+ postNo +'"/>' +
				'<input type="submit" value="댓글 수정"/>' +
				'</div>' +
				'</form>';
	
	        let form = document.getElementById("updateCommentForm "+ commentNum);
	        
	        if(form == null){
	        	document.getElementById("comment" + commentNum).insertAdjacentHTML("beforeend",input);
	        } else {
	            form.remove();
			}
	
		}
		
		function deleteComment(commentNo){
			location.href = "deleteComment.do?commentNo=" + commentNo + "&postNo=${postview.postNo}";
		}
		
		function report(postNum , commentNum, username, targetUsername, content, reportKinds) {
            
            reportForm.postNum.value = postNum;
			reportForm.commentNum.value = commentNum;
			reportForm.username.value = username;
			reportForm.targetUsername.value = targetUsername;
			reportForm.content.value = content;
			reportForm.report_kinds.value = reportKinds;
			
			
			reportForm.submit();
		}
	</script>

	


	<jsp:include page="footer.jsp" />
</body>
</html>
