package com.miquankj.api.entity;

import lombok.Data;

@Data
public class RolePermission {
    private Integer rolePerId;

    private Integer roleId;

    private Integer permissionId;

    private Byte valid = 1;

}