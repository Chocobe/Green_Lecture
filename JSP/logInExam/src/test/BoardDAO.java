package test;

import java.util.*;
import java.sql.*;
import test.*;

public class BoardDAO {
	
	DBConnectionMgr ds = DBConnectionMgr.getInstance();
	
	public Vector<BoardDTO> getList(int start, int cnt){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BoardDTO> vec = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(
					"select * from board1 limit ?, ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, cnt);
			rs = pstmt.executeQuery();
			vec = new Vector<BoardDTO>();
			
			while(rs.next()) {
				BoardDTO dto= new BoardDTO();
				dto.setIdx(rs.getInt(1));
				dto.setPw(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setHomepage(rs.getString(5));
				dto.setSubject(rs.getString(6));
				dto.setMemo(rs.getString(7));
				dto.setFile1(rs.getString(8));
				dto.setFile2(rs.getString(9));
				dto.setReday(rs.getString(10));
				vec.add(dto);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			ds.freeConnection(con,pstmt,rs);
		}
		return vec;
	}	
	
	public float getCount() {
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		float result = 0;// 전체갯수
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(
					"select count(*) from board1");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			ds.freeConnection(con,pstmt,rs);
		}
		return result;
	}
	
}














