package com.pagoda.clacontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.ClassDao;
import com.pagoda.dto.ClassDto;

public class ClaEditViewAciton implements CLAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		ClassDto dto = new ClassDto();
		ClassDao dao = new ClassDao();
		int classno = Integer.parseInt(request.getParameter("classno"));
		request.setAttribute("cinfo", dao.detail(classno));
		request.setAttribute("teacherlist", dao.listAll());

	}

}
