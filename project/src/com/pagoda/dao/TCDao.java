package com.pagoda.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.TCDto;

public class TCDao {
	//선생님들 리스트 불러오기
	
	public ArrayList<TCDto> listAll() {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<TCDto> list = new ArrayList<TCDto>();
		String sql = "select * from teachers order by teacherno desc";
		try {

			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new TCDto(rset.getInt("teacherno"), rset.getString("teachername"), rset.getString("teacherinfo"), 
						rset.getString("teacherimg"), rset.getString("teacherpostdate"), 
						rset.getString("teacherpostip"), rset.getString("teachercreator")));
				
				}
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	
	//선생님들 등록
	public int write(TCDto dto) {
		Connection conn = null; PreparedStatement pstmt =  null;
		DBmanager db = new DBmanager();
		String sql = "insert into teachers (teachername, teacherinfo, teacherimg, teacherpostip, teachercreator) values (?,?,?,?,?)";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTeachername());
			pstmt.setString(2, dto.getTeacherinfo());
			pstmt.setString(3, dto.getTeacherimg());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(5, dto.getTeachercreator());
			result = pstmt.executeUpdate();		
		}catch ( Exception  e) { e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
			if(conn!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
		}
		return result;
	}
	//선생님들 상세보기
	public TCDto detail(int teacherno) {
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select * from teachers where teacherno=?";
		TCDto dto = new TCDto();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacherno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				dto = new TCDto(rset.getInt("teacherno"), rset.getString("teachername"), rset.getString("teacherinfo"), 
						rset.getString("teacherimg"), rset.getString("teacherpostdate"), 
						rset.getString("teacherpostip"), rset.getString("teachercreator"));

			}
			}catch (Exception e) { e.printStackTrace(); 
			}finally {
				if(rset!=null) { try {rset.close(); }catch (SQLException e) {e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return dto;
		}
	
	//선생님들 수정
	public int edit (TCDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db = new DBmanager();
		String sql = "update teachers set teachername=?, teacherinfo=?, teachercreator=?, teacherimg=? where teacherno=?";
		int result =-1;
		try {

			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTeachername());
			pstmt.setString(2, dto.getTeacherinfo());
			pstmt.setString(3, dto.getTeachercreator());
			pstmt.setString(4, dto.getTeacherimg());
			pstmt.setInt(5, dto.getTeacherno());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace(); 
		}finally {
			if(pstmt!=null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return result;		
	}
	//선생님들 삭제
	public int delete (TCDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db  =  new DBmanager();
		String sql =  "delete from teachers where teacherno=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getTeacherno());
			result = pstmt.executeUpdate();
		}catch(Exception e) { e.printStackTrace(); 
		}finally{
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}	
		return result;
	}	
	//선생님 이름으로 다 조회
	
	public TCDto detailwithtname(String teachername) {
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select * from teachers where teachername=?";
		TCDto dto = new TCDto();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teachername);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				dto = new TCDto(rset.getInt("teacherno"), rset.getString("teachername"), rset.getString("teacherinfo"), 
						rset.getString("teacherimg"), rset.getString("teacherpostdate"), 
						rset.getString("teacherpostip"), rset.getString("teachercreator"));

			}
			}catch (Exception e) { e.printStackTrace(); 
			}finally {
				if(rset!=null) { try {rset.close(); }catch (SQLException e) {e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return dto;
		}	
	
	
	
	
}
