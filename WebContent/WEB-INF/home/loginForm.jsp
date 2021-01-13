<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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



form{
	padding-bottom : 50px;
	border-bottom: 1px #ccc solid;
	height: 535px;
}


input:focus {outline:none;}

body{
	height: 100%;
	background:#FFFFF3;
}


input {
	border-style:none;
    border-bottom:solid 1px #cacaca;
    border-collapse:collapse;
    font-size: 15px;
    line-height: normal;
    background-color: #FFFFF3;
    width: 400px;
    }

label{	
	font-size: 13px;
	font-weight: bold;
}

button{
  background:#ffc952;
  color:#fff;
  border:none;
  height:50px;
  text-align:center;
  font-size: 25px;
  width : 400px;
  outline:none;
  margin-top: 0;
  margin-left: 5px;
  cursor : pointer;
  border-radius: 15px;
}

div[id^='div'] {
		width: 100%;
		margin: 0 auto;
		text-align: center;
		margin-top: 30px;
	}

#loginmenu{
	text-align: center;
	font-size: 11px;
	margin-top: 10px;
}

#logo {
	margin-top: 60px;
	text-align: center;
	font-family:Bemin;
	font-size: 50px;
}

#logo a:link { color: #ffc952; text-decoration: none;}

#logo a:visited { color: #ffc952; text-decoration: none;}
 
#logo a:hover { color: #ffc952; text-decoration: none;}

#loginmenu a:link { color: black; text-decoration: none;}

#loginmenu a:visited { color: black; text-decoration: none;}
 
#loginmenu a:hover { color: black; text-decoration: none;}

.join{
	padding-right: 10px;
	border-right : 1px solid black;
}

.findpw{
	padding-left: 8px;
}



/* footer css */
.list_corp{
	list-style-type: none;
	padding: 0;
	margin: 0;
	
	
}

.list_corp > li{
	width: 120px;
	float: left;
	
	font-size: 10px;
	
	line-height: 20px;
	
	border-right : 1px solid #ccc;
	
	
}

.list_corp > li > a{
	text-decoration: none;
	padding: 10px 15px;
	margin : 0 3px;
}

.list_corp > li > a:hover {
	color: #000000; text-decoration: none;
}

.list_corp > li > a:link {
	color: #000000; text-decoration: none;
}

.list_corp > li > a:visited {
	color: #000000; text-decoration: none;
}

.main_corp {
	margin-top : 15px;
	
}

</style>
</head>
<body>

<div id = "main">
<% if( session.getAttribute("login") == null ) {%>

<form action = "/member/login" method = "POST">

<div id = "logo">
<a href = "/home/home">냠냠밥상</a>
</div>

<div id = "div1">
<input type = "text" name = "user_id" id = "user_id" placeholder="아이디"><br>
</div>

<div id = "div2">
<input type = "password" name = "user_pw" id = "user_pw" placeholder="비밀번호"><br>
</div>

<div id = "div3">
<button>로그인</button>
</div>

<div id = "loginmenu">
<a href = "/member/join" class = "join">회원가입</a>
<a href = "/member/findpw" class = "findpw">비밀번호 찾기</a>
</div>

</form>
</div>
<%} else {%>
<div id = "div4">
<%=session.getAttribute("sessionId") %>님 반갑습니다
</div>

<div id = "div5">
<button onclick="location.href='/member/logout'">로그아웃</button>
</div>
<%} %>

<footer style = "font-size : 0.8em; text-align: center;">
	<div class = "main_corp" >
		<ul class ="list_corp" >
			<li class = "corp_item"><a href = "#">이용약관</a></li>
			<li class = "corp_item"><a href = "#"><strong>개인정보처리방침</strong></a></li>
			<li class = "corp_item"><a href = "#">고객센터</a></li>
			<li class = "corp_item"><a href = "#">&copy; KH정보교육원</a></li>
		</ul>
		</div>
	</footer>
	
</body>
</html>