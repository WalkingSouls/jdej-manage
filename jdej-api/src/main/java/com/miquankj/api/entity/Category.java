package com.miquankj.api.entity;

import lombok.Data;

@Data
public class Category {
    private Integer categoryId;

    private Integer storeId;

    private String categoryName;

    private String description;

    private Byte categoryLevel;

    private Integer parentCatId;

    private Byte valid = 1;

}