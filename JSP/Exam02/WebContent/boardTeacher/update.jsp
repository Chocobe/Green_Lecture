<%@ page import="com.board.teacher.dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/* request.setCharacterEncoding("UTF-8"); */

String idx = request.getParameter("idx");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String email = request.getParameter("email");
String homepage = request.getParameter("homepage");
String subject = request.getParameter("subject");
String memo = request.getParameter("memo");
String file1 = request.getParameter("file1");
String file2 = request.getParameter("file2");
%>


<%= idx %>, <%= pw %>, <%= name %>, <%= email %>, <%= homepage %>, <%= subject %>, <%= memo %>, <%= file1 %>, <%= file2 %>...


<%
BoardDAO dao = BoardDAO.getInstance();
int result = dao.updateView(idx, pw, name, email, homepage, subject, memo, file1, file2);
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
				alert("수정완료");
				location.href="list.jsp";
			</script>
		
		<% } else { %>
			<script>
				alert("수정실패");
				history.back();
			</script>
		<% } %>
	</body>
</html>