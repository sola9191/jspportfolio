package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

public class editInfoAciton implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		PrintWriter out = response.getWriter();
		
		dto.setPid((String)session.getAttribute("pid"));
		dto.setPpass( request.getParameter("old"));
		String pNum1 = request.getParameter("pphonenumber1");
		String pNum2 = request.getParameter("pphonenumber2");
		String pNum3 = request.getParameter("pphonenumber3");
		dto.setPphonenumber(pNum1+"-"+pNum2+"-"+pNum3);
		String email1 = request.getParameter("pemail1");
		String email2 = request.getParameter("pemail2");
		dto.setPemail(email1+"@"+email2);
		
		//기존비밀번호가 db에 저장된 비밀번호랑 일치하는지 확인
		int result = dao.login(dto);
		
		if(result > 0 ) { 
			//일치하면 update하는거고
			dto.setPpass( request.getParameter("new"));

			int success = dao.useredit(dto);
			
			if(success>0) {

				out.println("<script> alert ('회원정보 수정이 완료되었습니다.다음 로그인시 수정된 정보로 확인이 가능합니다.'); </script>");	
				out.println("<script> location.href='"+request.getContextPath()+"/detail_view_back.do'; </script>");
			}
			else { out.println("<script> alert('회원정보 수정을 실패하였습니다. 관리자에게 문의바랍니다.'); history.go(-1); </script>");}
		}
		else { out.println("<script> alert ('기존 비밀번호를 다시 확인해주세요.'); history.go(-1); </script>"); }
	}
}
