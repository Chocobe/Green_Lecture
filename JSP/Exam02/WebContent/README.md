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

1.	``조합``의 값을 ``utf8mb4_general_ci``로 설정 (지금까지 사용했던 ``UTF-8``로 설정됨)

---

>	## 게시판 작성 과정(순서)

1.	DB 테이블 생성

1.	DAO 생성 - DB에 연결까지만

1.	게시판 작성 페이지 (JSP) 생성 및 작성

1.	작성한 게시글 처리 페이지 (JSP) 생성 및 작성 (값이 넘어오는지만 테스트)

1.	게시판 리스트 페이지(JSP - 게시판 글 목록) 생성 - ``글쓰기`` 버튼만 만들기

1.	DAO 메소드 작성 - ``insertBoard()`` - 글 작성하기 메소드

1.	게시판 리스트 페이지에서 ``table``로 틀만 만들어 두기

1.	DAO 메소드 작성 - ``getList()`` - 전체 글 가져오기

1.	가져온 전체 글 -> 게시판 리스트 페이지에 출력하기