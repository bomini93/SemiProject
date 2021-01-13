<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/header/header.jsp" %><br>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#upload").change(function( e ) {

		var files = e.target.files;
		
		if( !files[0].type.includes("image") ) {
			alert("이미지가 아닙니다")

			e.target.value = null

			return false;
		}
		
		var reader = new FileReader();
		
		reader.onload = function( ev ) {

			$("#image_container").html(
				$("<img>").attr({
					src: ev.target.result
					, width: "300"
					, height: "200"
				})
			)
			
		}
		
		reader.readAsDataURL( files[0] )//DataURL 형식으로 읽기
	
	})
	
	$("#upload2").change(function( e ) {

		var files = e.target.files;
		
		if( !files[0].type.includes("image") ) {
			alert("이미지가 아닙니다")

			e.target.value = null

			return false;
		}
		
		var reader = new FileReader();
		
		reader.onload = function( ev ) {

			$("#image_container2").html(
				$("<img>").attr({
					src: ev.target.result
					, width: "300"
					, height: "200"
				})
			)
			
		}
		
		reader.readAsDataURL( files[0] )//DataURL 형식으로 읽기
	
	})
	$("#upload3").change(function( e ) {

		var files = e.target.files;
		
		if( !files[0].type.includes("image") ) {
			alert("이미지가 아닙니다")

			e.target.value = null

			return false;
		}
		
		var reader = new FileReader();
		
		reader.onload = function( ev ) {

			$("#image_container3").html(
				$("<img>").attr({
					src: ev.target.result
					, width: "300"
					, height: "200"
				})
			)
			
		}
		
		reader.readAsDataURL( files[0] )//DataURL 형식으로 읽기
	
	})
	$("#upload4").change(function( e ) {

		var files = e.target.files;
		
		if( !files[0].type.includes("image") ) {
			alert("이미지가 아닙니다")

			e.target.value = null

			return false;
		}
		
		var reader = new FileReader();
		
		reader.onload = function( ev ) {

			$("#image_container4").html(
				$("<img>").attr({
					src: ev.target.result
					, width: "300"
					, height: "200"
				})
			)
			
		}
		
		reader.readAsDataURL( files[0] )//DataURL 형식으로 읽기
	
	})
	$("#upload5").change(function( e ) {

		var files = e.target.files;
		
		if( !files[0].type.includes("image") ) {
			alert("이미지가 아닙니다")

			e.target.value = null

			return false;
		}
		
		var reader = new FileReader();
		
		reader.onload = function( ev ) {

			$("#image_container5").html(
				$("<img>").attr({
					src: ev.target.result
					, width: "300"
					, height: "200"
				})
			)
			
		}
		
		reader.readAsDataURL( files[0] )//DataURL 형식으로 읽기
	
	})
	$("#upload6").change(function( e ) {

		var files = e.target.files;
		
		if( !files[0].type.includes("image") ) {
			alert("이미지가 아닙니다")

			e.target.value = null

			return false;
		}
		
		var reader = new FileReader();
		
		reader.onload = function( ev ) {

			$("#image_container6").html(
				$("<img>").attr({
					src: ev.target.result
					, width: "300"
					, height: "200"
				})
			)
			
		}
		
		reader.readAsDataURL( files[0] )//DataURL 형식으로 읽기
	
	})	
});

function checkFile(f){

	// files 로 해당 파일 정보 얻기.
	var file = f.files;

	// file[0].name 은 파일명 입니다.
	// 정규식으로 확장자 체크
	if(!/\.(gif|jpg|jpeg|png)$/i.test(file[0].name)) alert('gif, jpg, png 파일만 선택해 주세요.\n\n현재 파일 : ' + file[0].name);

	// 체크를 통과했다면 종료.
	else return;
	
	f.outerHTML = f.outerHTML;
}

</script>

<style type="text/css">

body{
	background: #FFFFF3;
}

#first{
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;

}


#cover{
	/* 	/* 내부 정렬 */ */
 	text-align: center;  
	
	/* 외부 정렬 */
/* 	width: 800px; */
	margin: 0 auto;
	
	padding: 10px;
	
/* 	상위에서 디스플레이 - 인라인 설정 */
 	display :inline;
	
}

#cover > div {
	/* 	하위에서 디스플레이 - 블록 설정 */
 	display: inline-block; 
	
	margin: 5px;
	padding: 10px;
	
	overflow: hidden;
	
/* 	flex-direction: row; */

}



*{
	font-size: 16px;
	font-weight: bold;
	font-family: Consolas, sans-serif;
	

	
	
	
}

