package com.miquankj.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private String orderNum;

    private Integer storeId;

    private Integer customerId;

    private String customerName;

    private Byte customerType;

    private Integer addrId;

    private BigDecimal totalMoney;

    private BigDecimal actualPrice;

    private Integer redEnvId;

    private BigDecimal redPrice;

    private Byte orderStatus;

    private Byte isSpecimen;

    private Byte expressCom;

    private String expressNum;

    private BigDecimal freightPrice;

    private String message;

    private Date orderTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getRedEnvId() {
        return redEnvId;
    }

    public void setRedEnvId(Integer redEnvId) {
        this.redEnvId = redEnvId;
    }

    public BigDecimal getRedPrice() {
        return redPrice;
    }

    public void setRedPrice(BigDecimal redPrice) {
        this.redPrice = redPrice;
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

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
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