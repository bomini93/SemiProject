<%@page import="dto.Rest_review_table"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/header/header.jsp" %>     
    
<%   Rest_review_table m = (Rest_review_table) request.getAttribute("result"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function goBack() {
	window.history.go(-2)
}

</script>
</head>
<body>

<h1>댓글 작성 결과</h1>
<hr>

<%-- 별점: <%=m.getRest_rating() %><br> --%>
별점: <br>
내용: <%=m.getRest_review_text() %><br><br>

<button onclick="goBack()">전체 댓글 보러가기</button>
<br><%@ include file="/footer/footer.jsp" %>

</body>
</html>