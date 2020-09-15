package com.pagoda.snslogin_controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class translate
 */
@WebServlet("/translate")
public class translate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public translate() {
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
		
	
		String clientId = "L6KH98yvInrfVK6_AFfw";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "d0awkHrYcb";//애플리케이션 클라이언트 시크릿값";
       
        String redirect_uri= "http://localhost:8080/project/translate";
        String url = "https://openapi.naver.com/v1/papago/detectLangs?";
    	String query = (String) request.getParameter("oldsen");
    	
    	url+= "X-Naver-Client-Id="+clientId+"&";
    	url+= "X-Naver-Client-Secret="+clientSecret+"&";
    	url+= "query=" + query;
    	
    	URL papago = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)papago.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");//포스트는 주소창에 안뜨고 숨겨줌 get은 250자까지 가능
 		conn.setRequestProperty("Contetext-type", "application/json;charset=UTF-8"); //고치기
    	
 		BufferedReader br = null;
		String line = null;
		StringBuffer sb = new StringBuffer();
		if(conn.getResponseCode()==200) //성공했을때
		{ br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		}else { //실패했을때
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));	}
		
		while( (line=br.readLine()) !=null) { sb.append(line); }

		System.out.println(sb.toString());
	}
}
	