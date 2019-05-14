package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3303380103882284097L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//String message = "Hello world, peoples";
		//PrintWriter pWriter = response.getWriter();
		//pWriter.write("<h1>Daily message is: " + message + "</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				//forward
		//if (admin)
		//request.getRequestDispatcher("AdminHome.html").forward(request, response);
		//else if (employee)
		//request.getRequestDispatcher("EmployeeHome.html").forward(request, response);
			}
}
