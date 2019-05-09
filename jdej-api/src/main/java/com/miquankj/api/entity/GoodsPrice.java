package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value = "批发规格价格实体类")
@Data
public class GoodsPrice {

    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "同步号", allowEmptyValue = true)
    private Integer seqNo;

    @ApiModelProperty(value = "商品id", required = true)
    private Integer cmsId;

    @ApiModelProperty(value = "数量类型 0-最低数量 1-区间数量 2-最大数量", required = true)
    private String priceType;

    @ApiModelProperty(value = "最低数量", allowEmptyValue = true)
    private Integer minNum;

    @ApiModelProperty(value = "最大数量", allowEmptyValue = true)
    private Integer maxNum;

    @ApiModelProperty(value = "价格", required = true)
    private Double cmsPrice;

    @ApiModelProperty(value = "库存量", allowEmptyValue = true)
    private Integer cmsStock;

    @ApiModelProperty(value = "型号", allowEmptyValue = true)
    private String cmsModel;

}