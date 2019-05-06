package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "商品对象")
public class Product {

    @ApiModelProperty(value = "商品id", required = true)
    private Integer productId;

    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;

    @ApiModelProperty(value = "商品名称", required = true)
    @NotEmpty(message = "商品名称必填")
    private String proName;

    @ApiModelProperty(value = "分类id", required = true)
    private Integer categoryId;

    @ApiModelProperty(value = "分类名称", required = true)
    @NotEmpty(message = "商品分类不能为空")
    private String categoryName;

    @ApiModelProperty(value = "商品主图", allowEmptyValue = true)
    private String proPic;

    @ApiModelProperty(value = "是否使用批发价格规范 0 否 1 用", required = true)
    private Byte isNormed = 0;

    @ApiModelProperty(value = "是否设置分销 0 否 1 用", required = true)
    private Byte isDistributed = 0;

    @ApiModelProperty(value = "分销批发折扣", allowEmptyValue = true)
    @Min(value = 0,message = "折扣最低为0")
    private BigDecimal discount;

    @ApiModelProperty(value = "发货期", allowEmptyValue = true)
    private Integer deliveryDays;

    @ApiModelProperty(value = "运费模式 0 统一定价 1 使用运费模版", required = true)
    private Byte deliveryType = 0;

    @ApiModelProperty(value = "统一定价金额", allowEmptyValue = true)
    private BigDecimal unifiedFre;

    @ApiModelProperty(value = "运费模版id", allowEmptyValue = true)
    private Integer freightId;

    @ApiModelProperty(value = "上架模式 0 立即上架 1 定时上架", required = true)
    private Byte onsaleTimeType = 0;

    @ApiModelProperty(value = "定时上架时间", allowEmptyValue = true)
    private Date onsaleTime;

    @ApiModelProperty(value = "是否有样品", required = true)
    private Byte specimen;

    @ApiModelProperty(value = "单价", required = true)
    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal priceUnit;

    @ApiModelProperty(value = "库存", allowEmptyValue = true)
    private Integer stock;

    @ApiModelProperty(value = "产品状态 0 下架 1 上架 -1 删除", required = true)
    private Byte productStatus = 1;

    @ApiModelProperty(value = "售出数量", allowEmptyValue = true)
    private Integer salesNum;

    @ApiModelProperty(value = "产品创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "产品更新时间", allowEmptyValue = true)
    private Date updateTime;

    @ApiModelProperty(value = "批发起始数量", allowEmptyValue = true)
    private Integer startAmount;

    @ApiModelProperty(value = "批发起始价格", allowEmptyValue = true)
    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal startPrice;

    @ApiModelProperty(value = "批发区间最小数量", allowEmptyValue = true)
    private Integer intervalStart;

    @ApiModelProperty(value = "批发区间最大数量", allowEmptyValue = true)
    private Integer intervalEnd;

    @ApiModelProperty(value = "批发区间价格", allowEmptyValue = true)
    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal intervalPrice;

    @ApiModelProperty(value = "批发设置最大数量", allowEmptyValue = true)
    private Integer maxAmount;

    @ApiModelProperty(value = "批发设置最优惠价格", allowEmptyValue = true)
    @Min(value = 0,message = "单价应不小于0")
    private BigDecimal maxDiscPrice;

    @ApiModelProperty(value = "产品详情", allowEmptyValue = true)
    private String productInfo;

    @ApiModelProperty(value = "产品图片列表", allowEmptyValue = true)
    private List<ProductPicture> pictureList = new ArrayList<>();

}