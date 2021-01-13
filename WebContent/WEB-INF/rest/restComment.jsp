<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String rest_no = (String) request.getAttribute("rest_no"); %>

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

</style>

<style type="text/css">
.star-box {
	/* 별과 별 사이 공백 제거 */
    font-size: 0;
}

.star {
	/* width,height 적용가능하도록 변경 */
	display: inline-block;

	/* 별이 표현되는 영역 크기 */
	width: 15px;
    height: 25px;

	/* 투명한 별 표현 */
	background-image: url(./resources/empty.png);
	background-repeat: no-repeat;
}

.star_left {
	/* 왼쪽 별 */
	background-position: 0 0;
	background-size: 200%;
}

.star_right {
	/* 오른쪽 별 */
	background-position: 100% 0;
	background-size: 200%;
}

.on {
	/* 채워진 별로 이미지 변경 */
	background-image: url(./resources/star.png);
}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	var idx = 0;
	
	//별 클릭 이벤트
	$(".star").click(function() {
		
		//클릭된 별이 몇 번째 칸인지 알아내기
		idx = $(this).index();
		
		//모두 투명하게 만들기
		$(".star").removeClass("on")
		
		//클릭이 된 곳까지 채워진 별로 만들기
		for(var i=0; i<=idx; i++) {
			$(".star").eq(i).addClass("on");
		}
		
		console.log("클릭된 별의 위치 : " + idx)
		console.log("점수로 변환 : " + (idx+1)/2)
		
		$("input[name='rest_rating']").val((idx+1)/2)
	})
	
})
</script>
</head>
<body>

<div id="logo">리뷰 작성</div>

<form action="/comment" method="post" enctype="multipart/form-data">
<div id="div7">
   <label>별점
<!-- <input type="text" id="star" name="rest_rating">  -->
<span class="star-box"> 
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
</span>   
</label><br>
</div>

<div id="div8">
<input type="hidden" name = "rest_no" value = "<%=rest_no%>" />
<label>내용<br>
	<textarea id="content" name="rest_review_text" cols=40px; rows=15px; placeholder="내용을 입력 해주세요"></textarea>
</label><br><br>
</div>

<div id="div9">
<label>파일<input type="file" name="upfile" /> </label><br><br>
	<input type="hidden" name="rest_rating"/>
<button>작성</button>
</div>

<div id="result"></div>
</form>
<br>

<%@include file="/footer/footer.jsp" %>

</body>
</html>