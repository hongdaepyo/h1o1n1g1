$(document).ready(function(){
	$('#btn').on('click',process)
});

function process(){
	//$ = jquery
	$.ajax({
		type:'GET',
		//dateType=응답형식
		dataType:'text',
		//get방식이기 때문에 파라미터를 넘기기 위해 url에 추가
		url:'customer.do?name='+$('#name').val(),
		//성공하면 실행할 함수 function(응답값변수)
		success:function(res){
			$('div').html(res);
		}
	});
}//end process