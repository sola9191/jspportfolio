package com.pagoda.clacontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.ClassDao;
import com.pagoda.dto.ClassDto;

public class ClaDeleteAction implements CLAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ClassDao dao = new ClassDao();
		ClassDto dto  = new ClassDto();
		int classno = Integer.parseInt(request.getParameter("classno"));
		dto.setClassno(classno);
		int result = dao.delete(dto);

		if(result>0) {
			out.println("<script> alert('게시글이 삭제 되었습니다'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.class'; </script>");
		}
		else {
			out.println("<scirpt> alert('게시글 삭제가 실패하였습니다. 관리자에게 문의하세요.); </script>");
		}
		
	}

}

