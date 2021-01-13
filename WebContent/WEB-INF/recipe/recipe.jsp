<%@page import="dto.Recipe_Table"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/header/header.jsp" %><br>     
    
<%
         	List<Recipe_Table> restinfoList = (List) request.getAttribute("recipeinfolist");
         %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript" src="/resources/js/httpRequest.js"></script>

<script type="text/javascript">

window.onload = function() {
	
	send(search_all);
}

function send(val){

	var params = "list="+val.value;
	console.log(params);
	
	var url = "/recipe/search";
	
	sendRequest("POST", url, params, callback);
}

function callback() {
	   if(httpRequest.readyState == 4) {
	      if(httpRequest.status == 200) {
	         console.log("AJAX 정상 응답")
	         
	         //정상응답 처리 함수
	         appendResult();
	         
	      } else {
	         console.log("AJAX 요청/응답 에러")
	      }
	   }
	}

function appendResult(){
	result.innerHTML = httpRequest.responseText;
	
}

</script>


<style type="text/css">

#category{
	/* 내부 정렬 */
	text-align: center;
	
	/* 외부 정렬 */
	width: 900px;
	margin: 0 auto;
	
	font-size: 20px;
/* 	font-weight: bold; */
	
/* 	border: 1px solid #f0ad4e; */
	
	padding: 10px;
	
}

a {
	color: #ffc952;
}


</style>

</head>

<body>
<br>
<div class="list_search_form" id="category" style="font-family: bemin;">
    <label><input type="radio" id="search_all" name="search_type" value="1" onchange="send(this)" checked />  레시피전체</label>
    &nbsp;&nbsp;&nbsp;<label><input type="radio" name="search_type" value="2" onchange="send(this)"/>  돼지고기</label>
    &nbsp;&nbsp;&nbsp;<label><input type="radio" name="search_type" value="3" onchange="send(this)"/>  소고기</label>
    &nbsp;&nbsp;&nbsp;<label><input type="radio" name="search_type" value="4" onchange="send(this)"/>  닭고기</label>
    &nbsp;&nbsp;&nbsp;<label><input type="radio" name="search_type" value="5" onchange="send(this)"/>  오리고기</label>
    &nbsp;&nbsp;&nbsp;<label><input type="radio" name="search_type" value="6" onchange="send(this)"/>  해물류</label>
    &nbsp;&nbsp;&nbsp;<label><input type="radio" name="search_type" value="7" onchange="send(this)"/>  채소류</label>
	&nbsp;&nbsp;&nbsp;<label><input type="radio" name="search_type" value="8" onchange="send(this)"/>  기타</label>
</div>
<br><br>
<!-- 리스트가 들어갈 div -->
<div id = "result">

</div>

<br>
<div>
<%@ include file="/footer/footer.jsp" %> 
</div>

</body>


</html>




