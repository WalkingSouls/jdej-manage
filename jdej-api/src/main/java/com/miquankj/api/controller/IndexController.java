package com.miquankj.api.controller;

import com.miquankj.api.dto.Customerdto;
import com.miquankj.api.entity.Customer;
import com.miquankj.api.service.OrderDataService;
import com.miquankj.api.service.StoreCustomerService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
@RestController
@Slf4j
public class IndexController {
    @Autowired
    private OrderDataService orderDataService;

    private StoreCustomerService storeCustomerService;

    @GetMapping("/index/{storeId}/{startDate}/{endDate}/{now}")
    public ResultVO index(@PathVariable Integer storeId, @PathVariable Date startDate,@PathVariable Date endDate,
                          @PathVariable Date now){
        Customerdto customerdto = new Customerdto();
        customerdto.setStoreId(storeId);
        customerdto.setState("1");
        customerdto.setPageNum(0);
        customerdto.setPageSize(9999);
        List<Integer> cus = storeCustomerService.findCusByCondition(customerdto);
        Integer applyAmount = cus.size();
        
        return ResultVOUtil.success();
    }
}
