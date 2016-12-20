<%@page contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	var k = "${sessionScope.mem_num}";
	$(document).ready(function() {
		$('#testdivdiv iframe').attr('src','myBoardList.do?mem_num='+k);
	return false;
		alert(k);
		$.ajax({
			type : 'post',
			data : 'mem_num=' + k,
			url : 'myBoardList.do',
			dataType : 'json',
			success : function(res) {
				console.log(res);
				$('#testdivdiv').html(res);
			}
		})
	})
</script>
<div id="testdivdiv">
	<iframe src="myBoardList.do?mem_num=1" width="1000px" height="650px">
	
	</iframe>
</div>

