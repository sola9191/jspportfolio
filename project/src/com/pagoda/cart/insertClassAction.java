package com.pagoda.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dbmanager.DBmanager;

public class insertClassAction implements CTAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(); 
		String pid = (String) session.getAttribute("pid");
		int result = -1;
	
		if(pid==null) {//로그인안되있으면 로그인먼저시키고 
			
			out.println("<script> alert('로그인이 필요한 페이지 입니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/login_view.do';</script>");	
		}
		else { //로그인 되있으면 dao 처리해서 다망
			//pid랑 cno필요
			int cno = Integer.parseInt(request.getParameter("cno"));
			int pno = -1;
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
			DBmanager db = new DBmanager();
			String sql = "select pno from pagodamember where pid=?";
			try {
				conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rset = pstmt.executeQuery();
			while(rset.next()) {  pno = rset.getInt("pno"); }
			pstmt.close(); rset.close(); sql = null;
			
			int classdbck =-1;
			sql = "select count(classno) from member_class where classno=? and pno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setInt(2, pno);
			rset = pstmt.executeQuery();
			while(rset.next()) { classdbck = rset.getInt(1);	}
			
			if(classdbck>0) {
				out.println("<script> alert('이미 수강중인 강의입니다.'); </script>");
				out.println("<script> location.href='"+request.getContextPath()+"/delete.cart'; </script>");
			}
			
			else {		
		
			sql = "insert into member_class (classno, pno) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setInt(2, pno);
			result = pstmt.executeUpdate();
						
			if(result > 0) { //성공했으면 
				out.println("<script> alert('강의가 결제되었습니다.'); </script>");
				out.println("<script> location.href='"+request.getContextPath()+"/mylecture.do'; </script>");
			}
			else {	out.println("<script> alert('강의 결제에 실패하였습니다.'); history.go(-1);</script>"); 	}
			}
			} catch (Exception e) {		e.printStackTrace(); 
			}finally { 
				if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
				if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		    }//end finally	
		}//end else			
	}//end method
}
