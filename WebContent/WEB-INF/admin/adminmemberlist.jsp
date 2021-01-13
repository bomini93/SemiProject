<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	List<Member> list = (List<Member>) request.getAttribute("list"); %>
<%@ include file ="/header/header.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> + 회원 정보 + </title>

<script type="text/javascript" src = "/resources/js/httpRequest.js"></script>

<script type="text/javascript">

function openMember(){
	window.name="parentForm";
    window.open("/admin/withdrawal",
            "", "width=500, height=300, resizable = no, scrollbars = no");    
}



</script>

<style type="text/css">

body{
	  background-color: #FFFFF3;
}

h1{
  color:#black;
  font-weight: bold;
   text-align: center;
}

.button{
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

  

}

table{
margin: 0 auto;
border: solid;
  border-width: thick;
}

.table-hover{
	text-align: center;
}

.memberlist{
	text-align : center;
	/* 테두리 */
	border: 3px solid black;
	/* 외부 여백 */
	margin: 5px 20px 30px;
	
	padding: 5px;
	/* 배경색 지정 */
	background-color: orange;
	/* 글자색 지정 */
	color: #FFFFF3;
}
.a{
   margin: auto;
   width: 8%;
   
}

</style>
</head>
<body>

<form action = "/admin/member" method = "post" name = "memberInfo">

<h1>회원 정보 목록</h1>

<table class="table table-hover" style="width: 600px;">
<tr>
	<th>사용자 번호</th>
	<th>사용자 ID</th>
	<th>생년월일</th>
	<th>성별</th>
</tr>
<%	for(int i=0; i<list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getUser_no() %></td>
	<td><%=list.get(i).getUser_id() %></td>
	<td><%=list.get(i).getUser_birth() %></td>
	<td><%=list.get(i).getUser_gender() %></td>
</tr>
<%	} %>

</table>

<div class="a">
<input type = "submit" class="button" value = "회원탈퇴" onclick = "openMember()"/>
</div>


</form>
<jsp:include page="/WEB-INF/views/common/adminmemberpaging.jsp" />

</body>
</html>
<%@ include file ="/footer/footer.jsp" %>