<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<base>
<link rel="stylesheet" href="css/reset.css?ver=1">
<script type="text/javascript">
$(document).ready(function(){
	$('input').filter(function(){
		return $(this).attr('readonly')=='readonly';
	}).css('background-color','orange');
});
</script>

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
	height: auto;
	background-color: #f0f0f0;
	width: 15%;
	float: left;
	font-size: 16px;
	margin-right: 15px;
}

menu span {
	text-align: center;
	margin: 0px auto;
	width: 100%;
	display: block;
	float: left;
}



section {
	margin-top : 10px;
	float: left;
}

section input{
	width: 30px;
	height: 20px;
	margin-bottom: 5px;
}



footer {
	background-color: #ffffff;
	clear: both;
}

</style>
<script type="text/javascript">

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
		<div>
			<tiles:insertAttribute name="body" />
		</div>
	</section>

</body>
</html>