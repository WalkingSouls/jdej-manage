package com.miquankj.api.entity;

import java.util.Date;

public class Store {
    private Integer storeId;

    private String storeName;

    private String linkmen;

    private String phone;

    private String address;

    private String major;

    private String idCardPath1;

    private String idCardPath2;

    private String licensePath;

    private Byte status;

    private Date createTime;

    private String storeInfo;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLinkmen() {
        return linkmen;
    }

    public void setLinkmen(String linkmen) {
        this.linkmen = linkmen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getIdCardPath1() {
        return idCardPath1;
    }

    public void setIdCardPath1(String idCardPath1) {
        this.idCardPath1 = idCardPath1;
    }

    public String getIdCardPath2() {
        return idCardPath2;
    }

    public void setIdCardPath2(String idCardPath2) {
        this.idCardPath2 = idCardPath2;
    }

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }
}