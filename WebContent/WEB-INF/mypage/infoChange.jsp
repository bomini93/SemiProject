<%@page import="java.util.List"%>
<%@page import="dto.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/header/header.jsp" %>
<style type="text/css">

input:focus {outline:none;}

select, input:not(#idchk) {
	 border-style:none;
     border-bottom:solid 1px #cacaca;
     border-collapse:collapse;
     font-size: 11px;
     line-height: normal;
     background-color: #FFFFF3;
}

form{
	padding-bottom : 50px;
	border-bottom: 1px #ccc solid;
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
  left: 110px; 
}

body{
	height: 900px;
	background:#FFFFF3;
}


#logo {
	margin-top: 60px;
	text-align: center;
	font-family:Bemin;
	font-size: 50px;
}

div[id^='div'] {
		width: 320px;
		margin: 0 auto;
		text-align: left;
		margin-top: 20px;
	}
	
	div[id^='div'] label {
		max-width: 100%;
	}
	
	div[id^='div'] input {
		width: 100%;
	}
	
	div[id^='div'] select#pw_questionno, div[id^='div'] select#user_gender, div[id^='div'] select#spicy_no, div[id^='div'] select#amount_no {
		width: 102%;
		height: 30px;
	}

/* #btnOk{ */
/* 	margin-right: 100px; */
/* } */

</style>
</head>


<script type="text/javascript">
	
</script>
<body>
<div id="logo">수정페이지</div><br>

<form action = "/mypage/change" method = "post" name = "userInfo" onsubmit="return checkValue()">
	
   		 <div id = "div8">
		 <label for = "spicy_no">매운음식 얼마나 잘드시나요?</label><br>
		 <select id = "spicy_no" name = "spicy_no">
			<option value = "1">참깨라면까지 먹을수 있어요</option>
   			<option value = "2">너구리까지 먹을수 있어요</option>
   			<option value = "3">신라면까지 먹을수 있어요</option>
   			<option value = "4">불닭볶음면까지 먹을수 있어요</option>
   		</select>
		</div><br>
	
		<div id = "div9">
		 <label for = "amount_no">드시는 양은 어느정도인가요?</label><br>
		 <select id = "amount_no" name = "amount_no">
			<option value = "1">라면 1봉</option>
   			<option value = "2">라면 2봉</option>
   			<option value = "3">라면 3봉</option>
   			<option value = "4">그 이상</option>
   		</select><br>
   
   		<button>수정하기</button>
  
		</div><br>
	</form>

<%@include file="/footer/footer.jsp" %>
</body>
</html>