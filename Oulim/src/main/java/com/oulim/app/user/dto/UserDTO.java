package com.oulim.app.user.dto;

import java.util.Date;

public class UserDTO {
	private int userNo;
    private String userName;
    private String userId;
    private String userPw;
    private String userBirth;
    private String userEmail;
    private int userType;
    private int userStatus;
    private Date userLastLogin;
    private String userNickname;
    private String organName;
    private int organNo;
	private String userPhoneNum;
    private String userAddress;
    private String userAddressDetail;
    private String userPostnum;
    
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public Date getUserLastLogin() {
		return userLastLogin;
	}
	public void setUserLastLogin(Date userLastLogin) {
		this.userLastLogin = userLastLogin;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
    public int getOrganNo() {
		return organNo;
	}
	public void setOrganNo(int organNo) {
		this.organNo = organNo;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserAddressDetail() {
		return userAddressDetail;
	}
	public void setUserAddressDetail(String userAddressDetail) {
		this.userAddressDetail = userAddressDetail;
	}
	public String getUserPostnum() {
		return userPostnum;
	}
	public void setUserPostnum(String userPostnum) {
		this.userPostnum = userPostnum;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", userPw=" + userPw
				+ ", userBirth=" + userBirth + ", userEmail=" + userEmail + ", userType=" + userType + ", userStatus="
				+ userStatus + ", userLastLogin=" + userLastLogin + ", userNickname=" + userNickname + ", organName="
				+ organName + ", organNo=" + organNo + ", userPhoneNum=" + userPhoneNum + ", userAddress=" + userAddress
				+ ", userAddressDetail=" + userAddressDetail + ", userPostnum=" + userPostnum + "]";
	}
    
}
