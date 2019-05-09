package com.miquankj.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "商品对象")
public class Goods {

    @ApiModelProperty(value = "商品id", required = true)
    private Integer id;

    @ApiModelProperty(value = "商品主图", allowEmptyValue = true)
    private String comMainPic;

    @ApiModelProperty(value = "商品名称", required = true)
    @NotBlank(message = "商品名称必填")
    private String comName;

    @ApiModelProperty(value = "分类id", required = true)
    @NotNull(message = "分类必选")
    private Integer comType;

    @ApiModelProperty(value = "是否使用批发价格规范 0 否 1 用", required = true)
    private String rule = "0";

    @ApiModelProperty(value = "是否设置分销 0 否 1 用", required = true)
    private String distribution = "0";

    @ApiModelProperty(value = "分销批发折扣", allowEmptyValue = true)
    @Min(value = 0,message = "折扣最低为0")
    private Double discount;

    @ApiModelProperty(value = "发货期", allowEmptyValue = true)
    private Integer deliveryDays;

    @ApiModelProperty(value = "运费模式 0 包邮 1 使用统一运费", required = true)
    private String shippingState = "0";

    @ApiModelProperty(value = "统一定价金额", allowEmptyValue = true)
    private Double freight;

    @ApiModelProperty(value = "是否有样品 0 无 1 有", required = true)
    private String sampleState = "0";

    @ApiModelProperty(value = "上架模式 0 立即上架 1 定时上架", required = true)
    private String shelfState = "0";

    @ApiModelProperty(value = "定时上架时间", allowEmptyValue = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shelfTimed;

    @ApiModelProperty(value = "操作 0 - 置顶 1 - 移除", allowEmptyValue = true)
    private String roofState;

    @ApiModelProperty(value = "商品创建时间", required = true)
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addDate = new Date();

    @ApiModelProperty(value = "所属店铺", required = true)
    private String addBis;

    @ApiModelProperty(value = "录入人", required = true)
    private String addCli;

    @ApiModelProperty(value = "单价", required = true)
    @Min(value = 0,message = "单价应不小于0")
    private Double price;

    @ApiModelProperty(value = "库存", allowEmptyValue = true)
    @NotNull(message = "必须设置库存")
    private Integer stock;

    @ApiModelProperty(value = "商品更新人", allowEmptyValue = true)
    private String updateCli;

    @ApiModelProperty(value = "商品更新时间", allowEmptyValue = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @ApiModelProperty(value = "起售数量", required = true)
    private Integer num;

    @ApiModelProperty(value = "同步序号", allowEmptyValue = true)
    private Integer seqNo;

    @ApiModelProperty(value = "推荐 0 是 1 否", required = true)
    private String recommend = "0";

    @ApiModelProperty(value = "商品状态 0 下架 1 上架 -1 删除", required = true)
    private String state = "1";

    @ApiModelProperty(value = "商品图片", allowEmptyValue = true)
    private String comDetaPic;

    @ApiModelProperty(value = "商品详情", allowEmptyValue = true)
    private String cmsRemark;

    @ApiModelProperty(value = "商品批发规格列表", allowEmptyValue = true)
    private List<GoodsPrice> goodsPriceList = new ArrayList<>();

}