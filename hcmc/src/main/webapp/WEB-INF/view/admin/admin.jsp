<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	var urno='';
	var n='';
	$(document).ready(function(){
		$('#addModel').addClass('addHide');
		$(document).on('click','.festival_delete',function(){
			$(this).parent().attr('action','adminFestivalDelete.do').submit();
		});
		
		$('#festival_add').on("click",function(){
			$('#addModel').addClass('addShow');
			$('#addModel').removeClass('addHide');
		})
		
		$('#btnAdd').on('click',festival_add_send);
		$('#btnClose').on('click',festival_add_close);
		
		var con_str=$('input[name="festival_content"]').val();
		//ConvertSystemSourcetoHtml(con_str);
		//$('input[name="festival_content"]').val(con_str);
		
	});
	
	function festival_add_close(){
		$('#addModel').removeClass('addShow');
		$('#addModel').addClass('addHide');
	}
	
	 function festival_add_send(){
		$('#addModel').removeClass('addShow');
		$('#addModel').addClass('addHide'); 
	} 
	 
	 
	 
//$('&lt').replaceAll('<');
		function test1(){
			$('\"').replaceAll("&quot;");
	 	/* str = str.replace(/</g,"&lt;");
		str = str.replace(/>/g,"&gt;");
		str = str.replace(/\"/g,"&quot;");
		str = str.replace(/\'/g,"&#39;");
	 	str = str.replace(/\n/g,"<br />"); */
	}
</script>
<style type="text/css">

form{
	width:1200px;
	margin-bootom: 5px;

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
	height: 500px;
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
			<form id="festival_form" action="adminFestivalUpdate.do">
				<input type="text" name="festival_num" readonly="readonly" value="${a.festival_num}" title="축제 번호">
				<input type="text" name="festival_name" value="${a.festival_name}" title="축제 이름">
				<input type="text" name="festival_start" title="축제 시작 날짜" value="<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.festival_start}"/>">
				<input type="text" name="festival_end" title="축제 끝 날짜" value="<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${a.festival_end}"/>">
				<input type="text" name="festival_hpage" value="${a.festival_hpage}" title="축제 홈페이지">
				<input type="text" name="festival_theme" value="${a.festival_theme}" title="축제 테마">
				<input type="text" name="festival_time" value="${a.festival_time}" title="축제 관람 가능 시간">
				<input type="text" name="festival_count" readonly="readonly" value="${a.festival_count}" title="축제 조회수">
				<input type="text" name="festival_content" value="${a.festival_content}" title="축제 내용">
				<input type="text" name="star" readonly="readonly" value="${a.star}" title="축제 평점" disabled="disabled">
				<input type="text" name="city_num" value="${a.city_num}" title="축제 지역 번호">
				<input type="submit" value="Submit">
				<input type="button" class="festival_delete" value="Delete">
			</form>
			<hr/>
			<br/>
		</c:forEach>
	</div>
	
	<div id="addModel">
		<form id="festival_add" action="adminFestivalAdd.do">
		<p><label>축제이름</label><input type="text" name="festival_name"> </p>
		<p><label>시작날짜</label><input type="text" name="festival_start"></p>
		<p><label>끝날짜</label><input type="text" name="festival_end"></p>
		<p><label>홈페이지</label><input type="text" name="festival_hpage"></p>
		<p><label>테마</label><input type="text" name="festival_theme"></p>
		<p><label>소요시간</label><input type="text" name="festival_time"></p>
		<p><label>축제내용</label><input type="text" name="festival_content"></p>
		<p><label>지역번호</label><input type="text" name="city_num"></p>
		<p>
		<input type="submit" value="Add" id="btnAdd">
		<input type="button" value="Close" id="btnClose">
		</p>	
		</form>
	</div>
	
	
</body>