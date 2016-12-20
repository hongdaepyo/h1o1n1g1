<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/mypage.js?ver=1"></script>
<base>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css?ver=1">
<link rel="stylesheet" href="css/mypage.css?ver=1">
<link rel="stylesheet" href="css/festival_info.css?ver=1">
<script type="text/javascript">
$(document).ready(function(){
	var chk ='${empty sessionScope.chk}' == 'true' ? true : false;
	var param = "${param.code}";
	console.log(chk);
	console.log(param);
	if(!chk){
		//headerView('${sessionScope.id}');
	}
});
</script>
</head>
<style>
* {
	margin: 0px;
	padding: 0px;
}

header {

	background-color: white;
	width: 100%;
	height: 150px;
	border-bottom: 40px solid #666666;
}


.mypage_logo li img:nth-of-type(1){
	width: 100px;
	height: 80px;
	float: left;
}

.mypage_logo .mypage_lo img{
	width: 200px;
	height: 100px;	
}

.mypage_logo .mypage_logout{
	float: right;
	position: absolute;
	right: 100px;
}

.mypage_logo .mypage_logout img{
	position:absolute;
	top:20px;
}



menu {
	height: 670px;
	width: 10%;
	float: left;
	font-size: 16px;
	background-color: #f0f0f0;
}

menu span {
	text-align: center;
	margin: 10px auto;
	width: 100%;
	display: block;
	float: left;
}

section {
	width: 80%;
	height: 670px;
}

footer {
	background-color: #ffffff;
	clear: both;
}

</style>
<script type="text/javascript">
var nick = '${dto.mem_nickname}';
var mem_num='${dto.mem_num}';
$(document).ready(function(){
	nick_view(nick);
	
	$('.confirm_btn').click(function(e){
			btnclick(e);
		});//confirm_btn click event
		
	
});

//비밀번호 체크/////////////////////////////
function check(){
	var a=$('.current_password input').val();
	var b=$('.new_password input').val();
	var c=$('.new_password_confirm input').val();
	//8~20글자, 영문, 숫자, 특수문자 조합
	var patt=/^.*(?=^.{8,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
	if(a==''||b==''||c==''){
		alert('비밀번호를 입력하세요.');
		return false;
	}else if(a!='${dto.mem_pass}'){
		alert('현재 비밀번호를 확인해주세요.');
		return false;
	}else if(b!=c){
		alert('새 비밀번호를 확인해주세요.');
		return false;
	/* }else if(patt.test(b)){
		alert('비밀번호 형식이 맞지 않습니다.') */
	}else{
		/* if(patt.test(b)){
			pw_update(b, mem_num);
		}else{
			alert("비밀번호는 8~20자리, 문자, 숫자, 특수문자를 조합해야 합니다.");
		} */
		pw_update(b, mem_num);
	}
}////////////////////////////////////
function id_delete(){
	var a=$('.text_input').val();
	if(a=='${dto.mem_pass}'){
		alert("a");
		
	}else
		alert("비밀번호를 확인하세요");
}

function btnclick(e){
	var s=$(e.target).parent().attr('class');
	switch(s){
	case 'nick':
				var str=$('#nickname').val().trim();
				if(str!="")
					{nick_update(str);
				}else{
					alert('닉네임을 입력해주세요');
				};break;
				
	case 'password':check(); break;
				
	case 'delete': id_delete();break;
		}		
}
</script>
<body>
	<header>
		<p>
			<tiles:insertAttribute name="header" />
		</p>
	</header>

	<menu>
		<tiles:insertAttribute name="menu" />
	</menu>

	<section>
		<p>
			<tiles:insertAttribute name="body" />
		</p>
	</section>

	<footer>
		<p>
			<tiles:insertAttribute name="footer" />
		</p>
	</footer>

</body>
</html>