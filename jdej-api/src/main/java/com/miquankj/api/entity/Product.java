package com.miquankj.api.entity;

import java.util.Date;

public class Product {
    private Integer productId;

    private Integer storeId;

    private String proName;

    private Integer categoryId;

    private String categoryName;

    private String proPic;

    private Byte isNormed;

    private Byte isDistributed;

    private Long discount;

    private Integer deliveryDays;

    private Byte deliveryType;

    private Byte onsaleTimeType;

    private Date onsaleTime;

    private Byte specimen;

    private Long priceUnit;

    private Integer stock;

    private Byte productStatus;

    private Integer salesNum;

    private Date createTime;

    private Date updateTime;

    private String productInfo;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProPic() {
        return proPic;
    }

    public void setProPic(String proPic) {
        this.proPic = proPic;
    }

    public Byte getIsNormed() {
        return isNormed;
    }

    public void setIsNormed(Byte isNormed) {
        this.isNormed = isNormed;
    }

    public Byte getIsDistributed() {
        return isDistributed;
    }

    public void setIsDistributed(Byte isDistributed) {
        this.isDistributed = isDistributed;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public Byte getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Byte deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Byte getOnsaleTimeType() {
        return onsaleTimeType;
    }

    public void setOnsaleTimeType(Byte onsaleTimeType) {
        this.onsaleTimeType = onsaleTimeType;
    }

    public Date getOnsaleTime() {
        return onsaleTime;
    }

    public void setOnsaleTime(Date onsaleTime) {
        this.onsaleTime = onsaleTime;
    }

    public Byte getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Byte specimen) {
        this.specimen = specimen;
    }

    public Long getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Long priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }
}