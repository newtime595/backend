package com.oulim.app.admin.dto;

public class AdminMemDetailDTO {

    private int userNo;
    private String userName;
    private String userId;
    private String userNickname;
    private String userAddress;
    private String userAddressDetail;
   
    private int totalAmount;
    
    
    
    
    
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
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
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
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "AdminMemDetailDTO [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId
				+ ", userNickname=" + userNickname + ", userAddress=" + userAddress + ", userAddressDetail="
				+ userAddressDetail + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
