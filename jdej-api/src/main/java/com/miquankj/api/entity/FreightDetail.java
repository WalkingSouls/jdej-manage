package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@ApiModel(value = "运费模版细节")
@Data
public class FreightDetail {
    @ApiModelProperty(value = "运费细节id", required = true)
    private Integer freDetailId;

    @ApiModelProperty(value = "运费模版id", required = true)
    private Integer freightId;

    @ApiModelProperty(value = "运送方式 0 快递 1 快运 2 其他 默认0", required = true)
    private Byte freWay = 0;

    @ApiModelProperty(value = "快递或者快运公司", allowEmptyValue = true)
    private String company;

    @ApiModelProperty(value = "运送范围 ， 隔开，默认全国", allowEmptyValue = true)
    private String freRange = "全国";

    @ApiModelProperty(value = "首件价格", allowEmptyValue = true)
    private BigDecimal firstMoney;

    @ApiModelProperty(value = "续件价格", allowEmptyValue = true)
    private BigDecimal otherMoney;

    @ApiModelProperty(value = "创建时间", allowEmptyValue = true)
    private Date createTime;

}