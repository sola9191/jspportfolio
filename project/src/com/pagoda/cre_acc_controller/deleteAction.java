package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.kakaoDao;
import com.pagoda.dto.Cre_Acc_Dto;

public class deleteAction implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		HttpSession session = request.getSession();
		
		///////////////////////////////아이디로 회원번호 알아내기
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		dto.setPid((String)session.getAttribute("pid"));
		int pno = dao.userinfo(dto).getPno(); //회원번호 구했드아
		//////////////////////////////		
		int result = dao.userdelete((String)session.getAttribute("pid"));
	
		if(result>0) {
			
			session.invalidate(); //세션삭제하기
			//쿠키삭제하기
			String cookie = request.getHeader("Cookie");
			if(cookie!=null) {
				Cookie [] cookies = request.getCookies();
				for(int i=0 ; i<cookies.length ; i++) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);	
				}
				
			}//쿠키삭제끝
			//여기다가 카카오테이블에 회원번호 조회했을때 아이디가 있으면 이것도 삭제하기 
			kakaoDao kakaodao = new kakaoDao();
			if(kakaodao.deletepro1(pno)==1) { //아디 있는거라서 테이브레서 아디 삭제해야됨
				if(kakaodao.deletepro2(pno)==1 ) {
					out.println("<script> alert('계정이 삭제되었습니다.'); </script>");
					out.println("<script> location.href='"+request.getContextPath()+"/Main/pagoda_main.jsp';</script>");	
				}
			}
			out.println("<script> alert('계정이 삭제되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/Main/pagoda_main.jsp';</script>");	
		}
		else { 
			out.println("<script> alert('계정 삭제에 실패하였습니다. 관리자에게 문의하세요.'); history.go(-1); </script>");
		}
	}

}
