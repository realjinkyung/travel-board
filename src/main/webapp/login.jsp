<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
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
					alert("비밀번호를 입력하세요")
					pw.focus();
					return false;
				}
			}
		}	
	</script>
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
<<<<<<< HEAD
	
	<style>
		.wrap {
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
		
		.form-horizontal .control-label {
			float: none;
			width: none;
			padding: 0;
			text-align: left;
			
		}
		
		.form-horizontal .control-group {
			margin: 30px;
		}
		
		.form-horizontal .controls {
			margin: 0;
		}
		
		
		
		
	
	</style>
	
=======
	<style>
       .join{
		   width:62px;
		   margin-left : 11.2rem;
	   }
	   
	</style>
>>>>>>> af51c7d18fb95c8d5a963c33b2add4e4b39c4ecd
</head>
<body>
	<div class="container">
		<div class="input-form-background row">			
			<form class="form-horizontal" name="frm" action='login.do' method="POST">
				<div class="align-self-center">
				  <fieldset>
				  	<div class="wrap"> 
					  	<div class="max-wrap"> 
						  	
						    <div id="legend">
						      <legend class="">Login</legend>
						    </div>
						    
						    <div class="control-group">
						      <!-- Username -->
						      <div class="controls">
						        <label class="control-label"  for="username">아이디</label>   
						        <input type="text" id="username" name="id" placeholder="아이디를 입력하세요" class="input-xlarge">
						      </div>
						    </div>
						 
						    <div class="control-group">
						      <!-- Password-->
						      <div class="controls">
						   		<label class="control-label" for="password">비밀번호</label>
						        <input type="password" id="password" name="pw" placeholder="비밀번호를 입력하세요" class="input-xlarge">
						      </div>
						    </div>
						    
						    <div class="control-group">
						      <!-- Button -->
						  
						      <div class="controls-btns"></div>
							      <div class="controls">
							        <button class="btn btn-success">Login</button>
							        <button class="btn btn-primary" onclick="location.href='joinForm.jsp'">Join</button>
							      </div>
						    </div>
					    </div>
				    </div>
				    
				  </fieldset>
				</div>
			</form>
			<div class="controls">
				<a href="joinForm.jsp"><button class="btn btn-success join"  >Join</button></a>
			</div>
		</div>
	</div>
</body>
</html>