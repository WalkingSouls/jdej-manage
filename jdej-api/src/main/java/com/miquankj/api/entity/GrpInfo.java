package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "客户实体类")
public class GrpInfo {
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "客户号")
    private Integer cliId;

    @ApiModelProperty(value = "消费者姓名/联系人")
    private String cliName;

    @ApiModelProperty(value = "联系方式")
    private String cliTel;

    @ApiModelProperty(value = "联系地址")
    private String cliAddr;

    @ApiModelProperty(value = "区域")
    private String cliArea;

    @ApiModelProperty(value = "单位编号")
    private String grpId;

    @ApiModelProperty(value = "商家名称")
    private String grpName;

    @ApiModelProperty(value = "单位简称")
    private String abbr;

    @ApiModelProperty(value = "地址")
    private String grpAdd;

    @ApiModelProperty(value = "真实姓名")
    private String grpLinkName;

    @ApiModelProperty(value = "联系方式")
    private String grpLinkTel;

    @ApiModelProperty(value = "会员类型 0-消费者 1-代理商 2-经销商 3-厂家")
    private String type;

    @ApiModelProperty(value = "申请类型： 1-代理商 2-经销商 3-厂家")
    private String subType;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "加入时间")
    private String addTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "所属平台/上级单位id")
    private String pId;

    @ApiModelProperty(value = "状态 0-正常 1-注销")
    private String status;

    @ApiModelProperty(value = "营业执照")
    private String businessLicense;

    @ApiModelProperty(value = "身份证正面")
    private String sfzZm;

    @ApiModelProperty(value = "身份证反面")
    private String sfzFm;

    @ApiModelProperty(value = "所在城市")
    private String whichCity;

    @ApiModelProperty(value = "客户经理")
    private String mngOprId;

    @ApiModelProperty(value = "注册人")
    private String addOprId;

    @ApiModelProperty(value = "申请时间")
    private String addDate;

    @ApiModelProperty(value = "注销人")
    private String clsOprId;

    @ApiModelProperty(value = "注销时间")
    private String clsDate;

    @ApiModelProperty(value = "部门id")
    private String deptid;

    @ApiModelProperty(value = "公司二维码")
    private String dbcode;

    @ApiModelProperty(value = "省")
    private Integer sheng;

    @ApiModelProperty(value = "市")
    private Integer shi;

    @ApiModelProperty(value = "区")
    private Integer qu;

    @ApiModelProperty(value = "街道")
    private Integer street;

    @ApiModelProperty(value = "审核人")
    private String checkMan;

    @ApiModelProperty(value = "审核时间")
    private String checkTime;

    @ApiModelProperty(value = "状态：0-待审核 1-通过 2-驳回")
    private String state;

    @ApiModelProperty(value = "原因")
    private String remark;

    @ApiModelProperty(value = "商家logo")
    private String photo;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "累计消费")
    private Double cumul;

    @ApiModelProperty(value = "累计需求")
    private Integer cumDem;

    @ApiModelProperty(value = "累计订单")
    private Integer cumOrd;

    @ApiModelProperty(value = "积分")
    private Double integ;

    @ApiModelProperty(value = "企业介绍")
    private String comIntroduction;

}