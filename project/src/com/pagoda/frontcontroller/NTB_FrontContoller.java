package com.pagoda.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.ntbcontroller.NAction;
import com.pagoda.ntbcontroller.NDeleteAction;
import com.pagoda.ntbcontroller.NDetailAction;
import com.pagoda.ntbcontroller.NEditAction;
import com.pagoda.ntbcontroller.NListAction;
import com.pagoda.ntbcontroller.NWriteAction;

/**
 * Servlet implementation class NTB_FrontContoller
 */
@WebServlet("*.notice")
public class NTB_FrontContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NTB_FrontContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticelist(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticelist(request, response);
	}
	
	protected void noticelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String view = "";
		NAction command  = null;
		//맨처음 list화면
				
		if(path.equals("/list.notice")) {
			command = new NListAction();
			command.execute(request, response);
			view = "/NT_Board/nt_BoardList.jsp";
			request.getRequestDispatcher(view).forward(request, response);		
			
		}else if(path.equals("/write_view.notice")){
			view ="/NT_Board/nt_BoardWrite.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		
		}else if(path.equals("/write.notice")) {
			command = new NWriteAction();
			command.execute(request, response);
			
		}else if(path.equals("/detail_view.notice")) {
			command = new NDetailAction();
			command.execute(request, response);
			HttpSession session = request.getSession();
			
			if(session.getAttribute("pid")!=null) {
				if(session.getAttribute("pid").equals("admin")) {
					view = "/NT_Board/nt_BoardDetail.jsp";
				}
				else { view = "/NT_Board/nt_BoardDetail_Cus.jsp"; }
			}
			else { view = "/NT_Board/nt_BoardDetail_Cus.jsp"; }
			request.getRequestDispatcher(view).forward(request, response);
						
		}else if(path.equals("/edit_view.notice")) {
			command = new NDetailAction();
			command.execute(request, response);
			view = "/NT_Board/nt_BoardEdit.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		
		}else if(path.equals("/edit.notice")) {
			command = new NEditAction();
			command.execute(request, response);			
			
		}else if(path.equals("/delete.notice")) {
			command = new NDeleteAction();
			command.execute(request, response);
			
		}else if(path.equals("/delete_view.notice")) {
			view="/NT_Board/nt_BoardDelete.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		
		}
	}
}
