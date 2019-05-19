package com.ers.controllers;

import javax.servlet.http.HttpServletRequest;

import com.ers.Employee;
import com.ers.Expense;
import com.ers.dao.ExpenseDaoImpl;

public class ExpenseController {

	public static String submitExpense(HttpServletRequest request) {
		Employee emp = (Employee)request.getSession().getAttribute("employee");
		int emp_id = emp.getUsedId();
		String firstname = emp.getFirstName();
		String lastname = emp.getLastName();
		int type = Integer.parseInt(request.getParameter("type"));
		double amount = Double.parseDouble(request.getParameter("Amount"));
		String desc = request.getParameter("Description");
		ExpenseDaoImpl expImpl = new ExpenseDaoImpl();
		Expense exp = new Expense(emp_id,firstname,lastname,type,amount,desc);
		expImpl.insertExpense(exp);
		return "/html/EmployeeHome.html";
	}
}
