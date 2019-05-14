package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 代理审核页面列表实体类
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
public class ApplyReturndto {
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "客户号")
    private Integer cliId;

    @ApiModelProperty(value = "申请类型： 1-代理商 2-经销商 3-厂家")
    private String subType;

    @ApiModelProperty(value = "真实姓名")
    private String grpLinkName;

    @ApiModelProperty(value = "联系方式")
    private String grpLinkTel;

    @ApiModelProperty(value = "地址")
    private String grpAdd;

    @ApiModelProperty(value = "审核人")
    private String checkMan;

    @ApiModelProperty(value = "审核时间")
    private String checkTime;

    @ApiModelProperty(value = "状态：0-待审核 1-通过 2-驳回")
    private String state;

    @ApiModelProperty(value = "原因")
    private String remark;

    @ApiModelProperty(value = "申请时间")
    private String addDate;
}
