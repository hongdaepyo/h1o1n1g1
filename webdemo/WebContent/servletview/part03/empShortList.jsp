<%@page import="java.util.List"%>
<%@page import="servletdemo.part03.EmployeesDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empShortList.jsp</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<style type="text/css">
div.wrap {
	width: 250px;
	border: 1px solid black;
	text-align: right;
}



div.wrap p>a {
	display: inline-block;
	width: 50px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>

</head>
<body>
<%
 List<EmployeesDTO> aList=
       (List<EmployeesDTO>)request.getAttribute("aList");
%>

	<div class="wrap">
		<a href="empList" class="more">더보기</a>
		<table>
			<thead>
				<tr>
					<th>employee_id</th>
					<th>first_name</th>
					<th>salary</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < aList.size(); i++) {
						EmployeesDTO dto = aList.get(i);
				%>
				<tr>
					<td><%=dto.getEmployee_id()%></td>
					<td><%=dto.getFirst_name()%></td>
					<td><%=dto.getSalary()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>


	</div>
</body>
</html>






