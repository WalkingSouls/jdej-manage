package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Role {
    private Integer roleId;

    private Integer storeId;

    private String roleName;

    private String description;

    private String creater;

    private Integer amount;

    private Byte status = 1;

    private Date createTime;

}