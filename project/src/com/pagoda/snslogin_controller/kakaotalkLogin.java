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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pagoda.dao.kakaoDao;

/**
 * Servlet implementation class kakaotalkLogin
 */
@WebServlet("/kakaotalkLogin")
public class kakaotalkLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kakaotalkLogin() {
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
		String client_id = "9a3ae449dbf7d54fb4151c3a2165a2f1";
		String redirect_uri= "http://pa4138.cafe24.com/solgoda/kakaotalkLogin";
		String code = request.getParameter("code"); 
		String url = "https://kauth.kakao.com/oauth/token?";
				
		url+= "grant_type=authorization_code&";
		url+= "client_id="+client_id + "&";
		url+= "redirect_uri="+redirect_uri + "&";
		url+= "code="+code ;
		
		///////////////////////////////////////////////위에 보낸 데이터 json객체로 받음
		URL kakaourl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)kakaourl.openConnection();
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

		//Json파일에서 access_token 추출하기
		JsonParser parser = new JsonParser();
		JsonObject jobj = (JsonObject) parser.parse(sb.toString());
		String access_token = jobj.get("access_token").getAsString();
	
		//System.out.println(access_token);
		//사용자정보요청
		//GET/POST /v2/user/me HTTP/1.1
		//Host: kapi.kakao.com
		//Authorization: Bearer {access_token}
		//Content-type: application/x-www-form-urlencoded;charset=utf-8
		
		url = "https://kapi.kakao.com/v2/user/me";
		kakaourl = new URL(url);
		conn = (HttpURLConnection) kakaourl.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer " + access_token);
		conn.setRequestProperty("Content-type" , "application/json;charset=UTF-8");
		
		br=null; line = null;  sb = new StringBuffer();

		if(conn.getResponseCode()==200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream())); }
		else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		while ( ( line=br.readLine()) !=null) { sb.append(line); }
		
		br.close(); conn.disconnect();
		
		//사용자 viewpage에서 확인
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(sb.toString());
		
		String id = jsonObject.get("id").getAsString();  
		
		kakaoDao kakaodao = new kakaoDao();
		int login = kakaodao.findkid(id); //1이면 아디있어서 로그인 0이면 회원가입하게하기
		
		if(login!=1) {
			out.println("<script> alert ('등록된 아이디가 없습니다. 회원가입화면으로 넘어갑니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/createId_view.do?kid="+id+"'; </script>");
		}
		else if(login==1){
			
			out.println("<script> alert ('카카오톡 아이디로 등록된 아이디가 존재합니다!'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/loginkakao.do?kid="+id+"'; </script>");
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
