package com.oulim.app.mypage.dto;



public class MyPageJoinDTO {
	
	private int volunActNo;
	private int volunActEndTime;
	private int volunActBeginTime;
	private int totalVolunTime;
	private int rankPoint;
	private int totalAmount;
	private String volunActTitle; 
//	private String comVolTitle;
//	private String finVolTitle;
	private String comVolunActProcBegin;
	private String comVolunActProcEnd;
	private String finVolunActProcBegin;
	private String finVolunActProcEnd;
	private int userStatus;
	private int userNo;
	private String userAddress;
	private String userAddressDetail;
	private String userPostnum;
	private String userNickname;
	private String userPw;
	private String userEmail;
	private String userPhoneNum;
	private String organName;
	private int organNo;
	private String organCertNum;
	private String postTitle;
	private String postDate;
	private int postLikeNo;
	private int postNo;
	private String logReason;
	private String logDate;
	private int changeAmount;
	
	
	
	public String getComVolunActProcBegin() {
		return comVolunActProcBegin;
	}
	public void setComVolunActProcBegin(String comVolunActProcBegin) {
		this.comVolunActProcBegin = comVolunActProcBegin;
	}
	public String getComVolunActProcEnd() {
		return comVolunActProcEnd;
	}
	public void setComVolunActProcEnd(String comVolunActProcEnd) {
		this.comVolunActProcEnd = comVolunActProcEnd;
	}
	public String getFinVolunActProcBegin() {
		return finVolunActProcBegin;
	}
	public void setFinVolunActProcBegin(String finVolunActProcBegin) {
		this.finVolunActProcBegin = finVolunActProcBegin;
	}
	public String getFinVolunActProcEnd() {
		return finVolunActProcEnd;
	}
	public void setFinVolunActProcEnd(String finVolunActProcEnd) {
		this.finVolunActProcEnd = finVolunActProcEnd;
	}
	public int getVolunActNo() {
		return volunActNo;
	}
	public void setVolunActNo(int volunActNo) {
		this.volunActNo = volunActNo;
	}
	public int getVolunActEndTime() {
		return volunActEndTime;
	}
	public void setVolunActEndTime(int volunActEndTime) {
		this.volunActEndTime = volunActEndTime;
	}
	public int getVolunActBeginTime() {
		return volunActBeginTime;
	}
	public void setVolunActBeginTime(int volunActBeginTime) {
		this.volunActBeginTime = volunActBeginTime;
	}
	public int getTotalVolunTime() {
		return totalVolunTime;
	}
	public void setTotalVolunTime(int totalVolunTime) {
		this.totalVolunTime = totalVolunTime;
	}
	public int getRankPoint() {
		return rankPoint;
	}
	public void setRankPoint(int rankPoint) {
		this.rankPoint = rankPoint;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getVolunActTitle() {
		return volunActTitle;
	}
	public void setVolunActTitle(String volunActTitle) {
		this.volunActTitle = volunActTitle;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public String getOrganCertNum() {
		return organCertNum;
	}
	public void setOrganCertNum(String organCertNum) {
		this.organCertNum = organCertNum;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public int getPostLikeNo() {
		return postLikeNo;
	}
	public void setPostLikeNo(int postLikeNo) {
		this.postLikeNo = postLikeNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
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
	@Override
	public String toString() {
		return "MyPageJoinDTO [volunActNo=" + volunActNo + ", volunActEndTime=" + volunActEndTime
				+ ", volunActBeginTime=" + volunActBeginTime + ", totalVolunTime=" + totalVolunTime + ", rankPoint="
				+ rankPoint + ", totalAmount=" + totalAmount + ", volunActTitle=" + volunActTitle
				+ ", comVolunActProcBegin=" + comVolunActProcBegin + ", comVolunActProcEnd=" + comVolunActProcEnd
				+ ", finVolunActProcBegin=" + finVolunActProcBegin + ", finVolunActProcEnd=" + finVolunActProcEnd
				+ ", userStatus=" + userStatus + ", userNo=" + userNo + ", userAddress=" + userAddress
				+ ", userAddressDetail=" + userAddressDetail + ", userPostnum=" + userPostnum + ", userNickname="
				+ userNickname + ", userPw=" + userPw + ", userEmail=" + userEmail + ", userPhoneNum=" + userPhoneNum
				+ ", organName=" + organName + ", organNo=" + organNo + ", organCertNum=" + organCertNum
				+ ", postTitle=" + postTitle + ", postDate=" + postDate + ", postLikeNo=" + postLikeNo + ", postNo="
				+ postNo + ", logReason=" + logReason + ", logDate=" + logDate + ", changeAmount=" + changeAmount + "]";
	}

	
	

	
	
}
