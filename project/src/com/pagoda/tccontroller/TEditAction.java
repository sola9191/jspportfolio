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

public class TEditAction implements TAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		TCDto dto = new TCDto();
		TCDao dao = new TCDao();
		PrintWriter out = response.getWriter();
		
		
		String path ="/upload";
		path = request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		String file = multi.getFilesystemName("teacherimg");

		if(file==null) { //첨부파일 추가안했을때
			TCDto imgdto = dao.detail(Integer.parseInt(request.getParameter("teacherno")));
			file = imgdto.getTeacherimg();
			dto.setTeacherimg(file);
		}
		else { dto.setTeacherimg(file); }
			
			dto.setTeacherno(Integer.parseInt(request.getParameter("teacherno")));			
			dto.setTeachercreator(multi.getParameter("teachercreator"));
			dto.setTeachername(multi.getParameter("teachername"));
			dto.setTeacherinfo(multi.getParameter("teacherinfo"));		
			
		if(dao.edit(dto) > 0 ) { 
			out.println("<script> alert('선생님 정보가 수정되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/detail.teacher?teacherno="+Integer.parseInt(request.getParameter("teacherno"))+"'; </script>");
		}
		else {
			out.println("<script> alert('선생님 정보 수정에 실패하였습니다.'); history.go(-1); </script>");
		}	
	
	}
}
