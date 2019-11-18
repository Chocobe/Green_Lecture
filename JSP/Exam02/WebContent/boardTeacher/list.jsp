<%@ page import="java.util.Vector" %>
<%@ page import="com.board.teacher.dao.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
BoardDAO dao = BoardDAO.getInstance();
Vector<BoardDTO> vec = dao.getList();
%>


<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			
			<% for(int i = 0; i < vec.size(); i++) { %>
			<tr>
				<td><%= vec.get(i).getIdx() %></td>
				<td>
					<a href="view.jsp?idx= <%= vec.get(i).getIdx() %>">
						<%= vec.get(i).getSubject() %>
					</a>
				</td>
				<td><%= vec.get(i).getName() %></td>
				<td><%= vec.get(i).getRegDay() %></td>
			</tr>
			<% } %>
		</table>
	
		<input type="button" value="글쓰기" onclick="javascript:location.href='writer.jsp'">
		
	</body>
</html>