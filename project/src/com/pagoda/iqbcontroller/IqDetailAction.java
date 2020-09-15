package com.pagoda.iqbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.IQBDao;
import com.pagoda.dto.Cre_Acc_Dto;
import com.pagoda.dto.IQBDto;

public class IqDetailAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IQBDao dao = new IQBDao();
		IQBDto dto = new IQBDto();
		
		int ino = Integer.parseInt(request.getParameter("ino"));

		dto = dao.detail(ino);
		request.setAttribute("dto", dto);

		//글번호로 회원 아이디랑 휴대폰 찾아야됨  ==> 새로 dao 만들기 
		Cre_Acc_Dto userinfo  = dao.userinfo_ino(Integer.parseInt(request.getParameter("ino")));
		request.setAttribute("userinfo", userinfo);
		
		//글을 조회했는데 indent가 0이아니고 1이나 2면 (답글이라면) 버튼없는 뷰페이지로 이동하게 함
		//iindent를 조회했을때 0--> (원글 view 다르게가기)
				//iindent 0아님 --> 답글 ( view 다르게 가기)
		int viewchk = dao.findiindent(ino);
		if(viewchk!=0) {			
			request.getRequestDispatcher("/IQ_Board/iq_BoardDetail_AD.jsp").forward(request, response);			
		}
		else { 
			request.getRequestDispatcher("/IQ_Board/iq_BoardDetail.jsp").forward(request, response);	
		}
	}
}
