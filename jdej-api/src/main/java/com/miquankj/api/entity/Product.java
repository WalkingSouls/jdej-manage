package com.miquankj.api.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Product {
    private Integer productId;

    private Integer storeId;

    @NotEmpty(message = "商品名称必填")
    private String proName;

    private Integer categoryId;

    @NotEmpty(message = "商品分类不能为空")
    private String categoryName;

    private String proPic;

    private Byte isNormed;

    private Byte isDistributed;

    @Min(value = 0,message = "折扣最低为0")
    private BigDecimal discount;

    private Integer deliveryDays;

    private Byte deliveryType;

    private Integer freightId;

    private Byte onsaleTimeType;

    private Date onsaleTime;

    private Byte specimen;

    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal priceUnit;

    private Integer stock;

    private Byte productStatus;

    private Integer salesNum;

    private Date createTime;

    private Date updateTime;

    private Integer startAmount;

    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal startPrice;

    private Integer intervalStart;

    private Integer intervalEnd;

    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal intervalPrice;

    private Integer maxAmount;

    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal maxDiscPrice;

    private String productInfo;

    private List<ProductPicture> pictureList = new ArrayList<>();

}