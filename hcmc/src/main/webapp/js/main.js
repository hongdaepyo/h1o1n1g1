$(function(){
	  $("#login").hover(function(){
		   $('#login a img').prop("src","icon/login3.png");		   
	  },function(){
	       $('#login a img').prop("src","icon/login.png");	   
	  });
	  
	  $("#join").hover(function(){
		   $('#join a img').prop("src","icon/join3.png");		   
	  },function(){
	       $('#join a img').prop("src","icon/join1.png");	   
	  });
	  
	 
	  
	  
	  $("#top .slide #location").hover(function(){
		   $('#location a img').prop("src","icon/button2.png");	
	  },function(){
	       $('#location a img').prop("src","icon/button.png");	   
	  });
	  
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
	  
	  
	  $("#location a img").on("click",function(){		  
		 $("#bot_pad2 .ff .ff_ff").css({"display":"block"});
		 $("#bot_pad2 .ff .ff_ss").css({"display":"none"});
		 $("#bot_pad2 .ff .ff_tr").css({"display":"none"});
	  });
	  
	  $("#top .slide #theme").hover(function(){
		   $('#theme a img').prop("src","icon/button2.png");
		   
	  },function(){
	       $('#theme a img').prop("src","icon/button.png");	   
	  });
	  
	  $("#theme a img").on("click",function(){
		  $("#bot_pad2 .ff .ff_ff").css({"display":"none"});
		  $("#bot_pad2 .ff .ff_ss").css({"display":"block"});
		  $("#bot_pad2 .ff .ff_tr").css({"display":"none"});
		  });
	  
	  $("#top .slide #month").hover(function(){
		   $('#month a img').prop("src","icon/button2.png");		   
	  },function(){
	       $('#month a img').prop("src","icon/button.png");	   
	  });
	  
	  $(".ff_ff li").hover(function(){
		   $('ff_ff li a img').prop("src","icon/se2.png");		   
	  },function(){
		  $('ff_ff li a img').prop("src","icon/se.png");	 
	  });
	  
	  
	//footer메뉴 색
	  $("#end_f .foot li a").hover(function(){
		  $(this).css({'color':'white'});
	  },function(){
		  $(this).css({'color':'#bfbfbf'});
	  });
	  
	  
	  //지역의 이미지를 클릭할 시 검색창으로 넘긴다.
	  $(".ff_ff li img").on("click",function(e){
		  
		  var name = $(e.target).parent().attr('name');
		  $('option').filter('.'+name).prop('selected',true);
		  $('option').not('.'+name).prop('selected',false);
		  
		  
	  });
	  
	  //테마 사진을 클릭하면 검색창으로 이름 가져간다.
	  $(".ff_ss li img").on("click",function(e){
		  var name = $(e.target).parent().attr('name');
		  $('input').filter('.'+name).prop('checked',true);
		  $('input').not('.'+name).prop('checked',false);
		    
		  
	  });
	  
	  

	  //검색 버튼을 누르면 값을 챙긴다.
	  $('#datepicker, #loca, .alone').change(function(){
		 var city_name =$("#loca option:selected").val();
		 var festival_theme = $(':radio[name="theme"]:checked').val();
		 var festival_start = $('#datepicker').val();
		 console.log(city_name,festival_theme,festival_start);
		 $('.tt a').attr('href',"search.do?city_name="+city_name+"&festival_theme="+festival_theme+"&festival_start="+festival_start);
	  });//검색 칸에 값이 변하면 a 요소의 링크를 변경해줌
	  
	  
	//tabs메뉴 hover  
	  $("#tab ul li:nth-of-type(1)").hover(function(){
		  $('#tabs-1').css({'display':'block'});
			$('#tabs-2').css({'display':'none'});
			$('#tabs-3').css({'display':'none'});
	  });
	  
	  $("#tab ul li:nth-of-type(2)").hover(function(){
		  $('#tabs-1').css({'display':'none'});
			$('#tabs-2').css({'display':'block'});
			$('#tabs-3').css({'display':'none'});
	  });
	  
	  $("#tab ul li:nth-of-type(3)").hover(function(){
		  $('#tabs-1').css({'display':'none'});
			$('#tabs-2').css({'display':'none'});
			$('#tabs-3').css({'display':'block'});
	  });
	  
	  
	  
	  
});

  
$( function() {
    $( "#datepicker").datepicker({
    	dateFormat : 'yymmdd',
    	monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	dayNamesMin : ['일','월','화','수','목','금','토'],
    	changeMonth : true,
    	changeYear : true,
    	showMonthAfterYear:true,
    	
    });
    
    var mySlider = $(".pic").bxSlider({
		mode : "horizontal", // 가로 수평으로 슬라이드 됩니다.
		speed : 500, // 이동 속도를 설정합니다.
		pager : false, // 현재 위치 페이징 표시 여부 설정.
		moveSlides : 1, // 슬라이드 이동시 갯수 설정.
		slideWidth :2000, // 슬라이드 마다 너비 설정.
		minSlides : 1, // 최소 노출 개수를 설정합니다.
		maxSlides : 1, // 최대 노출 개수를 설정합니다.
		slideMargin :10, // 슬라이드간의 간격을 설정합니다.
		auto : true, // 자동으로 흐를지 설정합니다.
		autoHover : true, // 마우스 오버시 정시킬지 설정합니다.
		autoControls: true,
		controls : false
	// 이전 다음 버튼 노출 여부 설정합니다.
	});
    
 // 이전 버튼을 클릭하면 이전 슬라이드로 전환됩니다.
	$("#main .touch_left_btn a").on("click", function() {
		mySlider.goToPrevSlide(); // 이전 슬라이드 배너로 이동됩니다.
		// <a>에 링크를 차단합니다.
	});
	// 다음 버튼을 클릭하면 다음 슬라이드로 전환됩니다.
	$("#main .touch_right_btn a").on("click", function() {
		mySlider.goToNextSlide(); // 다음 슬라이드 배너로 이동됩니다.
		
	});


	
  });

