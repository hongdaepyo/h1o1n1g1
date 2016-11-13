$(function(){
	var nick = '${dto.mem_nickname}';
	if(nick!=""){
		$('#nickname').attr("placeholder",'닉있다');
	}else{
		$('#nickname').attr("placeholder","닉네임을 설정하세요");
	}
});