package com.miquankj.api.service;

import com.miquankj.api.entity.OrderData;

import java.util.Date;
import java.util.List;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
public interface OrderDataService {
    OrderData findDataByDate(int storeId, Date yesterday);

    List<OrderData> findDataByDates(int storeId, Date begin, Date end);
}
