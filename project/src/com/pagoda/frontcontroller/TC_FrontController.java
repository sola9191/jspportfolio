package com.pagoda.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.tccontroller.TAction;
import com.pagoda.tccontroller.TCreateAction;
import com.pagoda.tccontroller.TDeleteAction;
import com.pagoda.tccontroller.TDetailAciton;
import com.pagoda.tccontroller.TDetailAction_CS;
import com.pagoda.tccontroller.TEditAction;
import com.pagoda.tccontroller.TEditViewAciton;
import com.pagoda.tccontroller.TListAction;

/**
 * Servlet implementation class TC_FrontController
 */
@WebServlet("*.teacher")
public class TC_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TC_FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		teachers(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		teachers(request, response);
	}
	
	protected void teachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String view ="";
		TAction command = null;
		
		//선생님 등록하는 화면
		if(path.equals("/register_view.teacher")) {
			view = "/teacher/registerteacher.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}//선생님 등록했을때
		else if(path.equals("/register.teacher")) {
			command = new TCreateAction();
			command.execute(request, response);	
		}//선생님 상세보기
		else if(path.equals("/detail.teacher")) {
			command = new TDetailAciton();
			command.execute(request, response);
		}
		//선생님 수정 화면
		else if(path.equals("/edit_view.teacher")) {
			command = new TEditViewAciton();
			command.execute(request, response);
			view="teacher/teacherEdit.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}//선새님 수정액션
		else if(path.equals("/edit.teacher")) {
			command = new TEditAction();
			command.execute(request, response);

		}//선생님 삭제 액션
		else if(path.equals("/delete.teacher")) {
			command = new TDeleteAction();
			command.execute(request, response);
			
		}//선생님 리스트 불러오기
		else if(path.equals("/list.teacher")) {
			command = new TListAction();
			command.execute(request, response);
			view="teacher/teacherList_AD.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			//회원이 선생님 소개 눌렀을때 
		}else if(path.equals("/solgoda.teacher")) {
			view ="teacher/teacherList.jsp";
			request.getRequestDispatcher(view).forward(request, response);			
			
		}else if(path.equals("/solgodadetail.teacher")) {
			command = new TDetailAction_CS();
			command.execute(request, response);
			view ="teacher/teacherDetail_CS.jsp";
			request.getRequestDispatcher(view).forward(request, response);			
			
		}
	}
}
