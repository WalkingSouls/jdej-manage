package com.miquankj.api.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Freight {
    private Integer freId;

    private Integer storeId;

    private String name;

    private Byte valid = 1;

    private Date createTime;

    private List<FreightDetail> freightDetailList = new ArrayList<>();

}