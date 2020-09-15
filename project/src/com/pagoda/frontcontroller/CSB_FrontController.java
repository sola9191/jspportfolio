package com.pagoda.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.csbcontroller.CAction;
import com.pagoda.csbcontroller.CDeleteAction;
import com.pagoda.csbcontroller.CDetailAction;
import com.pagoda.csbcontroller.CEditAction;
import com.pagoda.csbcontroller.CEmailction;
import com.pagoda.csbcontroller.CListAction;
import com.pagoda.csbcontroller.CSearchAction;
import com.pagoda.csbcontroller.CSortAction;
import com.pagoda.csbcontroller.CWriteAction;

/**
 * Servlet implementation class Customer_Service_Board_FrontController
 */
@WebServlet("*.service")
public class CSB_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSB_FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CSBservice(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CSBservice(request, response);
	}
	
	private void CSBservice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String view = "";
		CAction command  = null;
		//맨처음 list화면
		
		
		if(path.equals("/list.service")) {
			command = new CListAction();
			command.execute(request, response);
			view = "/CS_Board/cs_BoardList.jsp";
			request.getRequestDispatcher(view).forward(request, response);		
			
		}if(path.equals("/write_view.service")){
			view ="/CS_Board/cs_BoardWrite.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		
		}if(path.equals("/write.service")) {
			command = new CWriteAction();
			command.execute(request, response);
			
		}if(path.equals("/detail_view.service")) {
			command = new CDetailAction();
			command.execute(request, response);
			HttpSession session = request.getSession();
			if(session.getAttribute("pid")!=null) {
				if(session.getAttribute("pid").equals("admin")) {
					view = "/CS_Board/cs_BoardDetail.jsp";
				}
				else { view = "/CS_Board/cs_BoardDetail_Cus.jsp"; }
			}
			else { view = "/CS_Board/cs_BoardDetail_Cus.jsp"; }
			request.getRequestDispatcher(view).forward(request, response);
						
		}if(path.equals("/edit_view.service")) {
			command = new CDetailAction();
			command.execute(request, response);
			view = "/CS_Board/cs_BoardEdit.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		
		}if(path.equals("/edit.service")) {
			command = new CEditAction();
			command.execute(request, response);			
			
		}if(path.equals("/delete.service")) {
			command = new CDeleteAction();
			command.execute(request, response);
			
		}if(path.equals("/delete_view.service")) {
			view="/CS_Board/cs_BoardDelete.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		
		}else if(path.equals("/search.service")) {
			command = new CSearchAction();
			command.execute(request, response);	
			view="CS_Board/cs_BoardSearch.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
		//여기서부터는 자주묻는게시판 탭누르면 나오는것들
		if(path.equals("/sort.service")) {
			command = new CSortAction();
			command.execute(request, response);	
			view="CS_Board/cs_BoardSort.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
		//관리자에게 메일 보내기 눌렀을때 메일보내는 화면
		if(path.equals("/email_view.service")) {
			view="CS_Board/cs_Email.jsp";
			request.getRequestDispatcher(view).forward(request, response);				
		}
		//관리자에게 메일 보내기했을때
		if(path.equals("/email.service")) {
			command = new CEmailction();
			command.execute(request, response);	
			//view="CS_Board/cs_Email.jsp";
			//request.getRequestDispatcher(view).forward(request, response);				
		}
		if(path.equals("/location.service")) {
			view="CS_Board/cs_location.jsp";
			request.getRequestDispatcher(view).forward(request, response);				
		}
		else if(path.equals("/findbook.service")) {
			view="CS_Board/cs_book.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
		else if(path.equals("/qr.service")) {
			view="CS_Board/cs_qr.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
}
}
