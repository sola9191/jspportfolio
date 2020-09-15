package com.pagoda.rbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.RBDao;

public class rwriteViewAction implements RAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//작성자이름, 가지고있는 강의 불러와야함
		HttpSession session = request.getSession();
		String pid = (String) session.getAttribute("pid");
		int pno = -1;
		System.out.println("널"+pid);
		if(pid==null) {
			out.println("<script> alert('로그인이 필요한 페이지 입니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/login_view.do';</script>");
			
		}else {
			Cre_Acc_Dao accdao = new Cre_Acc_Dao(); 
			pno = accdao.findpno((String) session.getAttribute("pid"));
			RBDao dao = new RBDao();		
			request.setAttribute("extrainfo", dao.writeview(pno));
			String view="/Review/r_write.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			
		}
	}
}
