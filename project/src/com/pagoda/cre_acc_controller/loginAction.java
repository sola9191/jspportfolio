package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

public class loginAction implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF8");
		HttpSession session = request.getSession(); 
		PrintWriter out = response.getWriter();
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		Cre_Acc_Dto userinfo = new Cre_Acc_Dto();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		dto.setPid(request.getParameter("pid"));
		dto.setPpass(request.getParameter("ppass"));
		
		String pid = dao.userinfo(dto).getPid();
		int result = dao.login(dto);
		String remember = request.getParameter("rememberId");
		//회원정보가져오기
		userinfo = dao.userinfo(dto);
		//1. 이름
		request.setAttribute("pname", userinfo.getPname());
		//2. 수강후기
		//3. 수강강의
		
		if(result==1) {
			//1. 로그인 성공시 세션에 아이디 저장하고
			session.setAttribute("pid", request.getParameter("pid"));
			//2. remember 체크했을시 아이디 저장하기 (쿠키에 저장하기)
			if(remember!=null) {
				Cookie cookie1 = new Cookie("remember", "remember");
				Cookie cookie2 = new Cookie("pid", request.getParameter("pid"));
 				cookie1.setMaxAge(60*60*24*3);
 				cookie2.setMaxAge(60*60*24*3);
				response.addCookie(cookie1);	
				response.addCookie(cookie2);		
			}
			else { // remember 체크안했을때
				String cookie = request.getHeader("Cookie");
				if(cookie!=null) {
					Cookie [] cookies = request.getCookies();
					for(int i = 0; i<cookies.length ; i++) {
						if(cookies[i].getName().equals("remember")||cookies[i].getName().equals("pid")) {
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
					}
				}
			}
			}
			request.getRequestDispatcher("/Account/mypage.jsp").forward(request, response);
		}
		else { 
			out.println("<script> alert('아이디와 비밀번호를 다시 확인해주세요'); history.go(-1); </script>");
		}

	}

}
