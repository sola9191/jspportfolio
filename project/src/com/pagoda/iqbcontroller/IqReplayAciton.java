package com.pagoda.iqbcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.IQBDao;
import com.pagoda.dto.IQBDto;

public class IqReplayAciton implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		IQBDao dao = new IQBDao();		
		int ino = Integer.parseInt(request.getParameter("ino"));
		
		IQBDto now = dao.detail(ino); //step값 빼기 위해서 현재 스테값조회
		//pno값 구하기
		int pno = dao.findpno(ino);

		//기존에 답변글 달려있으면 bstep = bstep-1 해야함
		//iread도 바꿔줘야함
		int prev = ((int)Math.ceil(now.getIstep()/(float)1000)-1)*1000;
		int curr = now.getIstep();
		dao.update_reply(prev, curr);		
		
		//답변달기 성공여부
		IQBDto dto = new IQBDto();
		dto.setPno(pno);
		dto.setItitle(request.getParameter("ititle"));
		dto.setIcontent(request.getParameter("icontent"));
		dto.setIread(Integer.parseInt(request.getParameter("iread"))); 
		dto.setIgroup(now.getIgroup());
		dto.setIstep(now.getIstep()-1);
		dto.setIindent(now.getIindent()+1);
		dto.setIip(InetAddress.getLocalHost().getHostAddress());
		dto.setIemail(request.getParameter("iemail"));
		int result = dao.create_re(dto);
		//회원 iread상태 바꿔줘야함 update로 //그룹이 같은글 ? 올리기
		IQBDto userdto = new IQBDto();
		userdto.setIread(Integer.parseInt(request.getParameter("iread")));		
		userdto.setIgroup(now.getIgroup());
		dao.updateIread(userdto);

		if(result > 0 ) { 
			out.println("<script> alert('답변이 등록되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.consult?pno="+pno+"'; </script>");
		}
		else {
			out.println("<script> alert('답변등록에 실패하였습니다.'); history.go(-1); </script>");
		}	
		
		
	}
}
