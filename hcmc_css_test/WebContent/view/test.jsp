<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="../css/reset.css">
<style type="text/css">
.star_input{
width:150px;
height:30px;
border:1px solid black;
}
div span{
width:15px;
height:30px;
display:block;
float:left;
}

.star_input{
background-image: url("http://imgdb.kr/aHtO.dn");
background-size: 30px, 30px;
}

.over-left{
background-image: url("http://imgdb.kr/aHt9.dn");
background-size: 15px, 30px;
}
.over-right{
background-image: url("http://imgdb.kr/aHtL.dn");
background-size: 15px, 30px;
}

.over2{
background-color: red;
border-right: 1px solid black;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
		star_rating();
		$('#re').click(function(){
			star_rating();
		});
});

function star_rating(){
  $('div span').removeClass('over-left');
  $('div span').removeClass('over-right');
  $('div span').mouseenter(function(e){
	var i=$(e.target).index()+1;
	var score=(i/2).toFixed(1);
	$('.score').text(score+'/5.0');
	$('.star_input span:lt('+i+'):even').addClass('over-left');
	$('.star_input span:lt('+i+'):odd').addClass('over-right');
  }).mouseleave(function(e){
	var i=$(e.target).index()+1;
	$('.star_input span:lt('+i+'):even').removeClass('over-left');
	$('.star_input span:lt('+i+'):odd').removeClass('over-right');
  }).click(function(e){
	var i=$(e.target).index()+1;
	$('div span').off();
	//별점으로 i 값 넘겨주면 됨
  });
}

/* function star_rating(){
	$('div span').mouseenter(function(e){
		var i=$(e.target).index()+1;
		$(e.target).removeClass('over2');
		$('.star_input span:lt('+i+'):even').addClass('over');
	}).mouseleave(function(e){
		var i=$(e.target).index()+1;
		$('.star_input span:lt('+i+')').removeClass('over');
	}).click(function(e){
		var i=$(e.target).index()+1;
		$('.star_input span:lt('+i+')').addClass('over2');
		$('div span').off();
		alert(i);
	});
} */
</script>
<body>
<div class="star_input">
     <span></span>
     <span></span>
     <span></span>
     <span></span>
     <span></span>
     <span></span>
     <span></span>
     <span></span>
     <span></span>
     <span></span>
</div>
<button id="re">별점 다시 등록</button>
<span class="score"></span>
</body>
</html>