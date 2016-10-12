<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_006_response</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	if(id.equals("kim")&&pwd.equals("1234")){
		//response.sendRedirect("jsp_006_logout.jsp");
		//RequestDispatcher dis=request.getRequestDispatcher("jsp_006_logout.jsp");
		//서버에서 페이지이동
		//dis.forward(request,response);
	%>
	<jsp:forward page="jsp_006_logout.jsp"/>
	
	<%	
	}else{
		//서버와 클라이언트 사이에서 페이지이동
		response.sendRedirect("jsp_006_logoin.jsp");
	}
%>
</body>
</html>