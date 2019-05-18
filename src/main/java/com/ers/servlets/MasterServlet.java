package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controllers.RequestHelper;

public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = -3303380103882284097L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestHelper.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetURL = RequestHelper.process(request, response);
		request.getRequestDispatcher(targetURL).forward(request, response);
	}
}
