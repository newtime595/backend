package com.oulim.app.volunteer.dto;

public class VolunApplyDTO {

//	Volun_Act_No NUMBER,
//	  User_No NUMBER,
//	  VolunAct_ApplyDate DATE NOT NULL,
//	  VolunAct_ApplyStatus NUMBER(1) DEFAULT 1 NOT NULL,
//	  VolunAct_Attendance NUMBER(1) DEFAULT 0 NOT NULL,
//	  CONSTRAINT PK_TBL_VOLUN_APPLY PRIMARY KEY (Volun_Act_No, User_No),

	private int volunActNo;
	private int userNo;
	private String volunActApplyDate;
	private int volunActApplyStatus;
	private int volunActAttendance;
	private String userName;	//이름
	private String userBirth;	//생년월일
	private String userAge;		// 나이
	private int currentCount;	// 날짜 계산용
	
	public int getVolunActNo() {
		return volunActNo;
	}
	
	public void setVolunActNo(int volunActNo) {
		this.volunActNo = volunActNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getVolunActApplyDate() {
		return volunActApplyDate;
	}
	public void setVolunActApplyDate(String volunActApplyDate) {
		this.volunActApplyDate = volunActApplyDate;
	}
	public int getVolunActApplyStatus() {
		return volunActApplyStatus;
	}
	public void setVolunActApplyStatus(int volunActApplyStatus) {
		this.volunActApplyStatus = volunActApplyStatus;
	}
	public int getVolunActAttendance() {
		return volunActAttendance;
	}
	public void setVolunActAttendance(int volunActAttendance) {
		this.volunActAttendance = volunActAttendance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	@Override
	public String toString() {
		return "VolunApplyDTO [volunActNo=" + volunActNo + ", userNo=" + userNo + ", volunActApplyDate="
				+ volunActApplyDate + ", volunActApplyStatus=" + volunActApplyStatus + ", volunActAttendance="
				+ volunActAttendance + ", userName=" + userName + ", userBirth=" + userBirth + ", userAge=" + userAge
				+ ", currentCount=" + currentCount + "]";
	}
	
}
