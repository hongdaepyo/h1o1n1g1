<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('.list').bind('click', function() {
			$('form').attr('action', 'list.do');
			//"list.do?pageNum=${param.pageNum}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}"
			$('form').submit();
		});

		$('.reply').bind('click', function() {
			$('form').attr('action', 'writeForm.do');
			$('form').submit();
		});

		$('.update').bind('click', function() {
			$('form').attr('action', 'updateForm.do');
			$('form').submit();
		});

		$('.del').bind('click', function() {
			$('form').attr('action', 'delete.do');
			$('form').submit();
		});
	});
</script>
</head>
<body>
	<%
		//치환 변수 선언
		pageContext.setAttribute("cr", "\r"); //Space
		pageContext.setAttribute("cn", "\n"); //Enter
		pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
		pageContext.setAttribute("br", "<br/>"); //br 태그
	%>
	
	<table border="1" width="80%">
		<tr>
			<td width="20%">글쓴이</td>
			<td>${dto.writer}</td>
			<td width="20%">조회수</td>
			<td>${dto.readcount}</td>
		</tr>

		<tr>
			<td>제목</td>
			<td colspan="3">${dto.subject}</td>
		</tr>

		<tr>
			<td>메일</td>
			<td colspan="3">${dto.email}</td>
		</tr>

		<tr>
			<td>내용</td>
			
			<td colspan="3">
			${dto.content }
			</td>
		</tr>

		<tr>
			<td>파일</td>
			<td colspan="3"><a href="download.do?num=${dto.num}">${dto.upload}</a>
			</td>
		</tr>
	</table>

	<form name="frm" method="post" enctype="application/x-www-form-urlencoded">
		<input type="hidden" value="${dto.num}" name="num" /> 
		<input type="hidden" value="${dto.ref}" name="ref" /> 
		<input type="hidden" value="${dto.re_step}" name="re_step" /> 
		<input type="hidden" value="${dto.re_level}" name="re_level" /> 
		<input type="hidden" value="${param.pageNum}" name="pageNum" />
		<input type="hidden" name="searchKey" value="${param.searchKey}"/>
		<input type="hidden" name="searchWord" value="${param.searchWord}"/>
		<input type="button" value="목록" class="list"/> <input type="button" value="답변" class="reply" /> 
		<input type="button" value="수정" class="update" />
		<input type="button" value="삭제" class="del" />
	</form>
</body>
</html>























