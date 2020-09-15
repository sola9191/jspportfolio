package com.pagoda.iqbcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dao.IQBDao;
import com.pagoda.dto.Cre_Acc_Dto;
import com.pagoda.dto.IQBDto;

public class IqWriteAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int result = -1;
		IQBDao dao = new IQBDao();
		IQBDto dto = new IQBDto();
		Cre_Acc_Dao userinfo = new Cre_Acc_Dao();
		Cre_Acc_Dto userinfodto = new Cre_Acc_Dto(); 
		PrintWriter out = response.getWriter();
	
		
		String path="/upload/";
		
		path = request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		String file = multi.getFilesystemName("ifile");
		if(file==null) { System.out.println("업로드대실패"); file="noImg.png"; }
			//pno구하기
			userinfodto.setPid(multi.getParameter("pid"));
			int pno = userinfo.userinfo(userinfodto).getPno();
			
			dto.setPno(pno);
			dto.setItitle(multi.getParameter("ititle"));
			dto.setIcontent(multi.getParameter("icontent"));	
			dto.setIfile(file);
			//최대 step값 구하기
			int max = dao.max_read();			
			dto.setIgroup((int)(Math.ceil((max/(float)1000)))+1);
			dto.setIstep(((int)(Math.ceil((max/(float)1000)))+1)*1000);
			dto.setIemail(multi.getParameter("iemail"));
			dto.setIip(InetAddress.getLocalHost().getHostAddress());	
			
			result = dao.write(dto); //글등록되면 1 안되면 -1
			
		if(result > 0 ) { 
			out.println("<script> alert('1:1문의글이 등록되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/list.consult?pno="+pno+"'; </script>");
		}
		else {
			out.println("<script> alert('1:1문의글 등록에 실패하였습니다. 관리자에게 문의바랍니다.'); history.go(-1); </script>");
		}	
		
	}

}