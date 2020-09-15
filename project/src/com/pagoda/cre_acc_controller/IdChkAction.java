package com.pagoda.cre_acc_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pagoda.dao.Cre_Acc_Dao;
import com.pagoda.dto.Cre_Acc_Dto;

public class IdChkAction implements CreAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		int result = -1;
		String data ="사용가능한 아이디 입니다.";
		
		Cre_Acc_Dto dto = new Cre_Acc_Dto();
		Cre_Acc_Dao dao = new Cre_Acc_Dao();
		dto.setPid(request.getParameter("pid"));
		result = dao.iddouble(dto);
		if(result==1) { data = "중복된 아이디가 존재합니다."; }
		Gson gson = new Gson();
		JsonObject menu = new JsonObject();
		menu.addProperty("data", data);
		String json = gson.toJson(menu);
		out.println(json);
		out.close();
		
	}

}
