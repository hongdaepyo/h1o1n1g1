<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="member_manage">
		<c:forEach items="${list}" var="a">
			<form action="adminMemberUpdate.do">
				<input readonly="readonly" type="text" name="mem_num" value="${a.mem_num}">
				<input type="text" name="mem_id" value="${a.mem_id}">
				<input type="text" name="mem_nickname" value="${a.mem_nickname}">
				<input readonly="readonly" type="text" name="mem_admin" value="${a.mem_admin}">
				<input type="submit" value="Submit">
			</form>
			
			<hr/>
		</c:forEach>
	</div>