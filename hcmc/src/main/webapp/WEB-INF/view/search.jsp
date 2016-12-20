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
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link href="css/search.css?ver=1" type="text/css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/search.js?ver=1"></script>

<script src="js/festival_info2.js?ver=1"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=5ee006ef2a6a3775fb080c9b4180f51e&libraries=services"></script>
<link rel="stylesheet" type="text/css" href="css/festival_info.css?ver=1">

<!-- datepicker --> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- 사진 넘기기 -->
<!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<script type="text/javascript" src="js/slider.jquery.js"></script>
<link href="css/slide_styles.css" type="text/css" rel="stylesheet" />
<!-- select부드럽게 -->
<link rel="stylesheet" type="text/css" href="css/jquery.selectlist.css">

<script src="js/jquery.magnific-popup2.js"></script>
<link rel="stylesheet" href="css/magnific-popup.css"> 


<script type="text/javascript">


var festival;
var mem_num;

$(document).ready(function(){   	
	
	var chkis ='${empty sessionScope.chk}' == 'true' ? true : false;
	var chk='${sessionScope.chk}';
	console.log(chkis+'mem_num:${sessionScope.mem_num}/////id:${sessionScope.id}');
	
	if('${empty sessionScope.mem_num}'!= 'true')
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
	
	 var name =$("#loca option:selected").val();
	 var theme = $(':radio[name="theme"]:checked').val();
	 var year = $('#datepicker').val();
	
	 
	 $(document).on('click','.search_w .write h3',function(e){
		 		
			var n=$(e.target).prev().val();
			$('.festival_picpic').empty();
			if(n!=""){
				festival_view(n); //축제정보 가져오기
				festival_map(); //축제정보맵 호출
				resize_info(w_d,h_d); //축제정보창 띄우기	
				if(!'${empty sessionScope.chkis}')
					userfavor_inner(n);
				$('body').scrollTop(0);
			}
			
			
		});
	 
	 $('.bodywrap').hide();
	 
	 $("#login_info").hide();
	
	 ////////////////////////////////////////////////////////////////////////////test
	 console.log('${aList[0].festival_pic}');
	 
	 
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
	/* $('.search_w').hover(function(e){		
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
	}); */
	
	
 
	$( function() {
	    $( "#datepicker").datepicker({
	    	dateFormat : 'yymmdd',
	    	monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    	dayNamesMin : ['일','월','화','수','목','금','토'],
	    	changeMonth : true,
	    	changeYear : true,
	    	showMonthAfterYear:true,
	    	
	    });	    		
	  });

 	$(function() {
	    $('#slider-inner').slider('#previous', '#next');
	});
	   
	 /*  $(function(){
			$('select').selectlist({
				zIndex: 10,
				width: 200,
				height: 30
			});		
		}) */
 	
});

$(document).ready(function(){
	var k = "${sessionScope.mem_num}";
	$('#login_mypage a').attr('href',"http://localhost:8090/hcmc/info.do?mem_num="+k);
})


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
   
      <!-- 월 축제 뿌려주기 -->
   
   <div id="slider-demo">  
     <span class="ss"><img src="icon/festival.png"/></span>
   <span class="flag"><img src="icon/flag.png"/></span>
    <span class="fe">    
     <% Calendar cal = Calendar.getInstance();%> 
     <%=  cal.get(Calendar.MONTH)+1 %>월
     </span>
     <a href="#" id="previous">«</a>
     <div id="slider-inner">       
       <ul>      
        <c:forEach items="${month}" var="m" varStatus="status">
          <c:if test="${!empty m.festival_pic[0]}">
         	 <li class="img"><img src="image.do?filename=${m.festival_pic[status.index]}"/><br/>
          </c:if>
          <span class="name">${m.festival_name}</span><br/>
          <span class="year"><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${m.festival_start}"/>~<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${m.festival_end}"/></span><br/>
          <span class="addr">${m.city[0].city_address}</span></li>
        </c:forEach>       
       </ul>
     </div>
       <a href="#" id="next">»</a>
   </div>
   
   <div id="com">
   <ul>
   <li>
     <form  action="" method="get">           
              <select id="loca" name="location">
                <option value="서울" class="서울">   서                    울</option>
                <option value="경기" class="경기">   경                    기</option>
                <option value="경상" class="경상">   경                    상</option>
                <option value="강원" class="강원">   강                    원</option>
                <option value="충청" class="충청">   충                    청</option>
                <option value="전라" class="전라">   전                    라</option>
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
                <option value="혼자" class="혼자">혼자</option>
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

   
   
   
   
   <div id="totalPage">
     <p>총 게시물 : ${pv.totalCount}</p>
   </div>
   <div id="bodywrap">  
   	<c:choose>    
       <c:when test="${!empty aList}">	   
     <c:forEach items="${aList}" var="dto">
     <div class="search">
       <div class="search_w"> 
         
       <!-- 버튼눌렀을때 이동 -->
         <div class="pic">
         <c:if test="${!empty dto.festival_pic}">
         <img src="image.do?filename=${dto.festival_pic[0]}"/>
         </c:if>
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
	</c:when> 
         <c:otherwise>
         <div class="search">
       <div class="search_w"> 
         <span>검색한 데이터가 존재하지 않습니다.</span>
         </div></div>
         </c:otherwise>
        </c:choose>
	
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
         
         <%@ include file="festival_map_xxx.jsp" %>
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
          <label>로그인저장</label>
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












