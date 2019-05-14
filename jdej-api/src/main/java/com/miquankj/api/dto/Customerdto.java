package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 客户筛选条件
 * @author liuyadong
 * @since 2019/5/13
 */
@Data
public class Customerdto {
    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;

    @ApiModelProperty(value = "客户号")
    private Integer cliId;

    @ApiModelProperty(value = "消费者姓名/联系人")
    private String cliName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "商家名称")
    private String grpName;

    @ApiModelProperty(value = "会员类型 0-消费者 1-代理商 2-经销商 3-厂家")
    private String type;

    @ApiModelProperty(value = "联系方式")
    private String cliTel;

    @ApiModelProperty(value = "申请类型： 1-代理商 2-经销商 3-厂家")
    private String subType;

    @ApiModelProperty(value = "状态：0-待审核 1-通过 2-驳回")
    private String state;

    @ApiModelProperty(value = "开始时间")
    private Date timeStart;

    @ApiModelProperty(value = "结束时间")
    private Date timeEnd;

    @ApiModelProperty(value = "当前页码，从0开始", required = true)
    private Integer pageNum;

    @ApiModelProperty(value = "分页大小", required = true)
    private Integer pageSize = 10;
}
