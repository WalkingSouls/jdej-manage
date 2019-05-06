package com.miquankj.api.entity;

import lombok.Data;

@Data
public class StoreCustomer {
    private Integer stoCusId;

    private Integer storeId;

    private Integer customerId;

    private Byte valid = 1;

}