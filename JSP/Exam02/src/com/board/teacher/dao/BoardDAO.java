package com.board.teacher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class BoardDAO {
	private DataSource ds;
	private static final BoardDAO INSTANCE = new BoardDAO();
	
	private BoardDAO() {
		try {
			Context init = new InitialContext(); 
			ds = (DataSource)init.lookup("java:comp/env/jdbc/mysqlDB");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
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
	
	
// 로직
	public int insertBoard(String pw, 
						   String name, 
						   String email, 
						   String homepage, 
						   String subject,
						   String memo,
						   String file1,
						   String file2) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO BOARD1 VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, homepage);
			pstmt.setString(5, subject);
			pstmt.setString(6, memo);
			pstmt.setString(7, file1);
			pstmt.setString(8, file2);
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				
			} catch(SQLException e) { }
			
			try {
				conn.close();
				
			} catch(SQLException e) { }
		}
		
		return result;
	}
	
	
	public Vector<BoardDTO> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BoardDTO> vec = null;
		
		try {
			String sql = "SELECT * FROM BOARD1";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			vec = new Vector<BoardDTO>();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getInt("IDX"));
				dto.setPw(rs.getString("PW"));
				dto.setName(rs.getString("NAME"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setHomepage(rs.getString("HOMEPAGE"));
				dto.setSubject(rs.getString("SUBJECT"));
				dto.setMemo(rs.getString("MEMO"));
				dto.setFile1(rs.getString("FILE1"));
				dto.setFile2(rs.getString("FILE2"));
				dto.setRegDay(rs.getString("REG_DAY"));
				
				vec.add(dto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();
				
			} catch(Exception e) { }
			
			try {
				pstmt.close();
				
			} catch(Exception e) { }
			
			try {
				conn.close();
				
			} catch(Exception e) { }
		}
		
		return vec;
	}
	
	
	public BoardDTO getView(String idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = null;
		
		try {
			String sql = "SELECT * FROM BOARD1 WHERE IDX=?";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(idx));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setIdx(rs.getInt("IDX"));
				dto.setPw(rs.getString("PW"));
				dto.setName(rs.getString("NAME"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setHomepage(rs.getString("HOMEPAGE"));
				dto.setSubject(rs.getString("SUBJECT"));
				dto.setMemo(rs.getString("MEMO"));
				dto.setFile1(rs.getString("FILE1"));
				dto.setFile2(rs.getString("FILE2"));
				dto.setRegDay(rs.getString("REG_DAY"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();
				
			} catch(Exception e) { }
			
			try {
				pstmt.close();
				
			} catch(Exception e) { }
			
			try {
				conn.close();
				
			} catch(Exception e) { }
		}
		
		return dto;
	}
	
	
	public int deleteView(String idx) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM BOARD1 WHERE IDX=?";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(idx));
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception e) { }
			
			try {
				conn.close();
				
			} catch(Exception e) { }
		}
		
		return result;
	}
	
	
	public int updateView(String idx, 
						  String pw, 
						  String name, 
						  String email, 
						  String homepage, 
						  String subject, 
						  String memo, 
						  String file1, 
						  String file2) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE BOARD1 SET " + 
						 "PW=?, " +
						 "EMAIL=?, " +
						 "HOMEPAGE=?, " +
						 "SUBJECT=?, " +
						 "MEMO=?, " +
						 "FILE1=?, " +
						 "FILE2=?, " +
						 "REG_DAY = NOW() " +
						 "WHERE IDX=?";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, email);
			pstmt.setString(3, homepage);
			pstmt.setString(4, subject);
			pstmt.setString(5, memo);
			pstmt.setString(6, file1);
			pstmt.setString(7, file2);
			pstmt.setInt(8, Integer.parseInt(idx));
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception e) { }
			
			try {
				conn.close();
				
			} catch(Exception e) { }
		}
		
		return result;
	}
}






















