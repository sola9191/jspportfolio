package com.pagoda.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class findbook_list_AJAX
 */
@WebServlet("/findbook_list_AJAX")
public class findbook_list_AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findbook_list_AJAX() {
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
		 
		String clientId = "L6KH98yvInrfVK6_AFfw"; //애플리케이션 클라이언트 아이디값"
	    String clientSecret = "d0awkHrYcb"; //애플리케이션 클라이언트 시크릿값"
	    
	    String text = URLEncoder.encode(request.getParameter("booktitle"), "UTF-8");
	    String apiURL ="https://openapi.naver.com/v1/search/book.json?query="+text;
		
	    URL url = new URL(apiURL);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("X-Naver-Client-Id", "L6KH98yvInrfVK6_AFfw");
	    conn.setRequestProperty("X-Naver-Client-Secret", "d0awkHrYcb");
	    
		BufferedReader br = null;
		
		if(conn.getResponseCode()==200) {//성공한거
			br = new BufferedReader(new InputStreamReader (conn.getInputStream(), "UTF-8"));
		}
		else { br = new BufferedReader(new InputStreamReader ( conn.getErrorStream())); }
		
		StringBuffer sb = new StringBuffer();
		String line = "";
		while((line=br.readLine())!=null) { sb.append(line); }
		br.close(); conn.disconnect();
		out.println(sb.toString());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
