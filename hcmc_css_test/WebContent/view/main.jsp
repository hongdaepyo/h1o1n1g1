<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" type="text/css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/main.js"></script>

<!-- datepicker --> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!--  <link rel="stylesheet" href="/resources/demos/style.css"/> -->

<!-- bxslide -->
<!-- <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" media="all" /> -->
<!-- 터치 슬라이드 플러그인 연동 -->
<script src="./../js/jquery.bxslider.js?ver1"></script>
<script src="./../js/jquery.bxslider.min.js?ver1"></script>
<!-- bxSlider 플러그인 연동 -->
<script src="./../js/jquery-ui-1.10.4.custom.min.js?ver1"></script>

<!-- accordion -->  
<link rel="stylesheet" type="text/css" href="css/accordionImageMenu.css" />
<script src=./../js/jquery.accordionImageMenu.min.js?ver1"></script>



</head>
<body>

<div id="warp">
   <div id="header">
     <ul class="logo">
       <li><a href="#"><img src="icon/main2.png" /></a></li>
       <li class="lo"><img src="icon/logo_text.png"/></li>
       <li id="login"><a href="#"><img src="icon/login.png"/></a></li>
       <li id="join"><a href="#"><img src="icon/join1.png"/></a></li>    
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
              <select name="location">
                <option value="dd">지역명을 선택하세요</option>
                <option value="서울">   서                    울</option>
                <option value="경기">   경                    기</option>
                <option value="인천">   인                    천</option>
                <option value="강원">   강                    원</option>
                <option value="충청">   충                    청</option>
                <option value="전라">   전                    라</option>
                <option value="경상">   경                    상</option>
                <option value="제주">   제                    주</option>
              </select>                 
          </form>
          </div> 
          </li>     
          </ul>                
          <ul class="tm">
             <li>2.테마선택</li>
             <div class="alone">
             <form>
                <input type="radio" name="theme" value="나홀로" checked="checked">나홀로<br>
                <input type="radio" name="theme" value="연인">연인<br>
                <input type="radio" name="theme" value="가족">가족<br>
                <input type="radio" name="theme" value="친구">친구 
               </form>         
             </div>
          </ul>
          <ul class="year">
             <li>3.기간선택</li>
             <li class="date"><p><input type="text" id="datepicker" readonly value="날짜선택">
                  <!-- <button type="button" class="ui"><img src="http://www.tourbaksa.com/images/common/ico_02.gif"></button> -->
             </p></li>
          </ul>
          <ul class=search_icon>
          <li class="tt"><a href="#"><img src="icon/search.png"/></a></li>
          </ul>
        </div>
        
        
   </div>
   
   <div id="travel">
     <div id ="travel_f">
       <h2>인기여행지
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
   
   
   <div id="sing_form">
       <div id="del">
         <button>X</button>
       </div>
     <div id="singup_form">
        <div class="arr">          
        </div>
        <div id="email">
          <input type="text" placeholder="이메일">
        </div>
        <div id="pass">        
          <input type="password" placeholder="비밀번호">        
        </div>
        <div id="checked">
          <input type="checkbox" value="login">
          <label>자동로그인</label>
        </div>
        <div id="login_btn">                         
                       로그인
        </div>
        <div id="pass_search">
           <a href="pass_search">비밀번호 찾기</a>
        </div>
        
        <div id="facebook">
        <a href="https://www.facebook.com/login.php?skip_api_login=1&api_key=1637556516502515&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.4%2Fdialog%2Foauth%3Fredirect_uri%3Dhttp%253A%252F%252Fjasoseol.com%252Fusers%252Fauth%252Ffacebook%252Fcallback%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%26scope%3Demail%26response_type%3Dcode%26client_id%3D1637556516502515%26ret%3Dlogin%26logger_id%3D2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2&cancel_url=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Ffacebook%2Fcallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%23_%3D_&display=page&locale=ko_KR&logger_id=2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2">
          <img src="http://jasoseol.com/assets/index/icon-facebook-af12cbb0400bc3af9442327fc336f5773948cc5dfa58dae29609bf314bf68788.png"/>
          <p>페이스북 로그인</p>
        </a>
        </div>
        
        <div id="naver">
        <a href="https://nid.naver.com/oauth2.0/authorize?client_id=c8V5Z8ypkyCWSg6w2Cm7&redirect_uri=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Fnaver%2Fcallback&response_type=code&state=395462cbdc00ce3249bdf0fc26f6604f9867f5d4b7c43180">
        <img src="https://nid.naver.com/nidlogin.login?url=http%3A%2F%2Fnews.naver.com%2Fmain%2Fread.nhn%3Fmid%3Dhot%26sid1%3D148%26cid%3D321739%26iid%3D1143975%26oid%3D001%26aid%3D0008833019%26mode%3DLSD&svctype=0"/>
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
          <input type="text" id="id" placeholder="이메일">
        </div>
        <div id="pass">        
          <input type="password" id="password" placeholder="비밀번호(8자이상)">        
        </div>
        <div id="pass_en">        
          <input type="password" placeholder="비밀번호 재입력">        
        </div>        
        <div id="join_btn">                         
              <a href="#">회원가입</a> 
        </div>
        
        <div id="facebook">
        <a href="https://www.facebook.com/login.php?skip_api_login=1&api_key=1637556516502515&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.4%2Fdialog%2Foauth%3Fredirect_uri%3Dhttp%253A%252F%252Fjasoseol.com%252Fusers%252Fauth%252Ffacebook%252Fcallback%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%26scope%3Demail%26response_type%3Dcode%26client_id%3D1637556516502515%26ret%3Dlogin%26logger_id%3D2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2&cancel_url=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Ffacebook%2Fcallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3D8cb0afe175dd079d7ed5000717c01194220a43049fca581a%23_%3D_&display=page&locale=ko_KR&logger_id=2d8c7c4a-ae37-4e1c-989f-c078ad71b7e2">
          <img src="http://jasoseol.com/assets/index/icon-facebook-af12cbb0400bc3af9442327fc336f5773948cc5dfa58dae29609bf314bf68788.png"/>
          <p>페이스북 로그인</p>
        </a>
        </div>
        
        <div id="naver">
        <a href="https://nid.naver.com/oauth2.0/authorize?client_id=c8V5Z8ypkyCWSg6w2Cm7&redirect_uri=http%3A%2F%2Fjasoseol.com%2Fusers%2Fauth%2Fnaver%2Fcallback&response_type=code&state=395462cbdc00ce3249bdf0fc26f6604f9867f5d4b7c43180">
        <img src="https://nid.naver.com/nidlogin.login?url=http%3A%2F%2Fnews.naver.com%2Fmain%2Fread.nhn%3Fmid%3Dhot%26sid1%3D148%26cid%3D321739%26iid%3D1143975%26oid%3D001%26aid%3D0008833019%26mode%3DLSD&svctype=0"/>
        <p>네이버 로그인</p>
        </a>
        </div>
     </div>
   </div>
   
   <div id="end">
     <div id="end_f">
     
     </div>
   </div>
   
</div>
</body>
</html>












