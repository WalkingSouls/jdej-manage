package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Freight {
    private Integer freId;

    private Integer storeId;

    private String name;

    private Byte valid = 1;

    private Date createTime;

}