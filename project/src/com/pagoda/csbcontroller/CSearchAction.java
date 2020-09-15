package com.pagoda.csbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.CSBDao;
import com.pagoda.dto.CSBDto;

public class CSearchAction implements CAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("시작");
		System.out.println(request.getParameter("search"));
		System.out.println(request.getParameter("qamenu"));
		System.out.println("끝");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CSBDao dao = new CSBDao();
		CSBDto dto = new CSBDto();
		String word = request.getParameter("search");
		
		int catenum = Integer.parseInt(request.getParameter("qamenu"));
		
		if(word!=null) {
		request.setAttribute("list", dao.listAll_Search(word, catenum));	
		System.out.println("list확인"+request.getAttribute("list"));
		}
	
	}
}
