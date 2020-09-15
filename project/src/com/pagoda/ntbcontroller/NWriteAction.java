package com.pagoda.ntbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.NTBDao;
import com.pagoda.dto.NTBDto;

public class NWriteAction implements NAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		NTBDto dto  =  new NTBDto();
		NTBDao dao = new NTBDao();		
		
		if(dao.passchk(request.getParameter("npass"))==1) {
			dto.setNname(request.getParameter("nname"));
			dto.setNpass(request.getParameter("npass"));
			dto.setNcate(request.getParameter("ncate"));
			dto.setNtitle(request.getParameter("ntitle"));
			dto.setNcontent(request.getParameter("ncontent"));
			
			int  result = dao.write(dto);
				
			if(result > 0) {
					out.println("<script> alert('게시글 등록에 성공하였습니다.'); </script>");
					out.println("<script> location.href='"+request.getContextPath()+"/list.notice'; </script>");
				}
				else {
					out.println("<script> alert('게시글 등록에 실패하였습니다. '); history.go(-1);</script>");
				}
		}
		else { out.println("<script> alert('관리자 비밀번호가 일치하지 않습니다.'); history.go(-1); </script>"); }

	}
}
