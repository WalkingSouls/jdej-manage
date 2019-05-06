package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleCategory {
    private Integer catId;

    private String catName;

    private Integer artAmount;

    private Date createTime;

    private Boolean valid;

}