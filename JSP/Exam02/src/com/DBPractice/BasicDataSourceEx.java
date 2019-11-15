package com.DBPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class BasicDataSourceEx {
	private BasicDataSource ds;
	
	
	public BasicDataSourceEx() {
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("1111");
		ds.setUrl("jdbc:mysql://localhost:3307/test?serverTimezone=UTC");
		
		// Connection Pool�� ����� ���� Connection���� (���� �ʱ�ȭ)
		ds.setInitialSize(20);
		
		// ���� ���� ��
		ds.setMaxActive(20);
		
		// ���� Connection�� 20����  (��� Connection�� 20���� ������, �Ѵ°��� ������ ������)
		ds.setMaxIdle(20);
		
		// �ּ� ���� Connection����
		ds.setMinIdle(10);
	}
	
	
	public int insert(String testValue) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pStmt = null;
		
		try {
			String sql = "INSERT INTO item (idx) VALUES (?)";
			
			conn = ds.getConnection();
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,  Integer.parseInt(testValue));
			result = pStmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pStmt.close();
				
			} catch(SQLException e2) { }
			
			try {
				conn.close();
				
			} catch(SQLException e2) { }
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		BasicDataSourceEx o = new BasicDataSourceEx();
		
		for(int i = 0; i < 100; i++) {
			o.insert("" + i);
		}
	}
}
