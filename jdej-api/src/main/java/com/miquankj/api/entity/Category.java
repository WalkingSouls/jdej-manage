package com.miquankj.api.entity;

public class Category {
    private Integer categoryId;

    private Integer storeId;

    private String categoryName;

    private String description;

    private Byte categoryLevel;

    private Integer parentCatId;

    private Byte valid;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Byte categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public Integer getParentCatId() {
        return parentCatId;
    }

    public void setParentCatId(Integer parentCatId) {
        this.parentCatId = parentCatId;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }
}