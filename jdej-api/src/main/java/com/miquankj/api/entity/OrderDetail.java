package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
@ApiModel(value ="订单详情")
public class OrderDetail {

    @ApiModelProperty(value = "订单详情id",required = true)
    private Long detailId;

    @ApiModelProperty(value = "订单编号", required = true)
    private String orderNum;

    @ApiModelProperty(value = "订单id",required = true)
    private Integer orderId;

    @ApiModelProperty(value = "商品id",required = true)
    private Integer productId;

    @ApiModelProperty(value = "商品名称",required = true)
    private String proName;

    @ApiModelProperty(value = "商品分类",required = true)
    private String proCategory;

    @ApiModelProperty(value = "商品单价",required = true)
    private BigDecimal price;

    @ApiModelProperty(value = "数量",required = true)
    private Integer num;

    @ApiModelProperty(value = "订单合计金额",required = true)
    private BigDecimal amount;

    @ApiModelProperty(value = "订单商品状态 -1 删除 1 存在",required = true)
    private Byte status;

    @ApiModelProperty(value = "商品缩略图",required = true)
    private String proPic;

}