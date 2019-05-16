package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 筛选条件base
 * @author liuyadong
 * @since 2019/5/16
 */
@Data
public class FileterBase {
    @ApiModelProperty(value = "开始时间")
    private String timeStart;

    @ApiModelProperty(value = "结束时间")
    private String timeEnd;

    @ApiModelProperty(value = "当前页码，从0开始", required = true)
    private Integer pageNum = 0;

    @ApiModelProperty(value = "分页大小", required = true)
    private Integer pageSize = 10;
}
