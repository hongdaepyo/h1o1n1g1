<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	헤더다
	<a href="">로그인 테스트</a>
	<form action="memberRegister.do" method="post">
		<input placeholder="회원가입 테스트 id" name="mem_id" type="text">
		<input placeholder="회원가입 테스트 pass"  name="mem_pass" type="password">
		<input type="submit" value="submit">
	</form>
	<form action="login.do" method="post">
		<input placeholder="로그인 테스트 id" name="mem_id" type="text">
		<input placeholder="로그인 테스트 pass" name="mem_pass" type="password">
		<input type="submit" value="submit">
	</form>