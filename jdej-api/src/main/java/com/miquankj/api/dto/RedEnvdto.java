package com.miquankj.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 红包dto
 * @author liuyadong
 * @since 2019/5/7
 */
@Data
@ApiModel(value = "红包dto，列表使用")
public class RedEnvdto {
    private Integer redEnvId;

    private Integer storeId;

    private String redEnvName;

    private Integer amount;

    private BigDecimal money;

    private BigDecimal minMoney;

    private Integer getLimit = 1;

    private Date getStartTime;

    private Date getEndTime;

    private Byte useTimeType;

    private Date useStartTime;

    private Date useEndTime;

    private Integer limitDays;

    private Integer usedAmount;

    private Byte status = 1;

    private Date createTime;

}
