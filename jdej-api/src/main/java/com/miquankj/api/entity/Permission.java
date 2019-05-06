package com.miquankj.api.entity;

import lombok.Data;

@Data
public class Permission {
    private Integer permissionId;

    private Byte indexMan;

    private Byte userMan;

    private Byte productMan;

    private Byte orderMan;

    private Byte marktingMan;

    private Byte lendingMan;

    private Byte dataCenter;

    private Byte adminMan;

}