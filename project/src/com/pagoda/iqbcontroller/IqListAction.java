package com.pagoda.iqbcontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.IQBDao;
import com.pagoda.dto.IQBDto;

public class IqListAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IQBDao dao = new IQBDao();
		ArrayList<IQBDto> list = new ArrayList<>();
		//어드민아디로 접속했을때는 다른방식으로 리스트 뽑기
		HttpSession session = request.getSession();
		String pid = (String) session.getAttribute("pid");
		if(pid!=null) {
			
			if(pid.equals("admin")) { request.setAttribute("list", dao.listAll_Admin());	}
			else {		
				list = dao.listAll(Integer.parseInt(request.getParameter("pno")));
				request.setAttribute("list", list); 
			}
		}
	}
}
