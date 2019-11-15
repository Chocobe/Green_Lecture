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