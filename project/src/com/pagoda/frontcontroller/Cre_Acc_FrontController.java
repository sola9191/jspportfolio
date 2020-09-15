package com.pagoda.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.cre_acc_controller.CreAction;
import com.pagoda.cre_acc_controller.CreateIdAction;
import com.pagoda.cre_acc_controller.IdChkAction;
import com.pagoda.cre_acc_controller.MylectureAction;
import com.pagoda.cre_acc_controller.SolgodaMemberAction;
import com.pagoda.cre_acc_controller.deleteAction;
import com.pagoda.cre_acc_controller.detailAction;
import com.pagoda.cre_acc_controller.detailBackAction;
import com.pagoda.cre_acc_controller.editInfoAciton;
import com.pagoda.cre_acc_controller.enterDeleteAction;
import com.pagoda.cre_acc_controller.enterEditInfoAciton;
import com.pagoda.cre_acc_controller.findIdAction;
import com.pagoda.cre_acc_controller.findPassAction1;
import com.pagoda.cre_acc_controller.findPassAction2;
import com.pagoda.cre_acc_controller.loginAction;
import com.pagoda.cre_acc_controller.loginkakaoAction;
import com.pagoda.cre_acc_controller.logoutAction;

/**
 * Servlet implementation class Cre_Acc_FrontController
 */
@WebServlet("*.do")
public class Cre_Acc_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cre_Acc_FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JoinPagoda(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JoinPagoda(request, response);

	}
	
	private void JoinPagoda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF8");
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String view="";
		CreAction command = null;
		//제휴프로그램 안내페이지로 이동
		if(path.equals("/javaportfolio.do")) {
			view="Main/javaportfolio.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}		
		else if(path.equals("/main.do")){
			view="Main/pagoda_main.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}		
		else if(path.equals("/createId_view.do")){
			view="/Account/agree.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
		//회원가입 동의후 정보입력하는 화면
		else if(path.equals("/createInfo.do")) {
			view="/Account/createAccount.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}
		else if(path.equals("/doubleIdChk.do")) {
			command = new IdChkAction();			
			command.execute(request, response);		
		}
		else if(path.equals("/createId.do")) {
			command = new CreateIdAction();			
			command.execute(request, response);						
		}
		else if(path.equals("/login_view.do")){
			view="/Account/login.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
		else if(path.equals("/login.do")){ //성공하면 팝업뜨고 mypage 보여줌
			command = new loginAction();
			command.execute(request, response);
		}
		else if(path.equals("/loginkakao.do")) {
			command = new loginkakaoAction();
			command.execute(request, response);
		}
		else if(path.equals("/detail_view.do")) { //mypage에서 내정보관리누르면
			command = new detailAction();
			command.execute(request, response);	
		}

		else if(path.equals("/delete_view.do")) {
			command = new enterDeleteAction();
			command.execute(request, response);	
			//회우너탈퇴 화면으로 넘어가게
		}
		else if(path.equals("/editInfo_view.do")) { //비번더 한번 입력하고 수정폼으로이동하는
			command = new enterEditInfoAciton();
			command.execute(request, response);
		}
		else if(path.equals("/editInfo.do")) { //editinfo 페이지에서 정보변경시
			command = new editInfoAciton();
			command.execute(request, response);
		}
		else if(path.equals("/enterEditInfo_view.do")) { //회원정보 수정시
			view="/Account/enterEditInfo.jsp";
			request.getRequestDispatcher(view).forward(request, response);			
		}
		else if(path.equals("/enterDelete_view.do")) { //회원탈퇴 클릭시
			view="/Account/enterDelete.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}
		else if(path.equals("/detail_view_back.do")) { //회원정보 수정하고 다시 detail로 돌아갈때
			command = new detailBackAction();
			command.execute(request, response);
			view="/Account/detail.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}
		else if(path.equals("/delete.do")) {
			command = new deleteAction();
			command.execute(request, response);			
		}
		else if(path.equals("/logout.do")) {
			command  = new logoutAction();
			command.execute(request, response);
		}
		else if(path.equals("/findId_view.do")) {
			view="/Account/findPassId.jsp";
			request.getRequestDispatcher(view).forward(request, response);			
		}
		else if(path.equals("/findId.do")) {
			command  = new findIdAction();
			command.execute(request, response);			
		}
		else if(path.equals("/findPass_p.do")) {
			command  = new findPassAction1();
			command.execute(request, response);			
		}
		else if(path.equals("/findPass_e.do")) {
			command  = new findPassAction2();
			command.execute(request, response);
		}
		else if(path.equals("/mylecture.do")) { //나의강의실 눌렀을때
			command = new MylectureAction();
			command.execute(request, response);			
		}
		else if(path.equals("/sogodamember_view.do")) {
			command = new SolgodaMemberAction();
			command.execute(request, response);
			view="/Account/memberList.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
	}
}
