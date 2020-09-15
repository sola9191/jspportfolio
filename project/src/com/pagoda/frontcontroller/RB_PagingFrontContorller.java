package com.pagoda.frontcontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pagoda.dao.PagingDao;
import com.pagoda.dao.RBDao;
import com.pagoda.dto.PagingDto;
import com.pagoda.dto.RBDto;

/**
 * Servlet implementation class RB_FrontContorller
 */
@WebServlet("*.review")
public class RB_PagingFrontContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RB_PagingFrontContorller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PagingDao dao =new PagingDao();
		ArrayList<RBDto> test = null;
		//1. dao를 이용하여 전체 게시판의 갯수 (글의 갯수) 12개
		int pageTotal = dao.listCnt();
		//System.out.println("1. 전체 게시판의 갯수:" + pageTotal);
		
		//2. 한페이지당 보여줄 레코드수(글) 10
		int onepageLimit = 5;
		//System.out.println("2. 한페이지당 보여줄 레코드수(글):" + onepageLimit);
		
		//3. 하단 index의 갯수 12/10 : 26/5 => 5.1 25/5 = 5.0
		int pageAll = (int) Math.ceil(pageTotal/(float) onepageLimit);
		//System.out.println("3. 하단index의 갯수: " + pageAll);
 		
		//4.  db에서 가져올 번호(1번버튼시 0번째부터, 2번버튼 10번째부터, 3번버튼 20번째부터)
		int pstartno= 0;
		if(request.getParameter("pstartno")!=null) {
			pstartno = Integer.parseInt(request.getParameter("pstartno"));
		}
		 test = dao.list5(pstartno);
		//System.out.println("4. db에서 가져올 번호:" +pstartno);
		
		//5. 하단 페이지 네비(10) <이전 1,2,3,4,5,6,7,8,9,10 다음>
		int bottomlist = 5; 
		//System.out.println("5: 하단페이지네비(10): "+bottomlist);
		
		//6. 하단페이지 네비 - 현재페이지 네비번호 *** <이전 1(시작페이지번호) 2(현재페이지번호) 3 4 5 6 7 8 9 10(끝나는 페이지번호) 다음>
		//private int bottomlist;
		//pstart번호가 10이라면 현재페이지2 
		int bottom_current = (int) Math.ceil((pstartno +1)/(float)onepageLimit);
		
		//7. 하단페이지네비 - 현재페이지 기준 - 시작 페이지 네비번호**
		//private int bottom_start;
		int bottom_start = ((int) Math.floor((bottom_current-1)/(float)bottomlist))*bottomlist +1;
		
		//8. 하단페이지네비 - 현재페이지 기준 - 끝페이지 네비번호**
		//private int bottom_end;
		int bottom_end = bottom_start+bottomlist -1;
		if(pageAll < bottom_end) { bottom_end = pageAll; }
		
		//9. list페이지로 넘어가기
		request.setAttribute("items", new PagingDto(pageTotal, onepageLimit, pageAll, pstartno, bottomlist, bottom_current,
				bottom_start, bottom_end, test));
		//System.out.println(request.getAttribute("items"));
		RBDao daotest = new RBDao();
//		request.setAttribute("ttt", daotest.listAll());

		request.getRequestDispatcher("/Review/review_MainBoard.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);
			}
}
	