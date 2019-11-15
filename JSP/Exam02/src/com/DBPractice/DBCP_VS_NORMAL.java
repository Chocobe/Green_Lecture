package com.DBPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCP_VS_NORMAL {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private static BasicDataSource ds;
	
	static {
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("1111");
		ds.setUrl("jdbc:mysql://localhost:3307/test?serverTimezone=UTC");

		// Connection Pool에 만들어 놓을 Connection개수 (개수 초기화)
		ds.setInitialSize(20);
		
		// 동시 접속 수
		ds.setMaxActive(20);
		
		// 쉬는 Connection은 20개로  (노는 Connection이 20개를 넘으면, 넘는것을 해제해 버린다)
		ds.setMaxIdle(20);
		
		// 최소 보유 Connection개로
		ds.setMinIdle(10);
	}
	
	public static void normal() {
		Connection conn = null;
		long time = System.currentTimeMillis();
		
		for(int i = 0; i < 1000; i++) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/test?serverTimezone=UTC", "root", "1111");
				
			} catch(SQLException e) {
				e.printStackTrace();
				
			} finally {
				try {
					conn.close();
					
				} catch(SQLException e) { }
			}
		}
		
		time = System.currentTimeMillis() - time;
		System.out.println("normal : " + time);
	}
	
	
	public static void dbcp() {
		long time = System.currentTimeMillis();
		Connection conn = null;
		
		for(int i = 0; i < 1000; i++) {
			try {
				conn = ds.getConnection();
				
			} catch(SQLException e) {
				e.printStackTrace();
				
			} finally {
				try {
					conn.close();
					
				} catch(SQLException e) { }
			}
		}
		
		time = System.currentTimeMillis() - time;
		System.out.println("DBCP : " + time);
	}
	
	
	public static void main(String[] args) {
		normal();
		dbcp();
	}
}