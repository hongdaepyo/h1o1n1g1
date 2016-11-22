<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">

</script>
<body>
	<div class="festival_manage">
		<c:forEach items="${list}" var="a">
			<form action="adminFestivalUpdate.do">
				<input type="text" name="festival_num" readonly="readonly" value="${a.festival_num}">
				<input type="text" name="festival_name" value="${a.festival_name}">
				<input type="text" name="festival_start" value="<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.festival_start}"/>">
				<input type="text" name="festival_end" value="<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.festival_end}"/>">
				<input type="text" name="festival_pic" value="${a.festival_pic}">
				<input type="text" name="festival_hpage" value="${a.festival_hpage}">
				<input type="text" name="festival_theme" value="${a.festival_theme}">
				<input type="text" name="festival_time" value="${a.festival_time}">
				<input type="text" name="festival_count" readonly="readonly" value="${a.festival_count}">
				<input type="text" name="festival_content" value="${a.festival_content}">
				<input type="text" name="star" readonly="readonly" value="${a.star}" disabled="disabled">
				<input type="text" name="city_num" value="${a.city_num}">
				<input type="submit" value="Submit">
			</form>
			<hr/>
		</c:forEach>
		
	</div>
</body>