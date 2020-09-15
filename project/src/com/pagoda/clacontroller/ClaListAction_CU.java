package com.pagoda.clacontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.ClassDao;

public class ClaListAction_CU implements CLAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ClassDao dao = new ClassDao();	
		request.setAttribute("list", dao.clistAll_name(request.getParameter("classcate")));

	}

}
