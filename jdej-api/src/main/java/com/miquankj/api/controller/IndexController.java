package com.miquankj.api.controller;

import com.miquankj.api.dto.CusCondidto;
import com.miquankj.api.dto.Indexdto;
import com.miquankj.api.dto.OrderConditiondto;
import com.miquankj.api.entity.Order;
import com.miquankj.api.entity.OrderData;
import com.miquankj.api.service.OrderDataService;
import com.miquankj.api.service.OrderService;
import com.miquankj.api.service.StoreCustomerService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.utils.TimeUtil;
import com.miquankj.api.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * 首页
 *
 * @author liuyadong
 * @since 2019/5/13
 */
@RestController
@Slf4j
public class IndexController {
    @Autowired
    private OrderDataService orderDataService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private StoreCustomerService storeCustomerService;

    @GetMapping("/index/{storeId}")
    public ResultVO index(@PathVariable int storeId) {
        String today = TimeUtil.getToday();
        Date begin = TimeUtil.strToDate(TimeUtil.getNextDay(today, "-3"));
        Date end = TimeUtil.strToDate(TimeUtil.getNextDay(today, "3"));
        Date yesterday = TimeUtil.strToDate(TimeUtil.getNextDay(today, "-1"));
        int applyAmount = storeCustomerService.findCountById(storeId, 0);
        Order order = new Order();
        order.setStoreId(storeId);
        order.setOrderStatus(Byte.valueOf("2"));
        int orderToSend = orderService.findCounts(order);
        OrderData lastDayData = orderDataService.findDataByDate(storeId, yesterday);
        int lastDayOrders = lastDayData.getOrderAmount();
        BigDecimal lastDayMoney = lastDayData.getDealMoney();
        List<OrderData> weekDatas = orderDataService.findDataByDates(storeId, begin, end);
        int sumOrderAmount = 0;
        int sumOrderDeal = 0;
        BigDecimal sumDealMoney = null;
        Map<String, Object> orderMap = new TreeMap<>();
        Map<String, Object> moneyMap = new TreeMap<>();
        if (weekDatas != null) {
            for (int i = 0; i < weekDatas.size(); i++) {
                OrderData orderData = weekDatas.get(i);
                String date = orderData.getOrderDate().toString();
                orderMap.put(date,orderData.getOrderAmount());
                moneyMap.put(date,orderData.getDealMoney());
                sumOrderAmount = sumOrderAmount + orderData.getOrderAmount();
                sumOrderDeal = sumOrderDeal + orderData.getOrderDeal();
                sumDealMoney = sumDealMoney.add(orderData.getDealMoney());
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("applyAmount", applyAmount);
        map.put("orderToSend", orderToSend);
        map.put("lastDayOrders", lastDayOrders);
        map.put("lastDayMoney", lastDayMoney);
        map.put("sumOrderAmount",sumOrderAmount);
        map.put("sumOrderDeal",sumOrderDeal);
        map.put("sumDealMoney",sumDealMoney);
        map.put("orderMap",orderMap);
        map.put("moneyMap",moneyMap);
        return ResultVOUtil.success(map);
    }
}
