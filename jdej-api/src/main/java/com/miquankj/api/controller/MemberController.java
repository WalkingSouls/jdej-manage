package com.miquankj.api.controller;

import com.miquankj.api.dto.Customerdto;
import com.miquankj.api.entity.GrpInfo;
import com.miquankj.api.service.MemberService;
import com.miquankj.api.service.StoreCustomerService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @ApiOperation(value = "筛选客户列表", notes = "根据筛选条件查看客户列表")
    @GetMapping("/findCustomers")
    public ResultVO findCustomers(Customerdto customerdto) {
        List<Integer> cusIdList = storeCustomerService.findCusByCondition(customerdto);
        Map<String,Object> map = memberService.findCustomersByIds(cusIdList,customerdto.getPageNum(),customerdto.getPageSize());
        return ResultVOUtil.success(map);
    }

    @ApiOperation(value = "查看客户列表", notes = "查看消费者、经销商/代理商、代理审核列表")
    @GetMapping("/findList/{storeId}/{listType}/{pageNum}/{pageSize}")
    public ResultVO findList(@PathVariable Integer storeId, @PathVariable Integer listType,
                             @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        List<Integer> cusIdList = storeCustomerService.findCusIds(storeId,listType);
        Map<String,Object> map = memberService.findCustomersByIds(cusIdList,pageNum,pageSize);
        return ResultVOUtil.success(map);
    }
    @ApiOperation(value = "查看代理申请详情", notes = "根据客户ID查看代理申请详情")
    @GetMapping("/findApplyDetail/{storeId}/{cliId}")
    public ResultVO findApplyDetail(@PathVariable Integer storeId, @PathVariable Integer cliId){
        GrpInfo grpInfo = memberService.findApplyDetail(storeId,cliId);
        return ResultVOUtil.success(grpInfo);
    }

}
