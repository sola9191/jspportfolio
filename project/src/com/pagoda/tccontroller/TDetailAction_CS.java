package com.pagoda.tccontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.ClassDao;
import com.pagoda.dao.TCDao;
import com.pagoda.dto.ClassDto;
import com.pagoda.dto.TCDto;

public class TDetailAction_CS implements TAction {
	//선생님한테 딸린 강의정보랑 선생님 정보가져가기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String teachername = (String) request.getParameter("tname");
		System.out.println(teachername);
		TCDto dto = new TCDto();
		TCDao dao = new TCDao();
		dto = dao.detailwithtname(teachername); //선생님 정보획득
		
		//2. 선생님 번호로 강의 정보 배열로 다가져오기
		int teacherno = dto.getTeacherno();
		ClassDao classdao = new ClassDao();
		ArrayList<ClassDto> classarr = new ArrayList<>();
		classarr = classdao.clistAll_tno(teacherno);
		
		request.setAttribute("teacherinfo", dto);
		request.setAttribute("classinfo", classarr);	
	}
}