$(function(){
		var mySlider = $(".cal").bxSlider({
		mode : "horizontal", // 가로 수평으로 슬라이드 됩니다.
		speed : 400, // 이동 속도를 설정합니다.
		pager : false, // 현재 위치 페이징 표시 여부 설정.
		moveSlides : 1, // 슬라이드 이동시 갯수 설정.
		slideWidth :400, // 슬라이드 마다 너비 설정.
		minSlides : 1, // 최소 노출 개수를 설정합니다.
		maxSlides : 1, // 최대 노출 개수를 설정합니다.
		slideMargin :5, // 슬라이드간의 간격을 설정합니다.
		auto : true, // 자동으로 흐를지 설정합니다.
		autoHover : true, // 마우스 오버시 정시킬지 설정합니다.
		autoControls: true,
		controls : false
	// 이전 다음 버튼 노출 여부 설정합니다.
	});
    
 // 이전 버튼을 클릭하면 이전 슬라이드로 전환됩니다.
	$("#prev a").on("click", function() {
		mySlider.goToPrevSlide(); // 이전 슬라이드 배너로 이동됩니다.
		return false; // <a>에 링크를 차단합니다.
	});
	// 다음 버튼을 클릭하면 다음 슬라이드로 전환됩니다.
	$("#next a").on("click", function() {
		mySlider.goToNextSlide(); // 다음 슬라이드 배너로 이동됩니다.
		return false;
	});
})
  
  $(function() {
		$("#menu1").AccordionImageMenu({
			position : 'horizontal', //아코디언 가로/세로 방향을 설정 설정합니다.
			openItem : 0, //마우스를 올리지 않았을 때 기본 열려있는 배너를 설정함. 
			openDim : 500, //열려있는 배너의 너비를 설정함. 
			closeDim : 250, //닫혀있는 배너의 너비를 설정함. 
			height : 350, //배너의 높이를 설정함. 
			duration : 300, //전환되는 속도를 설정합니다. 
			effect : 'easeOutQuint', //전환될 때의 가속도를 설정합니다.
			border : 0 //선의 생성을 설정합니다.
		});
		
		$("#menu2").AccordionImageMenu({
			position : 'horizontal', //아코디언 가로/세로 방향을 설정 설정합니다.
			openItem : 0, //마우스를 올리지 않았을 때 기본 열려있는 배너를 설정함. 
			openDim : 500, //열려있는 배너의 너비를 설정함. 
			closeDim : 250, //닫혀있는 배너의 너비를 설정함. 
			height : 350, //배너의 높이를 설정함. 
			duration : 300, //전환되는 속도를 설정합니다. 
			effect : 'easeOutQuint', //전환될 때의 가속도를 설정합니다.
			border : 0 //선의 생성을 설정합니다.
		});
		
		$("#menu3").AccordionImageMenu({
			position : 'horizontal', //아코디언 가로/세로 방향을 설정 설정합니다.
			openItem : 0, //마우스를 올리지 않았을 때 기본 열려있는 배너를 설정함. 
			openDim : 500, //열려있는 배너의 너비를 설정함. 
			closeDim : 250, //닫혀있는 배너의 너비를 설정함. 
			height : 350, //배너의 높이를 설정함. 
			duration : 300, //전환되는 속도를 설정합니다. 
			effect : 'easeOutQuint', //전환될 때의 가속도를 설정합니다.
			border : 0 //선의 생성을 설정합니다.
		});
		
		$("#recommend #recommend_f #recommends").AccordionImageMenu({
			position : 'horizontal', //아코디언 가로/세로 방향을 설정 설정합니다.
			openItem : 0, //마우스를 올리지 않았을 때 기본 열려있는 배너를 설정함. 
			openDim : 400, //열려있는 배너의 너비를 설정함. 
			closeDim : 200, //닫혀있는 배너의 너비를 설정함. 
			height : 250, //배너의 높이를 설정함. 
			duration : 300, //전환되는 속도를 설정합니다. 
			effect : 'easeOutQuint', //전환될 때의 가속도를 설정합니다.
			border : 0 //선의 생성을 설정합니다.
		});
		
	});
 
  
  ///////////////////회원 가입, 로그인 버튼//////////////////////////////////////////////////////////////////////////
  $(function(){
		$('#join_btn').click(function(e){
			memberRegister();	    	  
		});//join	
		
		

		 $('#login_btn').on('click',function(e){
			login();
		  
		  }); //login
		 $(document).on('keypress','#password',function(e){
             if(e.which==13&&$(e.target).parent().attr('id')=="pass")
                login(); 
          }); //로그인 창의 패스워드 칸에서 엔터를 누르면 로그인을 수행함
       
		 $(document).on('keypress','#pass_en input',function(e){
			 if(e.which==13)
				 memberRegister();
		 }) //회원가입 창의 패스워드 칸에서 엔터를 누르면 회원가입을 수행함
		
		
	});////////////////////////////////////////////////////////////////////////////////////////////
  

  function searchView(res){
	  
  }
  //헤더부분 변경
  function headerView(id){
	  $('#join_form').css({"display":"none"});		
	  $('#header').empty();
	  $('#header').append('<ul class="logo"><li><a href="#"><img src="icon/main2.png" /></a></li><li class="lo"><img src="icon/logo_text.png"/></li><li id="login"><span>'+id+'님 환영합니다.</span></li><li id="logout"><a href="logout.do"><img src="icon/logout2.png"/></a></li></ul>');
       
	  $("#logout").hover(function(){
		   $('#logout a img').prop("src","icon/logout.png");		   
	  },function(){
	       $('#logout a img').prop("src","icon/logout2.png");	   
	  });
	  
	  
  
  }//end headerView()
  
  function memberRegister(){
	  	//아이디 :  영문자, $,_로 시작하고 총 5-8개
		//비밀번호 : 영문자,숫자,특수문자 총 7-10 
		//단 숫자와 특수문자는 반드시 하나 이상 포함한다.
	  
	  var nid=$('#id_email').val();    
	  var npassword=$('#id_pass').val();
	  
	  //id 패턴
	  //var pattern=/^[a-z$_]{1,1}[a-zA-Z0-9]{4,7}$/;
	  var pattern=/[\w\W]{1,20}/g; //테스트용 추후 삭제
    	
	  //비밀번호 패턴
	 // var pattern2= /^((?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\,.<>\/?]))([\S]){7,10}$/i;
	  var pattern2=/[\w\W]{1,20}/g; //테스트용 추후 삭제
	  if(nid==''){
		  alert('아이디를 입력하세요');
    		 return false;
	  }

      if(npassword==''){
		  alert('비밀번호를 입력하세요');
    		 return false;
	  }
      
	if(pattern.test(nid)){
		if(pattern2.test(npassword)){
			$.ajax({
				type:'POST',
				url:'memberRegister.do',
				data:'mem_id='+nid+'&mem_pass='+npassword,
				success:function(){
					alert('회원 가입이 완료 되었습니다. 가입시 입력한 메일주소로 인증을 해주세요.');
					window.location.reload();
				}
			});//end ajax
		}else{
			alert('비밀번호를 확인하세요');
		}
	}else{
		alert('아이디를 확인하세요');
	}
  }
  
  function login(){
	  var nid=$('#id').val().trim();
	  var npassword=$('#password').val().trim();
	  if(nid==''){
		  alert('아이디를 입력하세요');
    		 return false;
	  }
	  if(npassword==''){
		  alert('비밀번호를 입력하세요');
    		 return false;
	  }
	  
	  console.log('로그인버튼 이벤트 발생');
	  $.ajax({
			type:'POST',
			dataType:'text',
			url:'loginpro.do',
			data:'mem_id='+nid+'&mem_pass='+npassword,
			success:function(data){
				window.location.reload();
			}
		});
  }
  
  function logout(){
	  alert(1);
  }


