<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="footer.css">
<style type="text/css">
	/* http://meyerweb.com/eric/tools/css/reset/ 
	   v2.0 | 20110126
	   License: none (public com.douzone.travel.domain)
	*/
	
	html, body, div, span, applet, object, iframe,
	h1, h2, h3, h4, h5, h6, p, blockquote, pre,
	a, abbr, acronym, address, big, cite, code,
	del, dfn, em, img, ins, kbd, q, s, samp,
	small, strike, strong, sub, sup, tt, var,
	b, u, i, center,
	dl, dt, dd, ol, ul, li,
	fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td,
	article, aside, canvas, details, embed, 
	figure, figcaption, footer, header, hgroup, 
	menu, nav, output, ruby, section, summary,
	time, mark, audio, video {
		margin: 0;
		padding: 0;
		border: 0;
		font-size: 100%;
		font: inherit;
		vertical-align: baseline;
	}
	/* HTML5 display-role reset for older browsers */
	article, aside, details, figcaption, figure, 
	footer, header, hgroup, menu, nav, section {
		display: block;
	}
	body {
		line-height: 1;
	}
	ol, ul {
		list-style: none;
	}
	blockquote, q {
		quotes: none;
	}
	blockquote:before, blockquote:after,
	q:before, q:after {
		content: '';
		content: none;
	}
	table {
		border-collapse: collapse;
		border-spacing: 0;
	}
	
	*{box-sizing: border-box;}
	
	/* common-css end */
	
	.wrap{
		width: 1500px;
		margin: 15px auto;
	}

	.table-wrap{
		width: 100%;
		display: flex;
		position: relative;
	}
	
	/* board-css start */
	
	.board-wrap{
		width: 16%;
	}
	
	.board-wrap > h2{
		margin: 30px 0;
		font-size: 1.5rem;
		font-weight: bold;
	}
	
	.board-area h3{
		font-size: 1rem;
		font-weight: bold;
		margin: 30px 0;
		text-align: right;
		padding: 0 30px;
	}
	
	.board-area li{
		padding: 17px 30px;
		text-align: right;
		font-size: 0.8rem;
	}
	
	.board-area a{
		color: black;
		text-decoration: none;
	}
	
	.board-area a.seleted{
		color: orange;
	}
	/* board-css end */
	
	
	
	
	
	
	
	
	
	 /* post-css start */
	 
	.post-wrap{
		width: 84%;
		padding: 0 15px;
	}
	
	.post-wrap > h2 {
		margin: 20px 0;
		font-size: 1.5rem;
		font-weight: bold;
	}
	
	.post-wrap table{
		border-collapse: collapse;
		width: 100%;
		border-top: 2px solid gray;
	}
	.th-writer{
		text-align: left;
	}
	
	.post-wrap table{
		font-size: 0.8rem;
	}
	
	.post-wrap th{
		font-size: 0.9rem;
		font-weight: bold;
	}
	
	.post-wrap table tr{
		border-bottom: 1px solid whitesmoke;
	}
	
	.post-wrap table tr th, td{
		padding: 18px 0;
	}
	
	.post-wrap table .post-no, .created-date, .views{
		text-align: center;
	}
	
	.post-wrap table .title b{
		font-weight: bold;
		color: #03c75a;
		
	}
	
	.post-wrap table .title a{
		color: black;
		text-decoration: none;
	}
	
	.post-wrap table .title a:hover{
		text-decoration: underline;
	}
	
	.btn-new-area{
		position: absolute;
		bottom: -50px;
		right: 15px;
	}
	
	.post-none{
		padding: 250px 0;
		text-align: center;
		font-size: 0.8rem;
			
	}
	
	.blind_post{
		color: lightgray;
	}
	
	.blind_post b{
		font-weight: bold;
		opacity: 0.2;
	}
	
	.blind_post .title a{
		color: lightgray!important;
	}
	
	.blind_post .title a:hover{
		text-decoration: none!important;
	}
	
	.page-numbers{
		text-align: center;
		padding: 30px 0;
	}
	.page-number{
		display: inline-block;
		margin: 0 7px;
	}
	
	.page-number a{
		padding: 4px 7px;
	} 
	
	.page-number.selected a{
		color: #03c75a;
		border: 1px solid lightgray;
	}
	.page-number a{
		font-size: 0.8rem;
		font-weight: bold;
		color: black;
		text-decoration: none;
	}
	
	.page-number a:hover {
		text-decoration: underline;
	}
	
	.search-area{
		text-align: center;
		font-size: 0.8rem;
	}
	
	.search-area select, input, button{
		height: 30px;
	}
	
	.search-area select{
		width: 120px;
		padding-left: 5px;
		padding-right: 15px;
	}
	
	.search-area input{
		width: 300px;
		padding-left: 5px;
		padding-right: 15px;
	}
	
	.search-area button, .btn-new-post{
		border: none;
		background-color: #03c75a;
		color: white;
		padding: 0 10px;
		cursor: pointer;
	}
	
	/* post-css end */
	

}
</style>

