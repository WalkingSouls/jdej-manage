package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 代理审核筛选条件
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
public class Applydto  extends FileterBase{
    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;

//    @ApiModelProperty(value = "客户号")
//    private Integer cliId;

    @ApiModelProperty(value = "商家名称")
    private String grpName;

    @ApiModelProperty(value = "真实姓名")
    private String grpLinkName;

    @ApiModelProperty(value = "联系方式")
    private String grpLinkTel;

    @ApiModelProperty(value = "申请类型： 1-代理商 2-经销商 3-厂家")
    private String subType;

    @ApiModelProperty(value = "状态 0-正常 1-注销")
    private String status;

}
