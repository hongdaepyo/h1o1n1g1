<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://necolas.github.io/normalize.css/latest/normalize.css">
<link rel="stylesheet" type="text/css" href="css/boardcss.css">
<!-- Magnific Popup core CSS file -->
<link rel="stylesheet" href="css/magnific-popup.css"> 
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- Magnific Popup core JS file -->
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/autosize.js"></script>

<script type="text/javascript">
var board_num;
var rep_num;
var bool_sw = true;
var res1;
var file;
var fes_num;

//board_content 글 체크 시작
function writefnChkByte(obj, maxByte){
	var str = obj.value;
	var str_len = str.length;
	var rbyte = 0;
	var rlen = 0;
	var one_char = "";
	var str2 = "";
	for(var i=0; i<str_len; i++){
		one_char = str.charAt(i);
		if(escape(one_char).length > 4){
			rbyte += 2;//한글2Byte
		}else{
			rbyte++;//영문 등 나머지 1Byte
		}
		if(rbyte <= maxByte){
			rlen = i+1;//return할 문자열 갯수
		}
	}
	if(rbyte > maxByte){
		alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
		str2 = str.substr(0,rlen);//문자열 자르기
		obj.value = str2;
		fnChkByte(obj, maxByte);
	}else{
		document.getElementById('writebyteInfo').innerText = rbyte+"/2000Byte";
	}
}
//board_content 글 체크 끝

//boardupdate_content 글 체크 시작
function updatefnChkByte(obj, maxByte){
	var str = obj.value;
	var str_len = str.length;
	var rbyte = 0;
	var rlen = 0;
	var one_char = "";
	var str2 = "";
	for(var i=0; i<str_len; i++){
		one_char = str.charAt(i);
		if(escape(one_char).length > 4){
			rbyte += 2;//한글2Byte
		}else{
			rbyte++;//영문 등 나머지 1Byte
		}
		if(rbyte <= maxByte){
			rlen = i+1;//return할 문자열 갯수
		}
	}
	if(rbyte > maxByte){
		alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
		str2 = str.substr(0,rlen);//문자열 자르기
		obj.value = str2;
		fnChkByte(obj, maxByte);
	}else{
		document.getElementById('updatebyteInfo').innerText = rbyte+"/2000Byte";
	}
}
//boardupdate_content 글 체크 끝​

