package com.miquankj.api.controller.product;

import com.miquankj.api.dto.ProductConditiondto;
import com.miquankj.api.entity.Category;
import com.miquankj.api.entity.Freight;
import com.miquankj.api.entity.Product;
import com.miquankj.api.entity.Store;
import com.miquankj.api.service.CategoryService;
import com.miquankj.api.service.FreightService;
import com.miquankj.api.service.ProductService;
import com.miquankj.api.service.StoreService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import com.miquankj.common.enums.ResultEnum;
import com.miquankj.common.exception.JdejException;
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
 * @since 2019/5/4
 */
@RestController
@RequestMapping("/product")
@Slf4j
@Api(value = "商品controller，对商品的操作和列表")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private FreightService freightService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "新建产品", notes = "创建新产品，并校验产品参数等信息")
    @ApiResponses({
            @ApiResponse(code = 10, message = "参数有误"),
            @ApiResponse(code = 11, message = "所属店铺状态异常"),
            @ApiResponse(code = 12, message = "类目选择出错"),
            @ApiResponse(code = 13, message = "运费模版设置异常")
    })
    @PostMapping("/createNewPro")
    public ResultVO createNewPro(@RequestBody @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【商品】 参数有误，product={}", product);
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        Store store = storeService.findOne(product.getStoreId());
        if (store == null || store.getStatus() != 1) {
            log.error("【商品】 所属店铺状态异常，product={},store={}", product, store);
            return ResultVOUtil.error(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());
        }
        Category category = categoryService.findOne(product.getCategoryId());
        if (category == null || category.getValid() != 1 || category.getStoreId() != product.getStoreId()) {
            log.error("【商品】 类目选择出错，product={}", product);
            return ResultVOUtil.error(ResultEnum.CATEGORY_ERROR.getCode(), ResultEnum.CATEGORY_ERROR.getMsg());
        }
        if (product.getDeliveryType() == 1) {
            Freight freight = freightService.findOne(product.getFreightId());
            if (freight == null || freight.getValid() != 1 || freight.getStoreId() != product.getStoreId()) {
                log.error("【商品】 运费模版设置异常，product={}", product);
                return ResultVOUtil.error(ResultEnum.FREIGHT_ERROR.getCode(), ResultEnum.FREIGHT_ERROR.getMsg());
            }
        }
        productService.createNewPro(product);
        ResultVO resultVO = ResultVOUtil.success();
        return resultVO;
    }

    @ApiOperation(value = "更新商品", notes = "根据传入的product对象来更新商品，需要传入完整product对象")
    @ApiResponse(code = 14, message = "商品更新出错")
    @PostMapping("/updatePro")
    public ResultVO updatePro(@RequestBody Product product) {
        try {
            productService.updatePro(product);
        } catch (RuntimeException e) {
            log.error("【商品】 商品更新出错，product={}", product);
            return ResultVOUtil.error(ResultEnum.PRODUCT_UPDATE_ERROR.getCode(), ResultEnum.PRODUCT_UPDATE_ERROR.getMsg());
        }
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "查看某商品", notes = "根据店铺id和商品id查看商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "productId", value = "商品id", dataType = "Integer"),
    })
    @ApiResponse(code = 15, message = "商品不存在")
    @GetMapping("/findOne/{storeId}/{productId}")
    public ResultVO findOnePro(@PathVariable Integer storeId, @PathVariable Integer productId) {
        Product product = productService.findOnePro(productId);
        if (product == null || storeId != product.getStoreId()) {
            log.error("【商品】 商品不存在，product={}", product);
//            throw new JdejException(ResultEnum.PRODUCT_NOT_EXIST.getCode(),ResultEnum.PRODUCT_NOT_EXIST.getMsg());
            return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST.getCode(), ResultEnum.PRODUCT_NOT_EXIST.getMsg());
        }
        ResultVO resultVO = ResultVOUtil.success(product);
        return resultVO;
    }

    @ApiOperation(value = "查看商品列表", notes = "根据店铺id查看全部或者上下架商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "ListType",
                    value = "列表类型，为0时为下架列表，为1时为上架列表，2时为全部", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageNum", value = "当前页码，从1开始计数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "分页大小", dataType = "Integer"),
    })
    @ApiResponse(code = 15, message = "商品不存在")
    @GetMapping("/findAll/{storeId}/{ListType}/{pageNum}/{pageSize}")
    public ResultVO findAllPro(@PathVariable Integer storeId, @PathVariable Integer ListType,
                               @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        Map<String, Object> productMap = productService.findAllPro(storeId, ListType, pageNum, pageSize);
        if (productMap.get("productList") == null) {
            log.error("【商品】 商品不存在，productMap={}", productMap);
            return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST.getCode(), ResultEnum.PRODUCT_NOT_EXIST.getMsg());
        }
        ResultVO resultVO = ResultVOUtil.success(productMap);
        return resultVO;
    }

    @ApiOperation(value = "根据条件筛选商品", notes = "根据商品名称和创建时间筛选商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "ListType",
                    value = "列表类型，为0时为下架列表，为1时为上架列表，2时为全部", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageNum", value = "当前页码，从1开始计数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "分页大小", dataType = "Integer"),
    })
    @ApiResponse(code = 15, message = "商品不存在")
    @GetMapping("/findByCondition")
    public ResultVO findByCondition(ProductConditiondto productConditiondto
            /*@RequestParam("storeId") int storeId, @RequestParam("productName")String productName,
                                    @RequestParam("startTime") Date startTime, @RequestParam("endTime") Date endTime,
                                    @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize*/) {
        Map<String, Object> productMap = productService.findByCondition(productConditiondto);
        ResultVO resultVO = ResultVOUtil.success(productMap);
        return resultVO;
    }

    @ApiOperation(value = "更改商品状态", notes = "商品上下架和删除操作")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "productId", value = "商品id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "operationType",
                    value = "操作类型，为0时为下架，为1时为上架，-1时为删除", dataType = "Integer")
    })
    @ApiResponse(code = 16, message = "商品状态变更失败")
    @GetMapping("/changeProStatus/{productId}/{operationType}")
    public ResultVO changeProStatus(@PathVariable int productId, @PathVariable int operationType) {
        try {
            productService.changetProStatus(productId, operationType);
        } catch (RuntimeException e) {
            log.error("【商品】 商品状态变更失败，productId={}", productId);
            return ResultVOUtil.error(ResultEnum.PRODUCT_STATUS_FAIL.getCode(), ResultEnum.PRODUCT_STATUS_FAIL.getMsg());
        }
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "查看类目列表", notes = "查看所属店铺下的类目列表")
    @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer")
    @ApiResponse(code = 17, message = "类目信息不存在")
    @GetMapping("/findCates/{storeId}")
    public ResultVO findCates(@PathVariable int storeId) {
        Map<String, Object> cateMap = productService.findCates(storeId);
        if (cateMap == null || cateMap.size() == 0) {
            log.error("【商品】 类目信息不存在，categoryMap={}", cateMap);
            return ResultVOUtil.error(ResultEnum.CATEGORY_NOT_EXIST.getCode(), ResultEnum.CATEGORY_NOT_EXIST.getMsg());
        }
        ResultVO resultVO = ResultVOUtil.success(cateMap);
        return resultVO;
    }
    @ApiOperation(value = "查看运费模版列表", notes = "查看所属店铺下的运费模版列表")
    @ApiImplicitParam(paramType = "path", name = "storeId", value = "店铺id", dataType = "Integer")
    @ApiResponse(code = 18, message = "运费模版信息不存在")
    @GetMapping("/findFreights/{storeId}")
    public ResultVO findFreights(@PathVariable int storeId) {
        Map<String, Object> freMap = productService.findFreights(storeId);
        if (freMap == null || freMap.size() == 0) {
            log.error("【商品】 运费模版信息不存在，freightMap={}", freMap);
            return ResultVOUtil.error(ResultEnum.FREIGHT_NOT_EXIST.getCode(), ResultEnum.FREIGHT_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(freMap);
    }

    @ApiOperation(value = "更改运费模版", notes = "创建或更新运费模版信息")
    @ApiResponses({
            @ApiResponse(code = 11, message = "所属店铺状态异常"),
            @ApiResponse(code = 19, message = "运费模版更新失败")
    })
    @PostMapping("/changeFreight")
    public ResultVO changeFreight(@RequestBody Freight freight) {
        Store store = storeService.findOne(freight.getStoreId());
        if (store == null || store.getStatus() != 1) {
            log.error("【商品】 所属店铺状态异常，freight={},store={}", freight, store);
            return ResultVOUtil.error(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());
        }
        if (freight.getFreId() != null) {
            try {
                productService.updateFreight(freight);
            } catch (RuntimeException e) {
                log.error("【商品】 运费模版更新失败，freight={}", freight);
                return ResultVOUtil.error(ResultEnum.FREIGHT_UPDATE_ERROR.getCode(), ResultEnum.FREIGHT_UPDATE_ERROR.getMsg());
            }
            return ResultVOUtil.success();
        }
        productService.createFreight(freight);
        return ResultVOUtil.success();
    }
}
