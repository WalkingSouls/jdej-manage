package com.miquankj.api.entity;

import java.util.Date;

public class OrderData {
    private Date orderDate;

    private Integer storeId;

    private Integer orderDeal;

    private Long dealMoney;

    private Integer orderAmount;

    private Integer dealPeople;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getOrderDeal() {
        return orderDeal;
    }

    public void setOrderDeal(Integer orderDeal) {
        this.orderDeal = orderDeal;
    }

    public Long getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(Long dealMoney) {
        this.dealMoney = dealMoney;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getDealPeople() {
        return dealPeople;
    }

    public void setDealPeople(Integer dealPeople) {
        this.dealPeople = dealPeople;
    }
}