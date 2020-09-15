package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

public class findIdAction implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		dto.setPname(request.getParameter("pname"));
		dto.setPemail(request.getParameter("pemail"));
		if(dao.findId(dto).getPid()!=null) {
			
			request.setAttribute("tmpId", dao.findId(dto).getPid());
			request.getRequestDispatcher("/Account/afterFindId.jsp").forward(request, response);
		}
		else { 
			out.println("<script> alert('이름과 이메일을 다시 확인해주세요'); history.go(-1); </script>");
			
		}

	}

}
