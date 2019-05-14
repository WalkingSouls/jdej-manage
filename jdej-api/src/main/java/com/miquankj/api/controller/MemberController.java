package com.miquankj.api.controller;

import com.miquankj.api.dto.*;
import com.miquankj.api.entity.GrpInfo;
import com.miquankj.api.enums.ResultEnum;
import com.miquankj.api.service.MemberService;
import com.miquankj.api.service.StoreCustomerService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 店铺会员/客户管理controller
 *
 * @author liuyadong
 * @since 2019/5/13
 */
@RestController
@Slf4j
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private StoreCustomerService storeCustomerService;

    @ApiOperation(value = "筛选消费者列表", notes = "根据筛选条件查看消费者列表")
    @ApiResponse(code = 31, message = "客户不存在")
    @GetMapping("/findCousumers")
    public ResultVO findCousumers(Condto consumerdto) {
        if (StringUtils.isEmpty(consumerdto.getPageNum()) || StringUtils.isEmpty(consumerdto.getPageSize())) {
            consumerdto.setPageNum(0);
            consumerdto.setPageSize(10);
        }
        Map<String, Object> map = null;
        try {
            List<Integer> cusIds = storeCustomerService.findCusIds(consumerdto.getStoreId(), 0);
            map = memberService.findCusByCon(cusIds, consumerdto);
        } catch (RuntimeException e) {
            log.error("【客户】 客户不存在，customers={},exception={}", map.get("list"), e);
            return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(map);
    }

    @ApiOperation(value = "筛选经销商、代理商列表", notes = "根据筛选条件查看经销商、代理商列表")
    @ApiResponse(code = 31, message = "客户不存在")
    @GetMapping("/findDealers")
    public ResultVO findDealers(Dealerdto dealerdto) {
        if (StringUtils.isEmpty(dealerdto.getPageNum()) || StringUtils.isEmpty(dealerdto.getPageSize())) {
            dealerdto.setPageNum(0);
            dealerdto.setPageSize(10);
        }
        Map<String, Object> map = null;
        try {
            List<Integer> cusIds = storeCustomerService.findCusIds(dealerdto.getStoreId(), 1);
            map = memberService.findCusByDealer(cusIds, dealerdto);
        } catch (RuntimeException e) {
            log.error("【客户】 客户不存在，customers={},exception={}", map.get("list"), e);
            return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(map);
    }

    @ApiOperation(value = "筛选代理审核列表", notes = "根据筛选条件查看代理审核列表")
    @ApiResponse(code = 31, message = "客户不存在")
    @GetMapping("/findApply")
    public ResultVO findApply(Applydto applydto) {
        if (StringUtils.isEmpty(applydto.getPageNum()) || StringUtils.isEmpty(applydto.getPageSize())) {
            applydto.setPageNum(0);
            applydto.setPageSize(10);
        }
        Map<String, Object> map = null;
        try {
            List<Integer> cusIds = storeCustomerService.findCusIds(applydto.getStoreId(), 2);
            map = memberService.findCusByApply(cusIds, applydto);
        } catch (RuntimeException e) {
            log.error("【客户】 客户不存在，customers={},exception={}", map.get("list"), e);
            return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(map);
    }

    @ApiOperation(value = "查看审核明细", notes = "根据id查看审核明细")
    @ApiImplicitParam(value = "客户id")
    @ApiResponse(code = 32, message = "审核明细异常")
    @GetMapping("/findApplyDetail/{customerId}")
    public ResultVO findApplyDetail(@PathVariable Integer customerId) {
        ApplyDetaildto applyDetail = null;
        try {
            applyDetail = memberService.findByPK(customerId);
        } catch (RuntimeException e) {
            log.error("【客户】 审核明细异常，,exception={}", e);
            return ResultVOUtil.error(ResultEnum.APPLICATION_ERROR.getCode(), ResultEnum.APPLICATION_ERROR.getMsg());

        }
        return ResultVOUtil.success(applyDetail);
    }
}
