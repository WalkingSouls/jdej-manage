package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class DealerApplication {
    private Integer num;

    private Integer customerId;

    private String cusType;

    private Date applyTime;

    private String checker;

    private Byte applyStatus;

    private String applyReason;

    private Byte finalRemark;

    private Date updateTime;

}