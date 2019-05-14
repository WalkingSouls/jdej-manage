package com.miquankj.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "用户实体类")
public class User {
    @ApiModelProperty(value = "用户ID", required = true)
    private Integer userId;

    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    @ApiModelProperty(value = "店铺名称")
    private String storeName;

    @ApiModelProperty(value = "用户帐号", required = true)
    private String account;

    @ApiModelProperty(value = "用户密码", required = true)
    private String password;

    @ApiModelProperty(value = "用户姓名", required = true)
    private String name;

    @ApiModelProperty(value = "账户状态 0 禁言 1 可用 -1 删除")
    private Byte status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否登录 0 否 1 是")
    private Byte isLogin;

    @ApiModelProperty(value = "密码输错次数")
    private Integer errorPass;

    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "上次登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "店铺管理员 0 否 1 是")
    private Byte isAdmin = 0;

    @ApiModelProperty(value = "用户类型 0 生产厂商 1 经销商 2 代理商")
    private Byte userType;

}