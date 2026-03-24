package com.oulim.app.admin.dto;

import java.time.LocalDateTime;

public class AdminPointDTO {
    private int userNo;
    private int changeAmount;
    private String logReason;
    private LocalDateTime logDate;
    private int totalAmount;
    
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public LocalDateTime getLogDate() {
		return logDate;
	}
	public void setLogDate(LocalDateTime logDate) {
		this.logDate = logDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Override
	public String toString() {
		return "AdminPointDTO [userNo=" + userNo + ", changeAmount=" + changeAmount + ", logReason=" + logReason
				+ ", logDate=" + logDate + ", totalAmount=" + totalAmount + "]";
	}
    
    
    
}
