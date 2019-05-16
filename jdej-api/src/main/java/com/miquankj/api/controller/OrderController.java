package com.miquankj.api.controller;

import com.miquankj.api.dto.OrderConditiondto;
import com.miquankj.api.dto.OrderStatusdto;
import com.miquankj.api.entity.Order;
import com.miquankj.api.enums.ResultEnum;
import com.miquankj.api.service.OrderService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.utils.TimeUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单controller
 *
 * @author liuyadong
 * @since 2019/5/9
 */
@Api(value = "订单controller", description = "订单controller，对订单的创建、更新、列表等")
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "查看订单", notes = "根据商铺id和订单id查看订单")
    @GetMapping("/findOrder/{storeId}/{orderId}")
    public ResultVO findOrder(@PathVariable Integer storeId, @PathVariable Integer orderId) {
        Order order = orderService.findOrder(storeId, orderId);
        if (order == null || order.getStoreId() != storeId) {
            log.error("【订单】 订单不存在，order={}", order);
            return ResultVOUtil.error(ResultEnum.ORDER_NOT_EXIST.getCode(), ResultEnum.ORDER_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(order);
    }

    @ApiOperation(value = "筛选订单列表", notes = "根据订单号、下单时间、商品名称、买家名称、订单状态筛选订单列表")
    @GetMapping("/findOrders")
    public ResultVO findOrdersByCondition(OrderConditiondto orderCondition) {
        Map<String, Object> orderMap = orderService.findOrderByCondition(orderCondition);
        if (orderMap.get("list") == null) {
            log.error("【订单】 订单不存在，order={}", orderMap);
            return ResultVOUtil.error(ResultEnum.ORDER_NOT_EXIST.getCode(), ResultEnum.ORDER_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(orderMap);
    }

    @ApiOperation(value = "更改订单状态", notes = "确认订单、发货、取消订单")
    @ApiResponse(code = 22, message = "订单更新出错")
    @GetMapping("/changeOrderStatus")
    public ResultVO changeOrderStatus(OrderStatusdto orderStatusdto) {
        try {
            orderService.changeOrderStatus(orderStatusdto);
        } catch (RuntimeException e) {
            log.error("【订单】 订单更新出错，order={}", orderStatusdto.getId());
            return ResultVOUtil.error(ResultEnum.ORDER_UPDATE_ERROR.getCode(), ResultEnum.ORDER_UPDATE_ERROR.getMsg());
        }
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "查看某消费者所有订单", notes = "根据客户id查看消费者订单列表")
    @GetMapping("/findOrdersByMember/{customerId}")
    public ResultVO findOrdersByMember(@PathVariable Integer customerId) {
        OrderConditiondto orderConditiondto = new OrderConditiondto();
        try {
            orderConditiondto.setCustomerId(customerId);
            Date dateStart = TimeUtil.StringToDate("1970-01-01 01:01:01");
            Date dateEnd = TimeUtil.StringToDate("2039-01-01 01:01:01");
            orderConditiondto.setOrderTimeStart(dateStart);
            orderConditiondto.setOrderTimeEnd(dateEnd);
        } catch (ParseException e) {
            return ResultVOUtil.error(ResultEnum.ORDER_NOT_EXIST.getCode(), ResultEnum.ORDER_NOT_EXIST.getMsg());
        }
        return findOrdersByCondition(orderConditiondto);
    }

//    @ApiOperation(value = "创建订单")
//    @PostMapping("/createOrder")
//    public ResultVO createOrder(@Valid @RequestBody Order order, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            log.error("【订单】 参数有误，order={}", order);
//            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
//        }
//        orderService.createOrder(order);
//        return ResultVOUtil.success();
//    }
//
//    @ApiOperation(value = "更新订单")
//    @PostMapping("/updateOrder")
//    public ResultVO updateOrder(@RequestBody Order order) {
//        orderService.updateOrder(order);
//        return ResultVOUtil.success();
//    }
}
