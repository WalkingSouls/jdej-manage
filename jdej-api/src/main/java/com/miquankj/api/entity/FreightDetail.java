package com.miquankj.api.entity;

import java.util.Date;

public class FreightDetail {
    private Integer freDetailId;

    private Integer freightId;

    private Byte freWay;

    private String company;

    private String range;

    private Long firstMoney;

    private Long otherMoney;

    private Date createTime;

    public Integer getFreDetailId() {
        return freDetailId;
    }

    public void setFreDetailId(Integer freDetailId) {
        this.freDetailId = freDetailId;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public Byte getFreWay() {
        return freWay;
    }

    public void setFreWay(Byte freWay) {
        this.freWay = freWay;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Long getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(Long firstMoney) {
        this.firstMoney = firstMoney;
    }

    public Long getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(Long otherMoney) {
        this.otherMoney = otherMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}