<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br />
<br />
<div class="mflist">
	<c:forEach items="${mflist}" var="a">
		<c:set value="" />
		<tr>
			<td id="favor_num">${a.f_favor_num}</td>
			<td id="festival_num">${a.festival_num}</td>
			<td id="favor_star">${a.favor_star}</td>

		</tr>
	</c:forEach>
</div>
