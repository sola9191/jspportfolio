package com.pagoda.clacontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.ClassDao;
import com.pagoda.dao.RBDao;
import com.pagoda.dao.TCDao;
import com.pagoda.dto.ClassDto;

public class ClaDetailAciton implements CLAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		ClassDto dto = new ClassDto();
		ClassDao dao = new ClassDao();
		int classno = Integer.parseInt(request.getParameter("classno"));
		request.setAttribute("cinfo", dao.detail(classno));
		request.setAttribute("tname", dao.tname(classno));
		
		RBDao reviewdao= new RBDao();
		//수강후기 정보도 가져오기
		request.setAttribute("reviewlist" , reviewdao.detailreviewbyclassno(classno));
		
		//선생님 정보도가져오기
		int teacherno = dao.detail(classno).getTeacherno();
		TCDao tcdao = new TCDao();
	
		request.setAttribute("tinfo" , tcdao.detail(teacherno));
		
	}

}
