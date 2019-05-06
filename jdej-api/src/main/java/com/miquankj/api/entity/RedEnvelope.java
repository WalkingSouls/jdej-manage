package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class RedEnvelope {
    private Integer redEnvId;

    private Integer storeId;

    private String redEnvName;

    private Integer amount;

    private Long money;

    private Byte useLimit = 0;

    private Long minMoney;

    private Integer getLimit = 1;

    private Date getStartTime;

    private Date getEndTime;

    private Byte useTimeType;

    private Date useStartTime;

    private Date useEndTime;

    private Integer limitDays;

    private Byte appointType = 0;

    private String useCusTypes;

    private Byte useRange = 0;

    private String useCategory;

    private String useProduct;

    private Integer usedAmount;

    private Byte status = 1;

    private Date createTime;

    private String creater;

    private String useMessage;

}