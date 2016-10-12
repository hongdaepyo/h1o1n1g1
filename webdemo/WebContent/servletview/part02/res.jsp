<%@ page import="servletdemo.part02.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 스크립트릿(scriptlet)-jsp에서 자바코드를 구현 -->
 <%
  MemberDTO dto=(MemberDTO) request.getAttribute("dto");
 %>
 
 <p><%=dto.getId() %>/<%=dto.getPassword() %></p>
</body>
</html>







