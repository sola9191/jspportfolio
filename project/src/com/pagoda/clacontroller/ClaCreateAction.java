package com.pagoda.clacontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.ClassDao;
import com.pagoda.dto.ClassDto;

public class ClaCreateAction implements CLAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		ClassDto dto  =  new ClassDto();
		ClassDao dao = new ClassDao();
		
		dto.setClasscreator(request.getParameter("classcreator"));
		dto.setClasscateno(Integer.parseInt(request.getParameter("classcateno")));
		dto.setClasscategory(request.getParameter("classcategory"));
		dto.setClassname(request.getParameter("classname"));
		String teacher = request.getParameter("teachername").substring(0, request.getParameter("teachername").indexOf(".") );
		dto.setTeacherno(Integer.parseInt(teacher));
		dto.setClassprice(Integer.parseInt(request.getParameter("classprice")));
		dto.setClassstart(request.getParameter("classstart"));
		dto.setClassend(request.getParameter("classend"));
		dto.setClasscompo(request.getParameter("classcompo"));
		dto.setClassdetail(request.getParameter("classdetail"));
		
		int result = dao.create(dto);
		
		if(result > 0) {
			out.println("<script> alert('강의가 등록되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.class'; </script>");
		}
		else {
			out.println("<script> alert('강의 등록에 실패하였습니다.'); history.go(-1);</script>");
		}
		
	}
}
