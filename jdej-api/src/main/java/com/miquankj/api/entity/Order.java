package com.miquankj.api.entity;

import java.util.Date;

public class Order {
    private String orderId;

    private Integer storeId;

    private Integer customerId;

    private String customerName;

    private Byte customerType;

    private Long totalMoney;

    private Byte orderStatus;

    private Byte isSpecimen;

    private Byte expressCom;

    private String expressNum;

    private String message;

    private Date orderTime;

    private Date updateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Byte getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Byte customerType) {
        this.customerType = customerType;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getIsSpecimen() {
        return isSpecimen;
    }

    public void setIsSpecimen(Byte isSpecimen) {
        this.isSpecimen = isSpecimen;
    }

    public Byte getExpressCom() {
        return expressCom;
    }

    public void setExpressCom(Byte expressCom) {
        this.expressCom = expressCom;
    }

    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}