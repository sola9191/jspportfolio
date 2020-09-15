package com.pagoda.csbcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.CSBDao;
import com.pagoda.dto.CSBDto;

public class CEditAction implements CAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		CSBDto dto = new CSBDto();
		CSBDao dao = new CSBDao();
		dto.setCno(Integer.parseInt(request.getParameter("cno")));
		dto.setCname(request.getParameter("cname"));
		dto.setCpass(request.getParameter("cpass"));
		dto.setCtitle(request.getParameter("ctitle"));
		dto.setCcontent(request.getParameter("ccontent"));
		dto.setCcategorynum(Integer.parseInt(request.getParameter("ccategorynum")));
		
		if(dao.passchk(request.getParameter("cpass"))==1) {
			int result = dao.edit(dto);
				if(result>0) {
					out.println("<script> alert('수정성공'); </script>");		
					out.println("<script> location.href='"+request.getContextPath()+"/detail_view.service?cno="+
							Integer.parseInt(request.getParameter("cno"))+"'</script>");
				}
				else {
					out.println("<script> alert('수정실패'); history.go(-1); </script>");
				}
		}
		else { out.println("<script> alert('관리자 비밀번호가 일치하지 않습니다.'); history.go(-1); </script>"); }
	}

}
