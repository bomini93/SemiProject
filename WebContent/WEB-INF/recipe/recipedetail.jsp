<%@page import="dto.Recipe_review_table"%>
<%@page import="dto.Member"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Recipe_Photo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dto.Recipe_Table" %>

    <%@ include file="/header/header.jsp" %><br>     

    
<% Recipe_Table result = (Recipe_Table) request.getAttribute("result"); %>
<% List<Recipe_Photo> presult = (List) request.getAttribute("result2"); %>
<% ArrayList text = (ArrayList)request.getAttribute("text"); %>
<% List<Map> reviewlist = (List<Map>)request.getAttribute("reviewlist"); %>
<% String user_id = (String) request.getAttribute("user_id"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 상세 페이지</title>
<script type="text/javascript" src = "/resources/js/httpRequest.js"></script>

<script type="text/javascript">
function openOk(){
	window.alert("신고가 완료되었습니다");
}

function deleteOk(){
	window.alert("삭제가 완료되었습니다");
}

</script>
<style type="text/css">

body{
	background: #FFFFF3;
}

#title{
	text-align: center; 
}


#cover{
	width: 800px;
	height: 2600px;
	margin: 0 auto;
}

#cover > #first > div {
 	display: inline-block; 
/* 	font-weight: bold; */
	font-size: 15px;
	
	margin: 0 auto;
	text-align: center; 
	padding: 10px;
}

#first > div > div{
	margin: 0 auto;
	text-align: center; 
}

#content{
	
}

#content > #method> #cook{
	border: 1px solid gray;
}

#text{
	border: none;	
	
	width: 100px;
	float: right;
	margin: 50px;
}

#report{
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
   left: 50px; 
}  

#allreview{

	font-family: bemin;
}

.wrapper{
	width: 960px;
	margin: 0 auto;
}

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
   left: 50px;  
}

th{
	
    padding: 8px;
}

td{
	padding: 12px;
	margin: 8px;
	
}

#recipetable{
	font-family: Bemin;
	font-size: 15px;
}

#mainImg{
	width: 600px;
	height: 450px;
	border: none;
/* 	margin-top: 50px; */
}

.thumbnail{
	background: #FFFFF3;
	border: none;
	border-color:#FFFFF3;
	margin-left: 70px;
}

#reviewchange  {
	font-size:13px;
	width: 80px;
}

#reviewdelete {
	font-size: 13px;
	width: 80px;
}


</style>
</head>
<body>

<div id="cover">
	
		<div class = "thumbnail">
			<img id="mainImg" width="600px" height="350px" src="/upload/<%=result.getRecipe_new_name() %>" />
		</div><br><br><br>
		
		<div id="first">
			<table id="recipetable" style="width: 600px; margin:0 auto; padding: 20px; text-align: center; ">
				<tr>
					<th style="width: 25%; text-align: center; border-bottom: 1px solid #444444;" >작성 날짜</th>
					<th style="width: 25%; text-align: center; border-bottom: 1px solid #444444;">음식 이름</th>
					<th style="width: 25%; text-align: center; border-bottom: 1px solid #444444;">음식 종류</th>
					<th style="width: 25%; text-align: center; border-bottom: 1px solid #444444;">메인재료</th>
				</tr>
		
			<tr>
				<td style="text-align: center;"><%=result.getRecipe_date() %></td>
				<td style="text-align: center;"><%=result.getRecipe_name() %></td>
				<td style="text-align: center;"><%=result.getRecipe_kinds() %></td>
				<td style="text-align: center;"><%=result.getRecipe_ing() %></td>	
			</tr>
		</table><br>

	
	<div id="recipelike" style="text-align: center; margin:0 auto; margin-left: 180px;">
		<div><button onclick="location.href='/recipe/like?recipe_no=<%=result.getRecipe_no() %>'">
			즐겨찾기 등록</button>
			<button onclick="location.href='/recipe/likeCancel?recipe_no=<%=result.getRecipe_no()%>'">
			즐겨찾기 해제</button></div>
	</div>
	
</div>
		
		
	<br><br><br>

	
	
	
<div id="content">
	<div class = "cook" style="font-size:40px; font-family:bemin; text-align: center;">조리법</div><br>
	<div id="method">
		<%for(int i =0 ; i < presult.size(); i++ ){ %>
		
		<div id="cook">
		<img id="img" width="350" height="280" style="padding: 5px;" src="/upload/<%=presult.get(i).getPhoto_after() %>"/>
		<div id="text" style="display: inline-block; width:340px; max-height: 180px; 
				overflow-wrap: anywhere; overflow-x: hidden; overflow-y: auto; font-family: bemin;"> <%=text.get(i) %></div>
		</div><br><br>
		<%} %>
	</div>
		
</div>

<table style="width: 800px; text-align: center; margin-left: -30px;">
<tr>
	<th style="width: 25%; text-align: center;">
		<form action = "/recipe/detail" method="post">
		<input type="hidden" name="recipe_no" value = "<%=result.getRecipe_no() %>">
		<input id="report" type="submit" value="게시물 신고하기" onclick = "openOk()"/>
		</form>
	</th>
	<th style="width: 25%; text-align: center;">
		<form action = "/recipe/delete" method="get">
		<input type = "hidden" name = "recipe_no" value = "<%=result.getRecipe_no() %>"/>
		<button id="recipedelete" onclick ="deleteOk()">게시물 삭제</button>
		</form>
	</th>
	<th style="width: 25%; text-align: center;">
		<form action = "/recipe/change" method="get">
		<input type = "hidden" name = "recipe_no" value="<%=result.getRecipe_no() %>"/>
		<button id="recipeupdate">게시물 수정</button>
		</form>	
	</th>
	<th style="width: 25%; text-align: center;">
		<button id="reviewwrite" onclick = "location.href='/recipe/comment?recipe=<%=result.getRecipe_no()%>'">리뷰작성</button>
	</th>
</tr>


</table>
<hr>

<div class="wrapper">
<table id="allreview" style="width: 1000px; text-align: center;">

<%for(int i =0; i<reviewlist.size(); i++) {%>
<% Member mem = (Member) reviewlist.get(i).get("mem"); %>
<% Recipe_review_table rrt = (Recipe_review_table) reviewlist.get(i).get("rrt");%>
	
	<tr>
		<th style="width: 20%; text-align: center; padding: 10px;">작성자</th>
		<th style="width: 15%; text-align: center;">작성일</th>		
		<th style="width: 15%; text-align: center;">별점</th>
		<th style="width: 50%; text-align: center;">내용</th>
		<th>	
		<%if(user_id.equals(mem.getUser_id())) {%>
			
			<form action="/recipe/review/delete" method="get">
			<input type="hidden" name = "recipe_review_no" value="<%=rrt.getRecipe_review_no() %>"/>
			<input type="hidden" name = "recipe_no" value="<%=result.getRecipe_no()%>"/>
			<button id="reviewdelete">삭제</button>
			</form>
	
			

		
		</th>
		<th>
		<button id = "reviewchange"onclick="location.href='/recipe/review/change?review_no=<%=rrt.getRecipe_review_no() %>'">수정</button>
		</th>
				<%} %>
	</tr>

	
	<tr>
		<td><%=mem.getUser_id() %>님</td>
		<td><%=rrt.getRecipe_review_date() %></td>
		<td><%=rrt.getRecipe_rating() %>점</td>
		<td><%=rrt.getRecipe_review_text() %></td>
	</tr>


<%} %>

</table>

</div><br>





</body>
</html>