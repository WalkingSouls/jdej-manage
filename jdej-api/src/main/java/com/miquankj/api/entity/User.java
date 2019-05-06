package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Integer userId;

    private String account;

    private String name;

    private Byte status = 1;

    private Date createTime;

}