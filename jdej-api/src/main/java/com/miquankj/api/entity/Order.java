package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private String orderId;

    private Integer storeId;

    private Integer customerId;

    private String customerName;

    private Byte customerType;

    private Long totalMoney;

    private Byte orderStatus = 1;

    private Byte isSpecimen;

    private Byte expressCom;

    private String expressNum;

    private String message;

    private Date orderTime;

    private Date updateTime;

}