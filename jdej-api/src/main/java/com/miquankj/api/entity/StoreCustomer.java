package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "店铺客户中间表实体类")
public class StoreCustomer {

    @ApiModelProperty(value = "id")
    private Integer stoCusId;

    @ApiModelProperty(value = "店铺id")
    private Integer storeId;

    @ApiModelProperty(value = "顾客id")
    private Integer customerId;

    @ApiModelProperty(value = "客户号")
    private Integer cliId;

    @ApiModelProperty(value = "会员类型 0-消费者 1-代理商 2-经销商 3-厂家")
    private String customerType;

    @ApiModelProperty(value = "是否申请过审核 0 否 1 是")
    private Byte isApply;

    @ApiModelProperty(value = "企业名称")
    private String grpName;

    @ApiModelProperty(value = "消费者姓名/联系人")
    private String cliName;

    @ApiModelProperty(value = "联系方式")
    private String cliTel;

    @ApiModelProperty(value = "申请类型： 1-代理商 2-经销商 3-厂家")
    private String subType;

    @ApiModelProperty(value = "状态：0-待审核 1-通过 2-驳回")
    private String status;

    @ApiModelProperty(value = "加入时间")
    private Date addTime;

    @ApiModelProperty(value = "否删除 0 禁用 1 可用")
    private Byte valid;

    @ApiModelProperty(value = "真实姓名/联系人（店铺）")
    private String grpLinkName;

    @ApiModelProperty(value = "联系方式")
    private String grpLinkTel;
}