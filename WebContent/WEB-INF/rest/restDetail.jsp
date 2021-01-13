<%@page import="dto.Rest_photo_table"%>
<%@page import="dto.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="dto.Rest_review_table"%>
<%@page import="dto.Rest_info"%>
<%@page import="dto.Rest_review_table"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>     

<% Rest_info res = (Rest_info) request.getAttribute("result"); %>
<% List<Map> rList = (List<Map>) request.getAttribute("review_list"); %>
<% List<Map> my_review = (List<Map>) request.getAttribute("my_review"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/resources/js/httpRequest.js"></script>

<script type="text/javascript">
</script>

<script type="text/javascript">
$(document).ready(function(){

	$("#delete").click(function(){
		alert("삭제되었습니다.");
	})
	$("#report").click(function(){
		alert("부적절한 내용으로 신고되었습니다.");
	})
	
})
</script>

<style type="text/css">

body{
	height: 900px;
	background:#FFFFF3;
}

button {
	background: #ffc952;
	color: #fff;
	border: none;
	height: 30px;
	font-size: 10px;
	padding: 0 2em;
	outline: none;
	margin-top: 9px;
	margin-left: 3px;
	cursor: pointer;
	border-radius: 50px;
	/*    position: relative;  */
	/*    left: 300px;  */
	text-align: center;
}

#logo {
	margin-top: 60px;
	text-align: center;
	font-family: Bemin;
}

#mycontent{
	text-align: left;
	width: 700px;
	margin: 0 auto;
	padding: 50px;
	display: inline;
	font-family: Bemin;
}
#mycontent>div {
	display: inline-block;
	margin: 10px;
	padding: 10px;
}

#allcontent{
	display: inline-block;
	text-align: center;
	width: 300px;
	margin: 0 auto;
	padding: 50px;
	display: inline;
	font-family: Bemin;
}
#allcontent>div {
/* 	display: inline-block; */
	margin: 10px;
	padding: 10px;
}

#rcontent{
	width: 500px;
	height: 150px;
	overflow: auto;
}

#allreview{

	font-family: bemin;
}

.wrapper{
	width: 960px;
	margin: 0 auto;
}

.relative{
	positioin: relative;
}

.relative div[class^="myreview"]{position: absolute;}
.myreview1{
	left: 0; 
	width: 70%;
}

.myreview2{
	right: 0;
    width: 30%;
    position: absolute;
    margin: -182px 114px 0 0px;
}

#mytable{
	font-family: Bemin;
}

th{
	border-bottom: 1px solid #444444;
    padding: 8px;
}

td{
	padding: 12px;
	margin: 8px;
	
}
</style>

</head>
<body>

<div id="logo" style="font-size:50px;"><%=res.getRest_name() %></div>
<div id="avgstar" style="text-align: center;font-family:Bemin;font-size: 30px;">평균 별점 : <%=res.getRest_rating()%></div>
<div id="restlike" style="text-align: center;">
	<button onclick="location.href='/rest/like?rest_no=<%=res.getRest_no()%>'">즐겨찾기 등록</button>
	<button onclick="location.href='/rest/likeCancel?rest_no=<%=res.getRest_no()%>'">즐겨찾기 해제</button>
</div> <br><br>


<div id="restinfo" style="font-size: 15px; text-align: center; font-family: bemin;">
	<ul>
<%-- 		<li style="list-style: none;"><%=res.getRest_name() %></li> --%>
		<li style="list-style: none;">대표번호 : <%=res.getRest_phone() %></li>
		<li style="list-style: none;">(우편번호) <%=res.getRest_new_address_zip() %> 도로명주소 <%=res.getRest_new_address() %></li>
		<li style="list-style: none;">(우편번호)<%=res.getRest_address_zip() %> 지번주소 <%=res.getRest_address() %></li>
	</ul>
</div><br>
<div id="map" style="width:500px;height:300px; text-align: center; margin: 0 auto;"></div>


<!-- 지도 관련된 코드 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=24c2de90eb25394799e4baba4d7b8846&libraries=services"></script>
<script>
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
   center: new kakao.maps.LatLng(37.500646, 127.036384), //지도의 중심좌표.
   level: 5, //지도의 레벨(확대, 축소 정도)
   draggable : false
};

var map = new kakao.maps.Map(container, options);

var geocoder = new kakao.maps.services.Geocoder();

geocoder.addressSearch('<%=res.getRest_address() %>', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {
        console.log("실행됨 ㅎㅎ");

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=res.getRest_name() %>></div>'
        });

        infowindow.open(map, marker);
        
        map.setCenter(coords);

    } 
});

