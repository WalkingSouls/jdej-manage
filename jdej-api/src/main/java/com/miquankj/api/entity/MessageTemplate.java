package com.miquankj.api.entity;

import lombok.Data;

@Data
public class MessageTemplate {
    private Integer msgTemId;

    private String temName;

    private Boolean valid = true;

    private String temDes;

}