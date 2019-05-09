package com.miquankj.api.controller;

import com.miquankj.api.dto.OrderConditiondto;
import com.miquankj.api.dto.OrderStatusdto;
import com.miquankj.api.entity.Order;
import com.miquankj.api.service.OrderService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import com.miquankj.common.enums.ResultEnum;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 订单controller
 *
 * @author liuyadong
 * @since 2019/5/9
 */
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
        return ResultVOUtil.success(order);
    }

    @ApiOperation(value = "筛选订单列表", notes = "根据订单号、下单时间、商品名称、买家名称、订单状态筛选订单列表")
    @GetMapping("/findOrders")
    public ResultVO findOrdersByCondition(OrderConditiondto orderCondition) {
        Map<String, Object> orderMap = orderService.findOrderByCondition(orderCondition);
        return ResultVOUtil.success(orderMap);
    }

    @ApiOperation(value = "更改订单状态", notes = "确认订单、发货、取消订单")
    @GetMapping("/changeOrderStatus")
    public ResultVO changeOrderStatus(OrderStatusdto orderStatusdto) {
        orderService.changeOrderStatus(orderStatusdto);
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "创建订单")
    @PostMapping("/createOrder")
    public ResultVO createOrder(@Valid @RequestBody Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【订单】 参数有误，order={}", order);
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        orderService.createOrder(order);
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "更新订单")
    @PostMapping("/updateOrder")
    public ResultVO updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return ResultVOUtil.success();
    }
}
