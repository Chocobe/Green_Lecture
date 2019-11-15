<%@page import="com.logIn_practice.MyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
%>

<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
		이전 페이지에서 넘어온 값 :<br/>
		ID : <%= id %><br/>
		PW : <%= pw %><br/>
		Name : <%= name %><br/>
		Email : <%= email %><br/>
		Phone : <%= phone %><br/>
		
		<%
		MyDAO dao = MyDAO.getInstance();
		int result = dao.insertMember(id, pw, name, email, phone);
		
		if(result > 0) {
		%>
		
			회원가입 완료
			
		<% } else { %>
		
			회원가입 에러
		<% } %>
		
		
		<a href="logInTest_totalData.jsp">전체 회원</a>
	</body>
</html>