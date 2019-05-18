package com.ers;

import java.sql.Date;

public class Expense {

	int ticketId;
	int employeeId;
	String firstname;
	String lastname;
	ReimbursementTypes type;
	double amount;
	Date submitted;
	Date resolved;
	ReimbursementStatus status;
	String description;

	public Expense() {
	}

	public Expense(int ticketId, int employeeId, String firstname, String lastname, int type,
			double amount, Date submitted, Date resolved, int status, String description) {
		super();
		this.ticketId = ticketId;
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = getType(type);
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.status = getStatus(status);
		this.description = description;
	}

	public Expense(int employeeId, String firstname, String lastname, int type, double amount, String description) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = getType(type);
		this.amount = amount;
		this.submitted = new Date(System.currentTimeMillis());
		this.status = ReimbursementStatus.PENDING;
		this.description = description;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public ReimbursementTypes getType() {
		return type;
	}

	public ReimbursementTypes getType(int type) {
		switch (type) {
		case 1:
			return ReimbursementTypes.LODGING;
		case 2:
			return ReimbursementTypes.TRAVEL;
		case 3:
			return ReimbursementTypes.FOOD;
		case 4:
			return ReimbursementTypes.OTHER;
		default:
			return ReimbursementTypes.OTHER;
		}
	}

	public void setType(ReimbursementTypes type) {
		this.type = type;
	}

	public void setType(int type) {
		switch (type) {
		case 1:
			this.type = ReimbursementTypes.LODGING;
		case 2:
			this.type = ReimbursementTypes.TRAVEL;
		case 3:
			this.type = ReimbursementTypes.FOOD;
		case 4:
			this.type = ReimbursementTypes.OTHER;
		default:
			this.type = ReimbursementTypes.OTHER;
		}
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public ReimbursementStatus getStatus(int status) {
		switch (status) {
		case 1:		
			return ReimbursementStatus.PENDING;
		case 2:
			return ReimbursementStatus.APPROVED;
		case 3:
			return ReimbursementStatus.DENIED;
		default:
			return ReimbursementStatus.PENDING;
		}
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}
	
	public void setStatus(int status) {
		switch (status) {
		case 1:
			this.status = ReimbursementStatus.PENDING;
		case 2:
			this.status = ReimbursementStatus.APPROVED;
		case 3:
			this.status = ReimbursementStatus.DENIED;
		default:
			this.status = ReimbursementStatus.PENDING;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Expense [ticketId=" + ticketId + ", employeeId=" + employeeId + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", type=" + type + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", status=" + status + ", description=" + description + "]";
	}

}