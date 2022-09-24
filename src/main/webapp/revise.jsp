<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>revise</title>
</head>
<body>
<h2>회원정보 수정페이지</h2>
	
	<form action="revise.do" method="post">
	<table border="0" cellspacing="0">
    <tr>
        <td align="right" bgcolor="yellow"><font size="2"> 아이디 : </font></td>
        <td bgcolor="yellow"><input type="text" name="id"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow"><font size="2">비밀번호 : </font></td>
        <td bgcolor="yellow"><input type="password" name="pass"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow"><font size="2">이름 : </font></td>
        <td bgcolor="yellow"><input type="text" name="name"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow"><font size="2">주소 : </font></td>
        <td bgcolor="yellow"><input type="text" name="adress"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow"><font size="2">성별 : </font></td>
        <td bgcolor="yellow">
        <input type="radio" name="sex" value="1" checked="checked"><font size="2">남</font>
        <input type="radio" name="sex" value="2"><font size="2">여</font>
        </td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow"><font size="2">나이 : </font></td>
        <td bgcolor="yellow"><input type="text" name="age"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow"><font size="2">이메일 주소 : </font></td>
        <td bgcolor="yellow"><input type="text" name="email"></td>
    </tr>
    <tr>
        <td colspan="2" align="center" bgcolor="yellow">
            <input type="submit" value="회원 정보 수정">
            <input type="reset" value="다시작성">
            <input type="reset" value="취소">
        </td>
    </tr>
</table>
	
	</form>
	
	<hr/>
	
</body>
	
	
</html>