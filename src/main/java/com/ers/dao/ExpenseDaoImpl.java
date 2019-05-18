package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.ers.Employee;
import com.ers.Expense;

public class ExpenseDaoImpl implements ExpenseDao {

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private static String url = "jdbc:oracle:thin:@sqldb.cwlqx18ig2af.us-west-2.rds.amazonaws.com:1521:sqldb";
	private static String username = "Revature";
	private static String password = "P4$$w0rd";

	@Override
	public int insertExpense(Expense exp) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO ticket " + "(employee_id,firstname,lastname,type,amount,date_submitted,date_resolved,status,description) "
							+ "VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, exp.getEmployeeId());
			ps.setString(2, exp.getFirstname());
			ps.setString(3, exp.getLastname());
			ps.setInt(4, exp.getType().getValue());
			ps.setDouble(5, exp.getAmount());
			ps.setDate(6, exp.getSubmitted());
			ps.setDate(7, exp.getResolved());
			ps.setInt(8, exp.getStatus().getValue());
			ps.setString(9, exp.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Expense selectTicketsByEmployeeId(int emp_id) {

		return null;
	}

	@Override
	public List<Expense> selectAllExpenses() {
		System.out.println("selectAllExpenses");
		List<Expense> exps = new ArrayList<Expense>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ticket");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				exps.add(new Expense(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10)));
				System.out.println("Getting new Expense");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exps;
	}

	@Override
	public void updateExpense(Expense exp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExpense(Expense exp) {
		// TODO Auto-generated method stub

	}

}
