package com.pagoda.csbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.CSBDao;
import com.pagoda.dto.CSBDto;

public class CSortAction implements CAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CSBDao dao = new CSBDao();
		CSBDto dto = new CSBDto();
		
		int ccategorynum = Integer.parseInt(request.getParameter("ccategorynum"));
		System.out.println(ccategorynum);
		if(ccategorynum==0) {
			request.setAttribute("list", dao.listSort0(ccategorynum));			
		}
		else if(ccategorynum!=0) {
		request.setAttribute("list", dao.listSort(ccategorynum));	
		}

	}

}
