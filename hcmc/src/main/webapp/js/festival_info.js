$(function() {
	$(document).ready(function() {
		var w_d = $(this).width();
		var h_d = $(this).height();
		$('.bodywrap').width(0);
		//resize_f(w_d,h_d);
		$(document).click(function(e) {
			//bgclose(e);
		})
		
		//축제정보창 크기조절
		/*$(window).resize(function(){
			$('.bodywrap').width(w_d);
			$('.bodywrap').height(h_d);
			//resize_f(w_d,h_d);
		});*/
		
	})
	
	

});

function resize_f(a,b){
	$('.bodywrap').width(a);
	$('.bodywrap').height(b);
}

function bgclose(e) {
	if (!$(e.target).is($('.info_inner'))) {
		alert('추후 기능 추가');
	}

}