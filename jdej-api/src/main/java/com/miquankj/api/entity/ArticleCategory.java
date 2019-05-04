package com.miquankj.api.entity;

import java.util.Date;

public class ArticleCategory {
    private Integer catId;

    private String catName;

    private Integer artAmount;

    private Date createTime;

    private Boolean valid;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getArtAmount() {
        return artAmount;
    }

    public void setArtAmount(Integer artAmount) {
        this.artAmount = artAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}