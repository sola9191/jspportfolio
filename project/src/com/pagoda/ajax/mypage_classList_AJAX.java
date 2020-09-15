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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pagoda.dbmanager.DBmanager;

/**
 * Servlet implementation class mypage_classList_AJAX
 */
@WebServlet("/mypage_classList_AJAX")
public class mypage_classList_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mypage_classList_AJAX() {
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
		HttpSession session =  request.getSession();
		String pid = null; int pno=-1;
		if(session.getAttribute("pid")!=null) { pid = (String) session.getAttribute("pid"); } 
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "select pno from pagodamember where pid=?";
		DBmanager db = new DBmanager();
		
		try{					
			conn = db.getConnection();	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pno = rset.getInt(1);
			}
			pstmt = null; rset = null;
			 sql  ="select c.classno, c.classcategory, c.classname, c.classstart, c.classend from member_class mc, classes c where "
					+"mc.classno = c.classno and pno=?";	
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, pno);
			 rset = pstmt.executeQuery();
			 JsonArray arr = new JsonArray();
			 while(rset.next()) {
				 JsonObject obj = new JsonObject();
				 obj.addProperty("cno", rset.getString("classno"));
				 obj.addProperty("ccate", rset.getString("classcategory"));
				 obj.addProperty("cname", rset.getString("classname"));
				 obj.addProperty("cstart", rset.getString("classstart"));
				 obj.addProperty("cend", rset.getString("classend"));
				 arr.add(obj);
			 }
			 Gson gson = new Gson();
			 JsonObject json = new JsonObject();
			 json.add("list", arr);
			 out.println(gson.toJson(json));
		}catch (Exception e) { e.printStackTrace();
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
