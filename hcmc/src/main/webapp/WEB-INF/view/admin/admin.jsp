<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	var urno='';
	var n='';
	$(document).ready(function(){
		$('#festival_addModel').addClass('addHide');
		$(document).on('click','.festival_delete',function(){
			$(this).parent().attr('action','adminFestivalDelete.do').submit();
		});
		
		$('#festival_add').on("click",function(){
			$('#festival_addModel').addClass('addShow');
			$('#festival_addModel').removeClass('addHide');
		})
		
		$('#btnAdd').on('click',festival_add_close);
		$('#btnClose').on('click',festival_add_close);
		
	});
	
	function festival_add_close(){
		$('#festival_addModel').removeClass('addShow');
		$('#festival_addModel').addClass('addHide');
	}
	
	

</script>
<style type="text/css">


.festival_manage{
	width:1200px;
	margin-bottom: 5px;
	float: left;

}

hr{
	width: 1100px;
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
	height: 260px;
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

<body>
	<div class="festival_add">
		<input type="button" id="festival_add" value="Add">
	</div>
	<div class="festival_manage">
		<c:forEach items="${list}" var="a">
			<form id="festival_form" action="adminFestivalUpdate.do" method="post" enctype="multipart/form-data">
				<input type="text" name="festival_num" readonly="readonly" value="${a.festival_num}" title="축제 번호">
				<input type="text" name="festival_name" value="${a.festival_name}" title="축제 이름">
				<input type="text" name="festival_start" title="축제 시작 날짜" value="<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.festival_start}"/>">
				<input type="text" name="festival_end" title="축제 끝 날짜" value="<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.festival_end}"/>">
				<input type="text" name="festival_hpage" value="${a.festival_hpage}" title="축제 홈페이지">
				<input type="text" name="festival_theme" value="${a.festival_theme}" title="축제 테마">
				<input type="text" name="festival_time" value="${a.festival_time}" title="축제 관람 가능 시간">
				<input type="text" name="festival_count" readonly="readonly" value="${a.festival_count}" title="축제 조회수">
				<input type="text" name="star" readonly="readonly" value="${a.star}" title="축제 평점" disabled="disabled">
				<input type="text" name="city_num" value="${a.city_num}" title="축제 지역 번호">
				<textarea rows="10" cols="80" name="festival_content" title="축제 내용">${a.festival_content}</textarea>
				<input type="file" class="festivalUpdate_filename btn" name="festival_filename" multiple="multiple" />
				<input type="submit" value="Submit">
				<input type="button" class="festival_delete" value="Delete">
			</form>
			<hr/>
			<br/>
		</c:forEach>
	</div>
	
	<div id="festival_addModel">
		<form id="festival_add" action="adminFestivalIns.do" method="post" enctype="multipart/form-data">
		<p><label>축제이름</label><input type="text" name="festival_name"> </p>
		<p><label>시작날짜</label><input placeholder="YYYY/MM/dd" type="text" name="festival_start"></p>
		<p><label>끝날짜</label><input placeholder="YYYY/MM/dd" type="text" name="festival_end"></p>
		<p><label>홈페이지</label><input type="text" name="festival_hpage"></p>
		<p><label>테마</label><input type="text" name="festival_theme"></p>
		<p><label>소요시간</label><input type="text" name="festival_time"></p>
		<p><label>지역번호</label><input type="text" name="city_num"></p>
		<p><label>축제내용</label><input type="text" name="festival_content"></p>
		<p><input type="file" class="festivalUpdate_filename btn" name="festival_filename" multiple="multiple" /><p>
		<p>
		<input type="submit" value="Add" id="btnAdd">
		<input type="button" value="Close" id="btnClose">
		</p>	
		</form>
	</div>
	
	
</body>