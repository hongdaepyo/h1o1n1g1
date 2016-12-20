<%@page contentType="text/html; charset=UTF-8"%>
<div class="menu_container">
   <div>
      <span id="personalInfo"><a href="#">개인정보 변경</a></span> 
      <span id="personalBoard"><a href="myBoard.do">내가 쓴 글 관리</a></span> 
      <span id="personalFavor"><a href="#">즐겨찾기 관리</a></span> 
      </div>
</div>

<script>
$('#personalInfo a').on("click",function(){
   var k ="${sessionScope.mem_num}";
   $('#personalInfo a').attr('href',"http://localhost:8090/hcmc/info.do?mem_num="+k);
});

$('#personalBoard a').on("click",function(){
   var k ="${sessionScope.mem_num}";
   var h ="${dto.mem_num}"
	
//    $('#personalBoard a').attr('href',"http://localhost:8090/hcmc/myBoardList.do?mem_num="+k);
});

$('#personalFavor a').on("click",function(){
   var k ="${sessionScope.mem_num}";
   $('#personalFavor a').attr('href',"http://localhost:8090/hcmc/myFavorList.do?mem_num="+k);
});



</script>