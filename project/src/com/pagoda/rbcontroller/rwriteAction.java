package com.pagoda.rbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pagoda.dao.ClassDao;
import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.RBDao;
import com.pagoda.dto.Cre_Acc_Dto;
import com.pagoda.dto.RBDto;

public class rwriteAction implements RAction {
//여기 빈칸 검사제대로안함
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		RBDto dto = new RBDto();
		RBDao dao = new RBDao();
		HttpSession session = request.getSession();
		String pid = null; int pno =-1;
		if(session.getAttribute("pid")!=null) {
			pid = (String) session.getAttribute("pid");
		}
		
		//insert into reviewboard(pno, classno, rstar, rtitle, rpass, rcontent, rfile, rip) values(?,?,?,?,?,?,?,?)
		
		String path = "/upload/";
		path = request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		String file = multi.getFilesystemName("rfile");
		if(file==null) { file ="noImg.png"; }
		///////////////////////////////////////////////////
		Cre_Acc_Dao accdao = new Cre_Acc_Dao();
		Cre_Acc_Dto accdto = new Cre_Acc_Dto();
		accdto.setPid(pid); accdto.setPpass(multi.getParameter("rpass"));
		int logingsuccess = accdao.login(accdto); 
		pno = accdao.findpno(pid);//1이어야 밑에 꺼 실행함
		////////////////////////////////////////////////////
		
		if(logingsuccess>0) {
		
		dto.setPno(pno);
		ClassDao clsdao = new ClassDao();
		dto.setClassno(clsdao.findclassno(multi.getParameter("rclass")));
		dto.setRstar(multi.getParameter("rstarssave"));
		dto.setRtitle(multi.getParameter("rtitle"));
		dto.setRpass(multi.getParameter("rpass"));
		dto.setRcontent(multi.getParameter("rcontent"));
		dto.setRfile(file);
		int result = dao.write(dto);
		
		if(result>0)  {
			out.println("<script>alert('게시글이 등록되었습니다.');</script>"); 
			out.println("<script>location.href='"+request.getContextPath()+"/main.review'; </script>"); 
		
		}
		else { out.println("<script>alert('게시글이 등록에 실패하였습니다.');</script>"); 
			   out.println("<script>javascript:history.go(-1);</script>");		}
		}
		//view="/Review/r_detail.jsp";
		//request.getRequestDispatcher(view).forward(request, response);
		
		else {
			out.println("<script>alert('비밀번호를 다시 확인해주세요');</script>");
			out.println("<script>javascript:history.go(-1);</script>");		
		}
		
	}

}