function setDraggable(draggable) {
    // 마우스 드래그로 지도 이동 가능여부를 설정합니다
    map.setDraggable(draggable);    
}
</script>

<br><br>



<h1 id="logo">내가 작성한 리뷰</h1>
<div id="restwrite" style="text-align: center;">
<button onclick="location.href='/comment?rest_no=<%=res.getRest_no()%>'">리뷰 작성</button>
</div> <br><br>

<div class="wrapper">
<table id="mytable" style="width: 1000px; text-align: center;">
	<tr>
		<th style="width: 5%; text-align: center;">별점</th>
		<th style="width: 15%; text-align: center;">작성일</th>
		<th style="width: 50%; text-align: center;">내용</th>
		<th style="width: 20%; text-align: center;">사진</th>
		<th style="width: 10%; text-align: center;"></th>
	</tr>

<%	if( my_review != null  ) { %>
<% for(int i=0; i<my_review.size(); i++){ %>
	<% Rest_review_table rrtable = (Rest_review_table) my_review.get(i).get("myReview");  %>
	<% Rest_photo_table rpt = (Rest_photo_table) my_review.get(i).get("rpt"); %>
	
	<tr>
		<td style="width: 70px;"><%=rrtable.getRest_rating() %>점</td>
		<td style="width: 100px;"><%=rrtable.getRest_review_date() %></td>
		<td><%=rrtable.getRest_review_text() %></td>
		<td><img src="/upload/<%=rpt.getPhoto_chan_name()%>" style="width: 300px; height:250px;"/></td>
		<td>
			<button onclick="location.href='/change?rest_no=<%=res.getRest_no()%>&review_no=<%=rrtable.getRest_review_no()%>'">수정</button>
				
			<form action="/rest/delete" method="get">
				<input type="hidden" name = "rest_review_no" value="<%=rrtable.getRest_review_no() %>"/>
				<input type="hidden" name = "rest_no" value="<%=res.getRest_no()%>"/>
				
			<button id="delete">삭제</button>
			</form>
		</td>
	</tr>

	<%} %>
<%} %>	
		
</table><br>	
</div>


<br><br>


<h1 id="logo">전체 리뷰</h1> 
<div id="reviewcnt" style="text-align: center; font-family: bemin;">리뷰 수 : <%=res.getReview_count() %></div><br><br>

<div class="wrapper">
<table id="allreview" style="width: 1000px; text-align: center;">
	<tr>
		<th style="width: 10%; text-align: center; padding: 10px;">회원 정보</th>
		<th style="width: 5%; text-align: center;">별점</th>		
		<th style="width: 15%; text-align: center;">작성일</th>
		<th style="width: 50%; text-align: center;">내용</th>
		<th style="width: 20%; text-align: center;">사진</th>
	</tr>
	
<% for(int i=0; i<rList.size(); i++){ %>

	<% Member member = (Member) rList.get(i).get("mem"); %>
	<% Rest_review_table rrt = (Rest_review_table) rList.get(i).get("rrt"); %>
	<% Rest_photo_table rpt = (Rest_photo_table) rList.get(i).get("rpt"); %>

	<tr style="margin: 10px;">
		<td><%=member.getUser_id() %> 님<br>양 Lv. <%=member.getAmount_no() %><br>맵기Lv. <%=member.getSpicy_no() %><br>
		
			<form action="/rest/report" method="get">
				<input type="hidden" name="rest_review_no" value="<%=rrt.getRest_review_no()%>"/>
				<input type="hidden" name="user_no" value="<%=rrt.getUser_no()%>"/>
				<input type="hidden" name = "rest_no" value="<%=rrt.getRest_no()%>"/>
		<% if(!(member.getUser_id().equals(session.getAttribute("sessionId")))   ){%>
				<button id="report">신고</button>
				<%} %>
			</form>
		
		
		</td>
		<td><%= rrt.getRest_rating() %>점</td>
		<td><%= rrt.getRest_review_date() %></td>
		<td><%= rrt.getRest_review_text() %></td>
		<td><img src="/upload/<%=rpt.getPhoto_chan_name()%>" style="width: 300px; height:250px;"/></td>
	</tr>	
<%	} %>
</table>
</div><br><br>

<br><br>
<jsp:include page="/WEB-INF/views/common/restreviewpaging.jsp" /> <br><br>
<br><br>

<%@include file="/footer/footer.jsp" %>

</body>
</html>