package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

public class MylectureAction implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(); 
		String pid = (String) session.getAttribute("pid");
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		
		if(pid==null) {
			
			out.println("<script> alert('로그인이 필요한 페이지 입니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/login_view.do';</script>");
			
		}
		else {
			dto.setPid(pid);
			request.setAttribute("pname", dao.userinfo(dto).getPname());
			request.getRequestDispatcher("/Account/mypage.jsp").forward(request, response);
		
		}
	}

}
