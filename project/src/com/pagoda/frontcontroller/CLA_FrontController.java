package com.pagoda.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pagoda.clacontroller.CLAction;
import com.pagoda.clacontroller.ClaCreViewAction;
import com.pagoda.clacontroller.ClaCreateAction;
import com.pagoda.clacontroller.ClaDeleteAction;
import com.pagoda.clacontroller.ClaDetailAciton;
import com.pagoda.clacontroller.ClaEditAction;
import com.pagoda.clacontroller.ClaEditViewAciton;
import com.pagoda.clacontroller.ClaListAction;
import com.pagoda.clacontroller.ClaListAction_CU;
/**
 * Servlet implementation class CLA_FrontController
 */
@WebServlet("*.class")
public class CLA_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CLA_FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		classes(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		classes(request, response);
	}

	protected void classes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String view = "";
		CLAction command = null;
		HttpSession session = request.getSession();
		
		//강의 리스트 불러오기
		if(path.equals("/list.class")) {
			command = new ClaListAction();
			command.execute(request, response);
			view = "/class/classlist_AD.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		//강의 등록하는 화면
		else if(path.equals("/create_view.class")) {
			command = new ClaCreViewAction();
			command.execute(request, response);
			view="/class/createclass.jsp";
			request.getRequestDispatcher(view).forward(request, response);			
		}
		//강의 등록했을때
		else if(path.equals("/create.class")) {
			command = new ClaCreateAction();
			command.execute(request, response);			
		}
		//강의 상세보기
		else if(path.equals("/detail.class")) {
			command = new ClaDetailAciton();
			command.execute(request, response);
			
			if(session.getAttribute("pid")!=null) {
				if(session.getAttribute("pid").equals("admin")) {
					view="/class/classdetail.jsp";
					request.getRequestDispatcher(view).forward(request, response);
				}else {
					view="/class/classDetail_CS.jsp";
					request.getRequestDispatcher(view).forward(request, response);
				}
			}else {
				view="/class/classDetail_CS.jsp";
				request.getRequestDispatcher(view).forward(request, response);
			}		
		}
		//강의 수정화면
		else if(path.equals("/edit_view.class")) {
			command = new ClaEditViewAciton();
			command.execute(request, response);
			view="/class/classedit.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			
		}
		//강의 수정액션
		else if(path.equals("/edit.class")) {
			command = new ClaEditAction();
			command.execute(request, response);
		}
		//강의 삭제액션
		else if(path.equals("/deleteclass.class")) {
			command = new ClaDeleteAction();
			command.execute(request, response);
		}	
		//사이드바 눌렀을떄 강의리스트로 이동하기
		else if(path.equals("/allList.class")) {
			command = new ClaListAction_CU();
			command.execute(request, response);
			view="/class/classlist.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		
	}
}
}
