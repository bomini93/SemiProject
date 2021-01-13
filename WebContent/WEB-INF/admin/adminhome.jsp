<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file ="/header/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>+ 관리자 페이지 +</title>
<style type="text/css">
body{
	  background-color: #FFFFF3;
}

h1{
	text-align: center;
	  color:#black;
  font-weight: bold;
}

button{
  background:#ffc952;
  color:#black;
  font-weight: bold;
  border:none;
  height:30px;
  font-size: 15px;
  padding:0 2em;
  outline:none;
  cursor : pointer;
  border-radius: 50px;
  position: relative;
	left: 500px;

}

.menubar {
	margin-left: 75px;
}

</style>

</head>
<body>
<br><br>
<div class = "menubar">
<button type="button" onclick="location.href='/admin/member'">회원 관리</button>
<button type="button" onclick="location.href='/admin/report'">레시피 신고 관리</button>
<button type="button" onclick="location.href='/admin/rest/report'">리뷰 신고 관리</button>
</div>

</body>
</html>
<%@ include file ="/footer/footer.jsp" %>