$(document).ready(function() {
	$('.board_head').on('change', festival_select);
	$('.board_head_update').on('change', festival_select_update);
	$('.delete').on('click',function(){board_delete(this);});
	$('.rep_delete').on('click',function(){rep_delete(this);});
	$('.rep_insert').on('click', function(){$('.rep_insert_board_num').val($(this).prop("id"));});
	$('.update-openMask').on('click',function(){board_num = $(this).prop("id");});
	$('.rep_update').on('click',function(){rep_num = $(this).prop("id");});
	$('.boardWrite_filename').on('change',function(){imgArr(this);});
	$('.boardUpdate_filename').on('change', function(){imgArr(this);});
	
	//textarea resize 시작
	autosize($('textarea'));
	//textarea resize 끝
	
	//board content 내용 체크 시작
	$(".boardWrite_submit_new").on('click',function(e) {
		var boardWrite_content = $(".boardWrite_content").val();
		if (boardWrite_content == "" || boardWrite_content == null || boardWrite_content == undefined) { 
		alert("내용를 선택해 주세요"); 
		return false; 
		}
	});
	//board_content 내용 체크 끝
	
	//board_content 포커스 이벤트 시작
	$(".boardWrite_content").on('focus',function() {
		if($(this).val() == "내용 입력"){
			$(this).removeClass("boardWrite_content").addClass("boardWrite_content_new");
			$(this).val("");
		}else
		return false;
	});
	$(".boardWrite_content").on('focusout',function() {
		if($(this).val() == "" || $(this).val() == null || $(this).val() == undefined){
			$(this).removeClass("boardWrite_content_new").addClass("boardWrite_content");
			$(this).val("내용 입력");
		}else
			return false;
	});
	//board_content 포커스 이벤트 끝
	
	//boardUpdate_content 내용 체크 시작
	$(".boardUpdate_submit_new").on('click',function(e) {
		var boardUpdate_content = $('.boardUpdate_content').val();
		if (boardUpdate_content == "" || boardUpdate_content == null || boardUpdate_content == undefined) { 
		alert("내용를 선택해 주세요"); 
		return false; 
		}
	});
	//boardUpdate_content 내용 체크 끝

	//boardUpdate_content 포커스 이벤트 시작
	$(".boardUpdate_content").on('focus',function() {
		if($(this).val() == "내용 입력"){
			$(this).removeClass("boardUpdate_content").addClass("boardUpdate_content_new");
			$(this).val("");
		}else
		return false;
	});
	$(".boardUpdate_content").on('focusout',function() {
		if($(this).val() == "" || $(this).val() == null || $(this).val() == undefined){
			$(this).removeClass("boardUpdate_content_new").addClass("boardUpdate_content");
			$(this).val("내용 입력");
		}else
			return false;
	});
	//boardUpdate_content 포커스 이벤트 끝
	
	//rep_content 내용 체크 시작
	$('.rep_insert_new').on('click',function(){
		var rep_text = $(this).prev().val();
		if(rep_text == "" || rep_text == null || rep_text == undefined) {
		alert("내용을 입력하세요");
		return false;
		}
	});
	//rep_content 내용 체크 끝

	//rep_content 포커스 이벤트 시작
	$(".rep_insert_text").on('focus',function() {
		if($(this).val() == "내용 입력"){
			$(this).removeClass("rep_insert_text").addClass("rep_insert_text_new");
			$(this).val("");
		}else
		return false;
	});
	$(".rep_insert_text").on('focusout',function() {
		if($(this).val() == "" || $(this).val() == null || $(this).val() == undefined){
			$(this).removeClass("rep_insert_text_new").addClass("rep_insert_text");
			$(this).val("내용 입력");
		}else
			return false;
	});
	//rep_content 포커스 이벤트 끝
	
	//repupdate_content 내용 체크 시작
	$('.rep_update_insert_new').on('click',function(){
		var rep_text = $(this).prev().val();
		if(rep_text == "" || rep_text == null || rep_text == undefined) {
		alert("내용을 입력하세요");
		return false;
		}
	});
	//repupdate_content 내용 체크 끝

	//repupdate_content 포커스 이벤트 시작
	$(".rep_update_text").on('focus',function() {
		if($(this).val() == "내용 입력"){
			$(this).removeClass("rep_update_text").addClass("rep_update_text_new");
			$(this).val("");
		}else
		return false;
	});
	$(".rep_update_text").on('focusout',function() {
		if($(this).val() == "" || $(this).val() == null || $(this).val() == undefined){
			$(this).removeClass("rep_update_text_new").addClass("rep_update_text");
			$(this).val("내용 입력");
		}else
			return false;
	});
	//repupdate_content 포커스 이벤트 끝

	//board update 창 시작
	function wrapWindowByMask(){
		$('.boardUpdate_board_num').val(board_num);
		var maskHeight = $(document).height();
		var maskWidth = $(window).width();
		var $layerPopupObj = $('.board-window');
		var left = ( $(window).scrollLeft() + ($(window).width() - $layerPopupObj.width()) / 2 );
		var top = ( $(window).scrollTop() + ($(window).height() - $layerPopupObj.height()) / 2 );
		$layerPopupObj.css({'left':left,'top':top, 'position':'absolute'});
		$('body').css('position','relative').append($layerPopupObj);
		$('.board-mask').css({'width':maskWidth,'height':maskHeight});
		$('.board-mask').fadeIn(100);
		$('.board-mask').fadeTo('fast',0.8);
		$('.board-window').show();
	}
	//board update 창 끝
	
	//rep update 창 시작
	function wrapWindowByrepMask(){
		$('.rep_update_rep_num').val(rep_num);
		var repmaskHeight = $(document).height();
		var repmaskWidth = $(window).width();
	 	var $replayerPopupObj = $('.board-rep-window');
		var left = ( $(window).scrollLeft() + ($(window).width() - $replayerPopupObj.width()) / 2 );
		var top = ( $(window).scrollTop() + ($(window).height() - $replayerPopupObj.height()) / 2 );
		$replayerPopupObj.css({'left':left,'top':top, 'position':'absolute'});
		$('body').css('position','relative').append($replayerPopupObj);
		$('.board-mask').css({'width':repmaskWidth,'height':repmaskHeight});
		$('.board-mask').fadeIn(100);
		$('.board-mask').fadeTo('fast',0.8);
		$('.board-rep-window').show();
	}
	//rep update 창 끝
	
	//검은 막 띄우기 시작
	//board 수정
	$(document).on("click",'.update-openMask',function(e){
 		e.preventDefault();
 		wrapWindowByMask();
 		board_param="board_num="+board_num;
 		$.ajax({
			type : 'POST',
			dataType : 'json',
			data : board_param,
			url : 'boardboard.do',
			success : function boardboard(res){
				fes_num = res.festival_num;
				$('.boardUpdate_content').val("");
				$('.boardUpdate_content').val(res.board_content);
				$('.board_head_update').val(res.board_head);
				if(res.board_head == "후기"){
					$('.starstar_update').css("display", "inline");
					$.ajax({
						type : 'POST',
						dataType : 'json',
						url : 'FesList.do',
						success : fesListViewupdate
					});
				}
			}
		});
	});
		
	//board - 검은 막을 눌렀을 때
	$('.board-mask').on("click",function () {
	    $(this).hide();
	    file="";
	    $('.update_holder_arr').empty();
	    $('.festival_name_update').remove();
	    $('.board_head_update').val('일반');
		$('.starstar').css("display", "none");
	    $('.boardUpdate_content').val("");
	    $('.board-window').hide();
	});
	//검은 막 띄우기 끝
	
	//rep 수정
	$(document).on("click",'.rep_update',function(e){
		e.preventDefault();
		wrapWindowByrepMask();
		rep_param="rep_num="+rep_num;
		$.ajax({
			type : 'POST',
			dataType : 'json',
			data : rep_param,
			url : 'reprep.do',
			success : function(res){
				$(".rep_update_text").val(res.rep_content);
			}
		});
	});
	
	//rep - 검은 막을 눌렀을 때
	$('.board-mask').on("click",function () {
	    $(this).hide();
	    $('.board-rep-window').hide();
	});
	//검은 막 띄우기 끝
			
	//게시판 말머리 후기 선택시 축제 이름 SELECT 표시 시작
	function festival_select() {
		if ($(this).val() == '일반') {
			$('.festival_name').remove();
			$('.starstar').css("display", "none");
		} else if ($(this).val() == '문의') {
			$('.festival_name').remove();
			$('.starstar').css("display", "none");
		} else if ($(this).val() == '후기') {
			$('.starstar').css("display", "inline");
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : 'FesList.do',
				success : fesListView
			});
		}
	}
	//게시판 말머리 후기 선택시 축제 이름 SELECT 표시 끝
	
	//게시판 말머리 후기 선택시 축제 이름 SELECT 표시 시작
	function festival_select_update() {
		if ($(this).val() == '일반') {
			$('.festival_name_update').remove();
			$('.starstar_update').css("display", "none");
		} else if ($(this).val() == '문의') {
			$('.festival_name_update').remove();
			$('.starstar_update').css("display", "none");
		} else if ($(this).val() == '후기') {
			$('.starstar_update').css("display", "inline");
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : 'FesList.do',
				success : fesListViewupdate
			});
		}
	}
	//게시판 말머리 후기 선택시 축제 이름 SELECT 표시 끝
	
	//말머리 후기 축제데이터 불러오기 시작
	function fesListView(res){
		$('.festival_name').remove();/* ajax */
		var source = '<select class="festival_name" name="festival_num">';
		$.each(res,function(index, value) {
			source += '<option value="'+value.festival_num+'">'+value.festival_name+'</option>';
		});
		source += '</select>';
		$('.head-input').append(source);
	}
	//말머리 후기 축제데이터 불러오기 끝
	
	//말머리 후기 축제데이터 불러오기 시작
	function fesListViewupdate(res){
		$('.festival_name_update').remove();/* ajax */
		var source = '<select class="festival_name_update" name="festival_num">';
		$.each(res,function(index, value) {
			source += '<option value="'+value.festival_num+'">'+value.festival_name+'</option>';
		});
		source += '</select>';
		$('.head-input-update').append(source);
		$('.festival_name_update').val(fes_num);
	}
	//말머리 후기 축제데이터 불러오기 끝
	
	//말머리 후기 축제데이터 불러오기 시작
	function fesListViewupdate(res){
		$('.festival_name_update').remove();/* ajax */
		var source = '<select class="festival_name_update" name="festival_num">';
		$.each(res,function(index, value) {
			source += '<option value="'+value.festival_num+'">'+value.festival_name+'</option>';
		});
		source += '</select>';
		$('.head-input-update').append(source);
		$('.festival_name_update').val(fes_num);
	}
	//말머리 후기 축제데이터 불러오기 끝
	
	//사진 섬네일 출력 시작
	function imgArr(input) {
 		file = input.files;
		if (file.length == 0) {
			$(input).next().empty();
			return false;
		} else {
			$(input).next().empty();
		}
		for (var i = 0; i < file.length; i++) {
			if (file.length > 4) {
				alert("사진은 4장까지 올릴 수 있습니다.");
				$(input).val("");
				return false;
			} else if (!/\.(jpe?g|png|gif|jpg)$/i.test(file[i].name)) {
				alert("이미지 파일을 넣어주세요.");
				$(input).val("");
				return false;
			}
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = new Image();
				img.src = event.target.result;
				if (img.width > 100) {
					img.width = 100;
				}
				var iimmgg1 = $('img:eq(0)').attr("src");
				var iimmgg2 = $('img:eq(1)').attr("src");
				var iimmgg3 = $('img:eq(2)').attr("src");
				var iimmgg4 = $('img:eq(3)').attr("src");
				if(iimmgg1 == img.src)
					return false
				else if(iimmgg2 == img.src)
					return false
				else if(iimmgg3 == img.src)
					return false
				else if(iimmgg4 == img.src)
					return false
				else
				$(input).next().append(img);
			};
		reader.readAsDataURL(file[i]);
		}
		return false;
	}
	//사진 섬네일 출력 끝
	
	//사진 표시 시작
	$('.image-popup-fit-width').magnificPopup({
		type: 'image',
		closeOnContentClick: true,
		image: {verticalFit: false}
	});
	//사진 표시 끝
	
	//사진 출력 시작
	function picView(){
		$.ajax({
			type : 'get',
			url : 'boardpic.do',
			data : 'board_num='+currpage,
			success : function(res){
			}
		});
	};
	//사진 출력 끝
	
	//게시판 글 삭제 시작
	function board_delete(input) {
		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : 'boardDelete.do',
			data : 'board_num='+$(input).prop("id"),
			complete : reload
		});
	}
	//게시판 글 삭제 끝
	
	//댓글 삭제 시작
	function rep_delete(input) {
		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : 'repDelete.do',
			data : 'rep_num='+$(input).prop("id"),
			complete : reload
		});
	}
	//댓글 삭제 끝
	
	//새로고침 시작
	function reload(){
		location.reload();
	}
	//새로고침 끝
	
	//스크롤 최하단 체크 시작
	$(window).scroll(function() {
   		var maxHeigth = $(document).height();
   		var currentScroll = $(window).scrollTop() + $(window).height();
   		if(maxHeigth <= currentScroll+1){
   			if(bool_sw){
   				bool_sw = false;
   				setTimeout(function(){bool_sw = true;},1000);
   				lastPostFunc();
   			}
   		}
	});
	//스크롤 최하단 체크 끝
	
	
	//별점 표시 시작
	var idx=0;
	//star_rating();
	$('.star_input').on("mouseenter", function(){
		star_rating();
		$(this).on("mouseleave", function(){
			console.log(idx);
			$('.star_input span:lt('+idx+'):even').addClass('over-left');
			$('.star_input span:lt('+idx+'):odd').addClass('over-right');
			$('div span').off();
		});
	});

	function star_rating(){
		$('.star_input span').removeClass('over-left');
		$('.star_input span').removeClass('over-right');
		$('.star_input span').mouseenter(function(e){
			var i=$(e.target).index()+1;
			var score=(i/2).toFixed(1);
			idx=i;
			$('.favor_star').val(score);
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
	//별점표시 끝
	
	//update별점 표시 시작
	var idx_update=0;
	//star_rating();
	$('.star_input_update').on("mouseenter", function(){
		star_rating_update();
		$(this).on("mouseleave", function(){
			console.log(idx_update);
			$('.star_input_update span:lt('+idx_update+'):even').addClass('over-left-update');
			$('.star_input_update span:lt('+idx_update+'):odd').addClass('over-right-update');
			$('div span').off();
		});
	});

	function star_rating_update(){
		$('.star_input_update span').removeClass('over-left-update');
		$('.star_input_update span').removeClass('over-right-update');
		$('.star_input_update span').mouseenter(function(e){
			var i=$(e.target).index()+1;
			var score=(i/2).toFixed(1);
			idx_update=i;
			$('.favor_star_update').val(score);
			$('.star_input_update span:lt('+i+'):even').addClass('over-left-update');
			$('.star_input_update span:lt('+i+'):odd').addClass('over-right-update');
		}).mouseleave(function(e){
			var i=$(e.target).index()+1;
			$('.star_input_update span:lt('+i+'):even').removeClass('over-left-update');
			$('.star_input_update span:lt('+i+'):odd').removeClass('over-right-update');
		}).click(function(e){
			var i=$(e.target).index()+1;
			$('div span').off();
			//별점으로 i 값 넘겨주면 됨
		});
	}
	//update별점표시 끝	
	
});

//무한스크롤 페이징 시작
function lastPostFunc(){
	$("div#lastPostsLoader").html("로딩중...로딩중...로딩중...로딩중...로딩중...로딩중...");
	var currpage = 1;
	currpage *= 1;
	currpage += Number($(".board-view-main:last").attr("name"));
	$("script:gt(0)").remove();
	$.ajax({
		type : 'get',
		url : 'boardList.do',
		data : 'currentPage='+currpage,
		success : function(res){
			if (res != res1) {
				res1 = res;
				$(".board-view:last").after(res);
				picview();
				$(".boardwrite-input:gt(0)").remove();
				$(".update:gt(0)").html("");
				$(".board-mask:gt(0)").remove();
				$("hr:gt(0)").remove();
				$("script:gt(0)").remove();
				$(".wrap:gt(0)").html("");
			}
			$("div#lastPostsLoader").remove();
			$("script:gt(0)").remove();
		}
	});
};
//무한스크롤 페이징 끝

	//사진 배치 시작
	function picview(){
		for(var i=0; i<$(".true").length; i++){
			if($(".true:eq("+i+")").attr("val") == 4){
				//console.log($(".true:eq("+i+")").attr("val"));
				$(".picpic:eq("+i+") img").css("display","inline").css("margin","1px").css("border-radius","10px");
				$(".picpic:eq("+i+") a:nth-of-type(1) img").css("margin","1px").css("width","620px").css("height","455px").css("float","left");
				$(".picpic:eq("+i+") a:nth-of-type(2) img").css("margin","1px").css("margin-left","5px").css("width","220px").css("height","150px").css("position","absolute").css("float","right");
				$(".picpic:eq("+i+") a:nth-of-type(3) img").css("margin","1px").css("margin-left","5px").css("width","220px").css("height","150px").css("margin-top","153px").css("position","absolute").css("float","right");
				$(".picpic:eq("+i+") a:nth-of-type(4) img").css("margin","1px").css("margin-left","5px").css("width","220px").css("height","150px").css("margin-top","305px");
			}
			if($(".true:eq("+i+")").attr("val") == 3){
				//console.log($(".true:eq("+i+")").attr("val"));
				$(".picpic:eq("+i+") img").css("display","inline").css("margin","1px").css("border-radius","10px");
				$(".picpic:eq("+i+") a:nth-of-type(1) img").css("margin","1px").css("width","620px").css("height","455px").css("float","left");
				$(".picpic:eq("+i+") a:nth-of-type(2) img").css("margin","1px").css("margin-left","5px").css("width","220px").css("height","226px").css("position","absolute").css("float","right");
				$(".picpic:eq("+i+") a:nth-of-type(3) img").css("margin","1px").css("margin-left","5px").css("width","220px").css("height","226px").css("margin-top","229px");
			}
			if($(".true:eq("+i+")").attr("val") == 2){
				//console.log($(".true:eq("+i+")").attr("val"));
				$(".picpic:eq("+i+") img").css("display","inline").css("margin","1px").css("border-radius","10px");
				$(".picpic:eq("+i+") a:nth-of-type(1) img").css("margin","1px").css("width","421px").css("float","left");
				$(".picpic:eq("+i+") a:nth-of-type(2) img").css("margin","1px").css("margin-left","5px").css("width","421px");
			}
			if($(".true:eq("+i+")").attr("val") == 1){
				//console.log($(".true:eq("+i+")").attr("val"));
				$(".picpic:eq("+i+") img").css("display","inline").css("margin","1px").css("border-radius","10px");
				$(".picpic:eq("+i+") a:nth-of-type(1) img").css("margin","1px").css("width","850px");
			}
			if($(".true:eq("+i+")").attr("val") == 0){
				//console.log($(".true:eq("+i+")").attr("val"));
				$(".picpic:eq("+i+") img").css("display","inline").css("margin","1px").css("border-radius","10px");
			}
		}
	}
	//사진 배치 끝

</script>
</head>
<body onkeypress="if(event.keyCode==13)" onload="picview()">



<div class="wrap">
   <div id="header">
     <ul class="logo">
       <li><a href="main.do"><img src="icon/main2.png" /></a></li>
       <li class="lo"><img src="icon/logo_text.png"/></li>  
     </ul>     
   </div>

   
   <div id="gnb">     
   </div>
   
   <div id="text">
    <img src="image/notice_board.png"/>
   </div>
</div>


<div class="board-mask"></div>
	<div class="update">
		<!-- board 수정 시작 -->
		<div class="board-window">
			<form class="board_update_mainform" action="boardUpdate.do" method="post" enctype="multipart/form-data">
			<div class="board-update-input">
				<table>
					<tr>
						<th>말머리</th>
						<td class="head-input-update">
						<select class="board_head_update" name="board_head">
							<option value="일반" selected>일반</option>
							<option value="문의">문의</option>
							<option value="후기">후기</option>
						</select>
						<div class="starstar_update">
						<div class="star_input_update">
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
						</div>
					<input type="hidden" class="favor_star_update" name="favor_star" />
					</td>
					</tr>
					<tr>
						<% String mem_nick=(String)session.getAttribute("mem_nick"); %>
						<th><%=mem_nick %></th><!-- 로그인 시 닉네임 출력 -->
						<td><textarea class="boardUpdate_content" name="board_content" cols="100" rows="10" style="resize: none" onKeyUp="javascript:updatefnChkByte(this,'2000')">내용 입력</textarea>
						<span id="updatebyteInfo">0/2000Byte</span></td>
					</tr>
					<tr>
						<th>사진 추가</th>
						<td><input type="file" class="boardUpdate_filename btn" name="board_filename" multiple="multiple" />
						<div class="update_holder_arr"></div></td>
					</tr>
				</table>
			</div>
			<input type="hidden" class="boardUpdate_board_num" name="board_num" />
			<input type="submit" class="boardUpdate_submit btn" value="수정" />
		</form>
	</div>
	<!-- board 수정 끝 -->

	<!-- rep 수정 시작 -->
	<div class="board-rep-window">
		<form action="repUpdate.do" method="post">
			<table>
				<tr>
					<th><%=mem_nick %></th>
					<td><input type="hidden" class="rep_update_rep_num" name="rep_num" />
						<input type="text" size="85" class="rep_update_text" name="rep_content" value="내용 입력"/>
						<input type="submit" class="rep_update_insert" value="댓글 수정"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- rep 수정 끝 -->
</div>
	<c:if test="${sessionScope.mem_num !=null}">
	<!-- board 입력창 시작 -->
	<div class="boardwrite-input">
		<form class="board_write_mainform" action="boardWrite.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>말머리</th>
					<td class="head-input">
						<select class="board_head" name="board_head">
							<option value="일반" selected>일반</option>
							<option value="문의">문의</option>
							<option value="후기">후기</option>
						</select>
						<div class="starstar">
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
						</div>
					<input type="hidden" class="favor_star" name="favor_star" />
					</td>
				</tr>
				<tr>
					<th><%=mem_nick %></th><!-- 로그인 시 닉네임 출력 -->
					<td><textarea class="boardWrite_content" name="board_content" cols="100" rows="3" style="resize: none" onKeyUp="javascript:writefnChkByte(this,'2000')" >내용 입력</textarea>
					<span id="writebyteInfo">0/2000Byte</span></td>
				</tr>
				<tr>
					<th>사진 추가</th>
					<td><input type="file" class="boardWrite_filename btn" name="board_filename" multiple="multiple" />
					<div class="write_holder_arr"></div></td>
				</tr>
				<tr>
					<!-- <th>맴버 번호</th> -->
					<td><input type="hidden" class="mem_num" name="mem_num" value="${sessionScope.mem_num}"/></td>
				</tr>
			</table>
			<input type="submit" class="boardWrite_submit btn" value="게시" />
		</form>
	</div>
	<hr class="board_hr"/>
	<!-- board 입력창 끝 -->
	</c:if>
	
	<div class="board-view">
		<c:forEach items="${list}" var="BoardDTO">
		
			<!-- 게시글 출력 시작 -->
			<div class="board-view-main" name="${pv.currentPage}" >
				<div class="board-view-main-list">
					<c:forEach items="${BoardDTO.memList}" var="MemDTO">
						<p class="board_nickname">${MemDTO.mem_nickname}</p>
					</c:forEach>
					<p class="vv">/</p>
					<p class="bhead">${BoardDTO.board_head}</p>
					<c:if test="${BoardDTO.festival_num != 1}">
					<p class="vv">/</p>
						<c:forEach items="${BoardDTO.fesList}" var="FestivalDTO">
							<p class="fname">${FestivalDTO.festival_name}</p>
						</c:forEach>
					</c:if>
					<p class="days"><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${BoardDTO.board_date}" /></p>
					<p><textarea class="" name="content" cols="110" readonly="readonly" style="resize: none">${BoardDTO.board_content}</textarea></p>
						<c:if test="${not empty BoardDTO.board_pic}">
						<div class="picpic">
						<c:forEach items="${BoardDTO.board_pic}" var="img" varStatus="status">
						<p class="${status.last}" val="${status.count}" ></p>
							<a title="" class="image-popup-fit-width" href="image.do?filename=${img}">
							<img alt="" src="image.do?filename=${img}" />
							</a>
						</c:forEach>
						</div>
						</c:if>
					<c:if test="${BoardDTO.mem_num eq sessionScope.mem_num}">
						<div class="board-view-main-btn">
							<input type="button" class="update-openMask btn" id="${BoardDTO.board_num}" value="수정"/>
							<input type="button" class="delete btn" id="${BoardDTO.board_num}" value="삭제" />
						</div>
					</c:if>
				</div>
				<!-- 게시글 출력 끝 -->
				
				<c:if test="${sessionScope.mem_num !=null}">
				<!-- 댓글 입력창 시작 -->
				<div class="board-view-main-rep">
					<form action="repWrite.do" method="post">
						<table>
							<tr>
								<th>${sessionScope.mem_nickname}</th><!-- 로그인 시 닉네임 출력 -->
								<td><input type="hidden" name="mem_num" value="${sessionScope.mem_num}" />
								<input type="hidden" class="rep_insert_board_num" name="board_num" />
								<input type="text" size="95" class="rep_insert_text" name="rep_content" value="내용 입력"/>
								<input type="submit" class="rep_insert btn" id="${BoardDTO.board_num}" value="댓글 게시"></td>
							</tr>
						</table>
					</form>
				</div>
				<!-- 댓글 입력창 끝 -->
				</c:if>
			</div>
			
			<!-- 댓글 출력 시작 -->
			<div class="board-view-reply">
				<c:forEach items="${BoardDTO.replyList}" var="ReplyDTO">
					<c:if test="${BoardDTO.board_num eq ReplyDTO.board_num}">
						<div class="reply-view">
						<div class="board-view-reply-list">
							<c:forEach items="${ReplyDTO.rmemList}" var="RmemDTO">
								<p class="rep_nickname">${RmemDTO.mem_nickname}</p>
							</c:forEach>
							<%-- <p>${ReplyDTO.rep_num}</p> --%>
							<p class="days"><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${ReplyDTO.rep_date}" /></p>
							<p><textarea class="rep_content_update" name="rep_content" rows="1" cols="110" readonly="readonly" style="resize: none">${ReplyDTO.rep_content}</textarea></p>
						</div>
						<c:if test="${ReplyDTO.mem_num eq sessionScope.mem_num}">
						<div class="board-view-reply-rep_btn">
							<input type="button" class="rep_update btn" id="${ReplyDTO.rep_num}" value="댓글 수정" />
							<input type="button" class="rep_delete btn" id="${ReplyDTO.rep_num}" value="댓글 삭제" />
						</div>
						<br />
						</c:if>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<!-- 댓글 출력 끝 -->
			
			<br />
		</c:forEach>
	</div>
	<div id="lastPostsLoader"></div>
</body>
</html>