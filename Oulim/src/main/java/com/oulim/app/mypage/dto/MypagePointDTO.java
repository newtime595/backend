package com.oulim.app.mypage.dto;


public class MypagePointDTO {
	private String logReason;
	private String logDate;
	private int changeAmount;
	
	
	@Override
	public String toString() {
		return "MypagePointDTO [logReason=" + logReason + ", logDate=" + logDate + ", changeAmount=" + changeAmount
				+ "]";
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
	public int getChangeAmount() {
		return changeAmount;
	}
	public void setChangeAmount(int changeAmount) {
		this.changeAmount = changeAmount;
	}
	
	
	
	
}
