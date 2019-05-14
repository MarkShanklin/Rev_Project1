package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private static String url = "jdbc:oracle:thin:@sqldb.cwlqx18ig2af.us-west-2.rds.amazonaws.com:1521:sqldb";
	private static String username = "Revature";
	private static String password = "Pa$$w0rd";

	@Override
	public Employee selectEmployeeByUsername(String username) {
		Employee emp = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emps.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public void updateEmployee(Employee emp) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE employee SET username=?, password=?, first_name=?, last_name?, type=? WHERE user_id=?");
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getFirstName());
			ps.setString(4, emp.getLastName());
			ps.setString(5, emp.getType());
			ps.setInt(6, emp.getUsedId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(Employee emp) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE user_id=?");
			ps.setInt(1, emp.getUsedId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
