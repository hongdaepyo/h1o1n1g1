$(function(){	
	$("#ad_close").on("click",function(){
		$('#ad').hide(500);
	});
	
	
	$(".ad_show").on("click",function(){
		$(this).attr('href','http://www.naver.com');
	});
	
	banner_change();
	
});

function banner_change(){
    var	pic_arr =['pet1.jpg','pet2.jpg','pet3.jpg','pet4.jpg','pet5.jpg','pet6.jpg','Koala.jpg'];
    var i=0;
    console.log(i);
    var test= setInterval(img_change, 3000);
	function img_change(){
		$('#ad_show img, #ad_close img').fadeIn(2000);
		$('#ad_show img').attr('src','images/'+pic_arr[i]);
		$('#ad_show img, #ad_close img').fadeOut(1000);
		i++;
		if(i>=pic_arr.length)
			i=0;
	}
}


