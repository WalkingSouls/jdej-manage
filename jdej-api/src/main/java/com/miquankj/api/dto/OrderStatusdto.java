package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 订单状态dto
 * @author liuyadong
 * @since 2019/5/9
 */
@Data
public class OrderStatusdto {
    @ApiModelProperty(value = "店铺id",required = true)
    private Integer storeId;

    @ApiModelProperty(value = "订单id",required = true)
    private Integer id;

    @ApiModelProperty(value = "操作类型， 2 确认订单 3 订单发货 0 取消订单")
    private Integer operationType;

    @ApiModelProperty(value = "订单更新时间")
    private Date updateTime = new Date();

    @ApiModelProperty(value = "订单操作账户",allowEmptyValue = true)
    private Integer updateOperid;

    @ApiModelProperty(value = "所属快递公司",allowEmptyValue = true)
    private String expressCom;

    @ApiModelProperty(value = "快递编号",allowEmptyValue = true)
    private String expressNum;
}
