<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>

.board_manage{
	width:1200px;
	margin-bottom: 5px;
	float: left;
}

hr{
	width: 1200px;
}

form input{
	width:auto;
}

.addShow{
	display: block;
	position: absolute;
	top: 150px;
	left: 200px;
	width: 600px;
	height: 170px;
	z-index: 1000;
	border: 1px solid black;
	background-color: skyblue;
}

.addHide{
	visibility:hidden;
	width:0px; 
	height:0px;
}	

</style>
<script>
	$(document).ready(function(){
		$('.board_addModel').addClass('addHide');
		$(document).on('click','.board_delete',function(){
			$(this).parent().attr('action','adminBoardDelete.do').submit();
		});
		
		$("#board_btnadd").on("click",function(){
			$('.board_addModel').addClass('addShow');
			$('.board_addModel').removeClass('addHide');
		});
		$('#boardbtnAdd').on('click',board_add_send);
		$('#boardbtnClose').on('click',board_add_send);
				
	});
	
	function board_add_send(){
		$('.board_addModel').removeClass('addShow');
		$('.board_addModel').addClass('addHide');
	}
	
</script>
<div class="board_add">
	<input type="button" id="board_btnadd" value="Add">
</div>
<div class="board_manage">
	<c:forEach items="${list}" var="a">
		<form class="board_form" action="adminBoardUpdate.do">
			<input readonly="readonly" type="text" name="board_num" value="${a.board_num}" title="게시판 번호">
			<input type="text" name="board_head" value="${a.board_head}" title="게시판 말머리">
			<input readonly="readonly" type="text" name="board_content" value="${a.board_content}" title="게시판 내용">
			<input readonly="readonly" type="text" name="board_date" value=<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.board_date}"/> title="게시 시간">
			<input readonly="readonly" type="text" name="mem_num" value="${a.mem_num}" title="회원 번호">
			<input type="text" name="festival_num" value="${a.festival_num}" title="축제 번호">
			<input type="submit" value="Submit">
			<input type="button" class="board_delete" value="Delete">
		</form>
		<hr/>
		<br/>
	</c:forEach>
</div>

<div class="board_addModel">
	<form id="board_add" action="adminBoardAdd.do">
	<p><label>게시판 말머리</label><input type="text" name="board_head"></p>
	<p><label>게시판 내용</label><input type="text" name="board_content"></p>
	<p><label>게시 시간</label><input type="text" name="board_date"></p>
	<p><label>회원 번호</label><input type="text" name="mem_num"></p>
	<p><label>축제 번호</label><input type="text" name="festival_num"></p>
	<p>
	<input type="submit" value="Add" id="boardbtnAdd">
	<input type="button" value="Close" id="boardbtnClose">
	</p>
	</form>
</div>