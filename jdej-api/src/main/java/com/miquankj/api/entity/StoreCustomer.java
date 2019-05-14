package com.miquankj.api.entity;

import java.util.Date;

public class StoreCustomer {
    private Integer stoCusId;

    private Integer storeId;

    private Integer customerId;

    private Integer cliId;

    private String customerType;

    private Byte isApply;

    private String grpName;

    private String cliName;

    private String cliTel;

    private String subType;

    private String status;

    private Date addTime;

    private Byte valid;

    public Integer getStoCusId() {
        return stoCusId;
    }

    public void setStoCusId(Integer stoCusId) {
        this.stoCusId = stoCusId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Byte getIsApply() {
        return isApply;
    }

    public void setIsApply(Byte isApply) {
        this.isApply = isApply;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public String getCliName() {
        return cliName;
    }

    public void setCliName(String cliName) {
        this.cliName = cliName;
    }

    public String getCliTel() {
        return cliTel;
    }

    public void setCliTel(String cliTel) {
        this.cliTel = cliTel;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }
}