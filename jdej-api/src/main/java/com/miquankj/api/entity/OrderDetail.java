package com.miquankj.api.entity;

import lombok.Data;

@Data
public class OrderDetail {
    private Long detailId;

    private String orderId;

    private Integer productId;

    private String proName;

    private String proCategory;

    private String proPic;

    private Long priceUnit;

    private Integer amount;

    private Byte status = 1;

}