$(function(){	
	$("#ad_close").on("click",function(){
		$('#ad').hide();
	});
	
	
	$(".ad_show").on("click",function(){
		$(this).attr('href','http://www.naver.com');
	});
	
});



