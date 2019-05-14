package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 消费者列表实体类
 * @author liuyadong
 * @since 2019/5/14
 */
@Data
public class ConReturndto {
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
}
