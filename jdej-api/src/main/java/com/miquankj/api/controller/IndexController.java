package com.miquankj.api.controller;

import com.miquankj.api.entity.Order;
import com.miquankj.api.entity.OrderData;
import com.miquankj.api.entity.Store;
import com.miquankj.api.enums.ResultEnum;
import com.miquankj.api.service.OrderDataService;
import com.miquankj.api.service.OrderService;
import com.miquankj.api.service.StoreCustomerService;
import com.miquankj.api.service.StoreService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.utils.TimeUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
@Api(value = "首页数据展现",description = "首页数据展现")
public class IndexController {
    @Autowired
    private OrderDataService orderDataService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private StoreCustomerService storeCustomerService;

    @Autowired
    private StoreService storeService;

    private static final String BEGIN_DATE = "-7";
    private static final String END_DATE = "-1";
    private static final String  LAST_DAY= "-1";

    @ApiOperation(value = "首页")
    @ApiResponse(code = 11,message = "店铺状态异常")
    @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer")
    @GetMapping("/index/{storeId}")
    public ResultVO index(@PathVariable int storeId) {
        Store store = storeService.findOne(storeId);
        if(store == null || store.getStatus() != 1){
            log.error("【店铺】 店铺状态异常, store={}",store);
            return ResultVOUtil.error(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());
        }
        String today = TimeUtil.getToday();
        Date begin = TimeUtil.strToDate(TimeUtil.getNextDay(today, BEGIN_DATE));
        Date end = TimeUtil.strToDate(TimeUtil.getNextDay(today, END_DATE));
        Date yesterday = TimeUtil.strToDate(TimeUtil.getNextDay(today, LAST_DAY));
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
        BigDecimal sumDealMoney = new BigDecimal(0);
        LinkedHashMap<String, Object> orderMap = new LinkedHashMap<>();
        orderMap = setMapDate(orderMap);
        LinkedHashMap<String, Object> moneyMap = new LinkedHashMap<>();
        moneyMap = setMapDate(moneyMap);
        if (weekDatas != null) {
            for (int i = 0; i < weekDatas.size(); i++) {
                OrderData orderData = weekDatas.get(i);
                String date = TimeUtil.dateFormatMD0(orderData.getOrderDate());
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

    /**
     * 给Map赋默认时间值
     * @param map
     * @return
     */
    private LinkedHashMap<String,Object> setMapDate(LinkedHashMap<String, Object> map){
        String today = TimeUtil.getToday();
        Date begin = TimeUtil.strToDate(TimeUtil.getNextDay(today, BEGIN_DATE));
        Date end = TimeUtil.strToDate(TimeUtil.getNextDay(today, END_DATE));
        List<Date> betweenDates = TimeUtil.getBetweenDates(begin, end);
        ArrayList<String> dates = new ArrayList<>();
        betweenDates.forEach(x->dates.add(TimeUtil.dateFormatMD0(x)));
        dates.forEach(x->map.put(x,0));
        return map;
    }
}
