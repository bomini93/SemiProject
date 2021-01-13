<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Member result = (Member) request.getAttribute("result"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 성공</title>
<style type="text/css">
.bo{
	font-size: 20px;
	width: 100%;
		margin: 0 auto;
		text-align: center;
		margin-top: 30px;
		color: #black;
		background: #black:
}

</style>

</head>
<body>
	<div class="bo">
	비밀번호는  <%=result.getUser_pw()%>입니다
	</div>
</body>
</html>