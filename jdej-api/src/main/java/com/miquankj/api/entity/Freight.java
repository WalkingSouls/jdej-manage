package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "运费模版")
public class Freight {

    @ApiModelProperty(value = "运费模版id",required = true)
    private Integer freId;

    @ApiModelProperty(value = "运费模版所属店铺id",required = true)
    private Integer storeId;

    @ApiModelProperty(value = "运费模版名称",required = true)
    private String name;

    @ApiModelProperty(value = "运费模版状态 1 可用  0 否",required = false)
    private Byte valid = 1;

    @ApiModelProperty(value = "创建时间",required = false)
    private Date createTime;

    @ApiModelProperty(value = "运费模版详情列表",required = true)
    private List<FreightDetail> freightDetailList = new ArrayList<>();

}