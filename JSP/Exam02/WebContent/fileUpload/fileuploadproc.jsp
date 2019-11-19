<%@ page import="java.io.File"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

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
		try {
		
		String saveDir = application.getRealPath("upload");
		int maxPostSize = 1024 * 1024 * 10;
		
		// MultipartRequest객체 생성하는 동작으로, 업로드가 완료 된다.
		MultipartRequest multi = new MultipartRequest(request,
													  saveDir,
													  maxPostSize,
													  "UTF-8",
													  new DefaultFileRenamePolicy());
		
		out.println("파일저장 성공<br/><br/>");
		String uname = multi.getParameter("uname");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		out.println(uname + "<br/>");
		out.println(title + "<br/>");
		out.println(content + "<br/>");
		
		
		@SuppressWarnings("unchecked")
		Enumeration<String> files = multi.getFileNames();
		String fileName = (String)files.nextElement();
		
		out.println("파일명 : " + multi.getFilesystemName(fileName) + "<br/>");
		out.println("원본파일명 : " + multi.getOriginalFileName(fileName) + "<br/>");
		
		
		// 파일 다운로드
		File obj = multi.getFile(fileName);
		
		if(obj.exists()) {
			// 파일 업로드 성공 여부 검사
			
			out.println("파일크기 : " + obj.length() + "<br/>");
			out.println("파일명 : " + obj.getName() + "<br/>");
			out.println("경로 + 파일명 : " + obj.getPath() + "<br/>");
		}
		%>
		
		<a href="../upload/<%= obj.getName() %>"><%= obj.getName() %></a>
		
		<% } catch(Exception e) { 
			e.printStackTrace();
		} %>
		
		
		
		<%
		// 저장된 파일 지우기
		/*
			// 파일 생성 시, 경로와 파일명을 인자값으로 넣어 해당 파일을 가져온다.
			File file = new File(saveFolder + fileName);
		
			// 파일이 있다면,
			if(file.exists()) {
				file.delete();
			}
		*/		
		%>
		
	</body>
</html>