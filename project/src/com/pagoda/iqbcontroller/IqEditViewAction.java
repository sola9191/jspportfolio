package com.pagoda.iqbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.IQBDao;
import com.pagoda.dto.Cre_Acc_Dto;
import com.pagoda.dto.IQBDto;

public class IqEditViewAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IQBDao dao = new IQBDao();
		IQBDto dto = new IQBDto();
		
		Cre_Acc_Dao userinfo = new Cre_Acc_Dao();
		Cre_Acc_Dto userinfodto = new Cre_Acc_Dto();
		HttpSession session = request.getSession();
		String pid = (String) session.getAttribute("pid");
		userinfodto.setPid(pid);
		request.setAttribute("userinfo", userinfo.userinfo(userinfodto));		
		dto = dao.detail(Integer.parseInt(request.getParameter("ino")));
		request.setAttribute("dto", dto);
	}
}
