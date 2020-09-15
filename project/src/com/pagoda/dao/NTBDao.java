package com.pagoda.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.NTBDto;


public class NTBDao {
	//전체글조회
	public ArrayList<NTBDto> listAll() {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<NTBDto> list = new ArrayList<NTBDto>();
		String sql = "select * from noticeboard order by ncate desc, nno desc";
		try {

			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new NTBDto(rset.getInt("nno"), rset.getString("nname"), rset.getString("ntitle"), rset.getString("npass"), 
						rset.getString("ncontent"), rset.getString("nip"), rset.getString("ndate"), rset.getString("ncate")));
			}
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	//관리자 비밀번호체크
	public int passchk(String ppass) {
		int result = -1;
		if(ppass.equals("1234")){	result = 1;  }
		return result;	
	}
	
	//글 전체 갯수 세기
	public int listcnt() {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
		DBmanager db = new DBmanager();
		String sql = "select count(*) from noticeboard";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {   e.printStackTrace();	
			}finally {
				if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		
			return result; 
	}
	//관리자가 글쓰기 
	//int nno, String nname, String ntitle, String npass, String ncontent, String nip, String ndate, String ncate)

	public int write(NTBDto dto) {
		Connection conn = null; PreparedStatement pstmt =  null; DBmanager db = new DBmanager();
		String sql = "insert into noticeboard (nname, ntitle, npass, ncontent, nip, ncate) values (?,?,?,?,?,?)";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNname());
			pstmt.setString(2, dto.getNtitle());
			pstmt.setString(3, dto.getNpass());
			pstmt.setString(4, dto.getNcontent());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(6, dto.getNcate());
			result = pstmt.executeUpdate();		
		}catch ( Exception  e) { e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
			if(conn!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
		}
		return result;
	}
	
	//글 상세보기
	public NTBDto detail(int nno) {
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select * from noticeboard where nno=?";
		NTBDto dto = new NTBDto();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				dto = new NTBDto(rset.getInt("nno"), rset.getString("nname"), rset.getString("ntitle"), rset.getString("npass"), 
						rset.getString("ncontent"), rset.getString("nip"), rset.getString("nip"), rset.getString("ncate"));	
			
			}
			}catch (Exception e) { e.printStackTrace(); 
			}finally {
				if(rset!=null) { try {rset.close(); }catch (SQLException e) {e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return dto;
		}
  
	//글수정하기
	//insert into noticeboard (nname, ntitle, npass, ncontent, nip, ncate) values (?,?,?,?,?,?)"
	public int edit (NTBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null; 
		DBmanager db = new DBmanager();
		String sql = "update noticeboard set ntitle=?, ncontent=?, ncate=?, nip=? where nno=? and npass=?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNtitle());
			pstmt.setString(2, dto.getNcontent());
			pstmt.setString(3, dto.getNcate());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			pstmt.setInt(5, dto.getNno());
			pstmt.setString(6, dto.getNpass());
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		}catch(Exception e) {e.printStackTrace(); 
		}finally {
			if(pstmt!=null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return result;		
	}
	
	//글삭제
	public int delete (NTBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db  =  new DBmanager();
		String sql =  "delete from noticeboard where nno=? and npass=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNno());
			pstmt.setString(2, dto.getNpass());
			result = pstmt.executeUpdate();
		}catch(Exception e) { e.printStackTrace(); 
		}finally{
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}	
		return result;
	}	
}