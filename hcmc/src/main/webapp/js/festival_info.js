var star2;
$(function() {
	$(document).ready(function() {
		var w_d = $(document).width();
		var h_d = $(document).height();
		$('.bodywrap').hide();
		$('.info_mask').click(function(e) {
			bgclose(e);
		});
		
		$('.fh_top button').click(function(){
			$('.bodywrap').hide();
			$('.star img').remove();
		});
		
		$('.star').mouseover(function(e){			
			var tip=star2;
			$(this).attr('title','');
			$(this).append('<div id="tooltip"><div class="tipBody">'+tip+'/5.0</div></div>');
		}).mousemove(function(e){
			$('#tooltip').css('top',e.clientY*0.6);
			$('#tooltip').css('left',50+e.clientX*0.2);
		}).mouseout(function(){
			$(this).attr('title',$('.tipBody').html());
			$(this).children('div #tooltip').remove();
		});
		
	})
	
	

});
function resize_info(a, b){
	//$('.bodywrap').css('display','block');
	$('.bodywrap').show();
	$('.bodywrap, .info_mask').css({'width':'100%', 'height':'100%'});
}

function bgclose(e) {
	if (!$(e.target).is($('.info_inner'))) {
		e.preventDefault();  
		$('.bodywrap').hide();
		$('.star img').remove();
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
			festival_view_input();
		},
		error:function(request,status,error){
		//에러 메시지 띄워주는 부분
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
	})
}//end festival_view()

function fest_list(){
	$.ajax({
		//type:'post',
		dataType:'json',
		url:"calendar2.do",
		success:test
	})
}//달력에 넣어줄 축제 내용을 불러옴

function star_view(s){
	//추후 해당 축제 별점 수를 가져와서 나눠주는 걸로 바꿀 것
	star2=s/2;//별 평점
	var star=Math.floor(s/2);
	var star_half=(s*0.5-star).toFixed(2);
	if(star!=0){
	for(var i=1;i<=star;i++){
		$('.star').append('<img src="http://imgdb.kr/aFnm.dn" width="30px" height="30px">');
	}
	if(star_half>=0.5){
		$('.star').append('<img src="http://imgdb.kr/aGYp.dn" width="15px" height="30px">');
	}
	}else{
		for(var i=1;i<=5;i++){
			$('.star').append('<img src="http://imgdb.kr/aGYN.dn" width="30px" height="30px">');
		}
	}
}

function festival_map(){
	$('.festival_map').css({'width':'100%','height':'350px'});
	$('#map').css({'width':'100%','height':'350px'});
	//$('.festival_map').append('<jsp:include page="festival_map.jsp/>');
	//$('.festival_map').load("/hcmc/festival_map2.html");
}