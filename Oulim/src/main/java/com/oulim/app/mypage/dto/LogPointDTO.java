package com.oulim.app.mypage.dto;

public class LogPointDTO {
//	  Log_No NUMBER,
//	  User_No NUMBER NOT NULL,
//	  Currency_ID NUMBER NOT NULL,
//	  Change_AMOUNT NUMBER NOT NULL,
//	  Log_Reason VARCHAR2(50),
//	  Log_Date DATE NOT NULL,
	
	private int logNo;
	private int userNo;
	private int currencyId;
	private int changeAmount;
	private String logReason;
	private String logDate;
	
	public int getLogNo() {
		return logNo;
	}
	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public int getChangeAmount() {
		return changeAmount;
	}
	public void setChangeAmount(int changeAmount) {
		this.changeAmount = changeAmount;
	}
	public String getLogReason() {
		return logReason;
	}
	public void setLogReason(String logReason) {
		this.logReason = logReason;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	
	@Override
	public String toString() {
		return "LogPointDTO [logNo=" + logNo + ", userNo=" + userNo + ", currencyId=" + currencyId + ", changeAmount="
				+ changeAmount + ", logReason=" + logReason + ", logDate=" + logDate + "]";
	}
}
