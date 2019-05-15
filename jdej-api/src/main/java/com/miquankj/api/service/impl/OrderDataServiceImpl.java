package com.miquankj.api.service.impl;

import com.miquankj.api.dao.OrderDataMapper;
import com.miquankj.api.entity.OrderData;
import com.miquankj.api.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> map = new HashMap<>();
        map.put("storeId", storeId);
        map.put("yesterday",yesterday);
        return orderDataMapper.selectByDate(map);
    }

    @Override
    public List<OrderData> findDataByDates(int storeId, Date begin, Date end) {
        Map<String, Object> map = new HashMap<>();
        map.put("storeId", storeId);
        map.put("begin",begin);
        map.put("end",end);
        return orderDataMapper.selectByDates(map);
    }
}
