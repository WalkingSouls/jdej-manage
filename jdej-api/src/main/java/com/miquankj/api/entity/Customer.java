package com.miquankj.api.entity;

import java.util.Date;

public class Customer {
    private Integer customerId;

    private String avator;

    private String nick;

    private Byte cusType;

    private Integer storeId;

    private String company;

    private String realname;

    private String phone;

    private String province;

    private String city;

    private String addrDetail;

    private Date jointime;

    private Long totalConsumer;

    private Integer totalOrder;

    private Byte status;

    private String regIp;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Integer score;

    private Integer continueLogin;

    private Boolean isLogin;

    private Boolean errLoginTimes;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Byte getCusType() {
        return cusType;
    }

    public void setCusType(Byte cusType) {
        this.cusType = cusType;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public Long getTotalConsumer() {
        return totalConsumer;
    }

    public void setTotalConsumer(Long totalConsumer) {
        this.totalConsumer = totalConsumer;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getContinueLogin() {
        return continueLogin;
    }

    public void setContinueLogin(Integer continueLogin) {
        this.continueLogin = continueLogin;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Boolean getErrLoginTimes() {
        return errLoginTimes;
    }

    public void setErrLoginTimes(Boolean errLoginTimes) {
        this.errLoginTimes = errLoginTimes;
    }
}