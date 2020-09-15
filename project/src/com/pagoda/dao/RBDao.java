package com.pagoda.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.RBDto;
/*
int rno, int pno, int classno, String rstar, String rtitle, String rpass, 
String rcontent, int rhit,	String rfile, String rip, String rdate) 
 */
public class RBDao {

	public ArrayList<RBDto> listAll(){
		Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<RBDto> list = new ArrayList<RBDto>();
		String sql = "select * from reviewboard order by rno desc";
		try {			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new RBDto(rset.getInt("rno"), rset.getInt("pno"), rset.getInt("classno"), 
						rset.getString("rstar"), rset.getString("rtitle"), rset.getString("rpass"), rset.getString("rcontent"),
						rset.getInt("rhit"), rset.getString("rfile"), rset.getString("rip"), rset.getString("rdate")));
			}
			
			
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	//화면 불러오기
	//작성자이름, 가지고있는 강의 불러와야함 
	public ArrayList<String> writeview(int pno){ //세션으로 pno찾아서 넣어줍시다.
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select p.pname, c.classname from pagodamember p, member_class mc join classes c " + 
				"where p.pno = mc.pno and mc.classno = c.classno and p.pno=?";
		String classname = null;  	String pname = null; 
		ArrayList<String> arr = new ArrayList<>();
		try {			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				pname = rset.getString("pname");
				String div = "/"; 
				classname = rset.getString("classname");
				arr.add(pname+div+classname);
			}			
			
		}catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return arr;
	}	
	
	//글쓰기 액션시 db에 저장된 비번이랑 기존 비번이랑 비교해서 다를시 글등록 안됨
	//==>> Cre_Acc_Dao 의 public int login (Cre_Acc_Dto dto) method (1이면 일치고 1아니면 불일치)	
	//수강후기게시판 글쓰기 액션
	public int write(RBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null; 
		DBmanager db = new DBmanager();
		String sql = "insert into reviewboard(pno, classno, rstar, rtitle, rpass, rcontent, rfile, rip) values(?,?,?,?,?,?,?,?)";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPno());
			pstmt.setInt(2, dto.getClassno());
			pstmt.setString(3, dto.getRstar());
			pstmt.setString(4, dto.getRtitle());
			pstmt.setString(5, dto.getRpass());
			pstmt.setString(6, dto.getRcontent());
			pstmt.setString(7, dto.getRfile());
			pstmt.setString(8, InetAddress.getLocalHost().getHostAddress());
			result = pstmt.executeUpdate();
		}catch(Exception e) { e.printStackTrace(); 
		}finally {
			if(pstmt!=null) { try {pstmt.close(); } catch(Exception e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch(Exception e) { e.printStackTrace(); }}
		}
		return result;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//상세보기 할때 rno가지고 강의 이름이랑 작성자 출력하는 method
	public ArrayList<String> detailview(int rno){ //글고유번호 rno 넣기
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select p.pname, c.classname from pagodamember p, classes c join reviewboard rb " + 
				"where p.pno = rb.pno and rb.classno = c.classno and rb.rno=?";
		String classname = null;  String pname = null; 
		ArrayList<String> arr = new ArrayList<>();
		try {			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				pname = rset.getString("pname");
				String div = "/"; 
				classname = rset.getString("classname");
				arr.add(pname+div+classname);
			}			
			
		}catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return arr;
	}	
	//수강후기게시판 상세보기
	public RBDto detail(int rno) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null; 
		DBmanager db = new DBmanager();
		String sql = "select * from reviewboard where rno=?";
		RBDto dto = new RBDto();
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				dto.setRno(rset.getInt("rno"));
				dto.setPno(rset.getInt("pno"));
				dto.setClassno(rset.getInt("classno"));
				dto.setRstar(rset.getString("rstar"));
				dto.setRtitle(rset.getString("rtitle"));
				dto.setRpass(rset.getString("rpass"));
				dto.setRcontent(rset.getString("rcontent"));
				dto.setRhit(rset.getInt("rhit"));
				dto.setRfile(rset.getString("rfile"));
				dto.setRip(rset.getString("rip"));
				dto.setRdate(rset.getString("rdate"));
			}
			
		}catch(Exception e) { e.printStackTrace(); 
		}finally {
			if(rset!=null) { try {pstmt.close(); } catch(Exception e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch(Exception e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch(Exception e) { e.printStackTrace(); }}
		}
		return dto;
	}
	
	//수강후기게시판 업데이트 //위에 비밀번호확인하는거 한다음에
	public int update(RBDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db = new DBmanager();
		String sql = "update reviewboard set rstar=?, rtitle=? , rcontent=?, rfile=? where rno=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getRstar());
			pstmt.setString(2, dto.getRtitle());
			pstmt.setString(3, dto.getRcontent());
			pstmt.setString(4, dto.getRfile());
			pstmt.setInt(5, dto.getRno());
			
			result = pstmt.executeUpdate();			
		}catch(Exception e) { e.printStackTrace(); 
		}finally {
			if(pstmt!=null) { try {pstmt.close(); } catch(Exception e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch(Exception e) { e.printStackTrace(); }}
		}
		return result;
	}
	//수강후기게시판 글삭제 //삭제하기전에 비번물어봐야함
	public int delete(int rno) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db = new DBmanager();
		String sql = "delete from reviewboard where rno=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			result = pstmt.executeUpdate();
		}catch(Exception e) { e.printStackTrace(); 
		}finally {
			if(pstmt!=null) { try {pstmt.close(); } catch(Exception e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch(Exception e) { e.printStackTrace(); }}
		}
		return result;
	}	
	
	//조회수 올리기 디테일누르면 글 조회수 올라가야함 
		public int addrhit(int rno) {
			Connection conn = null; PreparedStatement pstmt = null;
			DBmanager db = new DBmanager();
			String sql = "update reviewboard set rhit=rhit+1 where rno=?";
			int result = -1;
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rno);
				result = pstmt.executeUpdate();
			}catch(Exception e) { e.printStackTrace(); 
			}finally {
				if(pstmt!=null) { try {pstmt.close(); } catch(Exception e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch(Exception e) { e.printStackTrace(); }}
			}
			return result;
		}	

	//강의넘버에 따라 수강후기 가져오기
	//String sql = "select * from reviewboard where classno=?";
		public ArrayList<RBDto> detailreviewbyclassno (int classno){ 
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			DBmanager db = new DBmanager();
			String sql = "select * from reviewboard where classno=?";
			RBDto dto = new RBDto();
			ArrayList<RBDto> arr = new ArrayList<>();
			try {			
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classno);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					arr.add(new RBDto(rset.getInt("rno"), rset.getInt("pno"), rset.getInt("classno"), 
							rset.getString("rstar"), rset.getString("rtitle"), rset.getString("rpass"), rset.getString("rcontent"),
							rset.getInt("rhit"), rset.getString("rfile"), rset.getString("rip"), rset.getString("rdate")));
				}			
				
			}catch ( Exception e) { e.printStackTrace();
			}finally {
				if(rset!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return arr;
		}				
}