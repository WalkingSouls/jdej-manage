package com.miquankj.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author liuyadong
 * @since 2019/5/5
 */
@Data
public class Productdto {
    private Integer productId;

    private Integer storeId;

    private String proName;

    private String proPic;

    private Integer stock;

    private Date createTime;

    private Byte productStatus;
}
