package com.ers.dao;

import java.util.List;

import com.ers.Expense;

public interface ExpenseDao {
	// CREATE
	public int insertExpense(Expense exp);

	// READ
	public Expense selectTicketsByEmployeeId(int emp_id);

	public List<Expense> selectAllExpenses();

	// UPDATE
	void updateExpense(Expense exp);

	// DELETE
	void deleteExpense(Expense exp);
}
