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
import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dbmanager.DBmanager;
import com.pagoda.dto.Cre_Acc_Dto;
/**
 * Servlet implementation class d
 */
@WebServlet("/mypage_reviewList_AJAX")
public class mypage_reviewList_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mypage_reviewList_AJAX() {
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
		HttpSession session =  request.getSession();
		String pid = null; int pno=-1;
		if(session.getAttribute("pid")!=null) { pid = (String) session.getAttribute("pid"); } 
		Cre_Acc_Dao pnodao = new Cre_Acc_Dao();
		Cre_Acc_Dto pnodto = new Cre_Acc_Dto();
		pnodto.setPid(pid);
		pnodao.userinfo(pnodto);
		pno = pnodao.userinfo(pnodto).getPno();

		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		DBmanager db = new DBmanager();
		String sql = "select rb.*, c.classname from reviewboard rb, classes c where rb.classno = c.classno and pno=?";
		
		try{					
			conn = db.getConnection();	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			 rset = pstmt.executeQuery();
			 JsonArray arr = new JsonArray();
			 while(rset.next()) {
				 JsonObject obj = new JsonObject();
				 obj.addProperty("rno", rset.getInt("rno"));
					obj.addProperty("pno", rset.getInt("pno"));
					obj.addProperty("classno", rset.getInt("classno"));
					obj.addProperty("rstar", rset.getString("rstar"));
					obj.addProperty("rtitle", rset.getString("rtitle"));
					obj.addProperty("rpass", rset.getString("rpass"));
					obj.addProperty("rcontent", rset.getString("rcontent"));
					obj.addProperty("rfile", rset.getString("rfile"));	
					obj.addProperty("rhit", rset.getInt("rhit"));	
					obj.addProperty("rip",  rset.getString("rip"));	
					obj.addProperty("rdate", rset.getString("rdate"));	
					obj.addProperty("classname", rset.getString("classname"));
					
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
}