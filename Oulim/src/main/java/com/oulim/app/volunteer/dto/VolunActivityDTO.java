package com.oulim.app.volunteer.dto;

public class VolunActivityDTO {

//	
//	Volun_Act_No NUMBER,
//	  Volun_Act_Title VARCHAR2(50) NOT NULL,
//	  Volun_Act_Recru_Begin DATE NOT NULL,
//	  Volun_Act_Recru_End DATE NOT NULL,
//	  Volun_Act_Proc_Begin DATE NOT NULL,
//	  Volun_Act_Proc_End DATE NOT NULL,
//	  Volun_Act_Point NUMBER NOT NULL,
//	  Volun_Act_Begin_Time NUMBER(2) NOT NULL,
//	  Volun_Act_End_Time NUMBER(2) NOT NULL,
//	  Volun_Act_Act_Type NUMBER(2) NOT NULL,
//	  Volun_Act_Age_Group NUMBER(1) NOT NULL,
//	  Volun_Act_Organ_No NUMBER NOT NULL,
//	  Volun_Act_Address VARCHAR2(50) NOT NULL,
//	  Volun_Act_Address_Detail VARCHAR2(50) NOT NULL,
//	  Volun_Act_Postnum VARCHAR2(6) NOT NULL,
//	  Volun_Act_Recru_Max_Count NUMBER(2) NOT NULL,
//	  Volun_Act_Detail VARCHAR2(4000),
	private int volunActNo;
	private String volunActTitle;
	private String volunActRecruBegin;
	private String volunActRecruEnd;
	private String volunActProcBegin;
	private String volunActProcEnd;
	private int volunActPoint;
	private int volunActBeginTime;
	private int volunActEndTime;
	private int volunActActType;
	private int volunActAgeGroup;
	private int volunActOrganNo;
	private String volunActAddress;
	private String volunActAddressDetail;
	private String volunActPostnum;
	private int volunActRecruMaxCount;
	private String volunActDetail;
	public int getVolunActNo() {
		return volunActNo;
	}
	public void setVolunActNo(int volunActNo) {
		this.volunActNo = volunActNo;
	}
	public String getVolunActTitle() {
		return volunActTitle;
	}
	public void setVolunActTitle(String volunActTitle) {
		this.volunActTitle = volunActTitle;
	}
	public String getVolunActRecruBegin() {
		return volunActRecruBegin;
	}
	public void setVolunActRecruBegin(String volunActRecruBegin) {
		this.volunActRecruBegin = volunActRecruBegin;
	}
	public String getVolunActRecruEnd() {
		return volunActRecruEnd;
	}
	public void setVolunActRecruEnd(String volunActRecruEnd) {
		this.volunActRecruEnd = volunActRecruEnd;
	}
	public String getVolunActProcBegin() {
		return volunActProcBegin;
	}
	public void setVolunActProcBegin(String volunActProcBegin) {
		this.volunActProcBegin = volunActProcBegin;
	}
	public String getVolunActProcEnd() {
		return volunActProcEnd;
	}
	public void setVolunActProcEnd(String volunActProcEnd) {
		this.volunActProcEnd = volunActProcEnd;
	}
	public int getVolunActPoint() {
		return volunActPoint;
	}
	public void setVolunActPoint(int volunActPoint) {
		this.volunActPoint = volunActPoint;
	}
	public int getVolunActBeginTime() {
		return volunActBeginTime;
	}
	public void setVolunActBeginTime(int volunActBeginTime) {
		this.volunActBeginTime = volunActBeginTime;
	}
	public int getVolunActEndTime() {
		return volunActEndTime;
	}
	public void setVolunActEndTime(int volunActEndTime) {
		this.volunActEndTime = volunActEndTime;
	}
	public int getVolunActActType() {
		return volunActActType;
	}
	public void setVolunActActType(int volunActActType) {
		this.volunActActType = volunActActType;
	}
	public int getVolunActAgeGroup() {
		return volunActAgeGroup;
	}
	public void setVolunActAgeGroup(int volunActAgeGroup) {
		this.volunActAgeGroup = volunActAgeGroup;
	}
	public int getVolunActOrganNo() {
		return volunActOrganNo;
	}
	public void setVolunActOrganNo(int volunActOrganNo) {
		this.volunActOrganNo = volunActOrganNo;
	}
	public String getVolunActAddress() {
		return volunActAddress;
	}
	public void setVolunActAddress(String volunActAddress) {
		this.volunActAddress = volunActAddress;
	}
	public String getVolunActAddressDetail() {
		return volunActAddressDetail;
	}
	public void setVolunActAddressDetail(String volunActAddressDetail) {
		this.volunActAddressDetail = volunActAddressDetail;
	}
	public String getVolunActPostnum() {
		return volunActPostnum;
	}
	public void setVolunActPostnum(String volunActPostnum) {
		this.volunActPostnum = volunActPostnum;
	}
	public int getVolunActRecruMaxCount() {
		return volunActRecruMaxCount;
	}
	public void setVolunActRecruMaxCount(int volunActRecruMaxCount) {
		this.volunActRecruMaxCount = volunActRecruMaxCount;
	}
	public String getVolunActDetail() {
		return volunActDetail;
	}
	public void setVolunActDetail(String volunActDetail) {
		this.volunActDetail = volunActDetail;
	}
	@Override
	public String toString() {
		return "VolunActivityDTO [volunActNo=" + volunActNo + ", volunActTitle=" + volunActTitle
				+ ", volunActRecruBegin=" + volunActRecruBegin + ", volunActRecruEnd=" + volunActRecruEnd
				+ ", volunActProcBegin=" + volunActProcBegin + ", volunActProcEnd=" + volunActProcEnd
				+ ", volunActPoint=" + volunActPoint + ", volunActBeginTime=" + volunActBeginTime + ", volunActEndTime="
				+ volunActEndTime + ", volunActActType=" + volunActActType + ", volunActAgeGroup=" + volunActAgeGroup
				+ ", volunActOrganNo=" + volunActOrganNo + ", volunActAddress=" + volunActAddress
				+ ", volunActAddressDetail=" + volunActAddressDetail + ", volunActPostnum=" + volunActPostnum
				+ ", volunActRecruMaxCount=" + volunActRecruMaxCount + ", volunActDetail=" + volunActDetail + "]";
	}
	
	
}
