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
	
</script>
</head>
<body>

	<form name="frm" method="get" action="sawonList">
		<table>
			<tr>
				<th><input type="button" id="all" value="전체" /> <input
					type="button" id="del" value="삭제" /></th>

				<th>employee_id</th>
				<th>first_name</th>
				<th>dept</th>
				<th>loc</th>
			</tr>

			<c:forEach items="${aList}" var="dto">
				<tr>
					<td><input type="checkbox" name="chk"
						value="${dto.employee_id}" /></td>
					<td>${dto.employee_id}</td>
					<td>${dto.first_name}</td>
					<td>${dto.dept.department_name}</td>
					<td>${dto.loc.street_address}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>