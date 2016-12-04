<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>

form{
	width:1000px;

}

form input{
	width:auto;
}


</style>
<div class="member_manage">
		<c:forEach items="${list}" var="a">
			<form action="adminMemberUpdate.do">
				<input readonly="readonly" type="text" name="mem_num" value="${a.mem_num}" title="회원 번호">
				<input type="text" name="mem_id" value="${a.mem_id}" title="회원 아이디">
				<input type="text" name="mem_nickname" value="${a.mem_nickname}" title="회원 닉네임">
				<input readonly="readonly" type="text" name="mem_admin" value="${a.mem_admin}" title="권한 번호">
				<input type="submit" value="Submit">
			</form>
			
			<hr/>
			<br/>
		</c:forEach>
	</div>