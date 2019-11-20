package com.board.teacher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
//import com.test.*;

import com.dbConnectionMGR.DBConnectionMgr;

public class BoardDAO {
	
// 페이징 처리_2 (인자값의 시작점과 개수만큼 DB에 게시물을 가져온다) 
	public Vector<BoardDTO> getList(int start, int cnt) {
		DBConnectionMgr ds = DBConnectionMgr.getInstance();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BoardDTO> vec = null;
		
		try {
			String sql = "SELECT * FROM BOARD1 LIMIT ?, ?";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, cnt);
			rs = pstmt.executeQuery();
			
			vec = new Vector<BoardDTO>();
			System.out.println(vec);
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
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			ds.freeConnection(conn, pstmt, rs);
		}
		
		return vec;
	}
	
	
// 페이징 처리 메소드_1 (전체 게시물 개수 가져오기)
	public float getCount() {
		DBConnectionMgr ds = DBConnectionMgr.getInstance();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BoardDTO> vec = null;
		
		// 전체개수
		float result = 0F;
		
		try {
			String sql = "SELECT COUNT(*) FROM BOARD1";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			ds.freeConnection(conn, pstmt, rs);
		}
		
		return result;
	}
}






















