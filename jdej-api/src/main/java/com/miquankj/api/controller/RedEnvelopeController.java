package com.miquankj.api.controller;

import com.miquankj.api.dto.RedEnvdto;
import com.miquankj.api.entity.RedEnvelope;
import com.miquankj.api.entity.Store;
import com.miquankj.api.enums.ResultEnum;
import com.miquankj.api.service.RedEnvelopeService;
import com.miquankj.api.service.StoreService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 营销管理(红包管理)
 *
 * @author liuyadong
 * @since 2019/5/7
 */
@Slf4j
@Api(value = "红包的管理，列表")
@RestController
@RequestMapping("/redEnvelope")
public class RedEnvelopeController {
    @Autowired
    private RedEnvelopeService redEnvelopeService;

    @Autowired
    private StoreService storeService;


    @ApiOperation(value = "查询红包", notes = "根据红包id查询红包")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "redEnvId", value = "红包id", dataType = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 20, message = "红包不存在"),
            @ApiResponse(code = 11, message = "所属店铺状态异常")
    })
    @GetMapping("/findOne/{storeId}/{redEnvId}")
    public ResultVO findOneByName(@PathVariable int storeId, @PathVariable int redEnvId) {
        RedEnvelope redEnvelope = redEnvelopeService.findOneByName(storeId, redEnvId);
        if (redEnvelope == null) {
            log.error("【商品】 红包不存在，redEnvelope={}", redEnvelope);
            return ResultVOUtil.error(ResultEnum.REDENVELOPE_NOT_EXIST.getCode(), ResultEnum.REDENVELOPE_NOT_EXIST.getMsg());
        }
        Store store = storeService.findOne(storeId);
        if (store == null || store.getStatus() != 1) {
            log.error("【商品】 所属店铺状态异常，store={}", store);
            return ResultVOUtil.error(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());
        }
        return ResultVOUtil.success(redEnvelope);
    }

    @ApiOperation(value = "查询红包列表", notes = "根据红包使用情况查询红包列表，全部，未开始，已开始，结束")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "status", value = "红包使用状态，0 未开始 1 已开始 2 已结束 3 全部 -1 删除", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageNum", value = "当前页码，从0开始计数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "分页大小", dataType = "Integer")
    })
    @GetMapping("/findRedEnvs/{storeId}/{status}/{pageNum}/{pageSize}")
    public ResultVO findRedEnvsByStatus(@PathVariable int storeId, @PathVariable int status,
                                        @PathVariable int pageNum, @PathVariable int pageSize) {
        Map<String,Object> redEnvMap =  redEnvelopeService.findRedEnvsByStatus(storeId,status);
        List<RedEnvdto> redEnvList = (List<RedEnvdto>) redEnvMap.get("redEnvList");
        if(redEnvMap.get("redEnvList") == null || ((List<RedEnvdto>) redEnvMap.get("redEnvList")).size() == 0){
            log.error("【商品】 红包不存在，redEnvMap={}", redEnvMap);
            return ResultVOUtil.error(ResultEnum.REDENVELOPE_NOT_EXIST.getCode(), ResultEnum.REDENVELOPE_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(redEnvMap);
    }
    @ApiOperation(value = "根据红包名称查询红包", notes = "查询红包并结果分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "redEnvName", value = "红包名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "status", required = false,
                    value = "红包使用状态，0 未开始 1 已开始 2 已结束 3 全部 -1 删除", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码，从0开始计数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "分页大小", dataType = "Integer")
    })
    @GetMapping("/findByRedEnvName")
    public ResultVO findByRedEnvName(@RequestParam int storeId, @RequestParam(required = false) String redEnvName,
                                     @RequestParam(required = false) int status, @RequestParam int pageNum,
                                     @RequestParam int pageSize){
        Map<String,Object> redEnvMap =  redEnvelopeService.findRedEnvsByStatus(storeId,status);
        List<RedEnvdto> redEnvList = (List<RedEnvdto>) redEnvMap.get("redEnvList");
        if(redEnvMap.get("redEnvList") == null || ((List<RedEnvdto>) redEnvMap.get("redEnvList")).size() == 0){
            log.error("【商品】 红包不存在，redEnvMap={}", redEnvMap);
            return ResultVOUtil.error(ResultEnum.REDENVELOPE_NOT_EXIST.getCode(), ResultEnum.REDENVELOPE_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(redEnvMap);
    }

}
