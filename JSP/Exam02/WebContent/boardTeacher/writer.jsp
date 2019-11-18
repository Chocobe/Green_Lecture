<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Board Teacher</title>
	</head>

	<body>
		<form action="writeproc.jsp" method="POST">
			<table>
				<tr>
					<td colspan="2">새로 글 쓰기</td>
				</tr>
				
				<tr>
					<td><b>Password</b></td>
					<td><input type="password" name="pw" required></td>
				</tr>
				
				<tr>
					<td><b>Name</b></td>
					<td><input type="text" name="name" required></td>
				</tr>
				
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email"></td>
				</tr>
				
				<tr>
					<td>Homepage</td>
					<td><input type="text" name="homepage"></td>
				</tr>
				
				<tr>
					<td><b>Subject</b></td>
					<td><input type="text" name="subject" required></td>
				</tr>
				
				<tr>
					<td><b>Memo</b></td>
					<td><textarea name="memo" required></textarea></td>
				</tr>
				
				<tr>
					<td>Upload #1</td>
					<td><input type="file" name="file1"></td>
				</tr>
				
				<tr>
					<td>Upload #2</td>
					<td><input type="file" name="file2"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="작성완료">
						<input type="button" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>