<%@page import="java.util.List"%>
<%@page import="dto.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<Question> qsList = (List)request.getAttribute("list"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>	
<style type="text/css">

@font-face {
	font-family:"Bemin";
	src:url("/resources/font/BMHANNA_11yrs_ttf.ttf") format("truetype");
	font-style: normal;
	font-weight: normal;
}

@font-face {
	font-family:"Bemin2";
	src:url("/resources/font/BMDOHYEON_ttf.ttf") format("truetype");
	font-style: normal;
	font-weight: normal;
}

input:focus {outline:none;}

input[type=text] { width: 300px; height: 25px;}
input[type=password] { width: 300px; height: 25px;}
input[type=date] {height: 30px;}
input[type = button] {	color: #fff;
						width: 50px;
						font-size: 10px;
						margin-left: 215px;
						background:#ffc952;
						border: none;
						border-radius: 5px;
					}


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
  height:50px;
  font-size: 25px;
  padding:0 4.5em;
  outline:none;
  margin-top: 15px;
  margin-left: 5px;
  cursor : pointer;
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

label{	
	font-size: 13px;
	font-weight: bold;
}

#join{
	text-align: center;
	margin-top: 20px;
}

#div4{
	margin-top: 0;
}

#logo a:link { color: #ffc952; text-decoration: none;}

#logo a:visited { color: #ffc952; text-decoration: none;}
 
#logo a:hover { color: #ffc952; text-decoration: none;}




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
	
/* footer css */
.list_corp{
	list-style-type: none;
	padding: 0;
	margin: 0;
	
	
}

.list_corp > li{
	width: 120px;
	float: left;
	
	font-size: 10px;
	
	line-height: 20px;
	
	border-right : 1px solid #ccc;
	
	
}

.list_corp > li > a{
	text-decoration: none;
	padding: 10px 15px;
	margin : 0 3px;
}

.list_corp > li > a:hover {
	color: #000000; text-decoration: none;
}

.list_corp > li > a:link {
	color: #000000; text-decoration: none;
}

.list_corp > li > a:visited {
	color: #000000; text-decoration: none;
}

.main_corp {
	margin-top : 15px;
	
}

</style>
</head>


<script type="text/javascript">


function check_pw(){
	var pw = document.getElementById('user_pw').value;
	var SC = ["!", "@", "#", "$", "%"];
	var check_SC = 0;
	
	if(pw.length<6 || pw.length>16){
		window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능 합니다.');
		document.getElementById('user_pw').value='';
	}
	for(var i =0; i<SC.length; i++){
		if(pw.indexOf(SC[i]) != -1){
			check_SC=1;
		}
	}
	
	if(check_SC == 0){
		window.alert('!,@,#,$,%의 특수문자가 들어가 있지 않습니다.')
		document.getElementById('user_pw').value='';
	}
	if(document.getElementById('user_pw').value!='' && document.getElementById('user_pw2').value!=''){
		if(document.getElementById('user_pw').value==document.getElementById('user_pw2').value){
            document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
            document.getElementById('check').style.color='blue';
            document.getElementById('check').style.fontSize='10px';
		}
		else{
			document.getElementById('check').innerHTML ='비밀번호가 일치하지 않습니다.';
			document.getElementById('check').style.color='red';
			document.getElementById('check').style.fontSize='10px';
		}
	}
}

//아이디 중복체크 화면open
function openIdChk(){
	window.name="parentForm";
    window.open("/memberid/check",
            "", "width=500, height=300, resizable = no, scrollbars = no");    
}

	
</script>
<body>
	
	<div id = "main">
	<form action = "/member/join" method = "post" name = "userInfo" onsubmit="return checkValue()">
	
	<div id = "logo">
	<a href = "/home/home">냠냠밥상</a>
	</div>
	
		<div id = "div1">
			<label for = "user_id">아이디<input type = "button" value = "중복확인" onclick="openIdChk()" id = "idchk" style = "width: 60px;"></label><br>
   			<input type="text" id="user_id" name = "user_id" maxlength= "50"> 
   			 <input type="hidden" name="idDuplication" value="idUncheck" >
   		</div>
   			 		
		
		<div id = "div2">
		<label for = "user_pw">비밀번호</label><br>
   		<input type="password" id="user_pw" name = "user_pw" onchange="check_pw()"/>
   		</div>
   		
   		<div id = "div3">
   		<label for = "user_pw2">비밀번호 재확인</label><br>
   		<input type="password" id="user_pw2" name = "user_pw2" onchange="check_pw()"/>&nbsp;<span id="check"></span>
   		</div>
   		
   		<div id = "div4">
   		<label for = "user_birth">생년월일</label><br>
   		<input type="date" id="user_birth" name = "user_birth">
   		</div>
   		
   		<div id = "div5">
   		<label for = "pw_questionno">비밀번호 확인 질문</label><br>
   		<select id = "pw_questionno" name = "pw_questionno">
   			<option value = "q1"><%=qsList.get(0).getPw_question() %></option>
   			<option value = "q2"><%=qsList.get(1).getPw_question() %></option>
   			<option value = "q3"><%=qsList.get(2).getPw_question() %></option>
   			<option value = "q4"><%=qsList.get(3).getPw_question() %></option>
   			<option value = "q5"><%=qsList.get(4).getPw_question() %></option>
   		</select>
   		</div>
   		
   		<div id = "div6">
   		<label for = "pw_answer">답변</label><br>
   		<input type="text" id="pw_answer" name = "pw_answer">
   		</div>
   		
   		<div id = "div7">
   		<label for = "user_gender">성별</label><br>
   		<select id = "user_gender" name = "user_gender">
   			<option value = "M">남자</option>
   			<option value = "F">여자</option>
   		</select>
   		</div>
   		
   		 <div id = "div8">
		 <label for = "spicy_no">매운음식 얼마나 잘드시나요?</label><br>
		 <select id = "spicy_no" name = "spicy_no">
			<option value = "1">참깨라면까지 먹을수 있어요</option>
   			<option value = "2">너구리까지 먹을수 있어요</option>
   			<option value = "3">신라면까지 먹을수 있어요</option>
   			<option value = "4">불닭볶음면까지 먹을수 있어요</option>
   		</select>
		</div>
	
		<div id = "div9">
		 <label for = "amount_no">드시는 양은 어느정도인가요?</label><br>
		 <select id = "amount_no" name = "amount_no">
			<option value = "1">라면 1봉</option>
   			<option value = "2">라면 2봉</option>
   			<option value = "3">라면 3봉</option>
   			<option value = "4">그 이상</option>
   		</select>
		</div>
		
		<div id = "join">
		<button>가입하기</button>
		</div>
	
	</form>
	</div>
	
	<footer style = "font-size : 0.8em; text-align: center;">
	<div class = "main_corp" >
		<ul class ="list_corp" >
			<li class = "corp_item"><a href = "#">이용약관</a></li>
			<li class = "corp_item"><a href = "#"><strong>개인정보처리방침</strong></a></li>
			<li class = "corp_item"><a href = "#">고객센터</a></li>
			<li class = "corp_item"><a href = "#">&copy; KH정보교육원</a></li>
		</ul>
		</div>
	</footer>
</body>
</html>