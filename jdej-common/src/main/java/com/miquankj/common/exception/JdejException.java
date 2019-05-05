package com.miquankj.common.exception;

import com.miquankj.common.enums.ResultEnum;
import lombok.Data;

/**
 * 商家管理中所抛出的异常
 * @author liuyadong
 * @since 2019/5/5
 */
@Data
public class JdejException extends RuntimeException{
    private Integer code;

    public JdejException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public JdejException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
