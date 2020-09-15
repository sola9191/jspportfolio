package com.pagoda.csbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.CSBDao;
import com.pagoda.dto.CSBDto;

public class CWriteAction implements CAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		CSBDto dto  =  new CSBDto();
		CSBDao dao = new CSBDao();

		dto.setCcategorynum(Integer.parseInt(request.getParameter("ccategorynum")));
		dto.setCname(request.getParameter("cname"));
		dto.setCpass(request.getParameter("cpass"));
		dto.setCtitle(request.getParameter("ctitle"));
		dto.setCcontent(request.getParameter("ccontent"));
		if(dao.passchk(request.getParameter("cpass"))==1) {
			int  result = dao.write(dto);
				if(result > 0) {
					out.println("<script> alert('게시글 등록에 성공하였습니다.'); </script>");
					out.println("<script> location.href='"+request.getContextPath()+"/list.service'; </script>");
				}
				else {
					out.println("<script> alert('게시글 등록에 실패하였습니다. '); history.go(-1);</script>");
				}
		}
		else { out.println("<script> alert('관리자 비밀번호가 일치하지 않습니다.'); history.go(-1); </script>"); }

	}
}
