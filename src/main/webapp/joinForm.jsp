<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
	
<body>
	<div>
		<form action="join.do" method="post">
			<br><br>
			<h3>회원가입</h3>
			<br><br>
			<p>아  이  디     : <input type="text" name="username" placeholder="아이디를 입력하세요"><br></p>
			<p>비  밀  번  호   : <input type="password" name="password" placeholder="비밀번호를 입력하세요"> <br></p>
			<p>비밀번호 재확인 : <input type="password" name="passwordCheck" placeholder="비밀번호를 다시 입력하세요"> <br></p>
			<p>이     름    : <input type="text" name="name" placeholder="이름을 입력하세요"> <br></p>
			<p>생  년  월  일   : 
			  	<div class="info" id="birth">
			  		<input type="date" name="birth">
			  	</div><br>
			</p>
			<p> 이  메  일      : <input type="text" name="email" placeholder="이메일을 입력하세요"><br></p>
			<p> 전 화 번 호    : <input type="text" name="phoneNumber" placeholder="전화번호를 입력하세요"><br></p>
			<p>
				성     별 : 
				<input type="radio" name="gender" value="남">남성
				<input type="radio" name="gender" value="여">여성
			</p><br><br>
			<input type="submit" value="회원가입"><br>
		</form>
	</div>

</body>
</html>