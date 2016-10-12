<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_007_forward</title>
</head>
<body>
	<jsp:forward page="jsp_007_pageres.jsp">
	 <jsp:param value="red"name="color"/>
	</jsp:forward>
</body>
</html>