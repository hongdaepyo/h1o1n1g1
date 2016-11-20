$(document).ready(function(){
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
		  $('#sing_form').fadeToggle('normal'); 
	  });
	  
	  $("#join").on("click",function(){
		  $('#sing_form').css({"display":"none"});
		  $('#join_form').fadeToggle('normal'); 
		  
	  });
	  
	  $("#del button").click(function(){		  
		  $('#sing_form').css({"display":"none"}); 
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
	  
	  
	  $("#search #search_m .search_icon .tt").hover(function(){
		  $('.tt a img').prop("src","icon/search2.png");
	  },function(){
		  $('.tt a img').prop("src","icon/search.png");
	  });	
	  
	  
	  //지역의 이미지를 클릭할 시 검색창으로 넘긴다.
	  $(".ff_ff li img").on("click",function(e){
		  
		  (function ($) {
	          $.fn.reBind = function(events, handler) {
	              return this.off(events, handler).on(events, handler);
	          };
	      }(jQuery));
		  
		  var name = $(e.target).parent().attr('name');
		  var option = "";
		  
		  for(var i =0; i<9;i++){
			  var option= $("option").eq(i).val();
			  if(name==option){
				  alert(name+option);
				  
				  $("option").eq(i).attr("selected","selected");
			  }else{
				  //select selected값 초기화
				  $("option").eq(i).removeAttr("selected");
			  }
		  }
		  
	  });
	  
	  //테마 사진을 클릭하면 검색창으로 이룸 가져간다.
	  $(".ff_ss li img").on("click",function(e){
		  
		  (function ($) {
	          $.fn.reBind = function(events, handler) {
	              return this.off(events, handler).on(events, handler);
	          };
	      }(jQuery));
		  
		  var name = $(e.target).parent().attr('name');		    
		  var input = "";
		  
		  for(var i =0; i<4;i++){
			  var input= $("input").eq(i).val();
			  
			  if(name==input){
					  $("input").eq(i).attr("checked","checked");			  
			   }else{
					  //checked checked값 초기화
					  $("input").eq(i).removeAttr("checked");
				  }
			  }		  
		  
	  });
	  
	  

	  //검색 버튼을 누르면 값을 챙긴다.
	  $("#search #search_m .search_icon .tt").on("click",function(e){
		  //나가 클릭한 곳에 이름을 가져옴(IMG)
		alert(e.target.nodeName); 
		
	  });
	  
	  
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
	$(".touch_left_btn a").on("click", function() {
		mySlider.goToPrevSlide(); // 이전 슬라이드 배너로 이동됩니다.
		return false; // <a>에 링크를 차단합니다.
	});
	// 다음 버튼을 클릭하면 다음 슬라이드로 전환됩니다.
	$(".touch_right_btn a").on("click", function() {
		mySlider.goToNextSlide(); // 다음 슬라이드 배너로 이동됩니다.
		return false;
	});
	
  });
  
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
	});
  $(document).ready(function(){
		$('#join_btn a').click(function(){
		
			//아이디 :  영문자, $,_로 시작하고 총 5-8개
			//비밀번호 : 영문자,숫자,특수문자 총 7-10 
			//단 숫자와 특수문자는 반드시 하나 이상 포함한다.
	    
	    	  var nid=$('#id').val();    	  
	    	  var pattern=/^[a-z$_]{1,1}[a-zA-Z0-9]{4,7}$/;
	    	   if(!(pattern.test(nid))){
	    		 alert('아이디를 확인하세요');
	    		 return false;
	    	    }
	    	
            var pattern2= /^((?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\,.<>\/?]))([\S]){7,10}$/i;
	         
	          var npassword=$('#password').val(); 	
	    	  if(!(pattern2.test(npassword))){
	     		 alert('비밀번호를 확인하세요');
	     		 return false;
	    	   }
	    	  
	    	alert(nid+npassword);
			return true;
		});
	});










