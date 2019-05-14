package com.miquankj.api.service.impl;

import com.miquankj.api.dao.OrderDataMapper;
import com.miquankj.api.entity.OrderData;
import com.miquankj.api.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
@Service
public class OrderDataServiceImpl implements OrderDataService {
    @Autowired
    private OrderDataMapper orderDataMapper;


    @Override
    public OrderData findDataByDate(int storeId, Date yesterday) {
        return orderDataMapper.selectByDate(storeId,yesterday);
    }

    @Override
    public List<OrderData> findDataByDates(int storeId, Date begin, Date end) {
        return orderDataMapper.selectByDates(storeId,begin,end);
    }
}
