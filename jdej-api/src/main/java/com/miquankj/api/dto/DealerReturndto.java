package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * j经销代理页面列表实体类
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
public class DealerReturndto {
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "客户号")
    private Integer cliId;

    @ApiModelProperty(value = "商家logo/用户头像")
    private String photo;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "会员类型 0-消费者 1-代理商 2-经销商 3-厂家")
    private String type;

    @ApiModelProperty(value = "商家名称")
    private String grpName;

    @ApiModelProperty(value = "真实姓名")
    private String grpLinkName;

    @ApiModelProperty(value = "联系方式")
    private String grpLinkTel;

    @ApiModelProperty(value = "地址")
    private String grpAdd;

    @ApiModelProperty(value = "加入时间")
    private String addTime;

}
