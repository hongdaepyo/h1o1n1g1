<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="conn" driver="oracle.jdbc.OracleDriver"
		user="hr" password="a1234"
		url="jdbc:oracle:thin://@localhost:1521:xe" />

	<%--  <sql:update dataSource="${conn}">
    insert into mem values(mem_num_seq.nextval,?,?,?)
   <sql:param value="test01" />
		<sql:param value="30" />
		<sql:param value="seoul" />
	</sql:update>  --%>

   <%-- <sql:update dataSource="${conn}">
     update mem set name=? where num=?
     <sql:param value="test2" />
     <sql:param value="11" /> 
   </sql:update>  --%>
   
  <%--  <sql:update dataSource="${conn}">
     delete from mem where  num>=?
     <sql:param value="10" />
   </sql:update>  --%>

	<sql:query var="rs" dataSource="${conn}">
		select * from mem order by num         
    </sql:query>

	<c:forEach items="${rs.rows}" var="data">
		<p>
			<c:out value="${data['num']}" />
			_
			<c:out value="${data['name']}" />
			_
			<c:out value="${data['age']}" />
			_
			<c:out value="${data['loc']}" />
		</p>
	</c:forEach>
</body>
</html>