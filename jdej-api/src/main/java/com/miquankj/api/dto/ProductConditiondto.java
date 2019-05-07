package com.miquankj.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 产品筛选条件传输对象
 *
 * @author liuyadong
 * @since 2019/5/5
 */
@ApiModel(value = "产品筛选条件传输对象")
@Data
public class ProductConditiondto {

    @ApiModelProperty(value = "店铺id", required = true)
    private int storeId;

    @ApiModelProperty(value = "产品名称", allowEmptyValue = true)
    private String productName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始创建时间 使用yyyy-MM-dd HH:mm:ss", required = true)
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束创建时间 使用yyyy-MM-dd HH:mm:s", required = true)
    private Date endTime;

    @ApiModelProperty(value = "当前页码.从0开始", required = true)
    private int pageNum;

    @ApiModelProperty(value = "分页大小", required = true)
    private int pageSize = 10;
}
