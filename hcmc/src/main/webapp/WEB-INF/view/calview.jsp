<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>흥 청 망 청 - 축제달력</title>

<script type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/ad.js?ver=1"></script>
<script src="js/festival_info.js?ver=1"></script>
<script type="text/javascript" src="js/month.js?ver=1"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=945948afbe6a4f41cd89e5fd9efe678e&libraries=services"></script>

<link rel="stylesheet" href="css/festival_info.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/reset.css?ver=1" />
<link rel="stylesheet" type="text/css" href="css/calendar.css?ver=1">

<script type="text/javascript">
var festival; //달력에서 선택하면 축제정보 및 도시정보를 저장하는 변수
var festival2;
var date = new Date(); // 날짜 객체 생성
var y = date.getFullYear(); // 현재 연도
var m = date.getMonth(); // 현재 월
$(document).ready(function(){
		var w_d = $(document).width();
		var h_d = $(document).height();
		cal(m,y); //달력생성
		fest_list(m,y); //달력에 축제 리스트 뿌림
		today_color(); //오늘 날짜 강조
		loc_filter(); //필터 이벤트 연결
		console.log(festival2);
		f_pic_preview(festival2); //달력항목 마우스 오버 미리보기
		console.log('${list}');		  		
		$(document).on('click','td div span',function(e){
			var n=$(e.target).attr('name');
			if(n!=""){
				festival_view(n); //축제정보 가져오기
				festival_map(); //축제정보맵 호출
				resize_info(w_d,h_d); //축제정보창 띄우기
			}
		});

		$('#test_btn').click(function(){
			$('area').remove();
		});
});

function test2(){
}

function cal_inner(res){
	console.log(res);
	$('.prev_tooltip').remove();
	for(var i=0;i<res.length;i++){
		var f_num=res[i].festival_num; //축제번호
		var f_name=res[i].festival_name; //축제이름
		var f_theme=res[i].festival_theme;
		var c_num=res[i].city_num; //도시번호
		var c_name=res[i].city[0].city_name; //도시이름
		var s_date=new Date(res[i].festival_start); //시작날짜
		var s_day=s_date.getDate();
		var d=document.getElementsByClassName(s_day); //클래스명이 시작날짜와 일치하는 DOM요소
		if(d.length>0){
		console.log(f_name+'////'+s_day+'////'+d.length);
		//$('.'+s_day+' span').attr('name',f_num);
		$('.'+s_day).append('<span name="'+f_num+'" class="'+c_name+' '+f_theme+'">'+f_name+'\n'+c_num+'</span>');
		$('body').append('<div class="prev_tooltip"><div id="d'+f_num+'"><img name="'+f_num+'" src="images/icon_cat.jpg"></div></div>');
		}
	};
}//읽어온 정보중 축제 이름과 도시 번호를 달력에 추가해줌

function festival_view_input(){
	/* var d = JSON.stringify(festival);
	var jsonObj = JSON.parse(d); */
	var star=festival.f.star;
	var sdate=new Date(festival.f.festival_start);
	var edate=new Date(festival.f.festival_end);
	var sdate_str=sdate.getFullYear()+"/"+(sdate.getMonth()+1)+"/"+sdate.getDate();
	var edate_str=edate.getFullYear()+"/"+(edate.getMonth()+1)+"/"+edate.getDate();
	$('.title').text(festival.f.festival_name);
	$('.period span').eq(0).text(sdate_str+"  ~  "+edate_str);
	$('.period span').eq(1).text(festival.f.festival_time+"~");
	$('.content').text(festival.f.festival_content);
	$('.fh_top a').attr('href',festival.f.festival_hpage);
	$('#marker').text(festival.f.festival_name);
	$('#viewcount').text(festival.f.festival_count);
	var city_name=festival.c.city_name;
	var city_lati=festival.c.city_lati;
	var city_long=festival.c.city_long;
	cal_addr(festival);
	test2();
	star_view(star);
}//읽어온 축제 정보로 축제 정보창에 별점을 만들어줌

