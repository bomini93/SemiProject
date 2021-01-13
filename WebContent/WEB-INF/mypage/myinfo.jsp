<%@page import="dto.Recipe_Table"%>
<%@page import="dto.Rest_info"%>
<%@page import="java.util.List"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<Member> member = (List) request.getAttribute("list"); %>
<% List<Rest_info> restlike = (List) request.getAttribute("restlike"); %>

<% List<Recipe_Table> recipelike = (List) request.getAttribute("recipelike"); %>

<%@include file="/header/header.jsp"%>


<style type="text/css">
button{
  background:#ffc952;
  color:#fff;
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
  left: 250px; 
}

body{
	height: 900px;
	background:#FFFFF3;
}

#logo1 {
	margin-top: 60px;
	text-align: center;
	font-family:Bemin;
	font-size: 50px;
}

#logo2 {
	margin-top: 60px;
	text-align: center;
	font-family:Bemin;
	font-size: 50px;
}

/* 테이블 중앙 정렬 */
table {
	margin: auto;
	margin-top: 60px;
	text-align: center;
	width: 50%;
	table-layout: fixed;
}

/* 테이블 제목 중앙 정렬 */
th {
	margin: auto;
	text-align: center;
	width: 50%;
}

#btnOk{
	margin-left: 450px;
}
</style>
</head>
<body>

<div id="main">

<div id="logo1">회원 정보 확인</div>

<table class="table table-hover" style="width: 600px;">
<tr>
	<th>회원 아이디</th>
	<th>회원 성별</th>
	<th>회원 맵기</th>
	<th>회원 양</th>
</tr>

<tr>
	<td><%=member.get(0).getUser_id() %></td>
	<td><%=member.get(0).getUser_gender() %></td>
	<td><%=member.get(0).getSpicy_no() %>단계</td>
	<td><%=member.get(0).getAmount_no() %>단계</td>
</tr>
</table>
<div><button id = "btnOk" onclick = "location.href = '/mypage/change'">정보 수정</button></div>


<br><br>

<div id="logo2">즐겨찾기 식당</div>


<table class="table table-hover" style="width: 600px;">
<tr>
	<th>식당 번호</th>
	<th>식당 이름</th>
</tr>

<%for (int i = 1; i<=restlike.size(); i++) { %>
<tr>
<td>
	<%=i %>
</td>
<td>
	<a href="/rest/detail?rest_no=<%=restlike.get(i-1).getRest_no()%>"><%=restlike.get(i-1).getRest_name() %></a>
</td>
</tr>
<%} %>

</table>

<div id="logo2">즐겨찾기 레시피</div>

<table class="table table-hover" style="width: 600px;">
<tr>
	<th>레시피 번호</th>
	<th>레시피 이름</th>
</tr>

<%for (int i = 0; i<recipelike.size(); i++)  { %>
<tr>
<td>
	<%=recipelike.get(i).getRecipe_no() %>
</td>
<td>
	<a href="/recipe/detail?recipe_no=<%=recipelike.get(i).getRecipe_no()%>"><%=recipelike.get(i).getRecipe_name() %></a>
</td>
</tr>
<%} %>

</table>

</div>

</body>
</html>