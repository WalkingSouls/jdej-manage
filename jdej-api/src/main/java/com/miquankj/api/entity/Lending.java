package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@ApiModel("借贷表实体类")
public class Lending {
    @ApiModelProperty(value = "借贷记录id", required = true)
    private Integer ledId;

    @ApiModelProperty(value = "顾客id")
    private Integer customerId;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;

    @ApiModelProperty(value = "联系方式")
    private String phone;

    @ApiModelProperty(value = "借贷金额")
    private BigDecimal money = new BigDecimal(0);

    @ApiModelProperty(value = "申请时间")
    private Date applyTime = new Date();

    @ApiModelProperty(value = "状态 0 失效 1 有效")
    private Byte status = 1;

}