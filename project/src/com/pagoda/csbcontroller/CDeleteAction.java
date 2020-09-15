package com.pagoda.csbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.CSBDao;
import com.pagoda.dto.CSBDto;

public class CDeleteAction implements CAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		CSBDto dto = new CSBDto();
		CSBDao dao = new CSBDao();
		
		dto.setCno(Integer.parseInt(request.getParameter("cno")));
		dto.setCpass(request.getParameter("cpass"));
			
		int result = dao.delete(dto);
		if(result>0) { 
			out.println("<script> alert('게시글 삭제 성공'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.service'; </script>");
		}
		else {
			out.println("<script> alert('게시글 삭제 실패'); history.go(-1); </script>");			
		}
	}

}
