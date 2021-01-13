<%@page import="dto.Rest_info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/header/header.jsp" %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function goBack() {
	window.history.back();
}
</script>
</head>
<body>

<h1>즐겨찾기에 등록 되었습니다</h1>
<button onclick='goBack();'>뒤로 가기</button>

<br><%@ include file="/footer/footer.jsp" %>

</body>
</html>