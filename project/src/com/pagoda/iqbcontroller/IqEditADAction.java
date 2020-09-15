package com.pagoda.iqbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.IQBDao;
import com.pagoda.dto.IQBDto;

public class IqEditADAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		IQBDao dao = new IQBDao();		
		IQBDto dto  = new IQBDto();
		int ino = Integer.parseInt(request.getParameter("ino"));
		
		dto.setItitle(request.getParameter("ititle"));
		dto.setIcontent(request.getParameter("icontent"));
		dto.setIread(Integer.parseInt(request.getParameter("iread"))); 
		dto.setIno(ino);
		int result = dao.editcomment(dto);
		//회원 iread상태 바꿔줘야함 update로
		IQBDto tmpigroup = dao.detail(ino);
				
		IQBDto userdto = new IQBDto();
		userdto.setIread(Integer.parseInt(request.getParameter("iread")));
		userdto.setIgroup(tmpigroup.getIgroup());
		dao.updateIread(userdto); //회원 iread값 올리기

		if(result > 0 ) { 
			out.println("<script> alert('답변이 수정되었습니다'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.consult'; </script>");
		}
		else {
			out.println("<script> alert('답변수정에 실패하였습니다.'); history.go(-1); </script>");
		}	
	}	

}
