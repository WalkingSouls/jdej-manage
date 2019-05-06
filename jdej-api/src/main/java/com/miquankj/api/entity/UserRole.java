package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class UserRole {
    private Integer userRoleId;

    private Integer userId;

    private Integer roleId;

    private Byte valid = 1;

    private Date joinTime;

}