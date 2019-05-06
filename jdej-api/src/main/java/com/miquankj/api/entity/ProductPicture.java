package com.miquankj.api.entity;

import lombok.Data;

@Data
public class ProductPicture {
    private Integer proPicId;

    private Integer productId;

    private String picPath;

    private Byte valid = 1;

}