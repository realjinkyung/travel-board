<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
	<title>회원가입</title>
</head>
	
<body>
	<div class="container">
		<div class="input-form-background row">			
			<form class="form-horizontal" action='join.do' method="POST">
			  <fieldset>
			    <div id="legend">
			      <legend class="">Register</legend>
			    </div>
			    <div class="control-group">
			      <!-- 아이디 -->
			      <label class="control-label"  for="username">아이디</label>
			      <div class="controls">
			        <input type="text" id="username" name="username" placeholder="아이디를 입력하세요" class="input-xlarge">
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- 비밀번호-->
			      <label class="control-label" for="password">비밀번호</label>
			      <div class="controls">
			        <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" class="input-xlarge">
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- 비밀번호 재확인 -->
			      <label class="control-label"  for="password_confirm">비밀번호 재확인</label>
			      <div class="controls">
			        <input type="password" id="password_confirm" name="passwordCheck" placeholder="비밀번호를 다시 입력하세요" class="input-xlarge">
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- 이름 -->
			      <label class="control-label" for="name">이름</label>
			      <div class="controls">
			        <input type="text" id="name" name="name" placeholder="이름을 입력하세요" class="input-xlarge">
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- 생년월일 -->
			      <label class="control-label" for="birth">생년월일</label>
			      <div class="controls">
			        <input type="date" id="birth" name="birth" class="input-xlarge">
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- E-mail -->
			      <label class="control-label" for="email">E-mail</label>
			      <div class="controls">
			        <input type="text" id="email" name="email" placeholder="name@example.com" class="input-xlarge">
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- 전화번호 -->
			      <label class="control-label" for="phone">전화번호</label>
			      <div class="controls">
			        <input type="tel" id="phone" name="phoneNumber" placeholder="전화번호를 입력하세요" class="input-xlarge">
			      </div>
			    </div>
			  
			    <div class="control-group">
			      <!-- 성별 -->
			      <label class="control-label" for="gender">성별</label>
			      <div class="form-check form-check-inline">
							<input type="radio" id="gender" name="gender" value="남">남성
							<input type="radio" id="gender" name="gender"value="여">여성
			      </div>
			    </div>
			    
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success">Register</button>
			      </div>
			    </div>
			  </fieldset>
			</form>
		</div>
	</div>
</body>
</html>