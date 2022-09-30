<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="footer.css">
<style type="text/css">
h2 {
	font-size: 1.5rem;
	margin: 20px 0;
	font-weight: bold;
}

.report-li{
	border-bottom: 1px solid lightgray; 
	padding: 15px 30px; 
	font-size: 0.8rem;
	cursor: pointer;
}

.report-li:last-child {
	border-bottom: none;
}

.report-li.selected{
	background-color: indianred;
	color: white;
	font-weight: bold;
}

button{
	border: none;
	background-color: red;
	color: white;
	padding: 5px 15px;
	cursor: pointer;
}

.footer {
	margin-left: 0;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div style="width: 1000px; margin: 50px auto;">
		
		<h2>신고</h2>
		<div style="border-top: 2px solid gray;">
			<h3 style="margin: 30px 0; margin-bottom: 15px; font-size: 0.9rem; font-weight: bold;">신고 내용</h3>
			<div style="border: 1px solid lightgray; min-height: 150px; padding: 15px; font-size: 0.8rem;">
				<p>${content}</p>
			</div>
			<h3 style="margin: 30px 0; margin-bottom: 15px; font-size: 0.9rem; font-weight: bold;">신고 사유</h3>
			<div style="border: 1px solid lightgray;">
				<div>
					<ul>
						<li id="report-1" class="report-li" onclick="checkReportReason(event);">
							<span>불법 정보를 포함하고 있습니다.</span>
						</li>
						<li id="report-2" class="report-li" onclick="checkReportReason(event);">
							<span>청소년에게 유해한 내용입니다.</span>
						</li>
						<li id="report-3" class="report-li" onclick="checkReportReason(event);">
							<span>욕설/생명경시/혐오/차별적 표현입니다.</span>
						</li>
						<li id="report-4" class="report-li" onclick="checkReportReason(event);">
							<span>스팸홍보/도배글입니다.</span>
						</li>
						<li id="report-5" class="report-li" onclick="checkReportReason(event);">
							<span>개인정보 노출 게시물 입니다.</span>
						</li>
						<li id="report-6" class="report-li" onclick="checkReportReason(event);">
							<span>불쾌한 표현이 있습니다.</span>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div style="padding: 15px 0; text-align: right;">
			<button onclick="report();">신고</button>
		</div>
	</div>
	
	<form action="reportComment.do" method="post" id="form-report">
		<input type="hidden" name="postNum" value="${postNum}">
		<input type="hidden" name="commentNum" value="${commentNum}">
		<input type="hidden" name="username" value="${username}">
		<input type="hidden" name="targetUsername" value="${targetUsername}">
		<input type="hidden" name="reportKinds" value="${reportKinds}">
		<input type="hidden" name="report_reason" id="report-reason" value="0">
	</form>
	
	<script type="text/javascript">
		let selectReport = 1;
		
		function checkReportReason(event){
			document.getElementsByClassName("report-li")[selectReport - 1].classList.remove("selected");
			event.currentTarget.classList.add("selected");
			
			selectReport = event.currentTarget.id.split("-")[1];
			
			document.getElementById("report-reason").value = selectReport;
		}
		
		function report(){
			let reportNumber = document.getElementById("report-reason").value;
			
			if(reportNumber == 0){
				alert("신고 사유를 선택하세요.")
			}else{
				document.getElementById("form-report").submit();
			}
		}
	</script>
	<jsp:include page="footer.jsp" />
</body>
</html>