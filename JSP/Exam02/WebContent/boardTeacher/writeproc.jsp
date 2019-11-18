<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.board.teacher.dao.*" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<%
		/* request.setCharacterEncoding("UTF-8"); */
		
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String memo = request.getParameter("memo");
		String file1 = request.getParameter("file1");
		String file2 = request.getParameter("file2");
		%>
		
		<%= pw %>, <%= name %>, <%= email %>, <%= homepage %>, <%= subject %>, <%= memo %>, <%= file1 %>, <%= file2 %>
		
		
	<!-- 로직 -->
		<%
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.insertBoard(pw, name, email, homepage, subject, memo, file1, file2);
		
		if(result > 0) {
			response.sendRedirect("list.jsp");
			
		} else { %>
			<script>alert("문제발생");</script>
		<% response.sendRedirect("list.jsp");
		
		} %>
		
	</body>
</html>