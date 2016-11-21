$(function(){
	/* 현재 날짜와 현재 달에 1일의 날짜 객체를 생성합니다. */
	var date = new Date(); // 날짜 객체 생성
	var y = date.getFullYear(); // 현재 연도
	var m = date.getMonth(); // 현재 월
	//var d = date.getDate(); // 현재 일
	//console.log(theDate);
	var row;

	var cal = function() {
		var theDate = new Date(y, m, 1);
		var theDay = theDate.getDay();
		var last = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
		var lastDate = last[m];
		row = Math.ceil((theDay + lastDate) / 7);
		console.log(theDay, lastDate);
		if (y % 4 && y % 100 != 0 || y % 400 === 0) {
			lastDate = last[1] = 29;
		}

		//문자 결합 연산자를 사용해 요일이 나오는 행을 생성합니다.
		var calendar = "<table class='calendar_table'>";
		calendar += "<tr>";
		calendar += "<strong> <h1>" + y + ". " + (m + 1) + "</h1> </strong>";
		calendar += "</tr>";

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
					calendar += "<td>" + dNum+"<div class='"+dNum+"' ><span name=''>축제추가</span></div>" + "</td>";
					dNum++;
				}
			}
			calendar += "</tr>";
		}
		calendar += "</table>";

		$('.cal').html(calendar);
		//document.write(calendar);
	}

	cal();
	
	$('#prev_btn').click(function() {
		if(m<=0){
			y--;m=11;cal();
		}else{
		m--;cal();
		}
	});
	
	$('#next_btn').click(function() {
		if(m>=11){
			y++;m=0;cal();col();
		}else{
		m++;cal();
		}
	}); 
	
	$('#today_btn').click(function(){
		y=date.getFullYear();
		m=date.getMonth();
		cal();
	});
	
});

function cal(){
	
}