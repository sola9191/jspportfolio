package com.pagoda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.KakaoDto;

public class kakaoDao {
	
	public int findkid(String kid) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
		DBmanager db = new DBmanager();
		String sql = "select count(*) from kakao where kid=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kid);
			rset = pstmt.executeQuery();
			while(rset.next()) {	result = rset.getInt(1);	}
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result; //1이면 있는거고 0이면 없는거
	}
	
	public int savekid(KakaoDto dto) {
		Connection conn = null; PreparedStatement pstmt = null; 
		DBmanager db = new DBmanager();
		String sql = "insert into kakao (kid, pno) values (?, ?)";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getKid());
			pstmt.setInt(2, dto.getPno());
			result = pstmt.executeUpdate();
			
		
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result; //1이면 성공 0이면 실패
	}
	
	//카카오톡 아디로 회원가입된 정보 찾는것
	public String findinfo(String kid) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql="select p.pname, p.pid from kakao k, pagodamember p where k.pno=p.pno and k.kid=?";
		String tmp = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kid);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				tmp=rset.getString("pname");
				tmp+=",";
				tmp+=rset.getString("pid");
			}
			
		
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return tmp; //이름이랑 아디랑 던짐
	}

	//탈퇴시에 회원번호로 테이블 조회해서 카카오 아이디 있나 확인하기
	//String sql = select count(*) from kakao where pno=31; 여기서 1이면 아이디 삭제필요
	public int deletepro1(int pno) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select count(*) from kakao where pno=?";
		int result = -1;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt(1);
			}
		
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result; //1이면 아디 있는거라 삭제해야되
	}
	//카카오테이블에서 아이디 삭제해주기
	public int deletepro2(int pno) {
		Connection conn = null; PreparedStatement pstmt = null; 
		DBmanager db = new DBmanager();
		String sql = "delete from kakao where pno=?";
		int result = -1;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			result = pstmt.executeUpdate();
		
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result; //1이면 아디 삭제성공한거!
	}
}
