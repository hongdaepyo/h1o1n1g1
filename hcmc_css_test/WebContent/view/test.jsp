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

</style>
<script type="text/javascript">
$(document).ready(function(){
		$('.ff_ff li img').click(function(e){
	      var n=$(e.target).parent().attr('name');
	      //8~20글자, 영문, 숫자, 특수문자 조합
	      var patt=/^.*(?=^.{8,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	      if(patt.test(n)){
	    	  alert('true');
	      }else{
	    	  alert('false');
	      }
	   });
});
</script>
<body>
<div class="ff_ff">
             <li name="서울">
               <img src="icon/se.png"/>
             </li> 
             <li name="경기">
               <img src="icon/se.png"/>            
             </li> 
             <li>
               <img src="icon/se.png"/>
             </li> 
             <li>
               <img src="icon/se.png"/>
             </li>       
             <li>
               <img src="icon/se.png"/>
             </li>
             <li>
               <img src="icon/se.png"/>
             </li>
             <li>
               <img src="icon/se.png"/>
             </li>
             <li>
               <img src="icon/se.png"/>
             </li>      
           </div>
</body>
</html>