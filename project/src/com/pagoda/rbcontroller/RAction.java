package com.pagoda.rbcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
