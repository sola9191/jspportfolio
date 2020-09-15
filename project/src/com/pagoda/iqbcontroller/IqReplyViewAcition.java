package com.pagoda.iqbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.IQBDao;
import com.pagoda.dto.IQBDto;

public class IqReplyViewAcition implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IQBDao dao = new IQBDao();
		IQBDto dto = dao.detail(Integer.parseInt(request.getParameter("ino"))); //admin 자기정보 
		
		dto.setItitle("ㄴRe: "+dto.getItitle());
		dto.setIcontent("\n\n\n> " + dto.getIcontent().replaceAll("\n", "> \n"));
		request.setAttribute("dto", dto);
	}

}
