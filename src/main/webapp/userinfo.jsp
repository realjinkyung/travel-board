<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
	.user-info-wrap{
		width: 700px;
		margin: 70px auto;
		font-size: 0.9rem;
	}
	
	.user-info-title{
		margin: 30px 0;
		line-height: 2rem;
	}
	
	.user-info-title h3{
		font-size: 1.5rem;
		font-weight: bold;
	}
	
	.user-info-title p{
		font-size: 0.8rem;
	}
	
	table{
		width: 100%;
		border-top: 1px solid lightgray;
		border-bottom: 1px solid lightgray;
	}
	
	table th, td{
		padding: 15px;
	}
	
	table th{
		width: 30%;
		text-align: left;
		font-weight: bold;
		background-color: whitesmoke;
		border-right: 1px solid lightgray;
		border-bottom: 1px solid lightgray;
		padding: 35px; 
	}
	
	table th:last-child{
		border-right: none;
		border-bottom: none;
	}
	table td{
		width: 70%;
		padding-left: 30px;
		border-right: 1px solid lightgray;
		border-bottom: 1px solid lightgray; 
	}
	
	#th-profile{
		vertical-align: top;
	}
	
	#td-profile{
		width: 100%;
		padding-left: 30px;
	}
	
	#td-profile div{
		display: flex;
		align-items: center;
	}
	
	#td-profile img{
		width: 120px;
		height: 120px;
		border: 1px solid lightgray;
		border-radius: 50%;
		margin-right: 30px;
		overflow: hidden;
	}
	
	#td-profile button{
		padding: 10px 15px;
		border: 1px solid lightgray;
		background-color: white;
		font-weight: bold;
	}
	
	.btn-area{
		text-align: right;
		padding: 10px 30px;
		padding-right: 0px;
		position: relative;
	}
	
	
	#btn-modify{
		position: absolute;
		padding: 7px 15px;
		border: 1px solid lightgray;
		background-color: white;
		font-weight: bold;
		cursor: pointer;
		right: 0;
	}
	
	#btn-home{
		position: absolute;
		padding: 7px 15px;
		border: 1px solid lightgray;
		background-color: white;
		font-weight: bold;
		cursor: pointer;
		left: 0;
	}
	
</style>
</head>
<body>
	<div class="user-info-wrap">
		<div class="user-info-title">
			<h3>?????? ??????</h3>
			<p>?????? ????????? ????????? ????????? ??? ????????????.</p>
		</div>
		
		<div class="user-info-table-wrap">
			<table>
				<tr>
					<th id="th-profile">????????? ??????</th>
					<td id="td-profile">
						<div>
							<img src="${path}">
						</div>
					</td>
				</tr>
				<tr>
					<th>?????????</th>
					<td>${user.username}</td>
				</tr>
				<tr>
					<th>??????</th>
					<td>${user.name}</td>
				</tr>
				<tr>
					<th>????????????</th>
					<td>${user.birth}</td>
				</tr>
				<tr>
					<th>??????</th>
					<td>${user.gender}</td>
					
				</tr>
				<tr>
					<th>?????????</th>
					<td>${user.email}</td>
				</tr>
				<tr>
					<th>????????? ??????</th>
					<td>${user.phoneNumber}</td>
				</tr>
			</table>
		</div>
		<div class="btn-area">
			<button id="btn-home" onclick="location.href='boardList.do'">?????????</button>
			<button id="btn-modify" onclick="location.href='userRevisePage.do'">??????</button>
		</div>
		
	</div>
</body>
</html>
