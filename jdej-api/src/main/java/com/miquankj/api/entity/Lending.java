package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Lending {
    private Integer ledId;

    private Integer customerId;

    private Integer storeId;

    private String phone;

    private Long money;

    private Date applyTime;

    private Byte status;

}