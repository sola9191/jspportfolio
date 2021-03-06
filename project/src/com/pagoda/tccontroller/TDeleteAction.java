package com.pagoda.tccontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pagoda.dao.TCDao;
import com.pagoda.dto.TCDto;

public class TDeleteAction implements TAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		TCDao dao = new TCDao();
		TCDto dto  = new TCDto();
		
		dto.setTeacherno(Integer.parseInt(request.getParameter("teacherno")));
		int result = dao.delete(dto);

		if(result>0) {
			out.println("<script> alert('게시글이 삭제 되었습니다'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.teacher'; </script>");
		}
		else {
			out.println("<scirpt> alert('게시글 삭제가 실패하였습니다. 관리자에게 문의하세요.); </script>");
		}
		
	}

}
