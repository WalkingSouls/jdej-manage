package com.miquankj.api.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author liuyadong
 * @since 2019/5/5
 */
@Data
public class ProductConditiondto {
    private int storeId;

    private String productName;

    private Date startTime;

    private Date endTime;

    private int pageNum;

    private int pageSize;
}
