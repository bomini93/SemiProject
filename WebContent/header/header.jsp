<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <!— 합쳐지고 최소화된 최신 CSS —> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- <!— 부가적인 테마 —> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- <!— 합쳐지고 최소화된 최신 자바스크립트 —> -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- 모든 페이지에 jQuery 라이브러리 추가 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 모든 페이지에 적용되는 JS -->
<script type="text/javascript">

</script>

<!-- 모든 페이지에 적용되는 CSS -->
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

* {
	margin:0;
	padding:0;
	color:#000;
	box-sizing: border-box;
}

.container {
	width:100%;
	margin:0 auto;
	border-bottom: 1px #ccc solid;
	
}

.head {
	width: 100%;
	height: 80px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	background: #FFFFF3;
}


.head > h3 {
 	font-family: "BMEULJIRO"; 
}

.menubar {
	margin-right: 40px;
	background: #FFFFF3;
}

.nav {
	width:100%;
	height: 100%;
	display: flex;
	justify-content: space-between;
	list-style: none;
	background: #FFFFF3;
}

.nav > li {
	font-size:15px;
	height: 100%;
	display: flex;
	align-items: center;
	margin-right: 40px;
	font-weight: 1000;
	color: black;	
}

.nav > li > a{
	text-decoration: none;
	outline: none; /* 태그를 감싸는 외곽라인 없애기 */
	font-size: 18px;
 	font-family: Bemin2; 
	color: #ffc952;
}

.logo {
	margin-top: 0px;
	margin-left: 40px;
	text-align: center;
	font-size: 40px;
}

.logo a{
	font-family: Bemin2;
}

.logo a:link { color: #ffc952; text-decoration: none;}

.logo a:visited { color: #ffc952; text-decoration: none;}
 
.logo a:hover { color: #ffc952; text-decoration: none;}


</style>
</head>
<body>
<!-- header 영역  -->
	<div class = "container">
	<header class = "head">
		<h3 class = "logo"><a href = "/home/home">냠냠밥상</a></h3>
	 	<nav class = "menubar">
	 		<ul class = "nav">
	 		<% if( session.getAttribute("login") == null ) 
	 		{%>
				<li><a href = "/member/login">로그인/회원가입</a></li>
				<li><a href = "/recipe/search">레시피</a></li>
				<li><a href = "/rest/search">식당</a></li>
				<li><a href = "/mypage">마이페이지</a></li>
			<%} else if( session.getAttribute("sessionId").equals("admin")) { %>
				<li>관리자님<a href = "/member/logout">로그아웃</a></li>
				<li><a href = "/admin/home">관리자 페이지</a></li>
				<li><a href = "/recipe/search">레시피</a></li>
				<li><a href = "/rest/search">식당</a></li>
			<%} else {%>
				<li>ID: <%=session.getAttribute("sessionId") %><a href = "/member/logout">로그아웃</a></li>
				<li><a href = "/recipe/search">레시피</a></li>
				<li><a href = "/rest/search">식당</a></li>
				<li><a href = "/mypage">마이페이지</a></li>
			<%} %>
			</ul>
	 	</nav>
	</header>
	</div>
