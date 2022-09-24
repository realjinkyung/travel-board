<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/login.do" method="post">
			아 이 디 : <input type="text", name="id" placeholder="아이디를 입력하세요">
			<br>
			비밀번호 : <input type="password", name="pw", placeholder="비밀번호를 입력하세요">
			<br>
			<input type="submit", value="로그인버튼">
		</form>
	</div>

</body>
</html>