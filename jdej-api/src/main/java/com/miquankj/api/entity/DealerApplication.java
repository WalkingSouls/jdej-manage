package com.miquankj.api.entity;

import java.util.Date;

public class DealerApplication {
    private Integer num;

    private Integer customerId;

    private String cusType;

    private Date applyTime;

    private String checker;

    private Byte applyStatus;

    private String applyReason;

    private Byte finalRemark;

    private Date updateTime;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Byte getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Byte applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Byte getFinalRemark() {
        return finalRemark;
    }

    public void setFinalRemark(Byte finalRemark) {
        this.finalRemark = finalRemark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}