package com.ers.controllers;

import javax.servlet.http.HttpServletRequest;

import com.ers.Employee;
import com.ers.dao.EmployeeDaoImpl;

public class LoginController {

	public static String Login(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EmployeeDaoImpl empImpl = new EmployeeDaoImpl();
		Employee emp = new Employee();
		emp = empImpl.selectEmployeeByUsername(username);
		request.getSession().setAttribute("employee", emp);
		String type = emp.getType();

		if (type.equals("Emp")) {
			if (username.equals(emp.getUsername()) & password.equals(emp.getPassword())) {
				return "/html/EmployeeHome.html";
			}
		} else if (type.equals("Admin")) {
			if (username.equals(emp.getUsername()) & password.equals(emp.getPassword())) {
				return "/html/AdminHome.html";
			}
		}

		return "/html/Login.html";

	}
}
