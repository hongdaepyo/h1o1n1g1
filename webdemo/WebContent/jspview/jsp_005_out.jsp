<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_005_out</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String ope=request.getParameter("ope");
	int x =Integer.parseInt(request.getParameter("x"));
	int y =Integer.parseInt(request.getParameter("y"));
	switch(ope){
	case "+":out.print("<p>"+x+"+"+y+"="+(x+y)+"</p>"); break;
	case "-":out.print("<p>"+x+"-"+y+"="+(x-y)+"</p>"); break;
	case "*":out.print("<p>"+x+"*"+y+"="+(x*y)+"</p>"); break;
	case "/":out.print("<p>"+x+"/"+y+"="+((double)x/(double)y)+"</p>");
	}
	
%>
</body>
</html>