package com.pagoda.rbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pagoda.dao.RBDao;
import com.pagoda.dto.RBDto;

public class reditAction implements RAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		RBDto dto = new RBDto();
		RBDao dao = new RBDao();
		HttpSession session = request.getSession();
		
		String path = "/upload/";
		path = request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		String file = multi.getFilesystemName("rfile");
		if(file==null) { //첨부파일추가안했을때 기존사진 그냥사용
		RBDto imgdto = dao.detail(Integer.parseInt(request.getParameter("rno")));
		file = imgdto.getRfile();
		dto.setRfile(file);
		}
		///////////////////////////////////////////////////
		//rstar=?, rtitle=? , rcontent=?, rfile=? where rno=?
		dto.setRstar(multi.getParameter("rstarssave"));
		dto.setRtitle(multi.getParameter("rtitle"));
		dto.setRcontent(multi.getParameter("rcontent"));
		dto.setRfile(file);
		dto.setRno(Integer.parseInt(request.getParameter("rno")));
		int result = dao.update(dto);
		
		if(result>0)  {
			out.println("<script>alert('게시글이 수정되었습니다.');</script>"); 
			out.println("<script>location.href='"+request.getContextPath()+"/detail.creview?rno="+Integer.parseInt(request.getParameter("rno"))+"'; </script>"); 
		
		}
		else { out.println("<script>alert('게시글이 수정에 실패하였습니다.');</script>"); 
			   out.println("<script>javascript:history.go(-1);</script>");		}
		}
		//view="/Review/r_detail.jsp";
		//request.getRequestDispatcher(view).forward(request, response);
		


}
