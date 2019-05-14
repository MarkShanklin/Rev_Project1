package com.ers;

public class Employee {

	int usedId;
	String username;
	String password;
	String firstName;
	String lastName;

	public Employee(int usedId, String username, String password, String firstName, String lastName) {
		super();
		this.usedId = usedId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void login() {
		// TODO login implementation. may not go here?
	}

	public int getUsedId() {
		return usedId;
	}

	public void setUsedId(int usedId) {
		this.usedId = usedId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [usedId=" + usedId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
}
