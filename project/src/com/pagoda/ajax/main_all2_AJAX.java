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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pagoda.dbmanager.DBmanager;

/**
 * Servlet implementation class main_all2_AJAX
 */
@WebServlet("/main_all2_AJAX")
public class main_all2_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main_all2_AJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		DBmanager db = new DBmanager();
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;	
		String sql1 = "select teachername from teachers where teacherno in ( select distinct c.teacherno from classcate cate, classes c where cate.classcateno=c.classcateno and cate.classcatename='토익')";		
		
		try {
			conn = db.getConnection();			
			pstmt = conn.prepareStatement(sql1);
			rset = pstmt.executeQuery();
			//json 형시으로 할려면 객체 만들기 
			JsonArray tname = new JsonArray();
			while(rset.next()) {
				JsonObject obj = new JsonObject();
				obj.addProperty("teachername", rset.getString("teachername"));
				tname.add(obj);
			}	
			
			Gson gson = new Gson();
			JsonObject teachername  = new JsonObject();
			teachername.add("tname", tname);
			out.println( gson.toJson(teachername));
			out.close();
		}catch(Exception e) { e.printStackTrace(); 
		}finally { 
			if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}	
	}
}		
			