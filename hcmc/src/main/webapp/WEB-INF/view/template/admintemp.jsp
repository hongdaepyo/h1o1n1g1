<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<base>
<link rel="stylesheet" href="css/reset.css?ver=1">
<link rel="stylesheet" href="css/header.css?ver=1">
<script type="text/javascript">
$(document).ready(function(){
	$('input').filter(function(){
		return $(this).attr('readonly')=='readonly';
	}).css('background-color','skyblue');
	
	
	
	
	
});
</script>

</head>
<style>
* {
	margin: 0px;
	padding: 0px;
}

#admin_header {
	background-color: white;
    width: 100%;
    height: 150px;
    border-bottom: 40px solid #666666;
	
}


.admin_logo li img:nth-of-type(1){
	width: 100px;
	height: 80px;
	float: left;
}



.admin_logo .admin_lo img{
	width: 200px;
	height: 100px;	
}

.admin_logo .admin_logout{
	float: right;
	position: absolute;
	right: 100px;
}

.admin_logo .admin_logout img{
	position:absolute;
	top:20px;
}

#gnb{
	height:40px;
	background-color: #666666;
}


menu {
	/* height: 100%; */
	background-color: #f0f0f0;
	width: 10%;
	position: absolute;
	font-size: 16px;
	margin-right: 15px;
	padding-bottom: 100%;
}

a{
	text-decoration: none;
	color: #11adea;
	font-weight: 700;
	text-align:center;
}

menu span {
	text-align: center;
	margin: 10px auto;
	width: 100%;
	display: block;
}

section {
	margin-top : 5px;
	margin-left: 230px;
}

form input{
	width: 30px;
	height: 20px;
	margin-bottom: 5px;
}


footer {
	background-color: orange;
	clear: both;
}

</style>
<script type="text/javascript">

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
		<div>
			<tiles:insertAttribute name="body" />
		</div>
	</section>

</body>
</html>