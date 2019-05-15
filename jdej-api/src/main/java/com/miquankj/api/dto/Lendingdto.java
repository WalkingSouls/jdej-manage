package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 借贷表筛选条件dto
 * @author liuyadong
 * @since 2019/5/15
 */
@Data
public class Lendingdto {
    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "联系方式")
    private String phone;

    @ApiModelProperty(value = "开始时间")
    private String timeStart;

    @ApiModelProperty(value = "结束时间")
    private String timeEnd;

    @ApiModelProperty(value = "当前页码，从0开始")
    private Integer pageNum = 0;

    @ApiModelProperty(value = "分页大小")
    private Integer pageSize = 10;
}
