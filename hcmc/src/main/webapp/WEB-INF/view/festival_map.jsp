<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>다음 지도 API</title>
</head>
<body>
	<div id="map" style="width:750px;height:350px;"></div>

	<script src="//apis.daum.net/maps/maps3.js?apikey=945948afbe6a4f41cd89e5fd9efe678e"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new daum.maps.LatLng(37.56682, 126.97865), // 지도의 중심좌표
		        level: 4, // 지도의 확대 레벨
		        mapTypeId : daum.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new daum.maps.Map(mapContainer, mapOption); 

		// 지도 타입 변경 컨트롤을 생성한다
		var mapTypeControl = new daum.maps.MapTypeControl();

		// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
		map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);	

		// 지도에 마커를 생성하고 표시한다
		var marker = new daum.maps.Marker({
		    position: new daum.maps.LatLng(37.56682, 126.97865), // 마커의 좌표
		    map: map // 마커를 표시할 지도 객체
		});

		// 마커 위에 표시할 인포윈도우를 생성한다
		var infowindow = new daum.maps.InfoWindow({
		    content : '<div style="padding:5px;">인포윈도우 :D</div>' // 인포윈도우에 표시할 내용
		});

		// 인포윈도우를 지도에 표시한다
		infowindow.open(map, marker);

		// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
		daum.maps.event.addListener(marker, 'click', function() {
		    alert('마커를 클릭했습니다!');
		});

		// 마커에 mouseover 이벤트를 등록한다
		daum.maps.event.addListener(marker, 'mouseover', function() {
		    console.log('마커에 mouseover 이벤트가 발생했습니다!');
		});

		// 마커에 mouseout 이벤트 등록
		daum.maps.event.addListener(marker, 'mouseout', function() {
		    console.log('마커에 mouseout 이벤트가 발생했습니다!');
		});

	</script>
</body>
</html>