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
<script src="js/festival_info.js?ver=2"></script>
<script type="text/javascript" src="js/ad.js?ver=1"></script>
<script type="text/javascript" src="js/month.js?ver=1"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=945948afbe6a4f41cd89e5fd9efe678e&libraries=services"></script>

<link rel="stylesheet" href="css/festival_info.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/reset.css?ver=1" />
<link rel="stylesheet" type="text/css" href="css/calendar.css?ver=1">

<script src="js/jquery.magnific-popup2.js"></script>
<link rel="stylesheet" href="css/magnific-popup.css"> 

<script type="text/javascript">
var festival; //달력에서 선택하면 축제정보 및 도시정보를 저장하는 변수
var festival2;
var date = new Date(); // 날짜 객체 생성
var y = date.getFullYear(); // 현재 연도
var m = date.getMonth(); // 현재 월
var mem_num;
var favor;
var chkis;
$(document).ready(function(){
	
	chkis ='${empty sessionScope.chk}' == 'true' ? true : false;
	var chk='${sessionScope.chk}';
	
	if('${not empty sessionScope.mem_num}')
	mem_num='${sessionScope.mem_num}';
	
	
	
	switch(chk){
	case '0':console.log("운영자 로그인"); 
	var url = "http://localhost:8090/hcmc/admin.do";
	   $(location).attr('href',url); break;
	case '1':console.log("일반회원 로그인");
	         headerView('${sessionScope.id}');break;
	case '2':alert('인증 메일을 전송했습니다. 확인해주세요.'); break;
	}
	
		var w_d = $(document).width();
		var h_d = $(document).height();
		cal(m,y); //달력생성
		fest_list(m,y); //달력에 축제 리스트 뿌림
		today_color(); //오늘 날짜 강조
		loc_filter(); //필터 이벤트 연결
		console.log(festival2);
		f_pic_preview(festival2); //달력항목 마우스 오버 미리보기
		
		//userfavor(mem_num);
		
		
		console.log('${list}');		  		
		$(document).on('click','td div span',function(e){
			var n=$(e.target).attr('name');
			$('.festival_picpic').empty();
			if(n!=""){
				festival_view(n); //축제정보 가져오기
				festival_map(); //축제정보맵 호출
				resize_info(w_d,h_d); //축제정보창 띄우기
				if(chkis==false)
				userfavor_inner(n);
			}
		});

		$('#test_btn').click(function(){
			$('area').remove();
		});
		
		$("#header").hide();
		$('#gnb').hide();
		$("#login_info").hide();

		
		$("#login").on("click",function(){
			  $('#join_form').css({"display":"none"}); 
			  $('#sign_form').fadeToggle('normal'); 
			  $('#sign_form').css({'position':'absolute','left':'64px','top':'84px'});
		  });
		  
		  $("#join").on("click",function(){
			  $('#sign_form').css({"display":"none"});
			  $('#join_form').fadeToggle('normal'); 
			  $('#join_form').css({'position':'absolute','left':'64px','top':'84px'});
		  });
		  
		  $("#del button").click(function(){		  
			  $('#sign_form').css({"display":"none"}); 
			  $('#join_form').css({"display":"none"}); 
		  });	
		  
		
});
//헤더
function headerView(id){
    $('#join_form').css({"display":"none"});  
    $('#header').empty();
    $('#header').append('<ul class="logo"><li><a href="#"><img src="icon/main2.png" /></a></li><li class="lo"><img src="icon/logo_text.png"/></li><li id="login"><span></span></li><li id="logout"><img src="icon/user2.png"/></li></ul>');		     
   
 		     
     $("#login_info").hide();
	  $("#logout").on("click",function(){
		  $('#login_info').fadeToggle('normal'); 
		  $('#login_info').css({'position':'absolute','left':'64px','top':'84px'});

	  });
 

}//end headerView()

function test2(){
}

