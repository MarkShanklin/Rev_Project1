package com.java.ers;

public enum ReimbursementTypes {
	LODGING(1), TRAVEL(2), FOOD(3), OTHER(4);

	private final int type;

	private ReimbursementType(int type){this.type = type;}

	public int getValue() {
		return type;
	}
	//ordinal();
}