input[type="text"] {
 	height: auto; /* 높이 초기화 */ 
 	line-height: normal; /* line-height 초기화 */ 
 	padding: .4em .2em; /* 여백 설정 */ 
 
 }






textarea::placeholder{
	color: black;
	
}

#submit{
	font-weight: bold;
	width: 110px;
	height: 40px;
	
/* 	background-color: gray; */
}





</style>

</head>
<body>

<div id="first">
<form id="cover" action="/recipe/write" method="post" enctype="multipart/form-data">
		
		<div>
			<div>레시피명</div>
			<div><input type="text" autofocus="autofocus" required="required" placeholder="ex)삼겹살숙주볶음" name="recipe_name" id="recipe_name" ></div>
		</div>
		
		
		<div>
		<div>종류</div>
			<div>
				<select style="width:100px;height:33px;" name="recipe_kinds" id="recipe_kinds" >
					<option value="한식">한식</option>
					<option value="중식">중식</option>
					<option value="분식">분식</option>
					<option value="일식">일식</option>
					<option value="양식">양식</option>
				</select>	
			</div>
		</div>
		
		<div>
			<div>주재료</div><div>
				<select style="width:150px;height:33px;" name="recipe_ing" id="recipe_ing">
					<option value="돼지고기">돼지고기</option>
					<option value="소고기">소고기</option>
					<option value="닭고기">닭고기</option>
					<option value="오리고기">오리고기</option>
					<option value="해물류">해물류</option>
					<option value="채소류">채소류</option>
					<option value="기타">기타</option>	
				</select></div>
		</div>
		
		
		<div>
			<div>조리시간</div>
			<div><input type="text" style="width:100px;height:33px;" required="required" name="recipe_time" id="recipe_time" placeholder="ex) 25분" /></div>
		</div><br>
		
		<div>
			<div>내용</div>
			<div><textarea required="required" name="recipe_text01" placeholder="조리법의 내용을 입력해주세요 ^^" id="recipe_text01" cols="75" rows="10"></textarea></div>
		</div>
		
		<div>
			<div>레시피이미지1</div>
			<div id="image_container"></div>
			<div><input type="file" required="required" name="imgFile01" id="upload" onchange="checkFile(this)" multiple /></div>
		</div><br><br>
		
		<div>
			<div>내용</div>
			<div><textarea required="required" name="recipe_text02" placeholder="조리법의 내용을 입력해주세요 ^^" id="recipe_text02" cols="75" rows="10"></textarea></div>
		</div>
		
		<div>
			<div>레시피이미지2</div>
			<div><div id="image_container2"></div></div>
			<div><input type="file" required="required" name="imgFile02" id="upload2" onchange="checkFile(this)" multiple/></div>
		</div><br><br>
		
		<div>
			<div>내용</div>
			<div><textarea name="recipe_text03" required="required" placeholder="조리법의 내용을 입력해주세요 ^^" id="recipe_text03" cols="75" rows="10"></textarea></div>
		</div>
		
		<div>
			<div>레시피이미지3</div>
			<div><div id="image_container3"></div></div>
			<div><input type="file" required="required" name="imgFile03" id="upload3" onchange="checkFile(this)" multiple/></div>
		</div><br><br>
		
		<div>
			<div>내용</div>
			<div><textarea required="required" name="recipe_text04" placeholder="조리법의 내용을 입력해주세요 ^^" id="recipe_text04" cols="75" rows="10"></textarea></div>
		</div>
		
		<div>
			<div>레시피이미지4</div>
			<div><div id="image_container4"></div></div>
			<div><input type="file" required="required" name="imgFile04" id="upload4" onchange="checkFile(this)" multiple/></div>
		</div><br><br>
		
		<div>
			<div>내용</div>
			<div><textarea required="required" name="recipe_text05" placeholder="조리법의 내용을 입력해주세요 ^^" id="recipe_text05" cols="75" rows="10"></textarea></div>
		</div>
		
		<div>
			<div>레시피이미지5</div>
			<div><div id="image_container5"></div></div>
			<div><input type="file" required="required" name="imgFile05" id="upload5" onchange="checkFile(this)" multiple /></div>
		</div><br><br>
		
		<div>
			<div>완성사진</div>
			<div><div id="image_container6"></div></div>
			<div><input type="file" required="required" name="mainFile" id="upload6" onchange="checkFile(this)" multiple/></div>
		</div><br><br>
		
		<div>
			<div><input width="20px" height="15px" type="submit" value="레시피 등록" id="submit" /></div>
		</div>	
	
</form>

</div>
</body>
</html>