package com.miquankj.api.service.impl;

import com.miquankj.api.dao.AddrInfoMapper;
import com.miquankj.api.dao.OrderDataMapper;
import com.miquankj.api.dao.OrderDetailMapper;
import com.miquankj.api.dao.OrderMapper;
import com.miquankj.api.dto.Goodsdto;
import com.miquankj.api.dto.OrderConditiondto;
import com.miquankj.api.dto.OrderStatusdto;
import com.miquankj.api.entity.AddrInfo;
import com.miquankj.api.entity.Order;
import com.miquankj.api.entity.OrderDetail;
import com.miquankj.api.service.OrderService;
import com.miquankj.api.utils.MapUtil;
import com.miquankj.api.utils.MathUtil;
import com.miquankj.api.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author liuyadong
 * @since 2019/5/9
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderDataMapper orderDataMapper;

    @Autowired
    private AddrInfoMapper addrInfoMapper;


    @Override
    public Order findOrder(Integer storeId, Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        List<OrderDetail> orderDetailList = orderDetailMapper.selectByOrderId(orderId);
        if (orderDetailList != null || orderDetailList.size() != 0) {
            order.setOrderDetailList(orderDetailList);
        }
        AddrInfo addrInfo = addrInfoMapper.selectByPrimaryKey(order.getAddrId());
        if (addrInfo != null)
            order.setAddrInfo(addrInfo);
        return order;
    }

    @Transactional
    @Override
    public Map<String, Object> findOrderByCondition(OrderConditiondto orderCondition) {
        Map<String, Object> map = MapUtil.entityToMap(orderCondition);
        Integer startRecord = orderCondition.getPageNum() * orderCondition.getPageSize();
        map.put("startRecord", startRecord);
        Integer totalRecord = 0;
        List<Order> orderList = orderMapper.selectByCondition(map);
        if (orderCondition.getProName() != null && orderList != null) {
            List<Order> orderTemp = new ArrayList<>();
            List<OrderDetail> orderDetailList =
                    orderDetailMapper.selectByOrderCondition(orderCondition.getOrderNum(), orderCondition.getProName());
            if (orderDetailList != null) {
                orderList.forEach((x) -> {
                    orderDetailList.forEach((y) -> {
                        if (y.getOrderId().equals(x.getId())) {
                            x.getOrderDetailList().add(y);
                            orderTemp.add(x);
                        }
                    });
                });
            }
            orderList = orderTemp;
            totalRecord = getTotalRecords(map, orderDetailList);
        } else {
            totalRecord = orderMapper.selectCountsByCondition(map);
            orderList.forEach((x) -> {
                List<OrderDetail> orderDetailList = orderDetailMapper.selectByOrderId(x.getId());
                x.setOrderDetailList(orderDetailList);
            });
        }
        int pageNum = orderCondition.getPageNum();
        int pageSize = orderCondition.getPageSize();
        Map<String, Object> orderMap = new PageUtil<Order>().objectPageToMap(pageNum, pageSize, totalRecord, orderList);
        return orderMap;
    }

    /**
     * 得到总记录数
     *
     * @param map
     * @param orderDetailList
     * @return
     */
    private Integer getTotalRecords(Map<String, Object> map, List<OrderDetail> orderDetailList) {
        Integer totalRecord;
        List<Order> ordersDB = orderMapper.selectOrdersByCondition(map);
        Set<Integer> orderDetailIds = new HashSet<>();
        Set<Integer> orderIds = new HashSet<>();
        orderDetailList.forEach(
                x -> orderDetailIds.add(x.getOrderId())
        );
        ordersDB.forEach(
                x -> orderIds.add(x.getId())
        );
        orderDetailIds.retainAll(orderIds);
        totalRecord = orderDetailIds.size();
        return totalRecord;
    }

    @Override
    public Integer changeOrderStatus(OrderStatusdto orderStatusdto) {
        Map<String, Object> map = MapUtil.entityToMap(orderStatusdto);
        orderMapper.changetOrderStatus(map);
        return 1;
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
