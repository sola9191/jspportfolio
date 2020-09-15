package com.pagoda.csbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.CSBDao;

public class CListAction implements CAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CSBDao dao = new CSBDao();
		request.setAttribute("list", dao.listAll());
		request.setAttribute("total", dao.listcnt());
	}
}
