<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String recipe_no = (String) request.getAttribute("recipe_no"); %>
    <% String review_no = (String) request.getAttribute("review_no"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	background-image: url(/resources/empty.png);
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
	background-image: url(/resources/star.png);
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
		
		$("input[name='recipe_rating']").val((idx+1)/2)
	})
	
})
</script>
</head>
<body>

<h1>수정 내용을 입력해주세요.</h1>

<form action = "/recipe/review/change" method = "post">
<div>
   <label>별점
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
	<input type="hidden" name = "review_no" value = "<%=review_no%>" />
   <label>내용<br>
      <textarea id="content" name="recipe_review_text"></textarea>
   </label><br><br>
   
   <input type="hidden"id="star" name="recipe_rating"> 
   <button>작성</button>                                                      
</div>	
</form>

</body>
</html>