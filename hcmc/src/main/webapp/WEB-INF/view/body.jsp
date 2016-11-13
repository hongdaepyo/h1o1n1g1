<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="bodywrap">
	<div id="nick">
		<div class="title">
			<span>닉네임 설정</span>
		</div>
		<input id="nickname" type="text" placeholder="">
		<button class="confirm_btn">확인</button>
	</div>

	<div id="password">
		<div class="title">
			<span>비밀번호 변경하기</span>
		</div>
		<div class="current_password">
			<div class="">현재 비밀번호</div>
			<input type="password">
		</div>
		<div class="new_password">
			<div class="">새 비밀번호</div>
			<input type="password">
		</div>
		<div class="new_password_confirm">
			<div class="">새 비밀번호 확인</div>
			<input type="password">
		</div>
		<button class="confirm_btn" onclick="submit">확인</button>
	</div>

	<div id="delete_member">
		<div class="title">
			<span>탈퇴하기</span>
		</div>
		<div class="delete">
			<div class="">비밀번호</div>
			<input class="text_input" type="password">
			<button class="confirm_btn">확인</button>
		</div>
	</div>

</div>
<%-- <c:forEach var="dto" items="${list}"> --%>
<%-- <p>${dto.mem_num}</p> --%>
<%-- <p>${dto.mem_id}</p> --%>
<%-- <p>${dto.mem_pass}</p> --%>
<%-- <p>${dto.mem_nickname}</p> --%>
<%-- <p>${dto.mem_admin}</p> --%>
<%-- </c:forEach> --%>
