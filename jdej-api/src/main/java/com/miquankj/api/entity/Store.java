package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Store {
    private Integer storeId;

    private String storeName;

    private Integer grpId;

    private String linkmen;

    private String phone;

    private String address;

    private String major;

    private String idCardPath1;

    private String idCardPath2;

    private String licensePath;

    private Byte status;

    private Date createTime;

    private String storeInfo;
}