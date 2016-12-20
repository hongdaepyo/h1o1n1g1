<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br />
<br />
<script type="text/javascript">
// if('${not empty sessionScope.mem_num}')
// var k = "${sessionScope.mem_num}";
$(document).ready(function() {
	var mem_num=${param.mem_num};
	$.ajax({
		type:'post',
		url:'memflist.do',
		dataType:'json',
		success:function(res){
			console.log(res);
			flist_input(res);
		}
		
	})
	
	$(document).on('click','.festival_delete',function(){
		$(this).parent().attr('action','myPageFavorDelete.do').submit();
		//window.location.reload();
	});
	
})

function flist_input(res){
	for(var i=0;i<res.length;i++){
		$('input[class='+i+'n]').val(res[i].festival_name);
	}
}
</script>
<style type="text/css">
.mflist *{
	border: 1px solid black;
	
}

.mflist{
	margin: 0px auto;
    width: 600px;
}

.mflist *{
	border-radius: 5px;
	text-align: center;
}

.favor_form{
	width:500px;
	margin: 0px auto;
	text-align: center;
	border:0px;
}

.favor_form :first-child{
	width:40px;
}

input[name="festival_name"]{
	min-width:50%;
}

section{
	overflow: hidden;
}
</style>

<div class="mflist">
	<c:forEach items="${mflist}" var="a">
		<form class="favor_form" action="">
		<input type="text" name="f_favor_num" readonly="readonly" value="${a.f_favor_num}" title="즐겨찾기 번호">
		<input disabled="disabled" class="${a.festival_num}f" type="hidden" name="festival_num" readonly="readonly" value="${a.festival_num}" title="축제 번호">
		<input disabled="disabled" class="${a.festival_num}n" type="text" name="festival_name" readonly="readonly" value="" title="축제 이름">
		<input type="hidden" name="mem_num" value="${param.mem_num}">
		<input type="button" class="festival_delete" value="Delete">
		</form>
		<br/>
	</c:forEach>
</div>
