# 요약

>	## lib파일

*	``commons-dbcp-1.4.jar`` : dbcp를 사용하기 위한 jar

*	``commons-pool-1.6.jar`` : dbcp를 사용하기 위한 jar

*	``mysql-connector-java-8.0.13.jar`` : mySQL을 사용하기 위한 컨넥션

---

>	## mysql연동 시, ``timezone``에러가 발생한다면  

*	에러 : The server time zone value ‘KST’ is unrecognized or represents more than one time zone : 

*	원인 : mysql-connector-java 버전 5.1.X 이후 버전부터 KST 타임존을 인식하지 못하는 이슈

*	DataSource객체의 URL값을 다음과 같이 변경한다 

	* 기존 URL : "jdbc:mysql://localhost:3307/test"
	
	* 수정 URL : ds.setUrl("jdbc:mysql://localhost:3307/test?serverTimezone=UTC"
	
*	driverClassName을 다음과 같이 변경한다.

	* 기존 driverClassName : "com.mysql.jdbc.Driver"
	
	* 수정 driverClassName : "com.mysql.cj.jdbc.Driver"

*	에러수정 참조 페이지 : https://yenaworldblog.wordpress.com/2018/01/24/java-mysql-%EC%97%B0%EB%8F%99%EC%8B%9C-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-%EC%97%90%EB%9F%AC-%EB%AA%A8%EC%9D%8C/

	* apache설치 폴더의 ``lib``에 직접 ``mysql-connector-java-xxx.jar``를 넣어주기.
	
		* 아파치 서버의 라이브러리에 직접 ``mysql-connector-java-xxx.jar``파일을 넣는 방식이다. (위의 수정사항이 필요없어진다)
		
---

>	## MySQL Tablem 인코딩 설정하기

1.	테이블 우클릭 -> ``편집``

1.	``조합``의 값을 ``utf8_general_ci``로 설정 (지금까지 사용했던 ``UTF-8``로 설정됨)

---

>	## 게시판 작성 과정(순서)
>
>	1. 게시글 작성 구현 (게시글 insert 기능)
>
>	1. 게시글 목록 구현
>
>	1. 게시글에 대한 기능 구현 (게시글 delete, update 기능)
>
>	1. 페이징 처리

1.	DB 테이블 생성

1.	DAO 생성 - DB에 연결까지만

1.	게시판 작성 페이지 (JSP) 생성 및 작성

1.	작성한 게시글 처리 페이지 (JSP) 생성 및 작성 (값이 넘어오는지만 테스트)

1.	게시판 리스트 페이지(JSP - 게시판 글 목록) 생성 - ``글쓰기`` 버튼만 만들기

1.	DAO 메소드 작성 - ``insertBoard()`` - 글 작성하기 메소드

1.	게시판 리스트 페이지에서 ``<table>``로 틀만 만들어 두기

1.	DAO 메소드 작성 - ``getList()`` - 전체 글 가져오기

1.	가져온 전체 글 -> 게시판 리스트 페이지에 출력하기

	* ``for(;;) { }``반복문을 사용하여 출력
	
	* 출력한 글의 제목은 ``<a>``태그를 이용하여, 해당 게시물 페이지로 이동하도록 작성(``질의 문자열``에 idx값을 넘겨줘서 DB에서 게시물을 찾는다)
	
1.	각 게시물의 수정, 삭제 기능 추가하기.

	* ```xml
		<form name="frm">
			<input type="button" value="수정" onclick="update()">
			<input type="button" value="삭제" onclick="delete()">
		</form>
		
		<script>
			function update() {
				frm.action="update.jsp";
				frm.submit();
			}
			
			function delete() {
				frm.action="delete.jsp";
				frm.submit();
			}
		</script>
	```
	
*	버튼 만들기 -> 특정 페이지, 또는 이전페이지

	```xml
		<!-- 특정 페이지 -->
		<input type="button" onclick="javascript:location.href='writer.jsp'">
		
		<!-- 이전 페이지 -->
		<input type="button" onclick="javascript:history.back()">
	```
	
---

>	## 파일 업로드

>	### View 작성

*	``cos.jar``파일 사용 (servlets.com에서 다운)

*	파일 업로드를 위해 View의 ``<form>``속성에 ``enctype="multipart/form-data"``를 추가.

*	위의 ``<form>``에 속한 ``<input>``태그 중, ``type="file"``속성이 지정된 ``<input>``태그로 파일 업로드 등록

>	### Controller 작성

*	``<form enctype="multipart/form-data">``의 질의문자열은 ``MultipartRequest``객체를 통해서 가질 수 있다.

*	```java
		MultipartRequest multi = new MultipartRequest(request, 저장경로, 파일최대크기, 인코딩값, new DefaultFileRenamePolicy());
	```
	
*	``MultipartRequest``객체의 ``getParameter("속성명")``으로 질의문자열을 가져온다.

*	```java
		MultipartRequest multi = new MultipartRequest(req, "/경로/", 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		
		// <form>태그의 "name"속성값들을 가져오는 부분
		Enumeration<String> names = multi.getFileNames();
		
		while(names.hasMoreElements()) {
			// 현재 커서의 <form>태그 "name"속성값을 가져온다.
			String name = names.nextElement();
			
			// DefaultFileRenamePolicy 객체에 의해 변경된 실제 파일명을 가져온다.
			String fileName = multi.getFilesystemName(name);
			
			// 사용자가 업로드한 실제 파일명을 가져온다.
			String fileOriginName = multi.getOriginalFileName(name);
			
			// 업로드된 파일을 <img>태그로 출력한다.
			out.print("<img src='경로/fileName'>");
		}
	```
	
---
	
>	## 업로드된 파일 삭제하기

*	업로드가 완료된 파일을 삭제하기 위해서는, 해당 파일을 가져온 후, 삭제를 해야 한다.

*	```java
		File file = new File("경로/저장된 파일명");
		
		if(file.exists()) {
			file.delete();
		}
	```
	