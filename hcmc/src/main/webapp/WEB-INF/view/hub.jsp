<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	if ('${param.ecode}' != null&&'${param.mem_num}'!=null) {
		var ecode = '${param.ecode}';
		var mem_num = '${param.mem_num}';
		mail_auth(ecode,mem_num);
	}
});

function mail_auth(ecode, mem_num){
	var url = "authChange.do?ecode="+ecode+"&mem_num="+mem_num;
	$(location).attr('href',url);
}
	
</script>
</head>
<body>

</body>
</html>