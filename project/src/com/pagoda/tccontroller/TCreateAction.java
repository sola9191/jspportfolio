package com.pagoda.tccontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pagoda.dao.TCDao;
import com.pagoda.dto.TCDto;

public class TCreateAction implements TAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		TCDto dto  =  new TCDto();
		TCDao dao = new TCDao();
		
		String path="/upload/";
		path = request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		String file = multi.getFilesystemName("teacherimg");
		if(file==null) { file="noImg.png"; }
		
		dto.setTeachercreator(multi.getParameter("teachercreator"));
		dto.setTeachername(multi.getParameter("teachername"));
		dto.setTeacherinfo(multi.getParameter("teacherinfo"));
		dto.setTeacherimg(file);
		
		int result = dao.write(dto);
		
		if(result > 0) {
			out.println("<script> alert('선생님이 등록되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.teacher'; </script>");
		}
		else {
			out.println("<script> alert('선생님 등록에 실패하였습니다.'); history.go(-1);</script>");
		}
		
		
	}
}
