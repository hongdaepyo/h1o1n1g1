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
<script type="text/javascript">
$(document).ready(function(){
	
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
	border-right: 2px solid #ff5e00;
}

menu span {
	text-align: center;
	margin: 0px auto;
	width: 100%;
	display: block;
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

</body>
</html>