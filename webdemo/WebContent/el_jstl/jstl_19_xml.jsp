<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_19_xml</title>
<!-- Servlet 3.1 and JavaServer page 2.3
	 xalan-2.7.1.jar 추가
 -->
<!-- http://archive.apache.org/dist/xml/xalan-j/xalan-j_2_7_1-bin.zip 받아서 압축 풀고 xalan.jar파일을 WEB-INF\lib 폴더에 복사 -->
</head>
<body>
<c:import url="mem.xml" var="mem" charEncoding="UTF-8"/>
 <x:parse var="xmldata" xml="${mem}"/>
  <x:forEach select="$xmldata//student">
   <p>
    <x:out select="./name"/>
    <x:out select="./id"/>
    <x:out select="./age"/>
   </p>
  </x:forEach>
</body>
</html>