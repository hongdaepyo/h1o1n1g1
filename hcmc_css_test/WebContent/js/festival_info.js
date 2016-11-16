$(function() {
	$(document).ready(function() {
		var width_iw = $(this).width();
		var height_iw = $(this).height();
		$(document).click(function(e) {
			bgclose(e);
		})
	})
	
	alert($('select option').eq(1).val());

});

function bgclose(e) {
	if (!$(e.target).is($('.info_inner'))) {
		alert('추후 기능 추가');
	}

}