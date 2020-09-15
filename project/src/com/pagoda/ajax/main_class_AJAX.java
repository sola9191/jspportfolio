package com.pagoda.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dbmanager.DBmanager;

/**
 * Servlet implementation class main_class_AJAX
 */
@WebServlet("/main_class_AJAX")
public class main_class_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main_class_AJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;
		String sql = "select c.classname from teachers t, classes c "
					+"where t.teacherno = c.teacherno "
					+"and classcategory=? "
					+"and teachername=? ";		
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"    ?> <final>";
		DBmanager db = new DBmanager();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("sbjname"));
			pstmt.setString(2, request.getParameter("tcname"));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result+= "<list><classes>"+rset.getString("classname")+"</classes></list>";
			}
			out.println(result+="</final>");
		}catch(Exception e) { e.printStackTrace(); 
		}finally { 
			if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
