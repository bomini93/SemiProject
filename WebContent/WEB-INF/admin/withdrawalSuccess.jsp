<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#cancelBtn{
  background:#ffc952;
  color:#black;
  font-weight: bold;
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
  left: 170px; 
}

</style>


</head>
<body>
	<p style = "text-align:center">회원탈퇴가 정상적으로 이루어졌습니다</p>
	<input id = "cancelBtn" type = "button" value = "취소" onclick = "window.close()">
</body>
</html>