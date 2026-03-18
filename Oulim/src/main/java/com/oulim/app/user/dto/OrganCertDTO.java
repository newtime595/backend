package com.oulim.app.user.dto;

import java.util.Arrays;

public class OrganCertDTO {
	
	private int organCertNo;
	private int userNo;
	private int organNo;
	private byte[] organCertFile;
	
	public int getOrganCertNum() {
		return organCertNo;
	}
	public void setOrganCertNum(int organCertNo) {
		this.organCertNo = organCertNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getOrganNo() {
		return organNo;
	}
	public void setOrganNo(int organNo) {
		this.organNo = organNo;
	}
	public byte[] getOrganCertFile() {
		return organCertFile;
	}
	public void setOrganCertFile(byte[] organCertFile) {
		this.organCertFile = organCertFile;
	}
	
	@Override
	public String toString() {
		return "OrganCertDTO [organCertNum=" + organCertNo + ", userNo=" + userNo + ", organNo=" + organNo
				+ ", organCertFile=" + Arrays.toString(organCertFile) + "]";
	}
	
	
}
