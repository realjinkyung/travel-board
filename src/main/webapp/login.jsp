<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<script type="text/javascript">
	// 유효성 검증 예정
	window.onload = function() {
		document.frm.onsubmit = function() {
			var id = document.frm.id;
			var pw = document.frm.pw;
			
			if(!id.value) {
				alert("아이디를 입력하세요")
				id.focus();
				return false;
			}
			if(!pw.value) {
				alert("아이디를 입력하세요")
				pw.focus();
				return false;
			}
		}
	}	
</script>
</head>
<body>
	<div>
		<form action="login.do" method="post" name="frm">
			아 이 디 : <input type="text", name="id" placeholder="아이디를 입력하세요">
			<br>
			비밀번호 : <input type="password", name="pw", placeholder="비밀번호를 입력하세요">
			<br>
			<input type="submit", value="로그인버튼">
		</form>
	</div>

</body>
</html>