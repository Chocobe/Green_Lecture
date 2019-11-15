<%@page import="com.logIn_practice.MyDTO"%>
<%@page import="com.logIn_practice.MyDAO"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체회원 정보</h1>
	<h2>연습</h2>
	
	<hr/>
	
	<%
	MyDAO dao = MyDAO.getInstance();
	List<Map<String, String>> result = dao.getDatas();
	
	Iterator<Map<String, String>> iterator = result.iterator();
	
	while(iterator.hasNext()) {
		Map<String, String> currentDatas = iterator.next();
		
		String id = currentDatas.get("id");
		String pw = currentDatas.get("pw");
		String email = currentDatas.get("email");
		String name = currentDatas.get("name");
		String phone = currentDatas.get("phone");
		
		out.print("<p>ID : " + id + "</p>");
		out.print("<p>PW : " + pw + "</p>");
		out.print("<p>Email : " + email + "</p>");
		out.print("<p>Name : " + name + "</p>");
		out.print("<p>Phone : " + phone + "</p>");
		
		out.print("<hr/>");
	}
	
	%>
	
	<hr/>
	
	<h2>선생님</h2>
	
	<hr/>
	
	<%
	MyDAO dao2 = MyDAO.getInstance();
	Vector<MyDTO> v = dao.getMembers();
	%>
	
	<br/>현재 가입한 회원들<br/>
	전체 : <%= v.size() %><br>
	<%
	for(int i = 0; i < v.size(); i++) {
	%>
		<%= v.get(i).getIdx() %>,
		<%= v.get(i).getId() %>,
		<%= v.get(i).getPw() %>,
		<%= v.get(i).getEmail() %>,
		<%= v.get(i).getName() %>,
		<%= v.get(i).getPhone() %>
		<br/>
	<% } %>
</body>
</html>