package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 前端列表用户展现实体类
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
public class GrpInfodto {

    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "客户号")
    private Integer cliId;

    @ApiModelProperty(value = "商家logo/用户头像")
    private String photo;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "累计消费")
    private Double cumul;

    @ApiModelProperty(value = "累计订单")
    private Integer cumOrd;

    @ApiModelProperty(value = "加入时间")
    private String addTime;

    @ApiModelProperty(value = "会员类型 0-消费者 1-代理商 2-经销商 3-厂家")
    private String type;

    @ApiModelProperty(value = "商家名称")
    private String grpName;

    @ApiModelProperty(value = "消费者姓名/联系人")
    private String cliName;

    @ApiModelProperty(value = "联系方式")
    private String cliTel;

    @ApiModelProperty(value = "联系地址")
    private String cliAddr;

    @ApiModelProperty(value = "申请时间")
    private String addDate;

    @ApiModelProperty(value = "申请类型： 1-代理商 2-经销商 3-厂家")
    private String subType;

    @ApiModelProperty(value = "审核人")
    private String checkMan;

    @ApiModelProperty(value = "审核时间")
    private String checkTime;

    @ApiModelProperty(value = "状态：0-待审核 1-通过 2-驳回")
    private String state;

    @ApiModelProperty(value = "原因")
    private String remark;

}
