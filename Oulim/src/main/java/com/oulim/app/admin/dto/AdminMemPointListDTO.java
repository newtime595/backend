package com.oulim.app.admin.dto;



public class AdminMemPointListDTO {

//	보유포인트
//	포인트지급차감이유(입력)
//	보유포인트(지급차감버튼)
//	포인트조회(리스트)
//	뒤로가기버튼
	
//	  Total_Amount NUMBER DEFAULT 0 NOT NULL,
//	  Change_AMOUNT NUMBER NOT NULL,
//	  Log_Reason VARCHAR2(50),
//	  Log_Date DATE NOT NULL,
	
		private int totalAmount;
		private int changeAmount;
		private String logReason;
		
		
		
		
		public int getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(int totalAmount) {
			this.totalAmount = totalAmount;
		}
		public int getChangeAmount() {
			return changeAmount;
		}
		public void setChangeAmount(int changeAmount) {
			this.changeAmount = changeAmount;
		}
		public String getLogReason() {
			return logReason;
		}
		public void setLogReason(String logReason) {
			this.logReason = logReason;
		}
		@Override
		public String toString() {
			return "AdminMemPointListDTO [totalAmount=" + totalAmount + ", changeAmount=" + changeAmount
					+ ", logReason=" + logReason + "]";
		}

		
		
	
}