function cal_inner(res){
	console.log("car_inner"+res[0].festival_num);
	$('.prev_tooltip').remove();
	for(var i=0;i<res.length;i++){
		var f_num=res[i].festival_num; //축제번호
		var f_name=res[i].festival_name; //축제이름
		var f_theme=res[i].festival_theme;
		var c_num=res[i].city_num; //도시번호
		var c_name=res[i].city[0].city_name; //도시이름
		var s_date=new Date(res[i].festival_start); //시작날짜
		var e_date=new Date(res[i].festival_end); //끝 날짜
		var s_day=s_date.getDate();
		var e_day=e_date.getDate();
		var f_period=(e_date-s_date)/(1000*60*60*24); //축제기간
		var d=document.getElementsByClassName(s_day); //클래스명이 시작날짜와 일치하는 DOM요소
		var str;
		str ='<div class="prev_tooltip"><div id="d'+f_num+'">';
		if(res[i].festival_pic.length>0){
		var img_name=res[i].festival_pic[0];
		str+='<img name="'+f_num+'" src="image.do?filename='+img_name+'"/>'
		console.log(img_name);
		}
		str+='</div></div>';
		if(d.length>0){
		$('.'+s_day).append('<span name="'+f_num+'" class="'+c_name+' '+f_theme+'">'+f_name+'\n'+c_num+'</span>');
		$('body').append(str);
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
	fpic();
	cal_addr(festival);
	star_view(star);
}//읽어온 축제 정보로 축제 정보창에 별점을 만들어줌

function fpic(){
	var fpic=festival.p;
	for(var i = 0; i<fpic.length; i++){
		console.log(fpic[i]);
	var scr='<a href="image.do?filename='+fpic[i]+'" title="The Cleaner"><img src="image.do?filename='+fpic[i]+'" width="75" height="75"></a>';
	$('.festival_picpic').append(scr);
	
	
	}
}////죽제 정보창에 사진추가

jQuery(document).ready(function($){
	$('.festival_picpic').magnificPopup({
		delegate: 'a',
		type: 'image',
		tLoading: 'Loading image #%curr%...',
		mainClass: 'mfp-img-mobile',
		gallery: {
			enabled: true,
			navigateByImgClick: true,
			preload: [0,1] // Will preload 0 - before current, and 1 after the current image
		},
		image: {
			tError: '<a href="%url%">The image #%curr%</a> could not be loaded.',
			titleSrc: function(item) {
				return '<small>'+festival.f.festival_name+'</small>';
			}
		}
	});
	
});/////////magnificPopup


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
	$('.'+date.getDate()).prev().css({'color':'#0066cc','font-weight':'700'});
}//오늘 날짜 색깔을 바꿔서 강조해줌

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

<div id="header">
     <ul class="logo">
       <li><a href="main.do"><img src="icon/main2.png" /></a></li>
       <li class="lo"><img src="icon/logo_text.png"/></li>
       <li id="login"><img src="icon/login.png"/></li>
       <li id="join"><img src="icon/join1.png"/></li>    
     </ul>     
   </div>
   
   <div id="login_info">
    <div id="loginup_form">
   	<div id="login_id">
   		<span>${sessionScope.id}</span>
   	</div>
   	<span class="hr"></span>
   	<div id="login_mypage">
   		<a href="#">마이페이지</a>
   	</div>
   	<div id="login_logout">
   		<a href="logout.do">로그아웃</a>
   	</div>
   	</div>
   </div>

   
   <div id="gnb">     
   </div>

<div class="ad" id="ad" >
	<a class="ad_show" id="ad_show" href="#" >
	<img src="icon/banner3.jpg" height = "100px" width="100%">
	<%-- <img src="<%= request.getContextPath()%>/images/Koala.jpg" height = "50px" width="97%"> --%>
	</a>
	
	<a class="ad_close" id="ad_close" href="#">
	<img title="배너 다시 보지 않기" src="icon/x2.png" >
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
	<div class="cal">
		
	</div>
	<div class="rrr">
	
	</div>
	
	    <div id="sign_form">
       <div id="del">
         <button>X</button>
       </div>
     <div id="signup_form">
        <div class="arr">          
        </div>
        <div id="email">
          <input type="text" id="id" placeholder="이메일">
        </div>
        <div id="pass">        
          <input type="password" id="password" placeholder="비밀번호">        
        </div>
        <div id="checked">
          <input type="checkbox" value="login" id="cb_saveId">
          <label>로그인저장</label>
        </div>
        <div id="login_btn">로그인</a>
        </div>
        <div id="pass_search">
           <a href="#">비밀번호 찾기</a>
        </div>
        
        <div id="facebook">
        <a href="https://www.facebook.com/login.php?skip_api_login=1&api_key=1637556516502515&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.4%2Fdialog%2Foauth%3Fredirect_uri%3Dhttp%253A%252F%252Fjasoseol.com%252Fusers%252Fauth%252Ffacebook%252Fcallback%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%26scope%3Demail%26response_type%3Dcode%26client_id%3D1637556516502515%26ret%3Dlogin%26logger_id%3D2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2&cancel_url=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Ffacebook%2Fcallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%23_%3D_&display=page&locale=ko_KR&logger_id=2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2">
          <img src="http://jasoseol.com/assets/index/icon-facebook-af12cbb0400bc3af9442327fc336f5773948cc5dfa58dae29609bf314bf68788.png"/>
          <p>페이스북 로그인</p>
        </a>
        </div>
        
        <div id="naver">
        <a href="https://nid.naver.com/oauth2.0/authorize?client_id=c8V5Z8ypkyCWSg6w2Cm7&redirect_uri=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Fnaver%2Fcallback&response_type=code&state=395462cbdc00ce3249bdf0fc26f6604f9867f5d4b7c43180">
        <img src="http://jasoseol.com/assets/index/icon-naver-66dfe17006198397f124d459c13c71dcfd559fc996537875fe40c61af124774a.png"/>
        <p>네이버 로그인</p>
        </a>
        </div>
     </div>
   </div>
   
   <div id="join_form">
   <div id="del">
         <button>X</button>
       </div>
     <div id="joinup_form">
        <div class="arr">          
        </div>
        <div id="email">
          <input type="text" id="id_email" placeholder="이메일">
        </div>
        <div id="pass">        
          <input type="password" id="id_pass" placeholder="비밀번호(8자이상)">        
        </div>
        <div id="pass_en">        
          <input type="password" placeholder="비밀번호 재입력">        
        </div>        
        <div id="join_btn">회원가입</div>
        
        <div id="facebook">
        <a href="https://www.facebook.com/login.php?skip_api_login=1&api_key=1637556516502515&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.4%2Fdialog%2Foauth%3Fredirect_uri%3Dhttp%253A%252F%252Fjasoseol.com%252Fusers%252Fauth%252Ffacebook%252Fcallback%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%26scope%3Demail%26response_type%3Dcode%26client_id%3D1637556516502515%26ret%3Dlogin%26logger_id%3D2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2&cancel_url=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Ffacebook%2Fcallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%23_%3D_&display=page&locale=ko_KR&logger_id=2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2">
          <img src="http://jasoseol.com/assets/index/icon-facebook-af12cbb0400bc3af9442327fc336f5773948cc5dfa58dae29609bf314bf68788.png"/>
          <p>페이스북 로그인</p>
        </a>
        </div>
        
        <div id="naver">
        <a href="https://nid.naver.com/oauth2.0/authorize?client_id=c8V5Z8ypkyCWSg6w2Cm7&redirect_uri=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Fnaver%2Fcallback&response_type=code&state=395462cbdc00ce3249bdf0fc26f6604f9867f5d4b7c43180">
        <img src="http://jasoseol.com/assets/index/icon-naver-66dfe17006198397f124d459c13c71dcfd559fc996537875fe40c61af124774a.png"/>
        <p>네이버 로그인</p>
        </a>
        </div>
     </div>
   </div>
	
<div class="bodywrap">
	<div class="infowrap">
		<div class="info_mask"></div>
		<div class="info_inner">
			<div class="festival_header inner_gap">
			<div class="fh_top inner_gap">
				<button name="close">X</button>
				<a href="" target="_blank"><img alt="홈페이지로 이동합니다." src="images/icon_home.png" width=20px height=20px></a>
				<div class="view_count">
          			<img src="icon/view1.png" width=20px, height=20px/>
          			<span id="viewcount"></span>
          			<img id="favor_insert" src="icon/heart-no.png" width=20px, height=20px>
        		 </div>
			</div>
			
				<span class="title"></span>
				<span class="period"><span></span><span></span></span>
				
				<div class="star"></div>
			</div>
			<div class="festival_detail inner_gap">
				<span class="content">////축제날짜</span>
			</div>
			
			<div class="festival_picpic inner_gap"></div>
				
			<div class="festival_map inner_gap">
			
<%--  			<jsp:include page="festival_map.jsp" flush="true"></jsp:include> --%>
			<%@ include file="festival_map.jsp" %>
			</div>

		</div>
	</div>
</div>

</body>
</html>