<%@page import="dto.Recipe_Table"%>
<%@page import="dto.Report_Recipe_Table"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/header/header.jsp" %>

<% List<Report_Recipe_Table> list = (List<Report_Recipe_Table>) request.getAttribute("list"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> + 신고 정보 + </title>
<style type="text/css">

h1{
  color:#black;
  font-weight: bold;
   text-align: center;
}

table{
margin: 0 auto;
border: solid;
  border-width: thick;
}
</style>
</head>
<body>
<form action = "/admin/report" method = "post">
<h1>신고 정보 목록</h1>
<table class="table table-hover" style="width: 600px;">
<tr>
	<th>사용자 번호</th>
	<th>레시피 번호</th>
	<th>해당 게시글 이동</th>
	<th>신고 횟수</th>
</tr>
<%	for(int i=0; i<list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getUser_no() %></td>
	<td><%=list.get(i).getRecipe_no() %></td>
	<td><a href = "/recipe/detail?recipe_no=<%=list.get(i).getRecipe_no() %>">이동</a></td>
	<td><%=list.get(i).getCnt() %></td>
</tr>
<%	} %>
</table>

</form>
<jsp:include page="/WEB-INF/views/common/paging.jsp" />

</body>
</html>
<%@ include file ="/footer/footer.jsp" %>