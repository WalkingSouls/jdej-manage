package com.miquankj.api.controller;

import com.miquankj.api.dto.Lendingdto;
import com.miquankj.api.service.LendingService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 家电金融ontroller
 * @author liuyadong
 * @since 2019/5/15
 */
@RequestMapping("/lending")
@RestController
@Slf4j
@Api(value = "家电金融，借贷表",description = "家电金融，借贷表")
public class LendingController {
    @Autowired
    private LendingService lendingService;

    @ApiOperation(value = "筛选申请列表")
    @ApiResponse(code = 33, message = "申请列表为空")
    @GetMapping("/findApplyList")
    public ResultVO findApplyList(Lendingdto lendingdto){
        Map<String, Object> map = lendingService.findByCon(lendingdto);
        if(map == null || map.get("list") == null){
            log.error("【金融】 申请列表为空， map={}",map);
        }
        return ResultVOUtil.success(map);
    }

}
