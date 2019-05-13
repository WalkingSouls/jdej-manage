package com.miquankj.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "订单实体类")
public class Order {
    @ApiModelProperty(value = "订单id",required = true)
    private Integer id;

    @ApiModelProperty(value = "订单编号", required = true)
    private String orderNum;

    @ApiModelProperty(value = "店铺id",required = true)
    private Integer storeId;

    @ApiModelProperty(value = "店铺名称",required = true)
    private String storeName;

    @ApiModelProperty(value = "顾客id",required = true)
    private Integer customerId;

    @ApiModelProperty(value = "顾客姓名",required = true)
    private String customerName;

    @ApiModelProperty(value = "买家类型 1 消费者 2 经销商 3 代理商",required = true)
    private Byte customerType;

    @ApiModelProperty(value = "收货地址id",required = true)
    private Integer addrId;

    @ApiModelProperty(value = "订单总金额",required = true)
    private BigDecimal totalMoney;

    @ApiModelProperty(value = "实际支付金额",required = true)
    private BigDecimal actualPrice;

    @ApiModelProperty(value = "红包/优惠券id", allowEmptyValue = true)
    private Integer redEnvId;

    @ApiModelProperty(value = "红包/优惠券金额", allowEmptyValue = true)
    private BigDecimal redPrice;

    @ApiModelProperty(value = "订单状态 0 已取消 1 待确认 2 待发货 3 已发货 4 已完结",required = true)
    private Byte orderStatus;

    @ApiModelProperty(value = "是否样品订单 0 否 1 是",required = true)
    private Byte isSpecimen;

    @ApiModelProperty(value = "所属快递公司",allowEmptyValue = true)
    private String expressCom;

    @ApiModelProperty(value = "快递编号",allowEmptyValue = true)
    private String expressNum;

    @ApiModelProperty(value = "配送费用",allowEmptyValue = true)
    private BigDecimal freightPrice;

    @ApiModelProperty(value = "留言",allowEmptyValue = true)
    private String message;

    @ApiModelProperty(value = "下单时间",allowEmptyValue = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    @ApiModelProperty(value = "订单更新时间",allowEmptyValue = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "订单操作账户",allowEmptyValue = true)
    private Integer updateOperid;

    @ApiModelProperty(value = "版本号", allowEmptyValue = true)
    private Integer version;

    @ApiModelProperty(value = "订单详情列表", allowEmptyValue = true)
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    @ApiModelProperty(value = "订单联系人及地址", required = true)
    private AddrInfo addrInfo = new AddrInfo();
}