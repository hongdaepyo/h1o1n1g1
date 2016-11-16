$(function(){
	//var mem_num='${dto.mem_num}';
	//var nick = '${dto.mem_nickname}';
	//nick_view(nick);
	
	$(window).resize(function(){
		var width=$('section').width();
		var width2=$(document).width();
		if(width<=660){
			menu_min();
		}else{
			menu_not_min();
		}
	})//창크기가 변할 때 bodywrap의 최소 크기 정함
	
	//메뉴 위치 변경
	var menu_min = function(){
		$('#bodywrap').removeClass('inner_not_min').addClass('inner_min');
		$('menu').removeClass('menu_not_min').addClass('menu_min');
		$('.menu_container').removeClass('menu_container_not_min').addClass('menu_container_min');
		$('menu span').width('120px');
	}
	
	var menu_not_min = function(){
		$('#bodywrap').removeClass('inner_min').addClass('inner_not_min');
		$('menu').removeClass('menu_min').addClass('menu_not_min');
		$('.menu_container').removeClass('menu_container_min').addClass('menu_container_not_min');
		$('menu span').width('100%');
	}
	/////////////////////////////////////////////////////////
	
	$('#test_btn').click(function(){
		var width1=$('#nickname').val().trim();
		alert($('#aaaa').attr('name'));
	});
});

//회원의 기존 닉네임을 보여줌
function nick_view(nick){
	var str='현재 닉네임은 "'+nick+'"입니다.';
	if(nick!=""){
		$('#nickname').attr('placeholder',str);
	}else{
		$('#nickname').attr('placeholder','닉네임을 설정하세요');
	}
}///end nick_view()

//회원의 비밀번호 변경

//회원 닉네임 변경
function nick_update(str){
	//var mem_num='${dto.mem_num}';
	//var Data={"mem_num" : mem_num, "mem_nickname" : str};
	/*var form_data=new FormData();
	form_data.append('mem_num',mem_num);
	form_data.append('nickname',str);*/
	//console.log(Data);
	$.ajax({
		type:'POST',
		dataType:'json',
		data:'mem_num='+mem_num+'&mem_nickname='+str,
		url:"nickUpdate.do",
		success:function(data){
			//alert(data.msg);
			console.log(data);
			var url='info.do?mem_num='+mem_num;
			//$(location).attr('href',url);
			
		},
		error:function(request,status,error){
			//에러 메시지 띄워주는 부분
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			alert('형식에 맞지 않습니다.');
		}
	})
}//end nick_update()

function pw_update(p, n){
	$.ajax({
		type:'POST',
		dataType:'json',
		data:'mem_num='+n+'&mem_pass='+p,
		url:"pwUpdate.do",
		success:function(){
			alert('비밀번호 변경 완료');
		},
		error:function(request,status,error){
		//에러 메시지 띄워주는 부분
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

	}
	})
}
