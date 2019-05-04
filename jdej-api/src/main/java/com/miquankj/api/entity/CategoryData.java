package com.miquankj.api.entity;

import java.util.Date;

public class CategoryData {
    private Date cateDate;

    private String cateName;

    private Integer cateSalesAmount;

    private Long cateDealMoney;

    public Date getCateDate() {
        return cateDate;
    }

    public void setCateDate(Date cateDate) {
        this.cateDate = cateDate;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getCateSalesAmount() {
        return cateSalesAmount;
    }

    public void setCateSalesAmount(Integer cateSalesAmount) {
        this.cateSalesAmount = cateSalesAmount;
    }

    public Long getCateDealMoney() {
        return cateDealMoney;
    }

    public void setCateDealMoney(Long cateDealMoney) {
        this.cateDealMoney = cateDealMoney;
    }
}