package com.pagoda.rbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.RBDao;

public class reditViewAction implements RAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RBDao dao = new RBDao();
		//작성자이름, 수강강의 강의 불러와야함
		HttpSession session = request.getSession();
		int pno = -1;
		if(session.getAttribute("pid")!=null) {
			Cre_Acc_Dao accdao = new Cre_Acc_Dao(); 
			pno = accdao.findpno((String) session.getAttribute("pid"));
		}
		request.setAttribute("extrainfo", dao.writeview(pno));
		
		//2. detail로 다른정보도 불러와야함
		int rno = Integer.parseInt(request.getParameter("rno"));
		request.setAttribute("reviewlist", dao.detail(rno));		
	}

}
