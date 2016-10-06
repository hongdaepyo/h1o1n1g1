<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var first=$("tr td:nth-of-type(2)").text()
		alert(test);
	});
</script>
</head>
<body>

	<form name="frm" method="get" action="sawonList2">
		<table>
			<tr>
				<th><input type="button" id="all" value="전체" /> <input
					type="button" id="del" value="삭제" /></th>

				<th>city</th>
				<th>department_name</th>
				<th>first_name</th>
				<th>salary</th>
			</tr>

			<c:forEach items="${aList}" var="dto">
			
			
					
					
					<c:forEach items="${dto.dept}" var="dept">
						
						<c:forEach items="${dept.emp}" var="emp">
							<tr>
						<td ><input type="checkbox" name="chk" value="${dto.city}" /></td>
							<td>${dto.city}</td>
							<td>${dept.department_name}</td>
							<td>${emp.first_name}</td>
							<td>${emp.salary}</td>
							</tr>
						</c:forEach>
					</c:forEach>




				
			</c:forEach>


		</table>
	</form>
</body>
</html>