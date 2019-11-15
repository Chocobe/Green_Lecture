package kr.ac.green.dbcp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MyDAO {
	private DataSource ds;
	
	private static final MyDAO INSTANCE = new MyDAO();
	
	private MyDAO() {
		try {
			Context init = new InitialContext(); 
			ds = (DataSource)init.lookup("java:comp/env/jdbc/mysqlDB");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}
	
	public static MyDAO getInstance() {
		return INSTANCE;
	}
	
	public Connection connect() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return con;
	}
	
	public int getCount() {
		String sql = "SELECT count(*) totalCount FROM item";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		try {
			con = connect();
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
}











