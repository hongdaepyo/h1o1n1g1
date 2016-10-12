<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 스크립트릿(scriptlet) : 자바소스 -->
<%
  String fname=(String)request.getAttribute("fname");
%>

<!-- expression(표현식) : 변수나 메소드를 호출해서 출력한다. -->
<p><%= fname %>님 회원입니다.</p>
</body>
</html>