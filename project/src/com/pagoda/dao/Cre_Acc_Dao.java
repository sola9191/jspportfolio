package com.pagoda.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.Cre_Acc_Dto;
import com.pagoda.dto.RBDto;


public class Cre_Acc_Dao {
	
	public int iddouble (Cre_Acc_Dto dto) {
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null; 
		DBmanager db = new DBmanager();
		String sql = "select count(*) from pagodamember where pid=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPid());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt(1);
			}
		}catch (Exception e ) { e.printStackTrace(); 
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	
	public int creAcc (Cre_Acc_Dto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db = new DBmanager();
		String sql = "insert into pagodamember (pname, pbirthDay, pgender, plocal, pphonenumber, pid, ppass, pemail, pip) values (?,?,?,?,?,?,?,?,?)";
		int result = -1;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getPbirthDay());
			pstmt.setString(3, dto.getPgender());
			pstmt.setString(4, dto.getPlocal());
			pstmt.setString(5, dto.getPphonenumber());
			pstmt.setString(6, dto.getPid());
			pstmt.setString(7, dto.getPpass());
			pstmt.setString(8, dto.getPemail());
			pstmt.setString(9,  InetAddress.getLocalHost().getHostAddress());
			
			result = pstmt.executeUpdate();
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	
	public int login (Cre_Acc_Dto dto) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select count(*) from pagodamember where pid=? and ppass=?";
		int result = -1;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPid());
			pstmt.setString(2, dto.getPpass());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt(1);
				
			}
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	
	public Cre_Acc_Dto userinfo(Cre_Acc_Dto dto) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		Cre_Acc_Dto tmpdto = new Cre_Acc_Dto();
		String sql = "select * from pagodamember where pid=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPid());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int pno = rset.getInt("pno");
				String pname = rset.getString("pname");
				String pbirthDay = rset.getString("pbirthday");;
				String pgender = rset.getString("pgender");
				String plocal = rset.getString("plocal");
				String pphonenumber = rset.getString("pphonenumber");
				String pid = rset.getString("pid");
				String ppass = rset.getString("ppass");
				String pemail = rset.getString("pemail");
				String pdate = rset.getString("pdate");
				String pip = rset.getString("pip");
				int shopno = rset.getInt("shopno");
					
				tmpdto = new Cre_Acc_Dto(pno, pname, pbirthDay, pgender, plocal, pphonenumber, pid, ppass, pemail, pdate, pip, shopno);
			}
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return tmpdto;
	}
	public int useredit(Cre_Acc_Dto dto) {
		Connection conn = null; PreparedStatement pstmt = null; 
		DBmanager db = new DBmanager();
		String sql = "update pagodamember set ppass=?, pphonenumber=?, pemail=? where pid=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPpass());
			pstmt.setString(2, dto.getPphonenumber());
			pstmt.setString(3, dto.getPemail());
			pstmt.setString(4, dto.getPid());
			result = pstmt.executeUpdate();
		if(result>0) { result = 1;	}
		else { result =-1;}
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int userdelete(String pid) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db = new DBmanager();
		String sql = "delete from pagodamember where pid=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			result = pstmt.executeUpdate();
			
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;	
	}
	public Cre_Acc_Dto findId(Cre_Acc_Dto dto) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		Cre_Acc_Dto list  = new Cre_Acc_Dto(); 
		String sql = "select * from pagodamember where pname=? and pemail=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getPemail());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int pno = rset.getInt("pno");
				String pname = rset.getString("pname");
				String pbirthDay = rset.getString("pbirthDay");
				String pgender = rset.getString("pgender");
				String plocal = rset.getString("plocal");
				String pphonenumber = rset.getString("pphonenumber");
				String pid = rset.getString("pid");
				String ppass = rset.getString("ppass");
				String pemail = rset.getString("pemail");
				String pdate = rset.getString("pdate");
				String pip = rset.getString("pip");
				int shopno = rset.getInt("shopno");
				
				list = new Cre_Acc_Dto(pno, pname, pbirthDay, pgender, plocal, pphonenumber, pid, ppass, pemail, pdate, pip, shopno);
			}
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	
	public Cre_Acc_Dto findPasswithP(Cre_Acc_Dto dto){
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		Cre_Acc_Dto list  = new Cre_Acc_Dto(); 
		String sql="select * from pagodamember where pname=? and pid=? and pphonenumber=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getPid());
			pstmt.setString(3, dto.getPphonenumber());			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int pno = rset.getInt("pno");
				String pname = rset.getString("pname");
				String pbirthDay = rset.getString("pbirthDay");
				String pgender = rset.getString("pgender");
				String plocal = rset.getString("plocal");
				String pphonenumber = rset.getString("pphonenumber");
				String pid = rset.getString("pid");
				String ppass = rset.getString("ppass");
				String pemail = rset.getString("pemail");
				String pdate = rset.getString("pdate");
				String pip = rset.getString("pip");
				int shopno = rset.getInt("shopno");
				
				list = new Cre_Acc_Dto(pno, pname, pbirthDay, pgender, plocal, pphonenumber, pid, ppass, pemail, pdate, pip, shopno);
				System.out.println("왜안됨"+list);
			}
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	
	public Cre_Acc_Dto findPasswithE(Cre_Acc_Dto dto){
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		Cre_Acc_Dto list  = new Cre_Acc_Dto(); 
		String sql="select * from pagodamember where pname=? and pid=? and pemail=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getPid());
			pstmt.setString(3, dto.getPemail());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int pno = rset.getInt("pno");
				String pname = rset.getString("pname");
				String pbirthDay = rset.getString("pbirthDay");
				String pgender = rset.getString("pgender");
				String plocal = rset.getString("plocal");
				String pphonenumber = rset.getString("pphonenumber");
				String pid = rset.getString("pid");
				String ppass = rset.getString("ppass");
				String pemail = rset.getString("pemail");
				String pdate = rset.getString("pdate");
				String pip = rset.getString("pip");
				int shopno = rset.getInt("shopno");
				
				list = new Cre_Acc_Dto(pno, pname, pbirthDay, pgender, plocal, pphonenumber, pid, ppass, pemail, pdate, pip, shopno);
				
			}
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	
	//pid로 pno찾는 method
	public int findpno(String pid){
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		int pno = -1;
		String sql="select pno from pagodamember where pid=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				pno = rset.getInt("pno");	}
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return pno;
	}
	
	//모든 회원 정보 불러오는 method
	
	public ArrayList<Cre_Acc_Dto> allMember(){
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		ArrayList<Cre_Acc_Dto> dto = new ArrayList<>();
		
		String sql="select * from pagodamember";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				int pno = rset.getInt("pno");
				String pname = rset.getString("pname");
				String pbirthDay = rset.getString("pbirthday");;
				String pgender = rset.getString("pgender");
				String plocal = rset.getString("plocal");
				String pphonenumber = rset.getString("pphonenumber");
				String pid = rset.getString("pid");
				String ppass = rset.getString("ppass");
				String pemail = rset.getString("pemail");
				String pdate = rset.getString("pdate");
				String pip = rset.getString("pip");
				int shopno = rset.getInt("shopno");
					
				dto.add(new Cre_Acc_Dto(pno, pname, pbirthDay, pgender, plocal, pphonenumber, pid, ppass, pemail, pdate, pip, shopno));	}
		
		}catch (Exception  e) {e.printStackTrace();	
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return dto;
	}
	
}