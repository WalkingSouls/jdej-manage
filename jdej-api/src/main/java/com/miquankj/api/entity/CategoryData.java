package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class CategoryData {
    private Date cateDate;

    private String cateName;

    private Integer cateSalesAmount;

    private Long cateDealMoney;

}