package com.pagoda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.Cre_Acc_Dto;
import com.pagoda.dto.IQBDto;
//int ino, int pno, String ititle, String icontent, String ifile, int iread, int igroup, int istep,
//int iindent, String iemail, String idate, String iip
public class IQBDao {
	//글리스트뽑기 
	public ArrayList<IQBDto> listAll (int pno){ 
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		ArrayList<IQBDto> list = new ArrayList<IQBDto>();
		String sql="select * from personalboard where pno=? order by istep desc, iindent asc";
		DBmanager db = new DBmanager();
		
		try {	
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new IQBDto(rset.getInt("ino"), rset.getInt("pno"),	rset.getString("ititle"),
						rset.getString("icontent"),rset.getString("ifile"), rset.getInt("iread"),
						rset.getInt("igroup"), rset.getInt("istep"), rset.getInt("iindent"),	
						rset.getString("iemail"), rset.getString("idate"), rset.getString("iip")));
			}
		}catch (Exception e) {e.printStackTrace(); 
		}finally { 
			if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return list;
	
	}
	//insert into personalboard 
	//(pno, ititle, icontent, ifile, igroup, istep, iemail, iip) values (1 , '궁금해요' , '궁금궁금' , 'no.img' , 1 , 1000 , '111@111', '111.111.111.111');

	public int write(IQBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null; 
		String sql = "insert into personalboard (pno, ititle, icontent, ifile, igroup, istep, iemail, iip) values (?,?,?,?,?,?,?,?)";
		DBmanager db = new DBmanager();
		int result  = -1;
		try {	
			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPno());
			pstmt.setString(2, dto.getItitle());
			pstmt.setString(3, dto.getIcontent());
			pstmt.setString(4, dto.getIfile());
			pstmt.setInt(5,  dto.getIgroup());
			pstmt.setInt(6,  dto.getIstep());
			pstmt.setString(7,  dto.getIemail());
			pstmt.setString(8, dto.getIip());			
			
			result = pstmt.executeUpdate();			
			
		}catch (Exception e) {e.printStackTrace(); 
		}finally { 
			
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return result;
	
	}

	public IQBDto detail(int ino) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		IQBDto list = new IQBDto();
		DBmanager db = new DBmanager();
		String sql = "select * from personalboard where ino=?";
		
		try {	
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ino);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list = 	new IQBDto(rset.getInt("ino"), rset.getInt("pno"),	rset.getString("ititle"),
						rset.getString("icontent"),rset.getString("ifile"), rset.getInt("iread"),
						rset.getInt("igroup"), rset.getInt("istep"), rset.getInt("iindent"),	
						rset.getString("iemail"), rset.getString("idate"), rset.getString("iip"));	
			}
		}catch (Exception e) {e.printStackTrace(); 
		}finally { 
			if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return list;
	}
		
	public int edit(IQBDto dto){
		
		Connection conn = null; PreparedStatement pstmt = null; 
		String sql = "update personalboard set iemail=?, ititle=?, icontent=?, ifile=? where ino=?";
		DBmanager db = new DBmanager();
		int result  = -1;
		try {	
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIemail());
			pstmt.setString(2, dto.getItitle());
			pstmt.setString(3, dto.getIcontent());
			pstmt.setString(4, dto.getIfile());
			pstmt.setInt(5, dto.getIno());
			result = pstmt.executeUpdate();	
			
		}catch (Exception e) {e.printStackTrace(); 
		}finally { 
			
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}

		return result;
		
	}
	
	public int delete(int ino) {
		Connection conn = null; PreparedStatement pstmt = null; 
		DBmanager db = new DBmanager();
		String sql = "delete from personalboard where ino=?";
		int result  = -1;
		try {	
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ino);
			result = pstmt.executeUpdate();	
			
		}catch (Exception e) {e.printStackTrace(); 
		}finally { 
			
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return result;
	}		
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////새로 추가된것들
	//bstep 최대 번호 찾기
		public int max_read() {
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			String sql="select max(istep) from personalboard";
			DBmanager db = new DBmanager();
			int max = -1;
			
			try {	
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					max = rset.getInt(1);
				}
			}catch (Exception e) {e.printStackTrace(); 
			}finally { 
				if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
			}
			return max;
		}
	//답글 달릴때마다 댓글번호글들 bstep 1씩 빼기
		public int update_reply(int prev, int curr) {
		Connection conn = null; PreparedStatement pstmt = null; 
		String sql = "update personalboard set istep=istep-1 where istep>? and istep<?;";
		DBmanager db = new DBmanager();
		int result  = -1;
		try {	
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prev);
			pstmt.setInt(2, curr);
			result = pstmt.executeUpdate();	
			
		}catch (Exception e) {e.printStackTrace(); 
		}finally { 
			
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}

		return result;
		
	}
	//답글 쓰는 method
		public int create_re(IQBDto dto) {
			Connection conn = null; PreparedStatement pstmt = null; 
			String sql = "insert into personalboard (pno, ititle, icontent, iread, igroup, istep, iindent, iemail, iip) values (?,?,?,?,?,?,?,?,?)";
			DBmanager db = new DBmanager();
			int result  = -1;
			try {	
	
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getPno());
				pstmt.setString(2, dto.getItitle());
				pstmt.setString(3, dto.getIcontent());
				pstmt.setInt(4, dto.getIread());
				pstmt.setInt(5,  dto.getIgroup());
				pstmt.setInt(6,  dto.getIstep());
				pstmt.setInt(7,  dto.getIindent());
				pstmt.setString(8,  dto.getIemail());
				pstmt.setString(9, dto.getIip());
				result = pstmt.executeUpdate();			
				}catch (Exception e) {e.printStackTrace(); 
			}finally { 
				
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
			}
			return result;
		
		}
		//어드민용 List all
		public ArrayList<IQBDto> listAll_Admin (){ 
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			ArrayList<IQBDto> list = new ArrayList<IQBDto>();
			//관리자는 읽지않음이나 처리중인글 보기
			String sql="select * from personalboard where iread=0 or iread=1 order by istep desc, iindent asc";
			DBmanager db = new DBmanager();
			
			try {	
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					list.add(new IQBDto(rset.getInt("ino"), rset.getInt("pno"),	rset.getString("ititle"),
							rset.getString("icontent"),rset.getString("ifile"), rset.getInt("iread"),
							rset.getInt("igroup"), rset.getInt("istep"), rset.getInt("iindent"),	
							rset.getString("iemail"), rset.getString("idate"), rset.getString("iip")));
				}
			}catch (Exception e) {e.printStackTrace(); 
			}finally { 
				if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
			}
			return list;
		
		}
		
	//글번호로 회원 번호 찾아내기
		public int findpno(int ino){ 
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			String sql="select pno from personalboard where ino=?";
			DBmanager db = new DBmanager();
			int pno = -1;
			
			try {	
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ino);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					pno = rset.getInt(1);
				}
			}catch (Exception e) {e.printStackTrace(); 
			}finally { 
				if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
			}
			return pno;	
		}	
	//관리자가 글읽었을때 같은 그룹의 글(답글이나 원글이나) iread값 업데이트시키기
		public int updateIread(IQBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null; 
		String sql = "update personalboard set iread=? where igroup=?";
		DBmanager db = new DBmanager();
		int result  = -1;
		try {	
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getIread());
			pstmt.setInt(2, dto.getIgroup());
			result = pstmt.executeUpdate();	
			
		}catch (Exception e) {e.printStackTrace(); 
		}finally { 
			
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}

		return result;
		
	}
	//글 넘버로 회원 아이디랑 전화번호 가져오기
		public Cre_Acc_Dto userinfo_ino (int ino){ 
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			Cre_Acc_Dto userinfo = new Cre_Acc_Dto();
			//관리자는 읽지않음이나 처리중인글 보기
			String sql="select m.pno, m.pname, m.pbirthDay, m.pgender, m.plocal, m.pphonenumber, m.pid, m.ppass, m.pemail, m.pdate, m.pip, m.shopno from pagodamember m, personalboard p where m.pno=p.pno and p.ino=?";
			DBmanager db = new DBmanager();
			
			try {	
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ino);
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
						
					userinfo = new Cre_Acc_Dto(pno, pname, pbirthDay, pgender, plocal, pphonenumber, pid, ppass, pemail, pdate, pip, shopno);
				}
			}catch (Exception e) {e.printStackTrace(); 
			}finally { 
				if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
			}
			return userinfo;
		
		}
		
	//글번호로 iindent 번호 알아내기 
		public int findiindent (int ino){ 
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			DBmanager db = new DBmanager();
			String sql= "select iindent from personalboard where ino=?";
			int iindentnum = -1;
			try {	
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ino);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					
					iindentnum = rset.getInt(1);
					
				}
			}catch (Exception e) {e.printStackTrace(); 
			}finally { 
				if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
			}
			return iindentnum;		
		}
	//답글 수정했을때
		public int editcomment (IQBDto dto){ 
			Connection conn = null; PreparedStatement pstmt = null; 
			String sql = "update personalboard set ititle=?, icontent=?, iread=? where ino=?";
			DBmanager db = new DBmanager();
			int result  = -1;
			try {	
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getItitle());
				pstmt.setString(2, dto.getIcontent());
				pstmt.setInt(3, dto.getIread());
				pstmt.setInt(4, dto.getIno());
				result = pstmt.executeUpdate();	
				
			}catch (Exception e) {e.printStackTrace(); 
			}finally { 
				
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
			}

			return result;
			
		}
	
}//end class