package com.miquankj.api.controller;

import com.miquankj.api.dto.*;
import com.miquankj.api.enums.ResultEnum;
import com.miquankj.api.service.MemberService;
import com.miquankj.api.service.StoreCustomerService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "店铺会员/客户管理controller", description = "店铺会员/客户管理controller")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private StoreCustomerService storeCustomerService;

    @ApiOperation(value = "筛选消费者列表", notes = "根据筛选条件查看消费者列表")
    @ApiResponse(code = 31, message = "客户不存在")
    @GetMapping("/findCousumers")
    public ResultVO findCousumers(Condto consumerdto) {
        Map<String, Object> map = null;
        try {
            List<Integer> cusIds = storeCustomerService.findCusIdsCon(consumerdto);
            if (cusIds.size() == 0) {
                log.error("【客户】 客户不存在，customers={}", map);
                return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
            }
            map = memberService.findCusByCon(cusIds, consumerdto);
        } catch (RuntimeException e) {
            log.error("【客户】 客户不存在，customers={},exception={}", map, e);
            return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(map);
    }

    @ApiOperation(value = "筛选经销商、代理商列表", notes = "根据筛选条件查看经销商、代理商列表")
    @ApiResponse(code = 31, message = "客户不存在")
    @GetMapping("/findDealers")
    public ResultVO findDealers(Dealerdto dealerdto) {
        Map<String, Object> map = null;
        try {
            List<Integer> cusIds = storeCustomerService.findCusIds(dealerdto);
            if (cusIds.size() == 0) {
                log.error("【客户】 客户不存在，customers={}", map);
                return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
            }
            map = memberService.findCusByDealer(cusIds, dealerdto);
        } catch (Exception e) {
            log.error("【客户】 客户不存在，customers={},exception={}", map, e);
            return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(map);
    }

    @ApiOperation(value = "筛选代理审核列表", notes = "根据筛选条件查看代理审核列表")
    @ApiResponse(code = 31, message = "客户不存在")
    @GetMapping("/findApply")
    public ResultVO findApply(Applydto applydto) {
        Map<String, Object> map = null;
        try {
            List<Integer> cusIds = storeCustomerService.findCusIdsApply(applydto,1);
            if (cusIds.size() == 0) {
                log.error("【客户】 客户不存在，customers={}", map);
                return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), ResultEnum.CUSTOMER_NOT_EXIST.getMsg());
            }
            map = memberService.findCusByApply(cusIds, applydto);
        } catch (RuntimeException e) {
            log.error("【客户】 客户不存在，customers={},exception={}", map, e);
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
            if(applyDetail == null){
                log.error("【客户】 审核明细异常");
                return ResultVOUtil.error(ResultEnum.APPLICATION_ERROR.getCode(), ResultEnum.APPLICATION_ERROR.getMsg());

            }
        } catch (RuntimeException e) {
            log.error("【客户】 审核明细异常，,exception={}", e);
            return ResultVOUtil.error(ResultEnum.APPLICATION_ERROR.getCode(), ResultEnum.APPLICATION_ERROR.getMsg());

        }
        return ResultVOUtil.success(applyDetail);
    }
}
