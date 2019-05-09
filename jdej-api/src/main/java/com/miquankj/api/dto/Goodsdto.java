package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 商品dto，列表用
 * @author liuyadong
 * @since 2019/5/8
 */
@Data
public class Goodsdto {

    @ApiModelProperty(value = "商品id", required = true)
    private Integer id;

    @ApiModelProperty(value = "商品名称", required = true)
    private String comName;

    @ApiModelProperty(value = "所属店铺", required = true)
    private String addBis;

    @ApiModelProperty(value = "商品主图", allowEmptyValue = true)
    private String comMainPic;

    @ApiModelProperty(value = "单价", required = true)
    private Double price;

    @ApiModelProperty(value = "库存", allowEmptyValue = true)
    private Integer stock;

    @ApiModelProperty(value = "商品创建时间", required = true)
    private Date addDate;

    @ApiModelProperty(value = "商品状态 0 下架 1 上架 -1 删除", required = true)
    private String state;

    @ApiModelProperty(value = "推荐 0 是 1 否", required = true)
    private String recommend;
}
