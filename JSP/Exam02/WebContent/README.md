# ���

>	## lib����

*	``commons-dbcp-1.4.jar`` : dbcp�� ����ϱ� ���� jar

*	``commons-pool-1.6.jar`` : dbcp�� ����ϱ� ���� jar

*	``mysql-connector-java-8.0.13.jar`` : mySQL�� ����ϱ� ���� ���ؼ�

---

>	## mysql���� ��, ``timezone``������ �߻��Ѵٸ�  

*	���� : The server time zone value ��KST�� is unrecognized or represents more than one time zone : 

*	���� : mysql-connector-java ���� 5.1.X ���� �������� KST Ÿ������ �ν����� ���ϴ� �̽�

*	DataSource��ü�� URL���� ������ ���� �����Ѵ� 

	* ���� URL : "jdbc:mysql://localhost:3307/test"
	
	* ���� URL : ds.setUrl("jdbc:mysql://localhost:3307/test?serverTimezone=UTC"
	
*	driverClassName�� ������ ���� �����Ѵ�.

	* ���� driverClassName : "com.mysql.jdbc.Driver"
	
	* ���� driverClassName : "com.mysql.cj.jdbc.Driver"

*	�������� ���� ������ : https://yenaworldblog.wordpress.com/2018/01/24/java-mysql-%EC%97%B0%EB%8F%99%EC%8B%9C-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-%EC%97%90%EB%9F%AC-%EB%AA%A8%EC%9D%8C/

	* apache��ġ ������ ``lib``�� ���� ``mysql-connector-java-xxx.jar``�� �־��ֱ�.
	
		* ����ġ ������ ���̺귯���� ���� ``mysql-connector-java-xxx.jar``������ �ִ� ����̴�. (���� ���������� �ʿ��������)