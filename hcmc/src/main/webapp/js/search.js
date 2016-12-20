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
	  
	  
	  $("#order .view").on("click",function(e){
		  
		  var city_name = $("#loca option:selected").val();
		  var festival_start = $("#datepicker").val();
		  
		  alert(city_name,festival_start);
		  
		  $.ajax({
			    type:'POST',
			    dataType:'json',
				url:'research.do',
				data:'city_name='+city_name+'&festival_theme='+festival_theme+'&festival_start='+festival_start,
				success:Research			  
		  })
		  
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
		
		
		
	});////////////////////////////////////////////////////////////////////////////////////////////
  

  function Research(res){
		city_name=res;
		$(".search_w").empty();
		for(var i = 0; i < res.length; i++){
		var start=$.datepicker.formatDate('yy MM dd', new Date(city_name[i].festival_start));
		var end=$.datepicker.formatDate('yy MM dd', new Date(city_name[i].festival_end));
		
		$(".search_w").append(' <div class="pic"><img src="image.do?filename='+city_name[i].festival_pic[0].festival_pic+'"/></div><div class="write"><input type="hidden" id="num" value="'+city_name[i].festival_num+'"><h3>'+city_name[i].festival_name+'</h3><hr/><p>'+city_name[i].festival_content+'</p><span>'+city_name[i].city[0].city_address+'</span><span>'+start+'~'+end+'</span></div><div class="view"><img src="icon/view1.png"/><span id="count">'+city_name[i].festival_count+'</span></div>');
		}
		
		}//조회순으로 정렬
  
//헤더부분 변경
  function headerView(id){
	     $('#join_form').css({"display":"none"});  
	     $('#header').empty();
	     $('#header').append('<ul class="logo"><li><a href="main.do"><img src="icon/main2.png" /></a></li><li class="lo"><img src="icon/logo_text.png"/></li><li id="login"></li><li id="logout"><img src="icon/user2.png"/></li></ul>');		     
	    
	  		     
	      $("#login_info").hide();
		  $("#logout").on("click",function(){
			  $('#login_info').fadeToggle('normal'); 
			  $('#login_info').css({'position':'absolute','left':'64px','top':'84px'});

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
	  var nid=$('#id').val();
	  var npassword=$('#password').val();
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







