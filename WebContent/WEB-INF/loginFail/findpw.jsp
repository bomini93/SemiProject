<%@page import="dto.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%List<Question> qsList = (List)request.getAttribute("list"); %>
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
  left: 300px; 
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

#btnOk {
	margin-left: 420px;
}

</style>
</head>
<body>
<div id="logo">비밀번호 찾기</div><br>
<form action = "/member/findpw" method = "post">  
	<div id="div1">
	<label for = "user_id">아이디</label>
    <input type="text" name="user_id" placeholder="아이디"><br>
    </div>
    
    <div id="div2">       
  	 비밀번호 질문<select id = "pw_questionno" name = "pw_questionno">
   				<option value = "q1"><%=qsList.get(0).getPw_question() %></option>
   				<option value = "q2"><%=qsList.get(1).getPw_question() %></option>
   				<option value = "q3"><%=qsList.get(2).getPw_question() %></option>
   				<option value = "q4"><%=qsList.get(3).getPw_question() %></option>
   				<option value = "q5"><%=qsList.get(4).getPw_question() %></option>
   			</select><br>
   	</div>	
   	
   	<div id="div3">
	비밀번호 답변<input type="text" name="pw_answer" placeholder="비밀번호 답변"><br>
    </div><br>
    
	<button id = "btnOk">확인</button>
</form>

<%@include file="/footer/footer.jsp" %>
</body>
</html>