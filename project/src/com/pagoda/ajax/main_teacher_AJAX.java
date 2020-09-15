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
 * Servlet implementation class main_teacher_AJAX
 */
@WebServlet("/main_teacher_AJAX")
public class main_teacher_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main_teacher_AJAX() {
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
		String sql = "select teachername from teachers " 
					+ "where teacherno in ( " 
					+ "select distinct c.teacherno "
					+ "from classcate cate, classes c "
					+ "where cate.classcateno=c.classcateno "
					+ "and cate.classcatename=?)";				
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"    ?> <teachers>";
		DBmanager db = new DBmanager();
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("subname"));
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result+= "<each><teachername>"+rset.getString("teachername")+"</teachername></each>";
			}
			out.println(result+="</teachers>");
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		PrintWriter out = response.getWriter();
		String sql  ="select teachername, teacherinfo, teacherimg from teachers where teacherno=?";
		//json 형시으로 할려면 객체 만들기 
		JsonArray arr = new JsonArray();
		try{	
			conn = db.getConnection();	
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			JsonObject obj = new JsonObject();
			obj.addProperty("teacherno", rset.getString("teacherno"));
			obj.addProperty("teachername", rset.getString("teachername"));
			obj.addProperty("teacherinfo", rset.getString("teacherinfo"));
			obj.addProperty("teacherimg", rset.getString("teacherimg"));
			arr.add(obj);
		}
			Gson gson = new Gson();
			JsonObject data  = new JsonObject();
			data.add("teacherinfo", arr);
			out.println( gson.toJson(data));
			out.close();
			}catch (Exception e) { e.printStackTrace();
		}finally { 
		if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
		if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
		if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}				
		}
	}
}

