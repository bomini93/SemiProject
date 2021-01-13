<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@font-face {
	font-family:"Bemin";
	src:url("/resources/font/BMHANNA_11yrs_ttf.ttf") format("truetype");
	font-style: normal;
	font-weight: normal;
}

@font-face {
	font-family:"Bemin2";
	src:url("/resources/font/BMDOHYEON_ttf.ttf") format("truetype");
	font-style: normal;
	font-weight: normal;
}

body{
	height: 900px;
	background:#FFFFF3;
}

#logo {
	margin-top: 60px;
	text-align: center;
	font-family:Bemin;
	font-size: 50px;
}

#logo2 {
	margin-top: 60px;
	text-align: center;
	font-size: 20px;
}

button{
  background:#ffc952;
  color:#fff;
  border:none;
  height:30px;
  font-size: 15px;
  padding:0 2em;
  outline:none;
  margin-top: 9px;
  margin-left: 3px;
  cursor : pointer;
  border-radius: 50px;
  position: relative;
  left: 660px; 
}

</style>
</head>
<body>
<div id="logo">회원가입 완료</div><br>


<div id="logo2">환영합니다. 자유롭게 기능을 사용해 보세요.</div>
<div><button onclick = "location.href = '/member/login'">로그인 페이지</button></div>

</body>
</html>