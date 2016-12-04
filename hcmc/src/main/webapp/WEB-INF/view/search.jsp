<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>흥 청 망 청</title>
<link href="css/search.css?ver=1" type="text/css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/search.js?ver=1"></script>

<script src="js/festival_info.js?ver=1"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=945948afbe6a4f41cd89e5fd9efe678e&libraries=services"></script>
<link rel="stylesheet" type="text/css" href="css/festival_info.css?ver=1">

<!-- datepicker --> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- bxslide -->
<!-- <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" media="all" /> -->
<!-- 터치 슬라이드 플러그인 연동 -->
<script src="js/jquery.bxslider.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<!-- bxSlider 플러그인 연동 -->
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>

<script type="text/javascript">
var festival;
$(document).ready(function(){
	var chk ='${empty sessionScope.chk}' == 'true' ? true : false;
	console.log(chk);
	
	if(!chk){
		headerView('${sessionScope.id}');
	}	
	
	var w_d = $(document).width();
	var h_d = $(document).height();
	
	 var name =$("#loca option:selected").val();
	 var theme = $(':radio[name="theme"]:checked').val();
	 var year = $('#datepicker').val();
	
	 
	 $(document).on('click','.search_w .write h3',function(e){
		 		
			var n=$(e.target).prev().val();
			if(n!=""){
				festival_view(n); //축제정보 가져오기
				festival_map(); //축제정보맵 호출
				resize_info(w_d,h_d); //축제정보창 띄우기			
			}
			
			
		});
	 $('.bodywrap').hide();
	
	
	 
	 
	var name='<%=request.getParameter("city_name")%>' ;
	$('#loca option').filter('.'+name).prop('selected',true);
	$('#loca option').not('.'+name).prop('selected',false);
	
	var theme='<%=request.getParameter("festival_theme")%>';
	$('#the option').filter('.'+theme).prop('selected',true);
	$('#the option').not('.'+theme).prop('selected',false);
	
	var year='<%=request.getParameter("festival_start")%>';
	$('#datepicker').val(year);
	
	$(".tt a").on("click",function(){
		var city_name =$("#loca option:selected").val();
		var festival_theme = $('#the option:selected').val();
		var festival_start = $('#datepicker').val();
		$('.tt a').attr('href',"search.do?city_name="+city_name+"&festival_theme="+festival_theme+"&festival_start="+festival_start);
		
	});
	$('.search_w').hover(function(){
		$('.write h3').css({'color':'white'});
		$('.write p').css({'color':'white'});
		$('.write span').css({'color':'white'});
		$('.search_w .view').css({'color':'white'});
		$('.search_w .view img').prop('src','icon/view2.png');
		
	},function(){
		$('.write h3').css({'color':'#666666'});
		$('.write p').css({'color':'#666666'});
		$('.write span').css({'color':'#666666'});
		$('.search_w .view').css({'color':'#666666'});
		$('.search_w .view img').prop('src','icon/view1.png');
	});
	
});



