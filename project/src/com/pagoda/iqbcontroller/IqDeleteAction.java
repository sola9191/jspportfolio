package com.pagoda.iqbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.IQBDao;
import com.pagoda.dto.Cre_Acc_Dto;

public class IqDeleteAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		IQBDao dao = new IQBDao();
		//pno값 구하기
		Cre_Acc_Dao userinfo = new Cre_Acc_Dao();
		Cre_Acc_Dto userinfodto = new Cre_Acc_Dto();
		HttpSession session = request.getSession();
		String pid = (String) session.getAttribute("pid");
		userinfodto.setPid(pid);
		int pno = userinfo.userinfo(userinfodto).getPno();
		
		int result = dao.delete(Integer.parseInt(request.getParameter("ino")));

		if(result>0) {
			out.println("<script> alert('게시글이 삭제 되었습니다'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.consult?pno="+pno+"'; </script>");
		}
		else {
			out.println("<scirpt> alert('게시글 삭제가 실패하였습니다. 관리자에게 문의하세요.); </script>");
		}
		
	}

}
