package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@ApiModel(value = "订单数据统计")
public class OrderData {

    @ApiModelProperty(value = "id",required = true)
    private Integer id;

    @ApiModelProperty(value = "订单日期",required = true)
    private Date orderDate = new Date();

    @ApiModelProperty(value = "商铺ID",required = true)
    private Integer storeId;

    @ApiModelProperty(value = "成交订单数",required = true)
    private Integer orderDeal = 0;

    @ApiModelProperty(value = "成交额",required = true)
    private BigDecimal dealMoney = new BigDecimal(0);

    @ApiModelProperty(value = "下单笔数",required = true)
    private Integer orderAmount = 0;

    @ApiModelProperty(value = "下单人数",required = true)
    private Integer dealPeople = 0;

}