package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 申请详情页面实体类
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
public class ApplyDetaildto {
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "客户号")
    private Integer cliId;

    @ApiModelProperty(value = "申请类型： 1-代理商 2-经销商 3-厂家")
    private String subType;

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

    @ApiModelProperty(value = "商家名称")
    private String grpName;

    @ApiModelProperty(value = "真实姓名")
    private String grpLinkName;

    @ApiModelProperty(value = "营业执照")
    private String businessLicense;

    @ApiModelProperty(value = "身份证正面")
    private String sfzZm;

    @ApiModelProperty(value = "身份证反面")
    private String sfzFm;

    @ApiModelProperty(value = "企业介绍")
    private String comIntroduction;
}
