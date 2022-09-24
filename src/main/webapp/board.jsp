<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
<style type="text/css">
	/* http://meyerweb.com/eric/tools/css/reset/ 
	   v2.0 | 20110126
	   License: none (public domain)
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
		border: 1px solid gray;
		margin: 0 auto;
	}
	
	
	
	
	/* board-css start */
	
	.board-wrap{
		width: 20%;
		border: 1px solid blue;
	}
	
	.board-wrap > h2{
		margin: 30px 0;
		font-size: 1.5rem;
		font-weight: bold;
	}
	
	.logo-area{
		display: flex;
		justify-content: center;
		align-items: center;
		width: 100%;
	}
	
	.logo-area a{
		display: block;
		text-decoration: none;
		font-weight: bold;
		font-size: 1.5rem;
		color: black;
		margin: 30px 0;
	}
	
	.logo-area img{
		width: 36px;
		height: 36px;
	}
	
	.logo-area span{
		vertical-align: super;
		margin-left: 10px; 
	}
	
	
	.board-area h3{
		font-size: 1rem;
		font-weight: bold;
		margin: 30px 0;
		text-align: right;
		padding: 0 30px;
	}
	
	.board-area li{
		padding: 15px 30px;
		text-align: right;
		font-size: 0.8rem;
	}
	/* board-css end */
	
	
	
	
	
	
	
	
	
	 /* post-css start */
	 
	.post-wrap{
		width: 80%;
		border: 1px solid red;
		padding: 0 15px;
	}
	
	.post-wrap > h2 {
		margin: 30px 0;
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
		padding: 12px 0;
	}
	
	.post-wrap table .post-no, .created-date, .views{
		text-align: center;
	}
	
	
	.page-numbers{
		text-align: center;
		padding: 30px 0;
	}
	.page-numbers li{
		display: inline-block;
		margin: 0 7px;
	}
	
	.page-numbers li a{
		padding: 4px 7px;
	} 
	
	.page-numbers li.selected a{
		color: #03c75a;
		border: 1px solid lightgray;
	}
	.page-numbers li a{
		font-size: 0.8rem;
		font-weight: bold;
		color: black;
		text-decoration: none;
	}
	
	.page-numbers li a:hover {
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
	
	.search-area button{
		border: none;
		background-color: #03c75a;
		color: white;
		padding: 0 10px;
	}
	
	/* post-css end */
}
</style>
</head>
<body>

<div class="wrap" style="display: flex">
	<div class="board-wrap">
		<div class="logo-area">
			<a href="#">
				<img src="logo."/><span>Jesu Story</span>
			</a>
		</div>
		<div class="board-area">
			<h3>전체보기</h3>
			<div>
				<h3>제주시</h3>
				<ul>
					<li>한경면</li>
					<li>한림읍</li>
					<li>애월읍</li>
					<li>제주시</li>
					<li>조천읍</li>
					<li>구좌읍</li>		
				</ul>	
			</div>
				
			<div>
				<h3>서귀포시</h3>
				<ul>
					<li>한경면</li>
					<li>한림읍</li>
					<li>애월읍</li>
					<li>제주시</li>
					<li>조천읍</li>
					<li>구좌읍</li>		
				</ul>	
			</div>
		</div>
	</div>
	
	<div class="post-wrap">
		<h2>전체글보기</h2>
		<div>
			<table>
				<tr>
					<th width="5%">글번호</th>
					<th width="55%">제목</th>
					<th width="15%" class="th-writer">작성자</th>
					<th width="15%">작성일</th>
					<th width="10%">조회</th>
				</tr>
				<c:forEach begin="0" end="5">
					<c:forEach var="post" items="${postList}">
						<tr>
							<td class="post-no">${post.postNo}</td>
							<td class="title">${post.title}</td>
							<td class="writer">${post.username}</td>
							<td class="created-date">${post.createdAt}</td>
							<td class="views">${post.views}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
			<div class="page-numbers">
				<ul>
					<li class="selected"><a href="#">1</a></li>
					<c:forEach begin="2" end="5" varStatus="i">
						<li><a href="#">${i.index}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="search-area">
				<select>
					<option>제목</option>
					<option>내용</option>
					<option>작성자</option>
				</select>
				<input type="text" placeholder="검색어를 입력해주세요">
				<button class="btn-search">검색</button>
			</div>
		</div>
	</div>
</div>
	
</body>
</html>
