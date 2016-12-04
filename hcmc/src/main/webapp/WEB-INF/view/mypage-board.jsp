<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br />
<br />
<div class="mblist">
	<c:forEach items="${mblist}" var="a">
		<c:set value="" />
		<tr>
			<td id="board_num">${a.board_num}</td>
			<td id="board_head">${a.board_head}</td>
			<td id="board_content">${a.board_content}</td>
			<td id="board_date">${a.board_date}</td>
			<td id="festival_num">${a.festival_num}</td>

		</tr>
	</c:forEach>
</div>
