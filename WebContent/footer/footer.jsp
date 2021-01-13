<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 모든 페이지에 적용된다 -->
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

* {
	margin:0;
	padding:0;
	color:#000;
	box-sizing: border-box;

}

.container2{
	width:100%;
	margin:0 auto;
}

footer{
	height: 70px;
	height: 70px;
	position: fixed; 
	bottom: 0; 
	width: 100%;
	background: #FFFFF3;
}
    

.list_corp{
	list-style-type: none;
	padding: 0;
	margin: 0;
	
	
}

.list_corp > li{
	width: 120px;
	float: left;
	
	font-size: 10px;
	
	line-height: 10px;
	
	border-right : 1px solid #ccc;
}

.list_corp > li > a{
	text-decoration: none;
	
	padding: 10px 15px;
	margin : 0 3px;
	color : gray;
}

.main_corp {
	margin-top : 15px;
}

.copr_item a:link { text-decoration: none;}

.logo a:visited { text-decoration: none;}
 
.logo a:hover {text-decoration: none;}

</style>

<!-- 모든 페이지에 적용된다. -->
<script type="text/javascript">

</script>

	<!-- footer 영역 -->
	<div class = "container2">
	<footer style = "font-size : 0.8em; text-align: center;">
	<div class = "main_corp">
		<ul class ="list_corp">
			<li class = "corp_item"><a href = "#">이용약관</a></li>
			<li class = "corp_item"><a href = "#">개인정보처리방침</a></li>
			<li class = "corp_item"><a href = "#">고객센터</a></li>
			<li class = "corp_item"><a href = "#">&copy; KH정보교육원</a></li>
		</ul>
		</div>
	</footer>
	</div>
</body>
</html>