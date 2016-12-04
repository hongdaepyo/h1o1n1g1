<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>흥 청 망 청</title>
<link href="css/main.css?ver=1" type="text/css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/main.js?ver=1"></script>

<!-- datepicker --> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!--  <link rel="stylesheet" href="/resources/demos/style.css"/> -->

<!-- bxslide -->
<!-- <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" media="all" /> -->
<!-- 터치 슬라이드 플러그인 연동 -->
<script src="js/jquery.bxslider.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<!-- bxSlider 플러그인 연동 -->
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>

<!-- accordion -->  
<link rel="stylesheet" type="text/css" href="css/accordionImageMenu.css" />
<script src="js/jquery.accordionImageMenu.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	if('${param.code}'!=null){
	var ecode='${param.code}';
	}
	
	var chkis ='${empty sessionScope.chk}' == 'true' ? true : false;
	var chk='${sessionScope.chk}';
	console.log(chkis+'mem_num:${sessionScope.mem_num}/////id:${sessionScope.id}');
	switch(chk){
	case '1':console.log("일반회원 로그인");headerView('${sessionScope.id}');break;
	case '2':alert('인증 메일을 전송했습니다. 확인해주세요.'); break;
	}
	console.log("${board_mem}");
});


</script>


</head>
<body>

<div id="fb-root"></div>
<script>
(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.8&appId=1315679015161292";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

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
   
   
   <div id="main">
     <div id="swipe">
      <ul class="pic">
      <!--  <li><img src="http://image.tourbaksa.com/new/Main/MainThema/2016/10/773B58FA-6911-4CAF-A4B7-CF6722D7F75F.jpg"/></li>
       <li><img src="http://image.tourbaksa.com/new/Main/MainThema/2016/9/4E4D76CC-3CA7-4BA0-A5ED-3CB292831B27.jpg"/></li> -->
       <li><img src="image/vietnam.jpg"/></li>
       <li><img src="image/travel.jpg"/></li>
       <li><img src="image/vietnam.jpg"/></li>
       <li><img src="image/travel.jpg"/></li>
      </ul>
     </div>     
     <p class="touch_left_btn"> <!-- 이전 버튼 -->
        <a href="#">
         <img src="icon/prev.png" alt="이전 배너" />
        </a>
     </p>
     <p class="touch_right_btn"> <!-- 다음 버튼 -->
        <a href="#">
         <img src="icon/next.png" alt="다음 배너" />
        </a>
     </p>
   </div>
   
   <div id="top">
     <ul class="slide">
       <li id="location"><a href="#"><img src="icon/button.png"/></a></li>
       <li id="theme"><a href="#"><img src="icon/button.png"/></a></li>
       <li id="month"><a href="#"><img src="icon/button.png"/></a></li>
     </ul>          
   </div>

   
   <div id="bot">
     <div id="bot_pad">
       <div id="bot_pad2">
         <ul class="ff">
           <div class="ff_ff">
             <li name="서울">
               <img src="icon/se.png"/>
             </li> 
             <li name="경기">
               <img src="icon/se.png"/>            
             </li> 
             <li name="인천">
               <img src="icon/se.png"/>
             </li> 
             <li name="강원">
               <img src="icon/se.png"/>
             </li>       
             <li name="충청">
               <img src="icon/se.png"/>
             </li>
             <li name="전라">
               <img src="icon/se.png"/>
             </li>
             <li name="경상">
               <img src="icon/se.png"/>
             </li>
             <li name="제주">
               <img src="icon/se.png"/>
             </li>      
           </div>
           <div class="ff_ss">
             <li name="나홀로">
              <img src="icon/kk.png"/>
             </li> 
             <li name="연인">
               <img src="icon/kk.png"/>
             </li> 
             <li name="가족">
               <img src="icon/kk.png"/>
             </li> 
             <li name="친구">
               <img src="icon/kk.png"/>
             </li>             
           </div>
           <div class="ff_tr">
             
             
           </div>         
         </ul>
       </div>
     </div>
   </div>
 
   
   <div id="search">
        <div id="search_m">
          <ul class="city">
              <li>1.지역선택</li>
            <li> <div id ="location2">
           <form  action="" method="get">           
              <select id="loca" name="location">
                <option value="dd"  class="dd">지역명을 선택하세요</option>
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
          </div> 
          </li>     
          </ul>                
          <ul class="tm">
             <li>2.테마선택</li>
             <div class="alone">
             <form  action="" method="get">  
                <input type="radio" name="theme" value="싱글" class="나홀로" checked="checked">나홀로<br>
                <input type="radio" name="theme" value="연인" class="연인">연인<br>
                <input type="radio" name="theme" value="가족" class="가족">가족<br>
                <input type="radio" name="theme" value="친구" class="친구">친구 
               </form>         
             </div>
          </ul>
          <ul class="year">
             <li>3.기간선택</li>
             <li class="date"><p><input type="text" id="datepicker" readonly value="날짜선택">
             </p></li>
          </ul>
          <ul class=search_icon>
          <li class="tt"><a href=#><img src="icon/search.png" /></a></li>
          </ul>
          
        </div>
        
        
   </div>
   
   <div id="event">
    <div id="bx_slider">
     <div id="prev">
       <a href="#"><img src="http://www.yeongju.go.kr/img/main/main/btn_prev.gif"/></a>
     </div>
     <ul class="cal">
      <li><a href="#"><img src="icon/calender.png"/></a>
      <h2>축제 일정 보기
          <p>: 축제의 상세 일정을 확인할 수 있으며 원하는 년과 달을 선택 할 수 있다.</p>
        </h2>
      </li>
     <li><a href="#"><img src="icon/bus.png"/></a>
      <h2>버스 예약하기
          <p>: 축제의 상세 일정을 확인할 수 있으며 원하는 년과 달을 선택 할 수 있다.</p>
        </h2>
      </li>
      <li><a href="#"><img src="icon/review.png"/></a>
      <h2>게시판 바로가기
          <p>: 다른 사람의 후기와 축제에 대한 자세한 정보와 사람들과 정보를 공유할 수 있다.</p>
        </h2>
      </li>
     </ul>
     <div id="next">
       <a href="#"><img src="http://www.yeongju.go.kr/img/main/main/btn_next.gif"/></a>
     </div>
    </div>
   </div>
   
   <div id="travel">
     <div id ="travel_f">
       <h2>BEST one´s destination
       <span>
                      사람들이 자주 찾는 곳을 둘러보세요
        </span>
       </h2>
     </div>
     <div id="tabs">
       <div id="tab">
         <ul>
           <li><a href="#tabs-1">서울</a></li>
           <li><a href="#tabs-2">경기</a></li>
           <li><a href="#tabs-3">인천</a></li>
         </ul>
       </div>
       
       <div id="tabs-1">
         <ul id="menu1">
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
         </ul>
       </div>
       <div id="tabs-2">
         <ul id="menu2">
           <li><a href="#"><img src="image/four_seasons2.jpg"/></a></li>
           <li><a href="#"><img src="image/four_seasons2.jpg"/></a></li>
           <li><a href="#"><img src="image/four_seasons2.jpg"/></a></li>
           <li><a href="#"><img src="image/four_seasons2.jpg"/></a></li>
         </ul>
       </div>
       <div id="tabs-3">
         <ul id="menu3">
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
           <li><a href="#"><img src="image/theme.jpg"/></a></li>
         </ul>
       </div>
     </div>
     
   </div>
   
   <div id = "recommend">
     <div id= "recommend_f">
       <h3>흥청망청
         <span>recommend festival</span>
       </h3>       
       <ul id="recommends">         
          <li><a href="#"><img src="image/way.jpg"/></a></li>
          <li><a href="#"><img src="image/road.jpg"/></a></li>
          <li><a href="#"><img src="image/australia.jpg"/></a></li>
          <li><a href="#"><img src="image/sea.jpg"/></a></li>
          <li><a href="#"><img src="image/west.jpg"/></a></li>       
       </ul>     
     </div>
   </div>
<%--    
   <c:if test="${fn:length(mm.memList[0].mem_id)}<=2">
          <ul class='board'>
            <li class="user">
            <img src="icon/user2.png"/>
            <span>${mm.memList[0].mem_id}</span></li>
            <li class="content">
            <img src="icon/chat-blue.png"/>
            <span>${mm.board_content}</span></li>                     
          </ul> --%>
   
   <div id="review">   
     <div id="review_f">  
     <h2>festival review</h2>     
       <div id="review_s">
       <c:forEach items="${board_mem}" var="mm" end="1">
          <ul class='board'>
            <li class="user">
            <img src="icon/user2.png"/>
            <span>${mm.memList[0].mem_id}</span></li>
            <li class="content">
            <img src="icon/chat-blue.png"/>
            <span>${mm.board_content}</span></li>                     
          </ul>
          </c:forEach> 
          <c:forEach items="${board_mem}" var="mm" begin="2" end="3">
          <ul class='board_s'>
            <li class="user">
            <img src="icon/user2.png"/>
            <span>${mm.memList[0].mem_id}</span></li>
            <li class="content">
            <img src="icon/chat-blue.png"/>
            <span>${mm.board_content}</span></li>                     
          </ul>
          </c:forEach> 
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
           <li><a href="https://www.facebook.com/eunji.namgung"><img src="//www.tourbaksa.com/images/common/btn_sns_facebook.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=291&Parm3=&Parm4=&Parm5=&LandingURL=http://blog.tourbaksa.com"><img src="//www.tourbaksa.com/images/common/btn_sns_blog.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=293&Parm3=&Parm4=&Parm5=&LandingURL=http://www.tourbaksa.com/event/view.asp?idx=760"><img src="//www.tourbaksa.com//images/common/btn_sns_kakaotalk.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=294&Parm3=&Parm4=&Parm5=&LandingURL=http://www.youtube.com/channel/UCukXMvEQ0ZGuKNq2JKVvENQ"><img src="//www.tourbaksa.com/images/common/btn_sns_youtube.png"/></a></li>
           <li><a href="http://www.tourbaksa.com/common/TargetLink.asp?Parm1=MK&Parm2=296&Parm3=&Parm4=&Parm5=&LandingURL=http://instagram.com/tourbaksa7"><img src="//www.tourbaksa.com/images/common/btn_sns_instagram.png"/></a></li>
         
         </ul>
       </div>
     </div>
   </div>
   
</div>
</body>
</html>












