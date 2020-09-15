package com.pagoda.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCart implements CTAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemcart ="";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String cookie = request.getHeader("Cookie"); //쿠키 있나보고
		//쿠키값 가져오기
		if(cookie!=null) {
			Cookie [] cookies = request.getCookies();
			for (int i = 0; i<cookies.length ; i++) {
				if(cookies[i].getName().equals("itemcart")) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);					
				}
			}
		}
	}
}
