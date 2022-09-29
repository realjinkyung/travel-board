<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div style="position: relative;">
			<div class="logo-area">
				<a href="boardList.do">
					<img src="logo."/><span>Jeju Story</span>
				</a>
			</div>
			
			<div class="login-area">
				<c:choose>
					<c:when test="${sessionScope.username == null}">
						<button onclick="location.href = 'login.jsp'"">로그인</button>
					</c:when>
					<c:otherwise>
						<span>안녕하세요. <b><a href="userinfo.do">${sessionScope.username}</a></b>님</span>
						<button onclick="location.href = 'logout.do'">로그아웃</button>		
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>