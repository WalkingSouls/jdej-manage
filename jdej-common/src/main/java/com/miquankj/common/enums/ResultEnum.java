package com.miquankj.common.enums;

import lombok.Getter;

/**
 * 返回结果状态和信息
 * @author liuyadong
 * @since 2019/5/5
 */
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(10,"参数不正确"),
    STORE_STATUS_ERROR(11,"店铺状态异常"),
    FREIGHT_ERROR(12,"运费模版设置异常"),
    CATEGORY_ERROR(13,"类目选择出错"),
    PRODUCT_UPDATE_ERROR(14,"商品更新出错"),
    PRODUCT_NOT_EXIST(15,"商品不存在"),
    PRODUCT_STATUS_FAIL(16,"商品状态变更失败"),
    CATEGORY_NOT_EXIST(17,"类目信息不存在"),
    FREIGHT_NOT_EXIST(18,"运费模版信息不存在"),
    FREIGHT_UPDATE_ERROR(19,"运费模版更新失败"),
    REDENVELOPE_NOT_EXIST(20,"红包不存在"),

    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
