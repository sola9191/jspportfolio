package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.kakaoDao;

public class loginkakaoAction implements CreAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF8");
		HttpSession session = request.getSession(); 
		PrintWriter out = response.getWriter();
		//카카오아디로 pno조회해서 이걸로 pid가져오기 
		kakaoDao dao = new kakaoDao();
		String userinfo = dao.findinfo(request.getParameter("kid"));
		
		String userinfoarr [] = userinfo.split(",");

		//1. 이름
		request.setAttribute("pname", userinfoarr[0]);
		request.setAttribute("pid", userinfoarr[1]);

		//2. 로그인 성공시 세션에 아이디 저장
		session.setAttribute("pid", userinfoarr[1]);
		request.getRequestDispatcher("/Account/mypage.jsp").forward(request, response);

	}
}
