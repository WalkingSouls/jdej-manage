package com.miquankj.api.enums;

import lombok.Getter;

/**
 * 返回结果状态和信息
 * @author liuyadong
 * @since 2019/5/5
 */
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(10,"商品参数有误"),
    STORE_STATUS_ERROR(11,"店铺状态异常"),
    FREIGHT_ERROR(12,"运费模版设置异常"),
    BRANDINFO_ERROR(13,"类目选择出错"),
    GOODS_UPDATE_ERROR(14,"商品更新出错"),
    GOODS_NOT_EXIST(15,"商品不存在"),
    GOODS_STATUS_FAIL(16,"商品状态变更失败"),
    BRANDINFO_NOT_EXIST(17,"类目信息不存在"),
    FREIGHT_NOT_EXIST(18,"运费模版信息不存在"),
    FREIGHT_UPDATE_ERROR(19,"运费模版更新失败"),
    REDENVELOPE_NOT_EXIST(20,"红包不存在"),
    ORDER_PARAM_ERROR(21,"订单参数有误"),
    ORDER_NOT_EXIST(22,"订单不存在"),
    ORDER_UPDATE_ERROR(23,"订单更新出错"),
    USER_NOT_EXIST(24,"账号不存在"),
    USER_PASS_ERROR(25,"密码错误"),
    USER_STATUS_ERROR(26,"账号状态异常，请联系店铺管理员"),
    PASS_ERROR_MAX(27,"密码输错次数超过3次，请明日再来或联系店铺管理员"),
    USER_LOGINED(28,"您的账号已在另一个地方登录，如果不是您本人操作，请联系店铺管理员修改密码"),
    ROLE_STATUS_ERROR(29,"角色状态异常"),
    ROLE_NOT_EXIST(30,"角色不存在"),
    CUSTOMER_NOT_EXIST(31,"客户不存在"),
    APPLICATION_ERROR(32,"审核明细异常"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
