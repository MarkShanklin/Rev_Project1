package com.ers.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch (request.getRequestURI()) {
		case "/0429ProjectOne/html/Login.do":
			return LoginController.Login(request);
		case "/0429ProjectOne/html/NewExpense.do":
			return ExpenseController.submitExpense(request);
		case "/0429ProjectOne/html/LoadExpenses.do":
			return AdminExpenseController.loadExpenses(request, response);
		case "/0429ProjectOne/html/ApproveExpense.do":
			return AdminExpenseController.approveExpense(request, response);
		case "/0429ProjectOne/html/DenyExpense.do":
			return AdminExpenseController.denyExpense(request, response);
		default:
			System.out.println("Not a valid .do string recieved");
			return null;
		}
	}
}
