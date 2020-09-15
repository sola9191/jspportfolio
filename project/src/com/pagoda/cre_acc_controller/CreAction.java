package com.pagoda.cre_acc_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CreAction {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	}

