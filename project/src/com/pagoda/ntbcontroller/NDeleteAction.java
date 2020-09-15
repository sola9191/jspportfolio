package com.pagoda.ntbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.NTBDao;
import com.pagoda.dto.NTBDto;

public class NDeleteAction implements NAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		NTBDto dto = new NTBDto();
		NTBDao dao = new NTBDao();
		
		dto.setNno(Integer.parseInt(request.getParameter("nno")));
		dto.setNpass(request.getParameter("npass"));
			
		int result = dao.delete(dto);
		if(result>0) { 
			out.println("<script> alert('게시글 삭제 성공'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.notice'; </script>");
		}
		else {
			out.println("<script> alert('게시글 삭제 실패'); history.go(-1); </script>");			
		}
	}

}
