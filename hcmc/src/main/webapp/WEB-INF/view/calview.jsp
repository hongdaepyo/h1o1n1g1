<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/ad.js?ver=1"></script>
<script type="text/javascript" src="js/month.js?ver=1"></script>
<script src="js/mypage.js?ver=1"></script>
<script src="js/festival_info.js?ver=1"></script>

<link rel="stylesheet" type="text/css" href="css/reset.css?ver=1" />
<link rel="stylesheet" type="text/css" href="css/calendar.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/month.css?ver=1" />
<link rel="stylesheet" href="css/festival_info.css?ver=1">
<script type="text/javascript">
var festival; //달력에서 선택하면 축제정보를 저장하는 변수
var l_len='${list}'.match(/\{/g).length;
$(document).ready(function(){
		var w_d = $(document).width();
		var h_d = $(document).height();
		console.log('${list}');	
		fest_list();
		
		$('#test_btn').click(function(){
			alert('test');
		});
		
		$('td div span').click(function(e){
			var n=$(e.target).attr('name');
			if(n!=""){
				festival_view(n); //축제정보 가져오기
				festival_map(); //축제정보맵 호출
				resize_info(w_d,h_d); //축제정보창 띄우기
			}
		});//a요쇼의 링크를 막고 축제정보창을 띄워줌 */
		
});

function day_match(a,b,c){
		
		console.log(a,b,c);
}

function test(res){
	console.log(res.length);
	for(var i=0;i<res.length;i++){
		var f_num=res[i].FESTIVAL_NUM;
		var f_name=res[i].FESTIVAL_NAME;
		var c_num=res[i].CITY_NUM;
		var s_date=new Date(res[i].FESTIVAL_START);
		var s_day=s_date.getDate();
		var d=document.getElementsByClassName(s_day);
		if(d.length>0){
		console.log(f_name+'////'+s_day+'////'+d.length);
		$('.'+s_day+' span').attr('name',f_num);
		$('.'+s_day+' span').text(f_name+'\n'+c_num);
		}
	};
}//읽어온 정보중 축제 이름과 도시 번호를 달력에 추가해줌

function festival_view_input(){
	var d = JSON.stringify(festival);
	var jsonObj = JSON.parse(d);
	var star=jsonObj.star;
	var sdate=new Date(jsonObj.festival_start);
	var edate=new Date(jsonObj.festival_end);
	var sdate_str=sdate.getFullYear()+"/"+sdate.getMonth()+"/"+sdate.getDate();
	var edate_str=edate.getFullYear()+"/"+edate.getMonth()+"/"+edate.getDate();
	$('.title').text(jsonObj.festival_name);
	$('.period').text(sdate_str+"  ~  "+edate_str+"　　　"+jsonObj.festival_time+"~");
	$('.content').text(jsonObj.festival_content);
	$('.fh_top a').attr('href',jsonObj.festival_hpage);
	star_view(star);
}

</script>
</head>
<body>
<div class="ad" id="ad" >
	<a class="ad_show" id="ad_show" href="#" >
	<img src="<%= request.getContextPath()%>/images/Koala.jpg" height = "50" width="97%">
	</a>
	
	<a class="ad_close" id="ad_close" href="#">
	<img src="images/x.jpg" height="50" width="2%" >
	</a>
</div>


<form name="city" method="get">
<fieldset>
<p>지역 								　
<input type="checkbox" name="seoul" />서울
<input type="checkbox" name="gyeonggi" />경기
<input type="checkbox" name="incheon" />인천
<input type="checkbox" name="kangwon" />강원
<input type="checkbox" name="gyeongsang" />경상
<input type="checkbox" name="chungcheong" />충청
<input type="checkbox" name="jeonlado" />전라
<input type="checkbox" name="jeju" />제주
</p>
</fieldset>
</form>

<form name="theme" method="get">
<fieldset>
<p>테마 								　
<input type="checkbox" name="family" />가족
<input type="checkbox" name="couple" />연인
<input type="checkbox" name="friend" />친구
<input type="checkbox" name="alone" />혼자
</p>
</fieldset>
</form>
	<div class='button' id='button'>
	<button id='prev_btn'>prev</button>
	<button id='today_btn'>today</button>
	<button id='next_btn'>next</button>
	<button id='test_btn'>test</button>
	</div>
	<div class="cal">
		
	</div>
	<div class="rrr">
	
	</div>
	
<div class="bodywrap">
	<div class="infowrap">
		<div class="info_mask"></div>
		<div class="info_inner">
			<div class="festival_header">
			<button id="tt">test</button>
			<div class="fh_top">
				<button name="close">X</button>
				<a href=""><img alt="홈페이지로 이동합니다." src="http://imgdb.kr/aGif.dn" width=20px height=20px></a>
			</div>
				<c:out value=""/>
				<span class="title"></span>
				<span class="period"></span>
				
				<div class="star">
					<!-- <img src="http://imgdb.kr/aFnm.dn" width=30px height=30px>
					<img src="http://imgdb.kr/aFnm.dn" width=30px height=30px>
					<img src="http://imgdb.kr/aFnm.dn" width=30px height=30px>
					<img src="http://imgdb.kr/aFnm.dn" width=30px height=30px>
					<img src="http://imgdb.kr/aFnm.dn" width=30px height=30px> -->
				</div>
			</div>
			<div class="festival_detail"></div>
				<span class="content">////축제날짜</span>
			<div class="festival_map">
			<jsp:include page="festival_map.jsp" flush="true">
			
			</jsp:include>
			</div>

		</div>
	</div>
</div>

	<%-- <div class="miniDB">
		<c:forEach items="${list}" var="FestivalDTO">
			<c:set value=""/>
			<tr>
				<td id="miniNum">${FestivalDTO.festival_num}</td>
				<td id="miniName">${FestivalDTO.festival_name}</td>
				<td id="miniStart">${FestivalDTO.festival_start}</td>
				<td id="miniEnd">${FestivalDTO.festival_end}</td>
			</tr>
		</c:forEach>
	</div> --%>
</body>
</html>