<%@page import="dto.Recipe_Table"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Recipe_Table> recipeinfoList = (List) request.getAttribute("recipeinfolist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 리스트</title>


<style type="text/css">

body{
	background: #FFFFF3;
}

#list {
	
/* 	/* 내부 정렬 */ */
 	text-align: center;  
	
	/* 외부 정렬 */
	width: 800px;
	margin: 0 auto;
	
	padding: 10px;
	
/* 	상위에서 디스플레이 - 인라인 설정 */
 	display :inline;
	
}

#list > div {

/* 	하위에서 디스플레이 - 블록 설정 */
 	display: inline-block; 
	
	margin: 10px;
	padding: 10px;
	
	overflow: hidden;
	
/* 	flex-direction: row; */
	
}

body{
		background: #FFFFF3;
}

.write {
	text-align: center;
}

a:visited { text-decoration: none;}
 
a:hover {text-decoration: none;}

/* .write a { */
/* 	padding: 5px; */
/* 	color: white; */
/* 	background:#ffc952; */
/* 	font-size: 12px; */
/* 	border-radius: 3px; */
/* } */

button {
	background: #ffc952;
	color: #fff;
	border: none;
	height: 35px;
	font-size: 20px;
	padding: 0 1em;
	outline: none;
	margin-top: 5px;
	margin-left: 3px;
	cursor: pointer;
	border-radius: 50px;
	/*    position: relative;  */
	/*    left: 300px;  */
	text-align: center;
}

ul {
	background: white;
}
</style>
</head>
<body>

<div class = "write">
<button onclick="location.href='/recipe/write'">레시피 작성</button>
</div><br><br>

<%for(int i=0 ; i<recipeinfoList.size(); i++) { %>
<div id="list">
	<div id="divimg">
		<img id="img" width="200" height="150" class="img-rounded" src="/upload/<%=recipeinfoList.get(i).getRecipe_new_name() %>"/>
	</div>
	
	
	
	<div id="divmenu">	
		<label id="recipe_name"> 레시피명 : <a href = "/recipe/detail?recipe_no=<%=recipeinfoList.get(i).getRecipe_no()%>"><%=recipeinfoList.get(i).getRecipe_name() %></a></label><br>
		<label id="recipe_kinds"> 종류(분류) : <%=recipeinfoList.get(i).getRecipe_kinds() %></label><br>
		<label id="recipe_ing"> 메인 재료 : <%=recipeinfoList.get(i).getRecipe_ing() %></label><br>
		<label id="recipe_time"> 소요시간 : <%=recipeinfoList.get(i).getRecipe_time() %></label><br>
		<label id="recipe_date"> 작성일자 : <%=recipeinfoList.get(i).getRecipe_date() %></label><br><br>
	</div>
	
</div>

	
<%}%>

<div>
<jsp:include page="/WEB-INF/views/common/recipelistpaging.jsp" />
</div>

</body>
</html>

