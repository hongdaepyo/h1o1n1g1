$(function(){	
	
		
		
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
		  
		  $("#ad_close").on("click",function(e){
			  	e.preventDefault();
				$('#ad').hide(500);
				$("#header").delay(300).fadeIn('normal');
				$('#gnb').delay(300).fadeIn('normal'); 
				$('body > form:nth-child(6) > fieldset > p').css({'padding-top':'0px'});
			 
		  });
	
});



/*//헤더부분 변경
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
*/


