<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<style>
		.input-form-background row {
		    width: 100%;
		    height: 100vh;
		    position: relative;
		}
	
		.max-wrap {
			position: absolute;
		    left: 50%;
		    top: 50%;
		    transform: translate(-50%, -50%);
		}
	</style>
	<title>회원가입</title>
</head>
<body>
	<div class="container">
		<div class="input-form-background row">	
			<div class="max-wrap">
				<form class="form-horizontal" action='join.do' method="POST">
				  <fieldset>
				  
				    <div id="legend">
				      <legend class="">Register</legend>
				    </div>
				    
					    <%-- 프로필 사진 업로드  --%>
					  <div class="control-group">
						  <input type="file" name="image"/>
					  </div>
				
				    <div class="control-group">
				      <!-- 아이디 -->
				      <label class="control-label"  for="username">아이디</label>
				      <div class="controls">
				        <input type="text" id="username" name="username" placeholder="아이디를 입력하세요" class="input-xlarge">
				        <button type="button" onclick= "checkId()">아이디 중복체크</button>
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
	</div>
	<!-- <script type="text/javascript">
		/* axios 아이디 중복 체크 */
		/* GET : URL / POST : URL X */
		function checkId() {
			let checkUserId = document.getElementById("username").value 	/* "id 값"을  getElementById() 안에  + value 값을 들고 와야 함*/
			console.log(checkUserId); /* 데이터 넘어옴 console */
			axios.get("./join.do", /* 보내는 URL */
						{params:{"checkUserId":checkUserId}}
						).then(res => console.log(res)) /* 확인 */
						/* 보낼 데이터 checkUserId(입력한 아이디)를 params로 보냄 , key : value JSON*/	 
		}
	</script> -->
</body>
</html>