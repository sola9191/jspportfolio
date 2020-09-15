package com.pagoda.rbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.RBDao;
import com.pagoda.dto.RBDto;

public class rdetailAction implements RAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RBDao dao = new RBDao();	
		RBDto classinfo = new RBDto();
		int rno = Integer.parseInt(request.getParameter("rno"));
		classinfo = dao.detail(rno);
		request.setAttribute("classinfo", classinfo); //정보던지기1
		//1.rno로 작성자이름이랑 수강강의 이름 뽑아내야도ㅓㅣㅁ..
		request.setAttribute("candtname", dao.detailview(Integer.parseInt(request.getParameter("rno"))));
		//2.글클릭한거니까 조회수올리기
		dao.addrhit(rno);
	}
}
