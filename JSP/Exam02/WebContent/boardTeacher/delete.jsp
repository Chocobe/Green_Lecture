<%@ page import="com.board.teacher.dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
String idx = request.getParameter("idx");
BoardDAO dao = BoardDAO.getInstance();
int result = dao.deleteView(idx);
%>


<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<%
		if(result > 0) { %>
			<script>
				alert("지웠다!");
				location.href="list.jsp";
			</script>
			
		<% } else { %>
			<script>
				alert("지우기 싫패");
				location.href="list.jsp";
			</script>
			
		<% } %>
	</body>
</html>