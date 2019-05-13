package com.miquankj.api.controller;

import com.miquankj.api.dto.GoodsConditiondto;
import com.miquankj.api.dto.Goodsdto;
import com.miquankj.api.entity.*;
import com.miquankj.api.service.BrandInfoService;
import com.miquankj.api.service.GoodsPriceService;
import com.miquankj.api.service.GoodsService;
import com.miquankj.api.service.StoreService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import com.miquankj.common.enums.ResultEnum;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 商品controller
 *
 * @author liuyadong
 * @since 2019/5/8
 */
@RestController
@RequestMapping("/goods")
@Slf4j
@Api(value = "商品controller，对商品的操作和列表",description = "商品controller，对商品的操作和列表")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private BrandInfoService brandInfoService;

    @ApiOperation(value = "新建商品", notes = "添加新商品，并校验商品参数等信息")
    @ApiResponses({
            @ApiResponse(code = 10, message = "商品参数有误"),
            @ApiResponse(code = 11, message = "所属店铺状态异常"),
            @ApiResponse(code = 12, message = "类目选择出错"),
    })
    @PostMapping("/createNewGoods")
    public ResultVO createNewGoods(@RequestBody @Valid Goods goods, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【商品】 商品参数有误，goods={}", goods);
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        Store store = storeService.findOne(Integer.parseInt(goods.getAddBis()));
        if (store == null || store.getStatus() != 1) {
            log.error("【商品】 所属店铺状态异常，goods={},store={}", goods, store);
            return ResultVOUtil.error(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());
        }
        BrandInfo brandInfo = brandInfoService.findOne(goods.getComType());
        if (null == brandInfo || brandInfo.getState().equals(0)) {
            log.error("【商品】 类目选择出错，brandInfo={}", brandInfo);
            return ResultVOUtil.error(ResultEnum.BRANDINFO_ERROR.getCode(), ResultEnum.BRANDINFO_ERROR.getMsg());
        }
        goodsService.createNewGoods(goods);
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "更新商品", notes = "根据传入的goods对象来更新商品，需要传入完整goods对象")
    @ApiResponses({
            @ApiResponse(code = 14, message = "商品更新出错"),
            @ApiResponse(code = 15, message = "商品不存在"),
            @ApiResponse(code = 11, message = "所属店铺状态异常"),
    })
    @PostMapping("/updateGoods")
    public ResultVO updateGoods(@RequestBody Goods goods) {
        Goods goodsTemp = goodsService.findOneGoods(goods.getId());
        if (goodsTemp == null || goodsTemp.getState().equals(-1)) {
            log.error("【商品】 商品不存在，goods={}", goods);
            return ResultVOUtil.error(ResultEnum.GOODS_NOT_EXIST.getCode(), ResultEnum.GOODS_NOT_EXIST.getMsg());
        }
        if (!goodsTemp.getAddBis().equals(goods.getAddBis())) {
            log.error("【商品】 所属店铺状态异常，goods={},store={}", goods, goods.getAddBis());
            return ResultVOUtil.error(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());
        }
        try {
            goodsService.updateGoods(goods);
        } catch (RuntimeException e) {
            log.error("【商品】 商品更新出错，goods={}", goods);
            return ResultVOUtil.error(ResultEnum.GOODS_UPDATE_ERROR.getCode(), ResultEnum.GOODS_UPDATE_ERROR.getMsg());
        }
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "查看某商品", notes = "根据店铺id和商品id查看商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "goodsId", value = "商品id", dataType = "Integer"),
    })
    @ApiResponse(code = 15, message = "商品不存在")
    @GetMapping("/findOne/{storeId}/{goodsId}")
    public ResultVO findOneGoods(@PathVariable Integer storeId, @PathVariable Integer goodsId) {
        Goods goods = goodsService.findOneGoods(goodsId);
        if (goods == null || storeId != Integer.parseInt(goods.getAddBis())) {
            log.error("【商品】 商品不存在，goods={}", goods);
            return ResultVOUtil.error(ResultEnum.GOODS_NOT_EXIST.getCode(), ResultEnum.GOODS_NOT_EXIST.getMsg());
        }
        ResultVO resultVO = ResultVOUtil.success(goods);
        return resultVO;
    }

    @ApiOperation(value = "查看商品列表", notes = "根据店铺id查看全部或者上下架、推荐列表、搜索商品名，创建时间段商品列表")
    @ApiResponse(code = 15, message = "商品不存在")
    @GetMapping("/findAll")
    public ResultVO findAllGoodsByCondition(GoodsConditiondto conditiondto) {
        Map<String, Object> goodsMap = goodsService.findAllPro(conditiondto);
        if (goodsMap.get("list") == null) {
            log.error("【商品】 商品不存在，goodsMap={}", goodsMap);
            return ResultVOUtil.error(ResultEnum.GOODS_NOT_EXIST.getCode(), ResultEnum.GOODS_NOT_EXIST.getMsg());
        }
        ResultVO resultVO = ResultVOUtil.success(goodsMap);
        return resultVO;
    }

    @ApiOperation(value = "更改商品状态", notes = "商品上下架和删除和推荐操作")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "goodsId", value = "商品id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "operationType",
                    value = "操作类型，为0时为下架，为1时为上架，2 时为推荐 -2时为移除推荐 -1时为删除", dataType = "Integer")
    })
    @ApiResponse(code = 16, message = "商品状态变更失败")
    @GetMapping("/changeGoodsStatus/{storeId}/{goodsId}/{operationType}")
    public ResultVO changeGoodsStatus(@PathVariable int storeId, @PathVariable int goodsId, @PathVariable int operationType) {
        try {
            goodsService.changetGoodsStatus(storeId, goodsId, operationType);
        } catch (RuntimeException e) {
            log.error("【商品】 商品状态变更失败，goodsId={}", goodsId);
            return ResultVOUtil.error(ResultEnum.GOODS_STATUS_FAIL.getCode(), ResultEnum.GOODS_STATUS_FAIL.getMsg());
        }
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "查看类目列表")
    @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer")
    @ApiResponse(code = 17, message = "类目信息不存在")
    @GetMapping("/findBrands")
    public ResultVO findBrands() {
        Map<String, Object> brandMap = brandInfoService.findBrands();
        if (brandMap == null || brandMap.size() == 0) {
            log.error("【商品】 类目信息不存在，brandMap={}", brandMap);
            return ResultVOUtil.error(ResultEnum.BRANDINFO_NOT_EXIST.getCode(), ResultEnum.BRANDINFO_NOT_EXIST.getMsg());
        }
        ResultVO resultVO = ResultVOUtil.success(brandMap);
        return resultVO;
    }
}
