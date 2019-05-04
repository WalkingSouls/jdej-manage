package com.miquankj.api.entity;

public class ProductPicture {
    private Integer proPicId;

    private Integer productId;

    private String picPath;

    private Byte valid;

    public Integer getProPicId() {
        return proPicId;
    }

    public void setProPicId(Integer proPicId) {
        this.proPicId = proPicId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }
}