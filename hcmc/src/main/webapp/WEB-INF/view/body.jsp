<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="bodywrap">
	<div class="nick_container">
		<div class="nick">
			<div class="title">
				<span>닉네임 설정</span>
			</div>
			<div class="nick_change">
				<div class="header">닉네임 설정</div>
				<input id="nickname" type="text" placeholder="">
			</div>
			<button class="confirm_btn">확인</button>
		</div>
	</div>
	<form id="frm" method="post">
	<div class="password_container">
		<div class="password">
			<div class="title">
				<span>비밀번호 변경하기</span>
			</div>
			<div class="current_password">
				<div class="header">현재 비밀번호</div>
				<input type="password" placeholder="현재 비밀 번호를 입력하세요.">
			</div>
			<div class="new_password">
				<div class="header">새 비밀번호</div>
				<input type="password" placeholder="새 비밀 번호를 입력하세요.">
			</div>
			<div class="new_password_confirm">
				<div class="header">새 비밀번호 확인</div>
				<input type="password" placeholder="새 비밀 번호를 재입력하세요.">
			</div>
			<input type="hidden" value="${dto.mem_num}">
			<button class="confirm_btn">확인</button>
		</div>
	</div>
	</form>


	<div class="delete_container">
		<div id="delete_member">
			<div class="title">
				<span>탈퇴하기</span>
			</div>
			<div class="delete">
				<div class="header">비밀번호</div>
				<input class="text_input" type="password" placeholder="현재 비밀 번호를 입력하세요.">
				<button class="confirm_btn">확인</button>
			</div>
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
