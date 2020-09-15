package com.pagoda.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.RBDto;

public class PagingDao {

	public int listCnt() throws ServletException, IOException{
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset= null;
		DBmanager db = new DBmanager();
		String sql = "select count(*) from reviewboard";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt(1);
			}
		}catch( Exception e ) { e.printStackTrace(); 
		}finally {
			if(rset!=null) {try { rset.close();}catch(SQLException e) {e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close();}catch(SQLException e) {e.printStackTrace(); }}
			if(conn!=null) {try { conn.close();}catch(SQLException e) {e.printStackTrace(); }}			
		}
		return result;
	}
	
	public ArrayList<RBDto> list5(int pstartno) {
		 ArrayList<RBDto> list = new  ArrayList<RBDto>();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select * from reviewboard order by rno desc limit ?, 5";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pstartno);	
			rset = pstmt.executeQuery();
			while(rset.next()) {
					
				list.add(new RBDto(rset.getInt("rno"), rset.getInt("pno"), rset.getInt("classno"), 
						rset.getString("rstar"), rset.getString("rtitle"), rset.getString("rpass"), rset.getString("rcontent"),
						rset.getInt("rhit"), rset.getString("rfile"), rset.getString("rip"), rset.getString("rdate")));
				
			}
		}catch( Exception e ) { e.printStackTrace(); 
		}finally {
			if(rset!=null) {try { rset.close();}catch(SQLException e) {e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close();}catch(SQLException e) {e.printStackTrace(); }}
			if(conn!=null) {try { conn.close();}catch(SQLException e) {e.printStackTrace(); }}			
		}
		return list;
	}
}//end class
