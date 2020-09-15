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
 * Servlet implementation class teacher_detil_AJAX
 */
@WebServlet("/teacher_detil_AJAX")
public class teacher_detil_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_detil_AJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String sql  ="select t.teachername, t.teacherinfo, t.teacherimg, c.classcategory, c.classname, c.classprice " + 
				"from teachers t, classes c where t.teacherno = c.teacherno and t.teachername=?"; 
		//json 형시으로 할려면 객체 만들기
		JsonArray arr = new JsonArray();
		try{	
			conn = db.getConnection();	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("teachername"));
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			JsonObject obj = new JsonObject();
			obj.addProperty("teachername", rset.getString("teachername"));
			obj.addProperty("teacherinfo", rset.getString("teacherinfo"));
			obj.addProperty("teacherimg", rset.getString("teacherimg"));
			obj.addProperty("classcategory", rset.getString("classcategory"));
			obj.addProperty("classname", rset.getString("classname"));
			obj.addProperty("classprice", rset.getString("classprice"));
			arr.add(obj);
		}
			
			Gson gson = new Gson();
			JsonObject jobj  = new JsonObject();
			jobj.add("tinfo", arr);
			out.println( gson.toJson(jobj));
			out.close();
			}catch (Exception e) { e.printStackTrace();
		}finally { 
		if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
		if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
		if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}				
		}
	}
}