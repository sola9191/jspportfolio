package com.pagoda.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pagoda.dbmanager.DBmanager;

/**
 * Servlet implementation class main_cart_AJAX
 */
@WebServlet("/main_cart_AJAX")
public class main_cart_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main_cart_AJAX() {
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
		Connection conn = null; PreparedStatement pstmt =null; ResultSet rset = null;
		String sql = "select c.classno, c.classcategory, c.classprice, c.classstart, c.classend, c.classname, t.teachername "
				+"from classes c, teachers t where c.teacherno = t.teacherno and c.classname=?";
		DBmanager db = new DBmanager();
		JsonArray arr = new JsonArray();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("classname"));
			rset = pstmt.executeQuery();
			JsonObject obj = new JsonObject();
			
			while(rset.next()) {
				
				obj.addProperty("classno", rset.getString("classno"));
				obj.addProperty("classcategory", rset.getString("classcategory"));
				obj.addProperty("classprice", Integer.parseInt(rset.getString("classprice")));
				obj.addProperty("classstart", rset.getString("classstart"));
				obj.addProperty("classend", rset.getString("classend"));
				obj.addProperty("classname", rset.getString("classname"));
				obj.addProperty("teachername", rset.getString("teachername"));
	
			}
			//1. json 파일만들기
			Gson gson  = new Gson();
			String json = gson.toJson(obj);
			
			//2. 파싱하기
			JsonParser parser = new JsonParser();
			JsonObject tmp = (JsonObject) parser.parse(json);
			String cno = tmp.get("classno").getAsString();
			String ccate = tmp.get("classcategory").getAsString();
			String cprice = tmp.get("classprice").getAsString();
			String cstart = tmp.get("classstart").getAsString();
			String cend = tmp.get("classend").getAsString();
			String tname = tmp.get("teachername").getAsString();
			String cname = tmp.get("classname").getAsString();
			
			String list = cno+","+ccate+","+cprice+","+cstart+","+cend+","+tname+","+cname;
		
			
			Cookie cookie = new Cookie("itemcart", URLEncoder.encode(list, "UTF-8"));
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
	
		}catch(Exception e) { e.printStackTrace(); 
		}finally { 
			if(rset!=null) {try {rset.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(pstmt!=null) {try {pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close(); } catch (SQLException e) {e.printStackTrace();}}
		}	
	}
}