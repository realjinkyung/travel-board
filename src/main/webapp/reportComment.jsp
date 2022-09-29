<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>내용</h2>
	<p>content : ${content}</p>
	
	<form action="reportComment.do" method="post" onsubmit="return checkReport();">
		<input type="hidden" name="postNum" value="${postNum}">
		<input type="hidden" name="commentNum" value="${commentNum}">
		<input type="hidden" name="username" value="${username}">
		<input type="hidden" name="targetUsername" value="${targetUsername}">
		<input type="hidden" name="reportKinds" value="${reportKinds}">
		<select name="report_reason" id="test">
			<option disabled="disabled" value="0">신고 사유를 선택하세요.</option>
			<option value="1">불법 정보를 포함하고 있습니다</option>
			<option value="2">청소년에게 유해한 내용입니다</option>
			<option value="3">욕설/생명경시/혐오/차별적 표현입니다</option>
			<option value="4">스팸홍보/도배글입니다</option>
			<option value="5">개인정보 노출 게시물 입니다</option>
			<option value="6">불쾌한 표현이 있습니다</option>
		</select>
		<input type="submit" value="신고 하기">
	</form>
	
	<script type="text/javascript">
		function checkReport(){
			let reason = document.getElementById("test").value;
			
			if(reason == 0){
				alert("신고 사유를 선택하세요.");
				return false;
			}
		}
	</script>
	
</body>
</html>