package com.oulim.app.user.dto;

public class CurrencyDTO {
//	CREATE TABLE TBL_CURRENCY (
//			  Currency_ID NUMBER,
//			  User_No NUMBER,
//			  Total_Amount NUMBER DEFAULT 0 NOT NULL,
//			  CONSTRAINT PK_TBL_CURRENCY PRIMARY KEY (Currency_ID, User_No),
//			  CONSTRAINT FK_CURRENCY_USER FOREIGN KEY (User_No) REFERENCES TBL_USER(User_No) ON DELETE CASCADE
//			);
	
	private int currencyID;
	private int userNo;
	private int totalAmount;
	public int getCurrencyID() {
		return currencyID;
	}
	public void setCurrencyID(int currencyID) {
		this.currencyID = currencyID;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
