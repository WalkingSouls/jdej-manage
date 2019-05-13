package com.miquankj.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 订单条件筛选dto
 * @author liuyadong
 * @since 2019/5/9
 */
@Data
public class OrderConditiondto {

    @ApiModelProperty(value = "店铺id",required = true)
    private Integer storeId;

    @ApiModelProperty(value = "订单编号")
    private String orderNum;

    @ApiModelProperty(value = "商品名称")
    private String proName;

    @ApiModelProperty(value = "买家姓名")
    private String customerName;

    @ApiModelProperty(value = "订单状态 0 已取消 1 待确认 2 已确认 3 已发货")
    private Byte orderStatus;

    @ApiModelProperty(value = "是否样品订单 0 否 1 是",required = true)
    private Byte isSpecimen;

    @ApiModelProperty(value = "下单区间开始时间",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTimeStart;

    @ApiModelProperty(value = "下单区间结束时间",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTimeEnd;

    @ApiModelProperty(value = "当前页码.从0开始", required = true)
    private int pageNum = 0;

    @ApiModelProperty(value = "分页大小", required = true)
    private int pageSize = 10;
}
