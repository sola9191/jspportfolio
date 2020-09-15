package com.pagoda.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.rbcontroller.RAction;
import com.pagoda.rbcontroller.rcheckAction;
import com.pagoda.rbcontroller.rdeleteAction;
import com.pagoda.rbcontroller.rdetailAction;
import com.pagoda.rbcontroller.reditAction;
import com.pagoda.rbcontroller.reditViewAction;
import com.pagoda.rbcontroller.rwriteAction;
import com.pagoda.rbcontroller.rwriteViewAction;

/**
 * Servlet implementation class RB_FrontController
 */
@WebServlet("*.creview")
public class RB_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RB_FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassReview(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassReview(request, response);
	}
	
	protected void ClassReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF8");
		
		String path=request.getRequestURI().substring(request.getContextPath().length());
		String view ="";
		RAction command = null;
		//수강후기쓰기 눌렀을떄 writeview 보여줌
		if(path.equals("/write_view.creview")) {
			command = new rwriteViewAction();
			command.execute(request, response);
		//수강후기 글쓰기 눌렀을때 액션이벤트
		}else if (path.equals("/write.creview")) {
			command = new rwriteAction();
			command.execute(request, response);	
		//detail 화면
		}else if (path.equals("/detail.creview")) {
			command = new rdetailAction();
			command.execute(request, response);
			view = "/Review/r_detail.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		//edit 화면 보여주는 method
		}else if (path.equals("/edit_view.creview")) {
			command = new reditViewAction();
			command.execute(request, response);
			view = "/Review/r_edit.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		//edit 실행하는 method
		}else if (path.equals("/edit.creview")) {
			command = new reditAction();
			command.execute(request, response);
			//delete 화면보여주는 메서드
		}else if (path.equals("/delete_view.creview")) {
			view ="/Review/r_delete.jsp?rno="+request.getParameter("rno");			
			request.getRequestDispatcher(view).forward(request, response);
			//delete 실행하는 method
		}else if(path.equals("/delete.creview")) {
			command = new rdeleteAction();
			command.execute(request, response);
		}else if(path.equals("/chk_view.creview")) {
			view ="/Review/r_check.jsp?rno="+request.getParameter("rno");			
			request.getRequestDispatcher(view).forward(request, response);
		}else if(path.equals("/chk.creview")) {
			command = new rcheckAction();
			command.execute(request, response);
		}
	}
}
