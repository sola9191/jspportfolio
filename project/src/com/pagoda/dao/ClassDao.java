package com.pagoda.dao;

import java.net.InetAddress;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.ClassDto;
import com.pagoda.dto.TCDto;
/*
 int classno, String classname, int classcateno, String classcategory, int classprice,
			String classdetail, String classcompo, String classstart, String classend, int teacherno,
			String classpostdate, String classip, String classcreator
 */
public class ClassDao {
	
	//선생님들 리스트 불러오기
	public ArrayList<TCDto> listAll() {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<TCDto> list = new ArrayList<TCDto>();
		String sql = "select * from teachers";
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
	//강의번호로 선생님 이름확인 
		public String tname(int classno) {
			Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
			DBmanager db = new DBmanager();
			String tname = null;
			String sql = "select t.teachername from teachers t inner join classes c on t.teacherno = c.teacherno where c.classno=?";
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classno);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					tname = rset.getString(1);	
					}
			} catch ( Exception e) { e.printStackTrace();
			}finally {
				if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return tname;
		}
	//강의 list불러오기
	public ArrayList<ClassDto> clistAll() {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
		DBmanager db = new DBmanager();
		ArrayList<ClassDto> list = new ArrayList<ClassDto>();
		String sql = "select * from classes order by classno desc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ClassDto(rset.getInt("classno"), rset.getString("classname"), rset.getInt("classcateno"),
						rset.getString("classcategory"), rset.getInt("classprice"), rset.getString("classdetail"), 
						rset.getString("classcompo"), rset.getString("classstart"), rset.getString("classend"),
						rset.getInt("teacherno"), rset.getString("classpostdate"), rset.getString("classip"),
						rset.getString("classcreator")));				
				}
		} catch ( Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}	
	
	//강의등록
	public int create(ClassDto dto) {
		Connection conn = null; PreparedStatement pstmt =  null;
		DBmanager db = new DBmanager();
				String sql = "insert into classes (classname, classcateno, classcategory, classprice, classdetail, classcompo, "
						+ "classstart, classend , teacherno , classip, classcreator)"
						+ "values (?,?,?,?,?,?,?,?,?,?,?)";
				int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getClassname());
			pstmt.setInt(2, dto.getClasscateno());
			pstmt.setString(3, dto.getClasscategory());
			pstmt.setInt(4, dto.getClassprice());
			pstmt.setString(5, dto.getClassdetail());
			pstmt.setString(6, dto.getClasscompo());
			pstmt.setString(7, dto.getClassstart());
			pstmt.setString(8, dto.getClassend());
			pstmt.setInt(9, dto.getTeacherno());
			pstmt.setString(10, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(11, dto.getClasscreator());
		
			result = pstmt.executeUpdate();		
		}catch ( Exception  e) { e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
			if(conn!=null) {try { pstmt.close(); } catch ( SQLException e ) { e.printStackTrace(); }}
		}
		return result;
	}
	//강의상세보기
	public ClassDto detail(int classno) {
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select * from classes where classno=?";
		ClassDto dto = new ClassDto();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				dto = new ClassDto(rset.getInt("classno"), rset.getString("classname"), rset.getInt("classcateno"),
						rset.getString("classcategory"), rset.getInt("classprice"), rset.getString("classdetail"), 
						rset.getString("classcompo"), rset.getString("classstart"), rset.getString("classend"),
						rset.getInt("teacherno"), rset.getString("classpostdate"), rset.getString("classip"),
						rset.getString("classcreator"));

			}
		
			}catch (Exception e) { e.printStackTrace(); 
			}finally {
				if(rset!=null) { try {rset.close(); }catch (SQLException e) {e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return dto;
		}
	//강의수정
	public int edit (ClassDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db = new DBmanager();
		String sql = "update classes set classname=?, classcateno=?, classcategory=?, classprice=?, "
				+ "classdetail=?, classcompo=?, classstart=?,  classend =?, teacherno=?, classcreator=? where classno=?";
		int result =-1;
		try { //여기서부터 수정
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getClassname());
			pstmt.setInt(2, dto.getClasscateno());
			pstmt.setString(3, dto.getClasscategory());
			pstmt.setInt(4, dto.getClassprice());
			pstmt.setString(5, dto.getClassdetail());
			pstmt.setString(6, dto.getClasscompo());
			pstmt.setString(7, dto.getClassstart());
			pstmt.setString(8, dto.getClassend());
			pstmt.setInt(9, dto.getTeacherno());
			pstmt.setString(10, dto.getClasscreator());
			pstmt.setInt(11, dto.getClassno());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace(); 
		}finally {
			if(pstmt!=null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
		}
		return result;		
	}
	//강의삭제
	public int delete (ClassDto dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		DBmanager db  =  new DBmanager();
		String sql =  "delete from classes where classno=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getClassno());
			result = pstmt.executeUpdate();
		}catch(Exception e) { e.printStackTrace(); 
		}finally{
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}	
		return result;
	}
	//강의 이름으로  강의 번호 찾기
	public int findclassno (String classname) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db  =  new DBmanager();
		String sql =  "select classno from classes where classname=?";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classname);
			rset = pstmt.executeQuery();
			while(rset.next()) { result = rset.getInt("classno");} 
		}catch(Exception e) { e.printStackTrace(); 
		}finally{
			if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}	
		return result;
	}
	
	//강의 강의이름으로 list불러오기
		public ArrayList<ClassDto> clistAll_name(String name) {
			Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
			DBmanager db = new DBmanager();
			ArrayList<ClassDto> list = new ArrayList<ClassDto>();
			String sql = "select * from classes where classcategory=?";
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					list.add(new ClassDto(rset.getInt("classno"), rset.getString("classname"), rset.getInt("classcateno"),
							rset.getString("classcategory"), rset.getInt("classprice"), rset.getString("classdetail"), 
							rset.getString("classcompo"), rset.getString("classstart"), rset.getString("classend"),
							rset.getInt("teacherno"), rset.getString("classpostdate"), rset.getString("classip"),
							rset.getString("classcreator")));				
					}
			} catch ( Exception e) { e.printStackTrace();
			}finally {
				if(rset!=null) { try {rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(pstmt!=null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
				if(conn!=null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
			}
			return list;
		}	
		
	//선생님 번호로 강의목록 배열로 출력 
		
		public ArrayList<ClassDto> clistAll_tno(int teacherno) {
			Connection conn = null; PreparedStatement pstmt = null; ResultSet  rset = null;
			DBmanager db = new DBmanager();
			ArrayList<ClassDto> list = new ArrayList<ClassDto>();
			String sql = " select * from classes where teacherno=?";
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, teacherno);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new ClassDto(rset.getInt("classno"), rset.getString("classname"), rset.getInt("classcateno"),
							rset.getString("classcategory"), rset.getInt("classprice"), rset.getString("classdetail"), 
							rset.getString("classcompo"), rset.getString("classstart"), rset.getString("classend"),
							rset.getInt("teacherno"), rset.getString("classpostdate"), rset.getString("classip"),
							rset.getString("classcreator")));				
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
