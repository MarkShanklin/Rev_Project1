package com.ers.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.Employee;
import com.ers.Expense;
import com.ers.dao.ExpenseDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeExpenseController {

	public static String loadExpensesById(HttpServletRequest request, HttpServletResponse response) {
		ExpenseDaoImpl expImpl = new ExpenseDaoImpl();
		List<Expense> lExp = new ArrayList<Expense>();
		Employee emp = (Employee)request.getSession().getAttribute("employee");
		int emp_id = emp.getUsedId();
		lExp = expImpl.selectExpensesByEmployeeId(emp_id);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(lExp));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/html/EmployeeHome.html";
	}
}
