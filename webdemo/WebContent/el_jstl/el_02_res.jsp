<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
  String data=request.getParameter("data");
out.print(data);
%> --%>
값이 하나면 param 여러개면 paramValues 사용
<p>${param.data}</p>

<%-- <%
  String[] chk=request.getParameterValues("chk");
  for(String sn: chk)
	  out.print(sn);
%> --%>

<p>${paramValues.chk[0]}</p>
<p>${paramValues.chk[1]}</p>
<p>${paramValues.chk[2]}</p>
</body>
</html>