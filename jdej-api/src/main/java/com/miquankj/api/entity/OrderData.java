package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class OrderData {
    private Date orderDate;

    private Integer storeId;

    private Integer orderDeal;

    private Long dealMoney;

    private Integer orderAmount;

    private Integer dealPeople;

}