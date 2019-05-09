package com.miquankj.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderData {
    private Integer id;

    private Date orderDate;

    private Integer storeId;

    private Integer orderDeal;

    private BigDecimal dealMoney;

    private Integer orderAmount;

    private Integer dealPeople;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public BigDecimal getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(BigDecimal dealMoney) {
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