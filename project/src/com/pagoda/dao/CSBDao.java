package com.pagoda.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.CSBDto;


public class CSBDao {
	
	public ArrayList<CSBDto> listAll() {
		Connection conn = null; PreparedStatement pstmt = null;
		ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<CSBDto> list = new ArrayList<CSBDto>();
		String sql = "select * from csboard order by cno asc";
		try {

			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new CSBDto(rset.getInt("cno"), rset.getString("cname"), rset.getString("ctitle"), 
						rset.getString("ccontent"), rset.getString("cpass"), rset.getString("cdate"), 
						rset.getString("cip"), rset.getInt("ccategorynum")));
				}
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	public int passchk(String ppass) {
		int result = -1;
		if(ppass.equals("1234")){
			result = 1;
		}
   
		return result;		
		
	}
	public int listcnt() {
		Connection conn = null; PreparedStatement pstmt = null;
		ResultSet  rset = null;
		DBmanager db = new DBmanager();
		String sql = "select count(*) from csboard";
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
	public int write(CSBDto dto) {
		Connection conn = null; PreparedStatement pstmt =  null;
		DBmanager db = new DBmanager();
		String sql = "insert into csboard ( cname, ctitle, ccontent, cpass, cip, ccategorynum) values (?,?,?,?,?,?)";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCtitle());
			pstmt.setString(3, dto.getCcontent());
			pstmt.setString(4, dto.getCpass());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setInt(6, dto.getCcategorynum());
			result = pstmt.executeUpdate();		
		}catch ( Exception  e) { e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
			if(conn!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
		}
		return result;
	}
	
	public CSBDto detail(int cno) {
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select * from csboard where cno=?";
		CSBDto dto = new CSBDto();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				dto = new CSBDto(rset.getInt("cno"), rset.getString("cname"), rset.getString("ctitle"), 
						rset.getString("ccontent"), rset.getString("cpass"), rset.getString("cdate"), rset.getString("cip")
						, rset.getInt("ccategorynum"));

			}
			}catch (Exception e) { e.printStackTrace(); 
			}finally {
				if(rset!=null) { try {rset.close(); }catch (SQLException e) {e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return dto;
		}
  
	public int edit (CSBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db = new DBmanager();
		String sql = "update csboard set ctitle=?, ccontent=?, ccategorynum=?, cip=? where cno=? and cpass=?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCtitle());
			pstmt.setString(2, dto.getCcontent());
			pstmt.setInt(3, dto.getCcategorynum());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			pstmt.setInt(5, dto.getCno());
			pstmt.setString(6, dto.getCpass());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace(); 
		}finally {
			if(pstmt!=null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return result;		
	}
	public int delete (CSBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db  =  new DBmanager();
		String sql =  "delete from csboard where cno=? and cpass=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCno());
			pstmt.setString(2, dto.getCpass());
			result = pstmt.executeUpdate();
		}catch(Exception e) { e.printStackTrace(); 
		}finally{
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}	
		return result;
	}	
	//회원이 검색기능 사용했을때 리스트 셋업
	public ArrayList<CSBDto> listAll_Search(String word, int catenum) {
		Connection conn = null; PreparedStatement pstmt = null;	ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<CSBDto> list = new ArrayList<CSBDto>();
		if(catenum==0) {
			
			String sql = "select * from csboard where ctitle like ? order by cno asc";
			try {		
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+word+"%");
				rset = pstmt.executeQuery();
				while(rset.next()) {
					list.add(new CSBDto(rset.getInt("cno"), rset.getString("cname"), rset.getString("ctitle"), 
							rset.getString("ccontent"), rset.getString("cpass"), rset.getString("cdate"), rset.getString("cip")
							,rset.getInt("ccategorynum")));
					}
			} catch ( Exception e) { e.printStackTrace();
			}finally {
				if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return list;
			
		}
		else {
			
		
		String sql = "select * from csboard where ctitle like ? and ccategorynum=? order by cno asc";
		try {		
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+word+"%");
			pstmt.setInt(2, catenum);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new CSBDto(rset.getInt("cno"), rset.getString("cname"), rset.getString("ctitle"), 
						rset.getString("ccontent"), rset.getString("cpass"), rset.getString("cdate"), rset.getString("cip")
						,rset.getInt("ccategorynum")));
				}
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
		}
	}
	//회원이 위에 8개 탭 눌러서 자주묻는게시판 카운트 했을때
	public ArrayList<CSBDto> listSort(int ccategorynum) {
		Connection conn = null; PreparedStatement pstmt = null;	ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<CSBDto> list = new ArrayList<CSBDto>();
		String sql = "select * from csboard where ccategorynum=? order by cno asc";
		try {		
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ccategorynum);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new CSBDto(rset.getInt("cno"), rset.getString("cname"), rset.getString("ctitle"), 
						rset.getString("ccontent"), rset.getString("cpass"), rset.getString("cdate"), rset.getString("cip")
						,rset.getInt("ccategorynum")));
				}
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	
	//회원이 위에 8개 탭 눌러서 자주묻는게시판 카운트 했을때 (위의버전의 전체)
		public ArrayList<CSBDto> listSort0(int ccategorynum) {
			Connection conn = null; PreparedStatement pstmt = null;	ResultSet  rset = null;
			DBmanager db = new DBmanager();
			ArrayList<CSBDto> list = new ArrayList<CSBDto>();
			String sql = "select * from csboard order by cno asc";
			try {		
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ccategorynum);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					list.add(new CSBDto(rset.getInt("cno"), rset.getString("cname"), rset.getString("ctitle"), 
							rset.getString("ccontent"), rset.getString("cpass"), rset.getString("cdate"), rset.getString("cip")
							,rset.getInt("ccategorynum")));
					}
			} catch ( Exception e) { e.printStackTrace();
			}finally {
				if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return list;
		}

}