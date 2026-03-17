package com.oulim.app.community.dto;

public class PostImageDTO {
//	CREATE TABLE TBL_POST_IMAGE (
//			  Image_No NUMBER,
//			  Post_No NUMBER NOT NULL,
//			  Post_Img_System_Name VARCHAR2(300) NOT NULL,
//			  Post_Img_Origin_Name VARCHAR2(300) NOT NULL,
	
	private int imageNo;
	private int postNo;
	private String postImgSystemName;
	private String postImgOriginName;
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getPostImgSystemName() {
		return postImgSystemName;
	}
	public void setPostImgSystemName(String postImgSystemName) {
		this.postImgSystemName = postImgSystemName;
	}
	public String getPostImgOriginName() {
		return postImgOriginName;
	}
	public void setPostImgOriginName(String postImgOriginName) {
		this.postImgOriginName = postImgOriginName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
