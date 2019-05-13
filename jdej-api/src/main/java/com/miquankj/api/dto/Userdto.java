package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户dto
 * @author liuyadong
 * @since 2019/5/11
 */
@Data
public class Userdto {

    @ApiModelProperty(value = "用户帐号", required = true)
    private String account;

    @ApiModelProperty(value = "用户密码", required = true)
    private String password;

    @ApiModelProperty(value = "记住我功能，0 否 1 是")
    private Byte rememberMe;

    @ApiModelProperty(value = "回调")
    private String callback;
}
