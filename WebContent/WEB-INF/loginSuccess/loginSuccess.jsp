<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style type="text/css">

body {
	text-align: center;
	margin: 0;
	font-size: 20px;
	color: #;
}
.ok{
	font-size: 30px;
	width: 100%;
		margin: 0 auto;
		text-align: center;
		margin-top: 30px;
		color: #ffc952;
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
  left: 300px; 
}
 a:link {color:#000000;}	기본 링크
 a:hover{color:#ffff00;}	링크에 마우스를 올렸을 때
 a:active{color:#00ff00;}	링크에 마우스를 클릭하는 순간
 a:visited{color:#0000ff;}	링크를 한번이라도 방문했을 경우
 a:focus{color:#ff6600;}

.home{
  color:#black;
  font-weight: bold;
  border:none;
  height:30px;
  font-size: 15px;
  padding: 0.5 2em;
  outline:none;
  margin-top: 9px;
  margin-left: 10px;
  cursor : pointer;
  border:8px groove #ffc952;
}
</style>
</head>

<body>

<h3 class="ok"><%=session.getAttribute("sessionId")%> 님, 로그인 되었습니다.</h3>
<hr>
<h3>환영합니다!!</h3>
<button onclick="location.href='/home/home'">메인화면</button>
</body>
</html>