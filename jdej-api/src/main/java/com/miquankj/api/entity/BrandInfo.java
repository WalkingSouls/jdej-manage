package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "商品分类实体类")
public class BrandInfo {

    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "单位编号", allowEmptyValue = true)
    private String grpId;

    @ApiModelProperty(value = "上级id",required = true)
    private String subId;

    @ApiModelProperty(value = "二级类别编号",allowEmptyValue = true)
    private String brandno;

    @ApiModelProperty(value = "类目名称",required = true)
    private String name;

    @ApiModelProperty(value = "品牌logo",allowEmptyValue = true)
    private String imgurl;

    @ApiModelProperty(value = "状态 0-正常 1-停用",required = true)
    private String state = "0";

    @ApiModelProperty(value = "商品类别：1-一级 2-二级",required = true)
    private String brandtype;

    @ApiModelProperty(value = "备注",required = true)
    private String remark;

    @ApiModelProperty(value = "编辑状态 0-不可编辑 1-编辑",allowEmptyValue = true)
    private String isEdit;

    @ApiModelProperty(value = "添加人",required = true)
    private String addOperid;

    @ApiModelProperty(value = "创建时间",allowEmptyValue = true)
    private Date adddateTime;

    @ApiModelProperty(value = "版本号",allowEmptyValue = true)
    private Integer version;

}