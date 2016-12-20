<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>

.member_manage{
	width:1000px;
	margin-bottom: 5px;
	float: left;
}

hr{
	width: 900px;
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
	height: 120px;
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
		$(document).on("click",".member_delete",function(){
			$(this).parent().attr("action","adminMemberDelete.do").submit();
		});
		
		/* $('.mem_addModel').addClass('addHide');
		$('#member_btnadd').on("click",function(){
			$('.mem_addModel').addClass('addShow');
			$('.mem_addModel').removeClass('addHide');
		})
		$('#memberbtnAdd').on('click',mem_add_send);
		$('#memberbtnClose').on('click',mem_add_send); */
	});
	
	/* function mem_add_send(){
		$('.mem_addModel').removeClass('addShow');
		$('.mem_addModel').addClass('addHide');
	}
	 */
</script>
<!-- <div class="board_add">
	<input type="button" id="member_btnadd" value="Add">
</div> -->
<div class="member_manage">
		<c:forEach items="${list}" var="a">
			<form action="adminMemberUpdate.do">
				<input readonly="readonly" type="text" name="mem_num" value="${a.mem_num}" title="회원 번호">
				<input type="text" name="mem_id" value="${a.mem_id}" title="회원 아이디">
				<input type="text" name="mem_nickname" value="${a.mem_nickname}" title="회원 닉네임">
				<input readonly="readonly" type="text" name="mem_admin" value="${a.mem_admin}" title="권한 번호">
				<input type="submit" value="Submit">
				<input type="button" class="member_delete" value="Delete">
			</form>
			
			<hr/>
			<br/>
		</c:forEach>
	</div>
<!-- <div class="mem_addModel">
	<form id="mem_add" action="adminMemberAdd.do">
	<p><label>회원 아이디</label><input type="text" name="mem_id"></p>
	<p><label>회원 닉네임</label><input type="text" name="mem_nickname"></p>
	<p><label>권한 번호</label><input type="text" name="mem_admin"></p>
	<p>
	<input type="submit" value="Add" id="memberbtnAdd">
	<input type="button" value="Close" id="memberbtnClose">
	</p>
	</form>
</div>	 -->
	