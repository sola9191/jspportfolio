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
 * Servlet implementation class main_final_AJAX
 */
@WebServlet("/main_final_AJAX")
public class main_final_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main_final_AJAX() {
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
		String sql = "select classno, classname, classprice, date_format(classstart, '%Y-%m-%d'), date_format(classend, '%Y-%m-%d') from classes where classname=?";
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"    ?> <classsinfo>";
		DBmanager db = new DBmanager();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("classname"));
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result+= "<list><classno>"+rset.getInt("classno")+"</classno>";
				result+= "<classname>"+rset.getString("classname")+"</classname>";
				result+= "<classprice>"+rset.getInt("classprice")+"</classprice>";
				result+= "<classstart>"+rset.getString("date_format(classstart, '%Y-%m-%d')")+"</classstart>";
				result+= "<classend>"+rset.getString("date_format(classend, '%Y-%m-%d')")+"</classend></list>";				
			}
			out.println(result+="</classinfo>");
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
