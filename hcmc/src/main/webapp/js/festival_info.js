var star2;
$(function() {
	$(document).ready(function() {
		var pos=$('.map_wrap').offset();
		var w_d = $(document).width();
		var h_d = $(document).height();
		menu_pos(pos);
		$('.bodywrap').hide();
		$('.info_mask').click(function(e) {
			bgclose(e);
		});
		
		$('.fh_top button').click(function(){
			$('.bodywrap').hide();
			$('.star img').remove();
		    removeMarker2();
			onClickCategory();  //닫을 때 마커도 같이 제거
			$('#keyword').val("");
			$('#placesList .item').remove();
		});
		
		$('.star').mouseover(function(e){			
			var tip=star2;
			$(this).attr('title','');
			$(this).append('<div id="tooltip"><div class="tipBody">'+tip+'/5.0</div></div>');
		}).mousemove(function(e){
			var pos=$(e.target).offset();
			$('#tooltip').css('top',e.pageY*0.6);
			$('#tooltip').css('left',50+e.pageX*0.2);
		}).mouseout(function(){
			$(this).attr('title',$('.tipBody').html());
			$(this).children('div #tooltip').remove();
		});
		
		/*$('#menu_wrap .option button').on('click',function(){
			console.log('눌렸다');
			searchPlaces2();
		});*/
		
		$(window).resize(function(pos){		
			menu_pos(pos);
		});
		
	})
	
	$('#map div[draggable]').dblclick(function(){
			$('#category').toggle(500);
		})
	
	

});
function resize_info(a, b){
	//$('.bodywrap').css('display','block');
	$('.bodywrap').show();
	$('.bodywrap').css({'width':'100%'});
	$('.info_mask').css({'width':'100%', 'height':'100%'});
}

function bgclose(e) {
	if (!$(e.target).is($('.info_inner'))) {
		e.preventDefault();  
		$('.bodywrap').hide();
		$('.star img').remove();
	    removeMarker2();
		onClickCategory(); //닫을 때 마커도 같이 제거
		$('#keyword').val("");
		$('#placesList .item').remove();	
	}
}//반투명 배경 누르면 축제정보창을 닫음

//달력에서 선택한 축제정보를 가져오기
function festival_view(n){
	$.ajax({
		type:'post',
		dataType:'json',
		data:'festival_num='+n,
		url:"finfo.do",
		success:function(res){
			console.log(res);
			festival=res;
			//조회수 값
			$("#count").text(res.f.festival_count);
			festival_view_input();
		},
		error:function(request,status,error){
		//에러 메시지 띄워주는 부분
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
	})
}//end festival_view()

function star_view(s){

	star2=s/2;//별 평점
	var star=Math.floor(s/2); //별 정수
	var star_half=(s*0.5-star).toFixed(2); //별 소수
	if(star!=0){
	for(var i=1;i<=star;i++){
		$('.star').append('<img src="http://cfile208.uf.daum.net/R320x0/272017345837158C231B46" width="30px" height="30px">');
	}
	if(star_half>=0.5){
		$('.star').append('<img src="http://cfile218.uf.daum.net/R320x0/27062A345837159404E141" width="15px" height="30px">');
	}
	}
}

function festival_map(){
	$('.festival_map').css({'width':'100%','height':'350px'});
	$('#map').css({'width':'100%','height':'350px'});
	//$('.festival_map').append('<jsp:include page="festival_map.jsp/>');
	//$('.festival_map').load("/hcmc/festival_map2.html");
}

function f_pic_preview(f2){
	$(document).on('mouseover mousemove','td div span',function(e){
		var f_num=$(e.target).attr('name');
		var f_pos=$(e.target).offset();
		$('img[name="'+f_num+'"]').addClass("preview_on");
		$('div[id="d'+f_num+'"]').addClass("preview_on preview_div");
		//$('div[id="d'+f_num+'"]').offset({ top:f_pos.top, left:f_pos.left+120});
		$('div[id="d'+f_num+'"]').offset({ top:e.pageY, left:e.pageX+30});
		$(e.target).css({'color':'red','font-weight':'bold', 'background-color':'bisque'});
	})
	$(document).on('mouseout','td div span',function(e){
		var f_num=$(e.target).attr('name');
		$('img[name="'+f_num+'"]').removeClass("preview_on");
		$('div[id="d'+f_num+'"]').removeClass("preview_on preview_div");
		$(e.target).css({'color':'','font-weight':'','background-color':''});
	})
}//달력 항목에 마우스 오버가 되면 미리보기 창을 띄워줌

function menu_pos(pos){
	$('#menu_wrap').offset({'top':pos.top,'left':pos.left-$('#menu_wrap').width()-40});
}