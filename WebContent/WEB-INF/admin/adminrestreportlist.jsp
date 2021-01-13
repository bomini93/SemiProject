<%@page import="dto.Rest_review_table"%>
<%@page import="dto.Report_rest_table"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file ="/header/header.jsp" %>
    <%List<Map> list = (List) request.getAttribute("reportlist"); %>
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
<h1>신고 정보 목록</h1>
<table class = "table table-hover" style="width: 600px;">
<tr>
	<th>리뷰번호</th>
	<th>유저번호</th>
	<th>식당번호</th>
	<th>리뷰</th>
	<th>신고횟수</th>
	<th>게시글 이동</th>
</tr>

	<%for (int i = 0; i<list.size(); i++){ %>
	<%Report_rest_table rrt = new Report_rest_table();%>
	<%Rest_review_table rwt = new Rest_review_table();%>
	<% rrt = (Report_rest_table) list.get(i).get("rest_review_no"); %>
	<% rwt = (Rest_review_table) list.get(i).get("rest_review_text"); %>
 
<tr>
    <td><%= rrt.getRest_review_no() %></td>	
    <td><%= rrt.getUser_no() %></td>
    <td><%= rwt.getRest_no() %></td>
    <td><%= rwt.getRest_review_text() %></td>
    <td><%= rrt.getCnt() %></td>
    <td><a href = "/rest/detail?rest_no=<%=rwt.getRest_no() %>">이동</a></td>
</tr>
<%} %>
</table>



</body>
</html>
<%@ include file ="/footer/footer.jsp" %>