//자동로그인 체크
  $(function (){
   // 쿠키값을 가져온다.
     var cookie_user_id = getLogin();


      /**
      * 쿠키값이 존재하면 id에 쿠키에서 가져온 id를 할당한 뒤
      * 체크박스를 체크상태로 변경
      */
      if(cookie_user_id != "") {
    	  $("#id").val(cookie_user_id);
    	  $("#cb_saveId").attr("checked", true);
      }

      // 아이디 저장 체크시
      $("#cb_saveId").on("click", function(){
    	  var _this = this;
    	  var isRemember;
         
    	  if($(_this).is(":checked")) {
    		  isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까?PC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");
    	  
    	  if(!isRemember)    
    		  $(_this).attr("checked", false);
      	}
      });

      // 로그인 버튼 클릭시
      $("#login_btn").on("click", function(){
    	  if($("#cb_saveId").is(":checked")){ // 저장 체크시
    		  saveLogin($("#id").val());
    	  }else{ // 체크 해제시는 공백
    		  saveLogin("");
    	  }
      });
  });



   /**
   * saveLogin
   * 로그인 정보 저장
   * @param id
   */
   function saveLogin(id) {
   if(id != "") {
   // userid 쿠키에 id 값을 7일간 저장
	   setSave("userid", id, 7);
   	}else{
   // userid 쿠키 삭제
   		setSave("userid", id, -1);
   	}	
   }

   /**
   * setSave
   * Cookie에 user_id를 저장
   * @param name
   * @param value
   * @param expiredays
   */
   function setSave(name, value, expiredays) {
      var today = new Date();
      today.setDate( today.getDate() + expiredays );
      document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + today.toGMTString() + ";"
   }

   /**
   * getLogin
   * 쿠키값을 가져온다.
   * @returns {String}
   */
   function getLogin() {
   // userid 쿠키에서 id 값을 가져온다.
	   var cook = document.cookie + ";";
	   var idx = cook.indexOf("userid", 0);
	   var val = "";

   if(idx != -1) {
	   cook = cook.substring(idx, cook.length);
	   begin = cook.indexOf("=", 0) + 1;
	   end = cook.indexOf(";", begin);
	   val = unescape(cook.substring(begin, end));
   }
   return val;
}






