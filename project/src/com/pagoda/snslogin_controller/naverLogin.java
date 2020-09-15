package com.pagoda.snslogin_controller;

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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

/**
 * Servlet implementation class naverLogin
 */
@WebServlet("/naverLogin")
public class naverLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public naverLogin() {
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
		
		String clientId = "L6KH98yvInrfVK6_AFfw";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "d0awkHrYcb";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://localhost:8080/project/naverLogin", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	   // System.out.println("apiURL="+apiURL);
	   
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br = null;

	    //  System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String line = null;
	      StringBuffer sb = new StringBuffer();
	     
	      while ((line = br.readLine()) != null) {    sb.append(line);     }
	      br.close();
	      if(responseCode==200) { // 정상 호출       System.out.println(sb.toString());
		      } 
	  
	      
	    	/////////////////////////////////////////////////////////////
	    //Json파일에서 access_token만 추출하기
	    JsonParser tparser  = new JsonParser();
	    JsonObject obj = (JsonObject) tparser.parse(sb.toString());
	    String atvalue = obj.get("access_token").getAsString();   
	    
/////////////////////////////////////////////////////////////////////////////

        apiURL = "https://openapi.naver.com/v1/nid/me";
        url = new URL(apiURL);
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + atvalue);
        br = null; line = null; sb = new StringBuffer();
        if(con.getResponseCode()==200) { //성공시
			br = new BufferedReader(new InputStreamReader(con.getInputStream())); }
		else { //실패시
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
        while( ( line = br.readLine()) !=null) {sb.append(line);}
        br.close(); con.disconnect();
        System.out.println("sb"+ sb.toString());
        JsonParser idparser = new JsonParser();
        JsonObject tmpobj = (JsonObject) idparser.parse(sb.toString());
        JsonObject res = (JsonObject) tmpobj.get("response");
     
        String id =  res.get("id").getAsString();
       //이아이디값을 새로운 servlet에 보내서 처리하자
        Cre_Acc_Dao dao = new Cre_Acc_Dao();
        Cre_Acc_Dto dto = new Cre_Acc_Dto();
        dto.setPid(id);
        int result = dao.iddouble(dto);
        String path =null; //경로정해줌
        if(result==1) { //아디있다 로그인
        		}
        else { 
        	out.println("<script> alert('등록된 아이디가 없습니다.'); </script>");
        	out.println("<script> location.href='"+request.getContextPath()+"/createId_view.do?id="+id+"';</script>");
        }
        
        request.getRequestDispatcher(path).forward(request, response);
        

	    }catch (Exception e) { System.out.println(e); } 

   
 
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
