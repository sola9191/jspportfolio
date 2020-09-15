package com.pagoda.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.cart.CTAction;
import com.pagoda.cart.DeleteCart;
import com.pagoda.cart.insertClassAction;

/**
 * Servlet implementation class CT_FrontController
 */
@WebServlet("*.cart")
public class CT_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CT_FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		shoppingCart(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		shoppingCart(request, response);
	}
	
	protected void shoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String path = request.getRequestURI().substring(request.getContextPath().length());
			String view = "";
			CTAction command = null;
			
			if(path.equals("/myCartList.cart")) { //리스트업하는 method
				
				view = "cart/cartList.jsp";
				request.getRequestDispatcher(view).forward(request, response);
				
			}else if(path.equals("/payment.cart")) { //결제하기 눌렀을때 회원한테 강의 담기
				command = new insertClassAction();
				command.execute(request, response);
			}else if(path.equals("/delete.cart")) { //카트 지워버릴떄...
				command = new DeleteCart();
				command.execute(request, response);
				view = "cart/cartList.jsp";
				request.getRequestDispatcher(view).forward(request, response);
				
				
			}
	}
	
}//end servlet
