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
	
	private int volunActNo;		//봉사봉사번호
	private String volunActTitle; 	// 봉사 타이틀	
	private String volunActRecruBegin;	//모집시작일
	private String volunActRecruEnd;	//모집 종료일
	private String volunActProcBegin;	// 봉사시작일
	private String volunActProcEnd;	// 봉사 종료일
	private int volunActPoint;		// 포인트
	private int volunActBeginTime; 	// 봉사 시작 시간
	private int volunActEndTime;	// 봉사 종료 시간
	private int volunActActType;	// 활동분야
	private int volunActAgeGroup;	// 활동가능연령
	private int volunActOrganNo;	// 기업번호
	private String volunActAddress; // 봉사 주소
	private String volunActAddressDetail;	//상세주소
	private String volunActPostnum;	// 우편번호
	private int volunActRecruMaxCount; // 최대모집인원수
	private String volunActDetail;	// 상세내용
	private String recruStatus;     // DB 계산 결과용 상태값(모집중,모집예정,마감)
	private String recruitStatus;   // 검색용 상태값
	private String actType;         // 검색용 활동분야 문자열
	private String keyword;         // 검색어
	private String searchType;		// 검색 조건
	private String VolunActOrginName;// 기관 명
	private String Organization;	// 주체단체
	private String orgName;			// 주체단체이름
	private String actTypeName; // 활동분야
	private String ageGroupName; // 활동가능연령대

	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getActTypeName() {
		return actTypeName;
	}
	public void setActTypeName(String actTypeName) {
		this.actTypeName = actTypeName;
	}
	public String getAgeGroupName() {
		return ageGroupName;
	}
	public void setAgeGroupName(String ageGroupName) {
		this.ageGroupName = ageGroupName;
	}
	private int StartRow;
    private int EndRow;
	

	public int getStartRow() {
		return StartRow;
	}
	public void setStartRow(int startRow) {
		StartRow = startRow;
	}
	public int getEndRow() {
		return EndRow;
	}
	public void setEndRow(int endRow) {
		EndRow = endRow;
	}
	public String getOrganization() {
		return Organization;
	}
	public void setOrganization(String organization) {
		this.Organization = organization;
	}
	
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
	public String getRecruStatus() {
		return recruStatus;
	}
	public void setRecruStatus(String recruStatus) {
		this.recruStatus = recruStatus;
	}
	public String getRecruitStatus() {
		return recruitStatus;
	}
	public void setRecruitStatus(String recruitStatus) {
		this.recruitStatus = recruitStatus;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getVolunActOrginName() {
		return VolunActOrginName;
	}
	public void setVolunActOrginName(String volunActOrginName) {
		VolunActOrginName = volunActOrginName;
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
				+ ", volunActRecruMaxCount=" + volunActRecruMaxCount + ", volunActDetail=" + volunActDetail
				+ ", recruStatus=" + recruStatus + ", recruitStatus=" + recruitStatus + ", actType=" + actType
				+ ", keyword=" + keyword + ", searchType=" + searchType + ", VolunActOrginName=" + VolunActOrginName
				+ "]";
	}
	
	
}
