package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 消费者筛选条件实体
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
public class Condto {
    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;

    @ApiModelProperty(value = "消费者姓名/联系人")
    private String cliName;

    @ApiModelProperty(value = "会员类型 0-消费者 1-代理商 2-经销商 3-厂家")
    private String customerType = "0";

    @ApiModelProperty(value = "开始时间")
    private String timeStart;

    @ApiModelProperty(value = "结束时间")
    private String timeEnd;

    @ApiModelProperty(value = "当前页码，从0开始")
    private Integer pageNum = 0;

    @ApiModelProperty(value = "分页大小")
    private Integer pageSize = 10;
}
