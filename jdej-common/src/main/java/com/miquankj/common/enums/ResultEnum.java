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
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
