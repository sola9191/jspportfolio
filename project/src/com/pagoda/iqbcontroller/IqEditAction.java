package com.pagoda.iqbcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pagoda.dao.IQBDao;
import com.pagoda.dto.IQBDto;

public class IqEditAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IQBDao dao = new IQBDao();
		IQBDto dto = new IQBDto(); 
		PrintWriter out = response.getWriter();
		
		String path="/upload/";
		path = request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		String file = multi.getFilesystemName("ifile");
		if(file==null) { //첨부파일 추가안한경우 예전꺼 불러서 가져와야함
			IQBDto imgdto = dao.detail(Integer.parseInt(request.getParameter("ino")));
			file = imgdto.getIfile(); //예전꺼 불러오기	
			dto.setIfile(file);
		}
		else { dto.setIfile(file); }
			dto.setIno(Integer.parseInt(multi.getParameter("ino")));
			dto.setIemail(multi.getParameter("iemail"));
			dto.setItitle(multi.getParameter("ititle"));
			dto.setIcontent(multi.getParameter("icontent"));						
		
		if(dao.edit(dto) > 0 ) { 
			out.println("<script> alert('문의글이 수정되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/detail_view.consult?ino="+Integer.parseInt(request.getParameter("ino"))+"'; </script>");
		}
		else {
			out.println("<script> alert('문의글 수정에 실패하였습니다. 관리자에게 문의바랍니다.'); history.go(-1); </script>");
		}	
	}

}
