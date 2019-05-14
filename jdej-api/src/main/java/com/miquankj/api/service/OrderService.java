package com.miquankj.api.service;

import com.miquankj.api.dto.OrderConditiondto;
import com.miquankj.api.dto.OrderStatusdto;
import com.miquankj.api.entity.Order;

import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/9
 */
public interface OrderService {
    Order findOrder(Integer storeId, Integer orderId);

    Map<String,Object> findOrderByCondition(OrderConditiondto orderCondition);

    Integer changeOrderStatus(OrderStatusdto orderStatusdto);

    Integer createOrder(Order order);

    Integer updateOrder(Order order);

    int findCounts(Order order);
}
