package com.oulim.app.admin.dto;


public class AdminCompanyCertificationDTO {
//	유저번호
//	회사명
//	아이디
//	가입일
//	회사코드
//	====
//	체크박스
//	페이지네이션
//	승인반려버튼
//	UserNo NUMBER
//	OrganName VARCHAR2
//	UserID varchar2
//	
//	  Organ_No NUMBER
	

   
    private int userNo;              // 유저번호
    private String organName;        // 회사명
    private String userId;           // 아이디
    private int organNo;
    private String userName;
    private String userEmail;
    private String userBirth;
    private String organCertNum;
    private String organFileSystemName;
    private String organFileOriginalName;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getOrganNo() {
		return organNo;
	}
	public void setOrganNo(int organNo) {
		this.organNo = organNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getOrganFileSystemName() {
		return organFileSystemName;
	}
	public void setOrganFileSystemName(String organFileSystemName) {
		this.organFileSystemName = organFileSystemName;
	}
	public String getOrganFileOriginalName() {
		return organFileOriginalName;
	}
	public void setOrganFileOriginalName(String organFileOriginalName) {
		this.organFileOriginalName = organFileOriginalName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrganCertNum() {
		return organCertNum;
	}
	public void setOrganCertNum(String organCertNum) {
		this.organCertNum = organCertNum;
	}
	
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	@Override
	public String toString() {
		return "AdminCompanyCertificationDTO [userNo=" + userNo + ", organName=" + organName + ", userId=" + userId
				+ ", organNo=" + organNo + ", userName=" + userName + ", userEmail=" + userEmail + ", userBirth="
				+ userBirth + ", organCertNum=" + organCertNum + ", organFileSystemName=" + organFileSystemName
				+ ", organFileOriginalName=" + organFileOriginalName + "]";
	}

}
