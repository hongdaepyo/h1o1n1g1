<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/mypage.js"></script><base>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/mypage.css">
</head>
<style>
* {
	margin: 0px;
	padding: 0px;
}

header {
	width: 100%;
	height: 100px;
	background-color: aqua;
}

menu {
	height: 670px;
	background-color: teal;
	width: 15%;
	float: left;
}

section {
	width: 80%;
	height: 670px;
	float: right;
}

footer {
	background-color: #ffffff;
	clear: both;
}
</style>
<script type="text/javascript">
var nick = '${dto.mem_nickname}';
$(document).ready(function(){
	if(nick!=""){
		$('#nickname').attr("placeholder",'${dto.mem_nickname}');
	}else{
		$('#nickname').attr("placeholder","닉네임을 설정하세요");
	}
});

//console.log('dto',${dto.mem_nickname});
</script>
<body>
	<header>
		<br />
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