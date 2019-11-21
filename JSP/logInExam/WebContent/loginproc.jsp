<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		int idresult = 0; // 0 또는 1 <= 0이면 아이디도 없음
		// select count(*) from logindb where id = id;
		//                                    원       넘
		// dao 만들기
		
		String dbpw="aaa";
		// select pw from logindb where id = id;
		// dao 만들기
		
//		아이디 유무 체크
//		if(idresult<1){
//			session.setAttribute("error", "2");
//		}
		
		if(dbpw.equals(pw)){
			session.removeAttribute("error");
			session.setAttribute("userid", id);
			response.sendRedirect("login.jsp");
		}else{
			session.setAttribute("error", "1");
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>











