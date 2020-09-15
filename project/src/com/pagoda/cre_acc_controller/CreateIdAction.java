package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.kakaoDao;
import com.pagoda.dto.Cre_Acc_Dto;
import com.pagoda.dto.KakaoDto;

public class CreateIdAction implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter();
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		
		dto.setPname(request.getParameter("pname"));
		String birthYear = (String) request.getParameter("birthDay_Year");
		String birthMonth = (String) request.getParameter("birthDay_Month");
		String birthDate = (String) request.getParameter("birthDay_date");
		dto.setPbirthDay(birthYear+birthMonth+birthDate);
		dto.setPgender(request.getParameter("pgender"));
		dto.setPlocal(request.getParameter("plocal"));
		String phoneN1 = (String) request.getParameter("pphonenumber1");
		String phoneN2 = (String) request.getParameter("pphonenumber2");
		String phoneN3 = (String) request.getParameter("pphonenumber3");
		dto.setPphonenumber(phoneN1+"-"+phoneN2+"-"+phoneN3);
		dto.setPid(request.getParameter("pid"));
		dto.setPpass(request.getParameter("ppass"));
		String email1 = request.getParameter("pemail1");
		String email2 = request.getParameter("pemail2");
		dto.setPemail(email1+"@"+email2);
		int result = dao.creAcc(dto);
		
		
		if(result>0) {
			//카카오 아디로 가입했을경우에 			
			if(request.getParameter("kid")!="") {
				int tmppno = dao.userinfo(dto).getPno();
				KakaoDto kakaodto = new KakaoDto();
				kakaodto.setKid((String) request.getParameter("kid"));
				kakaodto.setPno(tmppno);
				kakaoDao kakaodao = new kakaoDao();
				int kakaoresult = kakaodao.savekid(kakaodto);
				
				if(kakaoresult>0) { 
					
				out.println("<script> alert('회원가입을 축하드립니다. 다음부터는 카카오아이디로 로그인이 가능합니다.'); </script>"); 
				out.println("<script> location.href='"+request.getContextPath()+"/Account/welcome.jsp'; </script>");
				}
				else { out.println("<script> alert('회원가입에 실패하였습니다. 관리자에게 문의바랍니다.'); </script>"); 
				}
				
			}
			else {		//그냥 회원가입 	
			
			out.println("<script> alert('회원가입을 축하드립니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/Account/welcome.jsp'; </script>");
			}
		}
		else { 
			out.println("<script> alert('회원가입에 실패하였습니다. \n관리자에게 문의하세요.'); </script>");
		}
	}

}
