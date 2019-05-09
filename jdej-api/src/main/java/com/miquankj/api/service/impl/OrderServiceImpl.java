package com.miquankj.api.service.impl;

import com.miquankj.api.dao.OrderMapper;
import com.miquankj.api.dto.OrderConditiondto;
import com.miquankj.api.dto.OrderStatusdto;
import com.miquankj.api.entity.Order;
import com.miquankj.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/9
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order findOrder(Integer storeId, Integer orderId) {
        return null;
    }

    @Override
    public Map<String, Object> findOrderByCondition(OrderConditiondto orderCondition) {
        return null;
    }

    @Override
    public Integer changeOrderStatus(OrderStatusdto orderStatusdto) {
        return null;
    }

    @Override
    public Integer createOrder(Order order) {
        return null;
    }

    @Override
    public Integer updateOrder(Order order) {
        return null;
    }
}
