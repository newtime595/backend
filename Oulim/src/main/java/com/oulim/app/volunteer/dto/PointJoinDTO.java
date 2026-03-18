package com.oulim.app.volunteer.dto;

public class PointJoinDTO {

	private int currencyId; 
	private int userNo; 
	private int totalAmount; 

	private int logNo;
	private int changeAmount; 
	private String logReason; 
	private String logDate;
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
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
	public int getLogNo() {
		return logNo;
	}
	public void setLogNo(int logNo) {
		this.logNo = logNo;
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
		return "PointJoinDTO [currencyId=" + currencyId + ", userNo=" + userNo + ", totalAmount=" + totalAmount
				+ ", logNo=" + logNo + ", changeAmount=" + changeAmount + ", logReason=" + logReason + ", logDate="
				+ logDate + "]";
	} 
	
	
}
