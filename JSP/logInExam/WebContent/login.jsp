<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginproc.jsp">
	로그인한 아이디:<%=session.getAttribute("userid") %><br>
	<%
		if(session.getAttribute("error")!=null
			&&session.getAttribute("error").equals("1")
		){
	%>
		<script>
			alert("로그인에 실패했습니다. 아이디와 비밀번호를 확인해 주세요");
		</script>
	<%		
		}
	
		 if(session.getAttribute("userid")==null){
	%>		
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입">
	<%
		 }else{
	%>
		<input type="button" value="로그아웃" 
	onclick="javascript:location.href='logout.jsp'">
	<%
		 }
	%>
	</form>
</body>
</html>












