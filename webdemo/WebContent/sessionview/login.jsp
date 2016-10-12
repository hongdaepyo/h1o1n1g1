<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String logOk = (String) session.getAttribute("logOk");
		String ck = request.getParameter("ck");
		if (logOk == null) {
			if (ck == null || ck.equals("2")) {
	%>
	<div class="login">
		<form action="logPro" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pass" id="pass"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="로그인"> <input type="reset" value="취&nbsp;&nbsp;소"></td>
				</tr>
			</table>
		</form>
	</div>
	<%
		}
		} else {
	%>
	<div class="logout">
		<p>
			<a href="logout">로그아웃</a>
		</p>
	</div>
	<%
		}
	%>

</body>
</html>