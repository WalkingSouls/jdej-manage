package com.miquankj.api.entity;

import java.util.Date;

public class Freight {
    private Integer freId;

    private Integer productId;

    private String name;

    private Byte valid;

    private Date createTime;

    public Integer getFreId() {
        return freId;
    }

    public void setFreId(Integer freId) {
        this.freId = freId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}