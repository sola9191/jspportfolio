package com.pagoda.ntbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.NTBDao;
import com.pagoda.dto.NTBDto;

public class NEditAction implements NAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		NTBDao dao = new NTBDao();
		NTBDto dto = new NTBDto();
		
		if(dao.passchk(request.getParameter("npass"))==1) {
			dto.setNno(Integer.parseInt(request.getParameter("nno")));
			dto.setNpass(request.getParameter("npass"));
			dto.setNcate(request.getParameter("ncate"));
			dto.setNtitle(request.getParameter("ntitle"));
			dto.setNcontent(request.getParameter("ncontent"));
		
			int  result = dao.edit(dto);
			
			
			if(result > 0) {
				out.println("<script> alert('수정성공!'); </script>");
				out.println("<script> location.href='"+request.getContextPath()+"/list.notice'; </script>");
			}
			else {
				out.println("<script> alert('수정 실패!'); history.go(-1);</script>");
			}
	}
	else { out.println("<script> alert('관리자 비밀번호가 일치하지 않습니다.'); history.go(-1); </script>"); }

}
}

			
			
			
			
			
	