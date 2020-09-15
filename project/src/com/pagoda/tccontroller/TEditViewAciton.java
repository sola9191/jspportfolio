package com.pagoda.tccontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.TCDao;
import com.pagoda.dto.TCDto;

public class TEditViewAciton implements TAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		TCDto dto = new TCDto();
		TCDao dao = new TCDao();
		int teacherno = Integer.parseInt(request.getParameter("tno"));
		request.setAttribute("tinfo", dao.detail(teacherno));

	}

}
