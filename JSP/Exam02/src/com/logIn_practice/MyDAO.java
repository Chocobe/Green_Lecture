package com.logIn_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.dbcp.BasicDataSource;

public class MyDAO {
	private static MyDAO dao;
	private static BasicDataSource ds;
	
	
	static {
		dao = new MyDAO();
		
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
	
	
	public static MyDAO getInstance() {
		return dao;
	}
	
	
	public MyDAO() { };
	
	
	public int insertMember(String id,
							String password,
							String email,
							String name,
							String phone) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pStmt = null;
		
		try {
			String sql = "INSERT INTO myMember VALUE(NULL, ?, ?, ?, ?, ?)";
			conn = ds.getConnection();
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, id);
			pStmt.setString(2, password);
			pStmt.setString(3, email);
			pStmt.setString(4, name);
			pStmt.setString(5, phone);
			
			result = pStmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				pStmt.close();
				
			} catch(Exception e) { }
			
			try {
				conn.close();
				
			} catch(Exception e) { }
		}
		
		return result;
	}
	
	
	public List<Map<String, String>> getDatas() {
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM myMember";
			
			conn = ds.getConnection();
			pStmt = conn.prepareStatement(sql);
			rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Map<String, String> data = new HashMap<String, String>();
				data.put("id", rs.getString("id"));
				data.put("pw", rs.getString("password"));
				data.put("email", rs.getString("email"));
				data.put("name", rs.getString("name"));
				data.put("phone", rs.getString("phone"));
				
				result.add(data);
			}			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pStmt != null) {
					pStmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch(SQLException e) { }
		}
		
		
		
		
				
		return result;
	}
	
	
	
	
	
	
	
	public int getCount() {
		String sql = "SELECT count(*) totalCount FROM item";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt("totalCount");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public Vector<MyDTO> getMembers() {
		String sql = "SELECT * FROM myMember";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector<MyDTO> v = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			v = new Vector<MyDTO>();
			
			while(rs.next()) {
				MyDTO dto = new MyDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				
				v.add(dto);
			}
						
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch(SQLException ex) { }
		}
		
		return v;
	}
}
