package com.ers.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.Expense;
import com.ers.dao.ExpenseDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdminExpenseController {

	public static String loadExpenses(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("loadExpenses");
		ExpenseDaoImpl expImpl = new ExpenseDaoImpl();
		List<Expense> lExp = new ArrayList<Expense>();
		System.out.printf("list of expenses = ?",lExp);
		lExp = expImpl.selectAllExpenses();
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(lExp));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/html/AdminHome.html";
	}

	public static String approveExpense(HttpServletRequest request, HttpServletResponse response) {

		return "/html/AdminHome.html";
	}

	public static String denyExpense(HttpServletRequest request, HttpServletResponse response) {

		return "/html/AdminHome.html";
	}
}