function cal_addr(festival){
	var addr=festival.c.city_address;
	var fname=festival.f.festival_name;
	// 주소로 좌표를 검색합니다 //주소값 map 테이블에서 받아와서 넣어줄 것
	geocoder.addr2coord(addr, function(status, result) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === daum.maps.services.Status.OK) {

	        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
			
	        
	       /*  var imageSrc = 'http://cfile221.uf.daum.net/R320x0/2443453C5838E28622D9E6', // 마커이미지의 주소입니다    
	        imageSize = new daum.maps.Size(64, 69), // 마커이미지의 크기입니다
	        imageOption = {offset: new daum.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	        
	        var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption);
	         */
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new daum.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다 장소 이름 값 받아서 넣어줄것
	        var infowindow = new daum.maps.InfoWindow({
	            content: '<div id="marker" style="width:150px;text-align:center;padding:6px 0;">'+fname+'</div>'
	        });
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

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});///다음 지도 주소검색 구현부분//////////////////////////////////////////////////////////////////////////
	
}

function today_color(){
	if(m==date.getMonth())
	$('.'+date.getDate()).prev().css({'color':'#ff8000','font-weight':'700'});
}//오늘 날짜 색깔을 바꿔서 강조해줌

<%-- function remap(){
	$.ajax({url:"<%request.getContextPath();%>/festival_map.jsp",
		success:function(result) {
			console.log(result)
			$(".festival_map").html(result);
		}
	});
}; --%>
</script>
<style type="text/css">
html{
height:100%;
overflow-x:overlay;
overflow-y:auto;
}

#ad{
width:100%;
height: 30px;
}

</style>
</head>
<body>
<div class="ad" id="ad" >
	<a class="ad_show" id="ad_show" href="#" >
	<img src="<%= request.getContextPath()%>/images/Koala.jpg" height = "50px" width="97%">
	</a>
	
	<a class="ad_close" id="ad_close" href="#">
	<img title="배너 다시 보지 않기" src="images/x.jpg" height="50" width="2%" >
	</a>
</div>
<br/>


<form name="city" method="get">
<fieldset>
<p>지역 								　
<input id="chkbox_su" checked="checked" type="checkbox" name="서울" /><label for="chkbox_su">서울</label>
<input id="chkbox_gg" checked="checked" type="checkbox" name="경기" /><label for="chkbox_gg">경기</label>
<input id="chkbox_gw" checked="checked" type="checkbox" name="강원" /><label for="chkbox_gw">강원</label>
<input id="chkbox_gs" checked="checked" type="checkbox" name="경상" /><label for="chkbox_gs">경상</label>
<input id="chkbox_cc" checked="checked" type="checkbox" name="충청" /><label for="chkbox_cc">충청</label>
<input id="chkbox_jr" checked="checked" type="checkbox" name="전라" /><label for="chkbox_jr">전라</label>
<input id="chkbox_jj" checked="checked" type="checkbox" name="제주" /><label for="chkbox_jj">제주</label>
</p>
</fieldset>
</form>

<form name="theme" method="get">
<fieldset>
<p>테마 								　
<input id="chkbox_fa" checked="checked" type="checkbox" name="가족" /><label for="chkbox_fa">가족</label>
<input id="chkbox_co" checked="checked" type="checkbox" name="연인" /><label for="chkbox_co">연인</label>
<input id="chkbox_fr" checked="checked" type="checkbox" name="친구" /><label for="chkbox_fr">친구</label>
<input id="chkbox_si" checked="checked" type="checkbox" name="혼자" /><label for="chkbox_si">혼자</label>
</p>
</fieldset>
</form>
	<div class='button' id='button'>
	<button id='test_btn'>test</button>
	</div>
	<div class="cal">
		
	</div>
	<div class="rrr">
	
	</div>
	
<div class="bodywrap">
	<div class="infowrap">
		<div class="info_mask"></div>
		<div class="info_inner">
			<div class="festival_header inner_gap">
			<div class="fh_top inner_gap">
				<button name="close">X</button>
				<button id="tt">test</button>
				<a href="" target="_blank"><img alt="홈페이지로 이동합니다." src="images/icon_home.png" width=20px height=20px></a>
				<div class="view_count">
          			<img src="icon/view1.png" width=20px, height=20px/>
          			<span id="viewcount"></span>
        		 </div>
			</div>
			
				<span class="title"></span>
				<span class="period"><span></span><span></span></span>
				
				<div class="star"></div>
			</div>
			<div class="festival_detail inner_gap">
				<span class="content">////축제날짜</span>
			</div>
				
			<div class="festival_map inner_gap">
			
<%--  			<jsp:include page="festival_map.jsp" flush="true"></jsp:include> --%>
			<%@ include file="map_test.jsp" %>
			</div>

		</div>
	</div>
</div>
</body>
</html>