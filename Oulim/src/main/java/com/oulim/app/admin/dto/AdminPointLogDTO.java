package com.oulim.app.admin.dto;

import java.time.LocalDateTime;

public class AdminPointLogDTO {

    private int userNo;
    private LocalDateTime logDate;
    private String logReason;
    private int changeAmount;

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public String getLogReason() {
        return logReason;
    }

    public void setLogReason(String logReason) {
        this.logReason = logReason;
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
        this.changeAmount = changeAmount;
    }
}