package com.pagoda.frontcontroller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.iqbcontroller.IAction;
import com.pagoda.iqbcontroller.IqDeleteAction;
import com.pagoda.iqbcontroller.IqEditViewAction;
import com.pagoda.iqbcontroller.IqDetailAction;
import com.pagoda.iqbcontroller.IqEditADAction;
import com.pagoda.iqbcontroller.IqEditAction;
import com.pagoda.iqbcontroller.IqListAction;
import com.pagoda.iqbcontroller.IqReplayAciton;
import com.pagoda.iqbcontroller.IqReplyViewAcition;
import com.pagoda.iqbcontroller.IqViewAction;
import com.pagoda.iqbcontroller.IqWriteAction;

/**
 * Servlet implementation class Con_FrontContoller
 */
@WebServlet("*.consult")
public class IQB_FrontContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IQB_FrontContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalConsult(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalConsult(request, response);
	}
	
	private void PersonalConsult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String view ="";
		IAction command = null;
				
		//1:1문의 목록가져오기
		if(path.equals("/list.consult")) { 
			command = new IqListAction();
			command.execute(request, response);
			view="/IQ_Board/iq_BoardList.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}
		//1:1문의하기 눌렀을때 글쓰기 화면	
		else if(path.equals("/write_view.consult")) { //1:1문의창 보여줌
			command = new IqViewAction(); //세션으로 pid값 가져옴
			command.execute(request, response);	
			
		//1:1문의글에서 글다쓰고 db에 insert하는 action
		}else if(path.equals("/write.consult")) {
			command = new IqWriteAction();
			command.execute(request, response);			
		//1:1문의글 클릭시 detail
		}else if(path.equals("/detail_view.consult")) {
			command  = new IqDetailAction();
			command.execute(request, response);
					
		//detail에서 수정버튼 클릭시 수정페이지로 이동 
		}else if(path.equals("/edit_view.consult")) {
			command = new IqEditViewAction();
			command.execute(request, response);
			view = "/IQ_Board/iq_BoardEdit.jsp";
			request.getRequestDispatcher(view).forward(request, response);		
		//수정하기
		}else if(path.equals("/edit.consult")) {
			command = new IqEditAction();
			command.execute(request, response);
		//게시글 삭제
		}else if(path.equals("/delete.consult")) {
			command = new IqDeleteAction();
			command.execute(request, response);
		}
		//답글달기 클릭시 화면띄우기
		else if(path.equals("/reply_view.consult")) {
			command = new IqReplyViewAcition();
			command.execute(request, response);
			view = "/IQ_Board/iq_BoardReplyView.jsp";
			request.getRequestDispatcher(view).forward(request, response);			
		}
		//답글달기 버튼 클릭시 이벤트(어드민이 답글달기)
		else if(path.equals("/reply.consult")) {
			command = new IqReplayAciton();
			command.execute(request, response);
			//view = "/IQ_Board/iq_BoardList.jsp";
			//request.getRequestDispatcher(view).forward(request, response);
		}
		//어드민이 답글 수정할때화면
		else if(path.equals("/edit_view_AD.consult")) {
			command = new IqEditViewAction();
			command.execute(request, response);
			view = "/IQ_Board/iq_BoardReplyEdit.jsp";
			request.getRequestDispatcher(view).forward(request, response);		
			
		}
		//어드민이 답글 수정하기 버튼 클릭시 이벤트 (답글 업데이트)
		else if(path.equals("/edit_AD.consult")){
			command = new IqEditADAction();
			command.execute(request, response);
			
		}
	}
}
