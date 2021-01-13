<%@page import="dto.Rest_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Rest_info> list = (List) request.getAttribute("list"); %>
<%@include file="/header/header.jsp" %>
<style type="text/css">

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
  left: 250px; 
}

body{
	height: 900px;
	background:#FFFFF3;
}


#logo1 {
	margin-top: 60px;
	text-align: center;
	font-family:Bemin;
	font-size: 50px;
}

#logo2 {
	margin-top: 60px;
	text-align: center;
	font-family:Bemin;
	font-size: 50px;
}


/* 테이블 중앙 정렬 */
table {
	margin: auto;
	margin-top: 60px;
	text-align: center;
	width: 50%;
	table-layout: fixed;
}

/* 테이블 제목 중앙 정렬 */
th {
	margin: auto;
	text-align: center;
	width: 50%;
}

#map {
	margin: auto;
	margin-top: 10px;
	text-align: center;
}

#category {
	margin: auto;
	margin-top: 10px;
	text-align: center;
}

input[type=submit] {
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
	text-align: center;
}

input[type = button]{
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
	text-align: center;
}

a{
	color:black;
}

</style>

<body>

<div id="logo2">식당 리뷰</div>

<div id="category">
<form action="/restcategory" method="Get">
<input type="button" value="전체" onclick="location.href='/restselect'" />
<input type="submit" value="한식" name="category" />
<input type="submit" value="분식" name="category" />
<input type="submit" value="일식" name="category" />
<input type="submit" value="중국식" name="category" />
<input type="submit" value="경양식" name="category" />
<input type="submit" value="기타" name="category" />
</form>
</div>

<div>
<div id="map" style="width:800px;height:600px;"></div><br><br>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=24c2de90eb25394799e4baba4d7b8846&libraries=services"></script>

<script>
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.500646, 127.036384), //지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options);

var geocoder = new kakao.maps.services.Geocoder();

<%for(int i = 0 ; i < list.size(); i++) { %>
geocoder.addressSearch('<%=list.get(i).getRest_address() %>', function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=list.get(i).getRest_name() %></div>'
        });

        infowindow.open(map, marker);

    } 
});
<%}%>
</script>
</div>

<!-- 리스트 보여줄 div -->
<table class="table table-hover" style="width: 1000px;">
<tr>
	<th></th>
	<th>식당 이름</th>
	<th>리뷰 수</th>
	<th>별점</th>
</tr>

<%for(int i = 0 ; i < list.size(); i++) { %>
<tr>
<td>
	<%=list.get(i).getRest_no()%>
</td>
<td>
	<a href = "/rest/detail?rest_no=<%=list.get(i).getRest_no()%>"><%=list.get(i).getRest_name() %></a>
</td>
<td><%=list.get(i).getReview_count() %>개</td>
<td><%=list.get(i).getRest_rating() %>점</td>
</tr>
<%} %>

</table>

<div>
<jsp:include page="/WEB-INF/views/common/pagingCategory.jsp" />
</div><br><br><br><br>


</body>
</html>