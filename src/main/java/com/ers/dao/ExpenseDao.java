package com.ers.dao;

import java.util.List;

import com.ers.Expense;

public interface ExpenseDao {
	// CREATE
	public int insertExpense(Expense exp);

	// READ
	public List<Expense> selectExpensesByEmployeeId(int emp_id);

	public List<Expense> selectAllExpenses();

	// UPDATE
	void updateExpense(Expense exp);
	void approveExpense(int ticket_id);
	void denyExpense(int ticket_id);

	// DELETE
	void deleteExpense(Expense exp);
}
