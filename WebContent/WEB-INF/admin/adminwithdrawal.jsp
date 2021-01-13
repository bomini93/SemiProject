<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>+ 회원 탈퇴 +</title>

</head>
<body>
<form action = "/admin/withdrawal" method="post">

<h3>회원탈퇴</h3>
<hr>

<label>아이디</label>
<input type = "text" name = "user_id"/><br><br>
<div id = "msg"></div>
<input id = "cancelBtn" type = "button" value = "취소" onclick = "window.close()">
<input id = "userBtn "type = "submit" value = "회원탈퇴">

</form>
</body>
</html>