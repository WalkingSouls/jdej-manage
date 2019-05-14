package com.miquankj.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 首页数据dto
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
@ApiModel(value = "首页数据dto",description = "首页数据dto")
public class Indexdto {
    @ApiModelProperty(value = "店铺id",required = true)
    private Integer storeId;

    @ApiModelProperty(value = "",required = true)
    private Date todayDate;
}
