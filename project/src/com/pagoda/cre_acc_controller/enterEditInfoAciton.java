package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

public class enterEditInfoAciton implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		HttpSession session = request.getSession();
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		PrintWriter out = response.getWriter(); 
		dto.setPid((String) session.getAttribute("pid"));
		dto.setPpass(request.getParameter("ppass"));
		int result = dao.login(dto);
		
		if(result==1) { 
			request.setAttribute("dto", dao.userinfo(dto));
			request.getRequestDispatcher("/Account/editInfo.jsp").forward(request, response);
		}
		else {
			out.println("<script>alert('비밀번호를 다시 확인해주세요'); history.go(-1); </script>");		
		}
		

	}

}

