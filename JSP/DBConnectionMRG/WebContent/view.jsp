<%@ page import="com.board.teacher.dao.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<% 
		String idx = request.getParameter("idx"); 
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.getView(idx);
		%>
		
		<form method="post" name="frm">
			<table>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pw"></td>
				</tr>
				
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%= dto.getName() %>" readonly></td>
				</tr>
				
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email" value="<%= dto.getEmail() %>"></td>
				</tr>
				
				<tr>
					<td>Homepage</td>
					<td><input type="text" name="homepage" value="<%= dto.getHomepage() %>"></td>
				</tr>
				
				<tr>
					<td>Subject</td>
					<td><input type="text" name="subject" value="<%= dto.getSubject() %>"></td>
				</tr>
				
				<tr>
					<td>Memo</td>
					<td><textarea name="memo"><%= dto.getMemo() %></textarea></td>
				</tr>
				
				<tr>
					<td>file1</td>
					<td><input type="file" name="file1" value="<%= dto.getFile1() %>"></td>
				</tr>
				
				<tr>
					<td>file2</td>
					<td><input type="file" name="file2" value="<%= dto.getFile2() %>"></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="update1()">
						<input type="button" value="삭제" onclick="delete1()">
						<input type="button" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
			
			<input type="hidden" name="idx" value="<%= idx %>">
		</form>
		
		
		<script>
			function update1() {
				frm.action="update.jsp";
				frm.submit();
			} 
			
			
			function delete1() {
				frm.action="delete.jsp";
				frm.submit();
			}
		</script>
	</body>
</html>















