<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>

form{
	width:1200px;
}

form input{
	width:auto;
}


</style>
<div class="board_manage">
	<c:forEach items="${list}" var="a">
		<form action="adminBoardUpdate.do">
			<input readonly="readonly" type="text" name="board_num" value="${a.board_num}" title="게시판 번호">
			<input type="text" name="board_head" value="${a.board_head}" title="게시판 말머리">
			<input readonly="readonly" type="text" name="board_content" value="${a.board_content}" title="게시판 내용">
			<input readonly="readonly" type="text" name="board_date" value=<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.board_date}"/> title="게시 시간">
			<input readonly="readonly" type="text" name="mem_num" value="${a.mem_num}" title="회원 번호">
			<input type="text" name="festival_num" value="${a.festival_num}" title="축제 번호">
			<input type="submit" value="Submit">
		</form>
		<hr/>
		<br/>
	</c:forEach>
</div>