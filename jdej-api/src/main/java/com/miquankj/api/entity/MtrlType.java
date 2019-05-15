package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel("店铺主营表")
public class MtrlType {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "单位编号")
    private String grpId;

    @ApiModelProperty(value = "类别编号id")
    private Integer brandno;

    @ApiModelProperty(value = "类目名称")
    private String name;

    @ApiModelProperty(value = "商品类别：1-一级2-二级")
    private String brandtype;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "添加人id")
    private String addOperid;

    @ApiModelProperty(value = "添加时间")
    private Date adddateTime;

    @ApiModelProperty(value = "状态 0-正常 1-停用")
    private String state;

}