$(function(){
	/* 현재 날짜와 현재 달에 1일의 날짜 객체를 생성합니다. */
	/*var date = new Date(); // 날짜 객체 생성
	var y = date.getFullYear(); // 현재 연도
	var m = date.getMonth(); // 현재 월
*/	//var d = date.getDate(); // 현재 일
	//console.log(theDate);
	var row;

	$(document).on({
		click: function() {
			if(m<=0){
				y--;m=11;cal(m,y);fest_list(m,y);today_color();
			}else{
				m--;cal(m,y);fest_list(m,y);today_color();
			}
		},
		mouseover: function(){
			$('.prev_btn').removeClass('btn').addClass('btn_over');
		},
		mouseout:function(){
			$('.prev_btn').removeClass('btn_over').addClass('btn');
		}
	}, '.prev_btn');//이전 달 버튼
	
	$(document).on({
		click: function(){
			if(m>=11){
				y++;m=0;cal(m,y);fest_list(m,y);today_color();
			}else{
				m++;cal(m,y);fest_list(m,y);today_color();
			}
		},
		mouseover: function(){
			$('.next_btn').removeClass('btn').addClass('btn_over');
		},
		mouseout:function(){
			$('.next_btn').removeClass('btn_over').addClass('btn');
		}
	}, '.next_btn');//다음 달 버튼 
	
	$(document).on('click','.cal_title span:nth-of-type(2)',function() {
				window.location.reload();
	});//이번 달 버튼
	
	
});

function cal(m, y){
	var theDate = new Date(y, m, 1);
	var theDay = theDate.getDay();
	var last = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
	var lastDate = last[m];
	row = Math.ceil((theDay + lastDate) / 7);
	if (y % 4 && y % 100 != 0 || y % 400 === 0) {
		lastDate = last[1] = 29;
	}

	//문자 결합 연산자를 사용해 요일이 나오는 행을 생성합니다.
	var calendar = "<table class='calendar_table'>";
	calendar += "<tr><div class='cal_title'><div><span class='prev_btn btn'><　</span>";
	calendar += "<span>  　　" + y + ". " + (m + 1) + "　　  </span>";
	calendar += "<span class='next_btn btn'>　></span></div></div></tr>";

	calendar += "<tr>";
	calendar += "<th>일</th>"; 
	calendar += "<th>월</th>";
	calendar += "<th>화</th>";
	calendar += "<th>수</th>";
	calendar += "<th>목</th>";
	calendar += "<th>금</th>";
	calendar += "<th>토</th>";
	calendar += "</tr>";

	// 달력에 표기되는 일의 초기값!
	var dNum = 1;
	for (var i = 1; i <= row; i++) { // 행 만들기
		calendar += "<tr>";
		for (var k = 1; k <= 7; k++) { // 열 만들기
			// 월1일 이전 + 월마지막일 이후 = 빈 칸으로!
			if (i === 1 && k<=theDay || dNum>lastDate) {
				calendar += "<td> &nbsp; </td>";
			} else {
				calendar += "<td><span class='date'>" + dNum+"</span><div class='"+dNum+"' ><span name=''>축제추가</span></div>" + "</td>";
				dNum++;
			}
		}
		calendar += "</tr>";
	}
	calendar += "</table>";

	$('.cal').html(calendar);
}//각 날짜에 해당하는 달력을 만들어줌

function fest_list(m,y){
	console.log((m+1)+"//////"+y);
	$.ajax({
		type:'post',
		dataType:'json',
		data:'month='+(m+1)+'&year='+y,
		url:"calendar2.do",
		success:function(res){
			festival2=res;
			cal_inner(res);
			loc_icon(); //더 손봐야됨
		}
	})
}//달력에 넣어줄 축제 내용을 불러옴

function loc_filter(){
	$('fieldset input').change(function(e){
		var name=$(e.target).attr('name');
		$('span[class*='+name+']').toggle();
	});
}//장소와 테마로 필터

function loc_icon(){
	var city_list=['서울','경기','강원','충청','전라','경상','제주'];
	var city_pic=['city-icon-su','city-icon-gg','city-icon-kw','city-icon-cc','city-icon-jr','city-icon-gs','city-icon-jj'];
	var city=$('table tr td span').attr('name');
	
	for(var i=0;i<city_list.length;i++){
	      $('span[class*='+city_list[i]+']').prepend('<img src="images/'+city_pic[i]+'.png" width=22px, height=22px />');
	}
}
