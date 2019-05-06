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
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private FreightService freightService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createNewPro")
    public ResultVO createNewPro(@RequestBody @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【商品】 参数有误，product={}", product);
            throw new JdejException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        Store store = storeService.findOne(product.getStoreId());
        if (store == null || store.getStatus() != 1) {
            log.error("【商品】 所属店铺状态异常，product={},store={}", product, store);
            throw new JdejException(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());
        }
        Category category = categoryService.findOne(product.getCategoryId());
        if (category == null || category.getValid() != 1 || category.getStoreId() != product.getStoreId()) {
            log.error("【商品】 类目选择出错，product={}", product);
            throw new JdejException(ResultEnum.CATEGORY_ERROR.getCode(), ResultEnum.CATEGORY_ERROR.getMsg());
        }
        if (product.getDeliveryType() == 1) {
            Freight freight = freightService.findOne(product.getFreightId());
            if (freight == null || freight.getValid() != 1 || freight.getStoreId() != product.getStoreId()) {
                log.error("【商品】 运费模版设置异常，product={}", product);
                throw new JdejException(ResultEnum.FREIGHT_ERROR.getCode(), ResultEnum.FREIGHT_ERROR.getMsg());
            }
        }
        productService.createNewPro(product);
        ResultVO resultVO = ResultVOUtil.success();
        return resultVO;
    }

    @PostMapping("/updatePro")
    public ResultVO updatePro(@RequestBody Product product) {
        try {
            productService.updatePro(product);
        } catch (RuntimeException e) {
            log.error("【商品】 商品更新出错，product={}", product);
            throw new JdejException(ResultEnum.PRODUCT_UPDATE_ERROR.getCode(), ResultEnum.PRODUCT_UPDATE_ERROR.getMsg());
        }
        return ResultVOUtil.success();
    }

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

    @GetMapping("/findByCondition")
    public ResultVO findByCondition(ProductConditiondto productConditiondto
            /*@Param("storeId") int storeId, @Param("productName")String productName,
                                    @Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                    @Param("pageNum") int pageNum, @Param("pageSize") int pageSize*/) {
        Map<String, Object> productMap = productService.findByCondition(productConditiondto);
        ResultVO resultVO = ResultVOUtil.success(productMap);
        return resultVO;
    }

    @GetMapping("/changeProStatus/{productId}/{operationType}")
    public ResultVO changeProStatus(@PathVariable int productId, @PathVariable int operationType) {
        try {
            productService.changetProStatus(productId, operationType);
        } catch (RuntimeException e) {
            log.error("【商品】 商品状态变更失败，productId={}", productId);
            return ResultVOUtil.error(ResultEnum.PRODUCT_UPDATE_ERROR.getCode(), ResultEnum.PRODUCT_UPDATE_ERROR.getMsg());
        }
        return ResultVOUtil.success();
    }

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

    @GetMapping("/findFreights/{storeId}")
    public ResultVO findFreights(@PathVariable int storeId) {
        Map<String, Object> freMap = productService.findFreights(storeId);
        if (freMap == null || freMap.size() == 0) {
            log.error("【商品】 运费模版信息不存在，freightMap={}", freMap);
            return ResultVOUtil.error(ResultEnum.FREIGHT_NOT_EXIST.getCode(), ResultEnum.FREIGHT_NOT_EXIST.getMsg());
        }
        return ResultVOUtil.success(freMap);
    }

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
                return ResultVOUtil.error(ResultEnum.FREIGHT_NOT_EXIST.getCode(), ResultEnum.FREIGHT_NOT_EXIST.getMsg());
            }
            return ResultVOUtil.success();
        }
        productService.createFreight(freight);
        return ResultVOUtil.success();
    }
}