function festival_view_input(){
	/* var d = JSON.stringify(festival);
	var jsonObj = JSON.parse(d); */
	console.log(festival);
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

$(function(){
	/* 
	  var mySlider = $(".pic").bxSlider({
			mode : "horizontal", // 가로 수평으로 슬라이드 됩니다.
			speed : 500, // 이동 속도를 설정합니다.
			pager : false, // 현재 위치 페이징 표시 여부 설정.
			moveSlides : 3, // 슬라이드 이동시 갯수 설정.
			slideWidth :500, // 슬라이드 마다 너비 설정.
			minSlides : 1, // 최소 노출 개수를 설정합니다.
			maxSlides : 3, // 최대 노출 개수를 설정합니다.
			slideMargin :20, // 슬라이드간의 간격을 설정합니다.
			auto : true, // 자동으로 흐를지 설정합니다.
			autoHover : true, // 마우스 오버시 정시킬지 설정합니다.
			autoControls: true,
			controls : false
		// 이전 다음 버튼 노출 여부 설정합니다.
		});
	     */
	 // 이전 버튼을 클릭하면 이전 슬라이드로 전환됩니다.
		$(".touch_left_btn a").on("click", function() {
			mySlider.goToPrevSlide(); // 이전 슬라이드 배너로 이동됩니다.
			return false;// <a>에 링크를 차단합니다.
		});
		// 다음 버튼을 클릭하면 다음 슬라이드로 전환됩니다.
		$(".touch_right_btn a").on("click", function() {
			mySlider.goToNextSlide(); // 다음 슬라이드 배너로 이동됩니다.
			return false;
			
		});
	
});


</script>


</head>
<body>

<%-- <%
		//치환 변수 선언
		pageContext.setAttribute("cr", "\r"); //Space
		pageContext.setAttribute("cn", "\n"); //Enter
		pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
		pageContext.setAttribute("br", "<br/>"); //br 태그
	%> --%>

<div id="wrap">
   <div id="header">
     <ul class="logo">
       <li><a href="main.do"><img src="icon/main2.png" /></a></li>
       <li class="lo"><img src="icon/logo_text.png"/></li>
       <li id="login"><img src="icon/login.png"/></li>
       <li id="join"><img src="icon/join1.png"/></li>    
     </ul>     
   </div>

   
   <div id="gnb">     
   </div>
   
   <div id="com">
   <ul>
   <li>
     <form  action="" method="get">           
              <select id="loca" name="location">
                <option value="서울" class="서울">   서                    울</option>
                <option value="경기" class="경기">   경                    기</option>
                <option value="인천" class="인천">   인                    천</option>
                <option value="강원" class="강원">   강                    원</option>
                <option value="충청" class="충청">   충                    청</option>
                <option value="전라" class="전라">   전                    라</option>
                <option value="경상" class="경상">   경                    상</option>
                <option value="제주" class="제주">   제                    주</option>
              </select>                 
          </form> 
         </li>
         <li> 
          <form  action="" method="get">           
              <select id="the" name="theme">
                <option value="연인" class="연인">연 인</option>
                <option value="가족" class="가족">가 족</option>
                <option value="친구" class="친구">친 구</option>
                <option value="니홀로" class="나홀로">나홀로</option>
              </select>                 
          </form>
          </li>
           <li>
           <form  action="" method="get">           
              <input type="text" id="datepicker" class="yy" readonly value="날짜선택">              
           </form> 
           </li>
           <li class="tt"><a href=#><img src="icon/search.png" /></a></li>
           <div id="order">
           <a href="#" class="view">조회순</a>
           <a href="#" class="new">최신순</a> 
           </div>            
          </ul>          
   </div>
   <!-- 월 축제 뿌려주기 -->
   <div id="month_wrap">
   <span class="ss"><img src="icon/festival.png"/></span>
   <span class="flag"><img src="icon/flag.png"/></span>
    <span class="fe">    
  <% Calendar cal = Calendar.getInstance();%> 
  <%=  cal.get(Calendar.MONTH)+1 %>월</span>
     <div id="month_festival">
       <ul>
       <p class="touch_left_btn"> <!-- 이전 버튼 -->
        <a href="#">
         <img src="icon/prev.png" alt="이전 배너" />
        </a>
     </p>
        <c:forEach items="${month}" var="m">
          <li class="img"><img src="image/ff.jpg"/><br/>
          <span class="name">${m.festival_name}</span><br/>
          <span class="year"><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${m.festival_start}"/>~<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${m.festival_end}"/></span><br/>
          <span class="addr">${m.city[0].city_address}</span></li>
        </c:forEach>      
     <p class="touch_right_btn"> <!-- 다음 버튼 -->
        <a href="#">
         <img src="icon/next.png" alt="다음 배너" />
        </a>
     </p>   
       </ul>
     </div>
   </div>
   <div id="totalPage">
     <p>총 게시물 : ${pv.totalCount}</p>
   </div>
   <div id="bodywrap">  
   		   
     <c:forEach items="${aList}" var="dto">
     <div class="search">
       <div class="search_w"> 
       <!-- 버튼눌렀을때 이동 -->
         <div class="pic">
         <img src="image/flower.jpg"/>
         </div>
         <div class="write">
         <input type="hidden" id="num" value="${dto.festival_num}">
         <h3>${dto.festival_name}</h3><hr/>
		 <p>${dto.festival_content}</p>		 
		 <span>${dto.city[0].city_address}</span>
         <span><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${dto.festival_start}"/>~<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${dto.festival_end}"/></span>
         </div>
         <div class="view">
          <img src="icon/view1.png"/>
          <span id="count">${dto.festival_count}</span>
         </div>
       </div>
     </div>
	</c:forEach>
	
	<!-- 이전  -->
		<c:if test="${pv.startPage>1}">
		<c:url var="prePage" value="search.do">
		<c:param name="currentPage" value="${pv.startPage-pv.blockPage}"/>
		</c:url>
		<a href="${prePage}"><c:out value="이전"/></a>
		</c:if>

		<!-- 페이지 출력 시작 -->
		<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
			<a href="search.do?currentPage=${i}" class="current">${i}</a>
		</c:forEach>
		<!-- 페이지 출력 끝 -->
		<!-- 다음 -->
		<c:if test="${pv.totalPage>pv.endPage}">
				 <c:url var="nextPage" value="list.sb">
			<c:param name="currentPage" value="${pv.startPage+pv.blockPage}"/>
			</c:url>
			<a href="${nextPage}"><c:out value="다음"/></a>
		</c:if>
	    
   </div>
   
   
   	
<div class="bodywrap">
	<div class="infowrap">
		<div class="info_mask"></div>
		<div class="info_inner">
			<div class="festival_header">
			<button id="tt">test</button>
			<div class="fh_top">
				<button name="close">X</button>
				<a href=""><img alt="홈페이지로 이동합니다." src="http://imgdb.kr/aGif.dn" width=20px height=20px></a>
			</div>
				<c:out value=""/>
				<span class="title"></span>
				<span class="period"></span>
				
				<div class="star"></div>
			</div>
			<div class="festival_detail"></div>
				<span class="content">////축제날짜</span>
			<div class="festival_map">
			
			<%@ include file="map_test.jsp" %>
			</div>

		</div>
	</div>
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
          <label>자동로그인</label>
        </div>
        <div id="login_btn">로그인</a>
        </div>
        <div id="pass_search">
           <a href="#">비밀번호 찾기</a>
        </div>
        
        <div id="facebook">
        <a href="https://www.facebook.com/login.php?skip_api_login=1&api_key=1637556516502515&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.4%2Fdialog%2Foauth%3Fredirect_uri%3Dhttp%253A%252F%252Fjasoseol.com%252Fusers%252Fauth%252Ffacebook%252Fcallback%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%26scope%3Demail%26response_type%3Dcode%26client_id%3D1637556516502515%26ret%3Dlogin%26logger_id%3D2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2&cancel_url=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Ffacebook%2Fcallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%23_%3D_&display=page&locale=ko_KR&logger_id=2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2">
          <img src="icon/icon-facebook-af12cbb0400bc3af9442327fc336f5773948cc5dfa58dae29609bf314bf68788.png"/>
          <p>페이스북 로그인</p>
        </a>
        </div>
        
        <div id="naver">
        <a href="https://nid.naver.com/oauth2.0/authorize?client_id=c8V5Z8ypkyCWSg6w2Cm7&redirect_uri=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Fnaver%2Fcallback&response_type=code&state=395462cbdc00ce3249bdf0fc26f6604f9867f5d4b7c43180">
        <img src="icon/icon-naver-66dfe17006198397f124d459c13c71dcfd559fc996537875fe40c61af124774a.png"/>
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
          <img src="icon/icon-facebook-af12cbb0400bc3af9442327fc336f5773948cc5dfa58dae29609bf314bf68788.png"/>
          <p>페이스북 로그인</p>
        </a>
        </div>
        
        <div id="naver">
        <a href="https://nid.naver.com/oauth2.0/authorize?client_id=c8V5Z8ypkyCWSg6w2Cm7&redirect_uri=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Fnaver%2Fcallback&response_type=code&state=395462cbdc00ce3249bdf0fc26f6604f9867f5d4b7c43180">
        <img src="icon/icon-naver-66dfe17006198397f124d459c13c71dcfd559fc996537875fe40c61af124774a.png"/>
        <p>네이버 로그인</p>
        </a>
        </div>
     </div>
   </div>
   
   
   
   
   
   <div id="end">
     <div id="end_f">
        <ul class="foot">
          <li><a>회사소개</a></li>  
          <li><a>축제약관</a></li>    
          <li><a>서비스이용약관</a></li> 
          <li><a>제휴및광고문의</a></li>    
          <li><a>서비스이용약관</a></li>  
          <li><a>찾아오시는길</a></li>       
        </ul>
     </div>
     <div id="end_s">
       <div class="inner">
         <span>흥청망청 | 윤성준, 홍대표, 김도형, 남궁은지 | 주소 : 서울특별시 종로구 kh정보교육원</span>
         <span>Tel: 02-567-8546 | Fax: 02-5689-4121 | Mail: hcmc@hcmc.com</span>
         <span>Copyright @ 2016~</span>
         <span>흥청망청의 모든 컨텐츠 저작권은 흥청망청에 있습니다. 흥청망청의 사전 동의 없는 무단 컨텐츠 도용(복사, 스크랩, 캡쳐 등)은 경고 없이 법적 절차를 진행하게 됩니다.</span>
       </div>
       <div class="sns">
         <ul>
           <li><a href="https://www.facebook.com/eunji.namgung"><img src="icon/btn_sns_facebook.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=291&Parm3=&Parm4=&Parm5=&LandingURL=http://blog.tourbaksa.com"><img src="icon/btn_sns_blog.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=293&Parm3=&Parm4=&Parm5=&LandingURL=http://www.tourbaksa.com/event/view.asp?idx=760"><img src="icon/btn_sns_kakaotalk.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=294&Parm3=&Parm4=&Parm5=&LandingURL=http://www.youtube.com/channel/UCukXMvEQ0ZGuKNq2JKVvENQ"><img src="icon/btn_sns_youtube.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=296&Parm3=&Parm4=&Parm5=&LandingURL=http://instagram.com/tourbaksa7"><img src="icon/btn_sns_instagram.png"/></a></li>
         
         </ul>
       </div>
     </div>
   </div>
   
</div>
</body>
</html>












