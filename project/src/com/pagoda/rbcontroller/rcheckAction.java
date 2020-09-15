package com.pagoda.rbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.RBDao;
import com.pagoda.dto.RBDto;

public class rcheckAction implements RAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		RBDao dao = new RBDao();
		RBDto dto = new RBDto();
		dto = dao.detail(Integer.parseInt(request.getParameter("rno")));
		
		if(dto.getRpass().equals(request.getParameter("rpass"))){ 
			String view="/edit_view.creview";
			request.getRequestDispatcher(view).forward(request, response);			
		}
		else {
			out.println("<script>alert('비밀번호를 다시 확인해주세요.');</script>");
			out.println("<script> history.go(-1); </script>");
		}		

	}

}
