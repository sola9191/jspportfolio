package com.pagoda.cre_acc_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

public class detailBackAction implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chatset=UTF-8");
		HttpSession session = request.getSession();
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		dto.setPid((String) session.getAttribute("pid"));
		request.setAttribute("dto", dao.userinfo(dto));

	}

}
