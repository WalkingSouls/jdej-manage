package com.miquankj.api.entity;

public class StoreCustomer {
    private Integer stoCusId;

    private Integer storeId;

    private Integer customerId;

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

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }
}