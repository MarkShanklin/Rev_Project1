package com.ers;

public enum ReimbursementStatus {
	PENDING(1), APPROVED(2), DENIED(3);
	
	private final int type;

	private ReimbursementStatus(int type){this.type = type;}

	public int getValue() {
		return type;
	}
}