</head>
<body>

<div class="wrap">
<!--
	<div class="login-area">
		<c:choose>
			<c:when test="${sessionScope.username == null}">
				<button onclick="location.href = 'login.jsp'">로그인</button>
			</c:when>
			<c:otherwise>
				<span>안녕하세요. <b><a href="userinfo.do">${sessionScope.username}</a></b>님</span>
				<button onclick="location.href = 'logout.do'">로그아웃</button>		
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="board-wrap">
		<div class="logo-area">

			<a href="boardList.do">

				<img src="logo."/><span>Jeju Story</span>
			</a>
		</div>
		<div class="board-area">
			<h3><a id="board-all" href="boardList.do?board=all">전체보기</a></h3>
			<div>
				<h3>제주시</h3>
				<ul>
					<li><a id="board-1" href="boardList.do?board=한경면">한경면</a></li>
					<li><a id="board-2" href="boardList.do?board=한림읍">한림읍</a></li>
					<li><a id="board-3" href="boardList.do?board=애월읍">애월읍</a></li>
					<li><a id="board-4" href="boardList.do?board=제주시">제주시</a></li>
					<li><a id="board-5" href="boardList.do?board=조천읍">조천읍</a></li>
					<li><a id="board-6" href="boardList.do?board=구좌읍">구좌읍</a></li>		
				</ul>	
			</div>
				
			<div>
				<h3>서귀포시</h3>
				<ul>
					<li><a id="board-7" href="boardList.do?board=대정읍">대정읍</a></li>
					<li><a id="board-8" href="boardList.do?board=안덕면">안덕면</a></li>
					<li><a id="board-9" href="boardList.do?board=서귀포시">서귀포시</a></li>
					<li><a id="board-10" href="boardList.do?board=남원면">남원면</a></li>
					<li><a id="board-11" href="boardList.do?board=표선면">표선면</a></li>
					<li><a id="board-12" href="boardList.do?board=성산읍">성산읍</a></li>		
				</ul>	
			</div>
		</div>
		<script type="text/javascript">
			switch("${param.board}"){
				case "all":
					document.getElementById("board-all").classList.add("seleted");
					break;
				case "한경면":
					document.getElementById("board-1").classList.add("seleted");
					break;
				case "한림읍":
					document.getElementById("board-2").classList.add("seleted");
					break;
				case "애월읍":
					document.getElementById("board-3").classList.add("seleted");
					break;
				case "제주시":
					document.getElementById("board-4").classList.add("seleted");
					break;
				case "조천읍":
					document.getElementById("board-5").classList.add("seleted");
					break;
				case "구좌읍":
					document.getElementById("board-6").classList.add("seleted");
					break;
				case "대정읍":
					document.getElementById("board-7").classList.add("seleted");
					break;
				case "안덕면":
					document.getElementById("board-8").classList.add("seleted");
					break;
				case "서귀포시":
					document.getElementById("board-9").classList.add("seleted");
					break;
				case "남원면":
					document.getElementById("board-10").classList.add("seleted");
					break;
				case "표선면":
					document.getElementById("board-11").classList.add("seleted");
					break;
				case "성산읍":
					document.getElementById("board-12").classList.add("seleted");
					break;
				default:
					document.getElementById("board-all").classList.add("seleted");
					break;
			}
		</script>
	</div>
	
	<div class="post-wrap">
		<h2>전체글보기</h2>
		<a href="newPost.do?status=1"><button>새글쓰기</button></a>
		<div>
			<table>
				<tr>
					<th width="5%">글번호</th>
					<th width="55%">제목</th>
					<th width="15%" class="th-writer">작성자</th>
					<th width="15%">작성일</th>
					<th width="10%">조회</th>
				</tr>
				<c:choose>
					<c:when test="${fn:length(postList) != 0}">
						<c:forEach begin="0" end="5">
							<c:forEach var="post" items="${postList}">
								<tr>
									<td class="post-no">${post.postNo}</td>
									<td class="title"><a href="post.do?postNo=${post.postNo}&status=${true}&username=${post.username}">${post.title}</a><b><c:if test="${post.commentCount != 0}">[${post.commentCount}]</c:if></b></td>
									<td class="writer">${post.username}</td>
									<td class="created-date">${post.createdAt}</td>
									<td class="views">${post.views}</td>
								</tr>
							</c:forEach>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td class="post-none" colspan="5"><p>게시물이 존재하지 않습니다.</p></td>
						</tr>					
					</c:otherwise>
				</c:choose>

			</table>
			<div class="page-numbers">
				<ul>
					<c:choose>
						<c:when test="${param.board == null}">
							<li class="page-number"><a href="boardList.do?page_number=1&board=all">1</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-number"><a href="boardList.do?page_number=1&board=${param.board}&search_option=${param.search_option}&search_content=${param.search_content}">1</a></li>
						</c:otherwise>
					</c:choose>
					-->

	<jsp:include page="header.jsp"/>
	
	<div class="table-wrap">
		<div class="board-wrap">
			
			<div class="board-area">
				<h3><a id="board-all" href="boardList.do?board=all">전체보기</a></h3>
				<div>
					<h3>제주시</h3>
					<ul>
						<li><a id="board-1" href="boardList.do?board=한경면">한경면</a></li>
						<li><a id="board-2" href="boardList.do?board=한림읍">한림읍</a></li>
						<li><a id="board-3" href="boardList.do?board=애월읍">애월읍</a></li>
						<li><a id="board-4" href="boardList.do?board=제주시">제주시</a></li>
						<li><a id="board-5" href="boardList.do?board=조천읍">조천읍</a></li>
						<li><a id="board-6" href="boardList.do?board=구좌읍">구좌읍</a></li>		
					</ul>	
				</div>
					
				<div>
					<h3>서귀포시</h3>
					<ul>
						<li><a id="board-7" href="boardList.do?board=대정읍">대정읍</a></li>
						<li><a id="board-8" href="boardList.do?board=안덕면">안덕면</a></li>
						<li><a id="board-9" href="boardList.do?board=서귀포시">서귀포시</a></li>
						<li><a id="board-10" href="boardList.do?board=남원면">남원면</a></li>
						<li><a id="board-11" href="boardList.do?board=표선면">표선면</a></li>
						<li><a id="board-12" href="boardList.do?board=성산읍">성산읍</a></li>		
					</ul>	
				</div>
			</div>
			<script type="text/javascript">
				switch("${param.board}"){
					case "all":
						document.getElementById("board-all").classList.add("seleted");
						break;
					case "한경면":
						document.getElementById("board-1").classList.add("seleted");
						break;
					case "한림읍":
						document.getElementById("board-2").classList.add("seleted");
						break;
					case "애월읍":
						document.getElementById("board-3").classList.add("seleted");
						break;
					case "제주시":
						document.getElementById("board-4").classList.add("seleted");
						break;
					case "조천읍":
						document.getElementById("board-5").classList.add("seleted");
						break;
					case "구좌읍":
						document.getElementById("board-6").classList.add("seleted");
						break;
					case "대정읍":
						document.getElementById("board-7").classList.add("seleted");
						break;
					case "안덕면":
						document.getElementById("board-8").classList.add("seleted");
						break;
					case "서귀포시":
						document.getElementById("board-9").classList.add("seleted");
						break;
					case "남원면":
						document.getElementById("board-10").classList.add("seleted");
						break;
					case "표선면":
						document.getElementById("board-11").classList.add("seleted");
						break;
					case "성산읍":
						document.getElementById("board-12").classList.add("seleted");
						break;
					default:
						document.getElementById("board-all").classList.add("seleted");
						break;
				}
			</script>
		</div>
		
		<div class="post-wrap">
			<h2>전체글보기</h2>
			<div>
				<div style="position: relative;">
					<table>
						<tr>
							<th width="5%">글번호</th>
							<th width="55%">제목</th>
							<th width="15%" class="th-writer">작성자</th>
							<th width="15%">작성일</th>
							<th width="10%">조회</th>
						</tr>
						<c:choose>
							<c:when test="${fn:length(postList) != 0}">
								<c:forEach var="post" items="${postList}">
									<c:choose>
										<c:when test="${post.isBlinded == 0}">
											<c:choose>
												<c:when test="${post.postReportCount >= 5}">
													<tr class="blind_post">
														<td class="post-no">${post.postNo}</td>
														<td class="title"><a>게시글 신고로 인해 블라인드 된 글입니다.</a><b><c:if test="${post.commentCount != 0}">[${post.commentCount}]</c:if></b></td>												
														<td class="writer">${post.username}</td>
														<td class="created-date">${post.createdAt}</td>
														<td class="views">${post.views}</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td class="post-no">${post.postNo}</td>												
														<td class="title"><a href="post.do?postNo=${post.postNo}&status=${true}&username=${post.username}">${post.title}</a><b><c:if test="${post.commentCount != 0}">[${post.commentCount}]</c:if></b></td>
														<td class="writer">${post.username}</td>
														<td class="created-date">${post.createdAt}</td>
														<td class="views">${post.views}</td>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<tr class="blind_post">
												<td class="post-no">${post.postNo}</td>
												<c:choose>
													<c:when test="${post.postReportCount >= 5}">
														<td class="title"><a>게시글 신고로 인해 블라인드 된 글입니다.</a><b><c:if test="${post.commentCount != 0}">[${post.commentCount}]</c:if></b></td>												
													</c:when>
													<c:otherwise>
														<td class="title"><a>사용자 신고로 인해 블라인드 된 글입니다.</a><b><c:if test="${post.commentCount != 0}">[${post.commentCount}]</c:if></b></td>
													</c:otherwise>
												</c:choose>
												
												<td class="writer">${post.username}</td>
												<td class="created-date">${post.createdAt}</td>
												<td class="views">${post.views}</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td class="post-none" colspan="5"><p>게시물이 존재하지 않습니다.</p></td>
								</tr>					
							</c:otherwise>
						</c:choose>
					</table>
					<div class="btn-new-area">
						<a href="newPost.do"><button class="btn-new-post">새글쓰기</button></a>
					</div>
				</div>
				<div class="page-numbers">
					<ul>
						<c:choose>
							<c:when test="${param.board == null}">
								<li class="page-number"><a href="boardList.do?page_number=1&board=all">1</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-number"><a href="boardList.do?page_number=1&board=${param.board}&search_option=${param.search_option}&search_content=${param.search_content}">1</a></li>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${(postCount%10) == 0 && (postCount/10) >= 1 }">
								<c:forEach begin="1" end="${(postCount/10) - 1}" varStatus="i">
									<li class="page-number"><a href="boardList.do?page_number=${i.count + 1}&board=${param.board}&search_option=${param.search_option}&search_content=${param.search_content}">${i.index + 1}</a></li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:if test="${(postCount%10) != 0 && (postCount/10) >= 1 }">
									<c:forEach begin="1" end="${(postCount/10)}" varStatus="i">
										<li class="page-number"><a href="boardList.do?page_number=${i.count + 1}&board=${param.board}&search_option=${param.search_option}&search_content=${param.search_content}">${i.index + 1}</a></li>
									</c:forEach>	
								</c:if>
							</c:otherwise>
						</c:choose>
						
					</ul>
				</div>
	
				<script type="text/javascript">
				if("${param.page_number}" == ''){
					document.getElementsByClassName("page-number")[0].classList.add("selected");
				}else{
					document.getElementsByClassName("page-number")[${param.page_number - 1}].classList.add("selected");
				}
				</script>
				
				<div class="search-area">
					<form name="search_form" action="boardList.do" method="get" onsubmit="return checkSearchForm();">
						<input type="hidden" name="board" value="${param.board}">
						<input type="hidden" name="page_number" value="${param.page_number}">
						<select name="search_option">
							<option value="title" selected="selected">제목</option>
							<option value="content">내용</option>
							<option value="writer">작성자</option>
						</select>
						<input type="text" name="search_content" placeholder="검색어를 입력해주세요">
						
						<button class="btn-search">검색</button>
					</form>
				</div>
				<script type="text/javascript">
					function checkSearchForm(){
						let searchContent = search_form.search_content.value;
						let board = search_form.board.value;
						let page_number = search_form.page_number.value;
						
						return true;
					}
				</script>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</div>

</body>
</html>
