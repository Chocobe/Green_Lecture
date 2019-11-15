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
		//?serverTimezone=UTC
		// Connection Pool�� ����� ���� Connection���� (���� �ʱ�ȭ)
		ds.setInitialSize(20);
		
		// ���� ���� ��
		ds.setMaxActive(20);
		
		// ���� Connection�� 20����  (��� Connection�� 20���� ������, �Ѵ°��� ������ ������)
		ds.setMaxIdle(20);
		
		// �ּ� ���� Connection����
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
