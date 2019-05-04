package com.miquankj.api.entity;

import java.util.Date;

public class Lending {
    private Integer ledId;

    private Integer customerId;

    private Integer storeId;

    private String phone;

    private Long money;

    private Date applyTime;

    private Byte status;

    public Integer getLedId() {
        return ledId;
    }

    public void setLedId(Integer ledId) {
        this.ledId = ledId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}