package com.miquankj.api.controller.product;
import com.miquankj.api.dto.ProductConditiondto;
import com.miquankj.api.dto.Productdto;
import com.miquankj.api.entity.Freight;
import com.miquankj.api.entity.Product;
import com.miquankj.api.service.ProductService;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import com.miquankj.common.enums.ResultEnum;
import com.miquankj.common.exception.JdejException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @PostMapping("/createNewPro")
    public ResultVO createNewPro(@RequestBody  @Valid Product product, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("【商品】 参数有误，product={}",product);
            throw new JdejException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        productService.createNewPro(product);
        ResultVO resultVO = ResultVOUtil.success();
        return resultVO;
    }
    @PostMapping("/updatePro")
    public ResultVO updatePro(@RequestBody Product product){
        productService.updatePro(product);
        ResultVO resultVO = ResultVOUtil.success();
        return resultVO;
    }

    @GetMapping("/findOne/{productId}")
    public ResultVO findOnePro(@PathVariable Integer productId) {
        Product product = productService.findOnePro(productId);
        ResultVO resultVO = ResultVOUtil.success(product);
        return resultVO;
    }
    @GetMapping("/findAll/{storeId}/{ListType}/{pageNum}/{pageSize}")
    public ResultVO findAllPro(@PathVariable Integer storeId, @PathVariable Integer ListType,
                               @PathVariable Integer pageNum, @PathVariable Integer pageSize){
        Map<String,Object> productMap = productService.findAllPro(storeId,ListType,pageNum,pageSize);
        ResultVO resultVO = ResultVOUtil.success(productMap);
        return resultVO;
    }
    @GetMapping("/changeProStatus/{productId}/{operationType}")
    public ResultVO changeProStatus(@PathVariable int productId,@PathVariable int operationType){
        productService.changetProStatus(productId,operationType);
        ResultVO resultVO = ResultVOUtil.success();
        return resultVO;
    }
    @GetMapping("/findByCondition")
    public ResultVO findByCondition( ProductConditiondto productConditiondto
            /*@Param("storeId") int storeId, @Param("productName")String productName,
                                    @Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                    @Param("pageNum") int pageNum, @Param("pageSize") int pageSize*/){
        Map<String,Object> productMap = productService.findByCondition(productConditiondto);
        ResultVO resultVO = ResultVOUtil.success(productMap);
        return resultVO;
    }
    @GetMapping("/findCates/{storeId}")
    public ResultVO findCates(@PathVariable int storeId){
        Map<String,Object> cateMap = productService.findCates(storeId);
        ResultVO resultVO = ResultVOUtil.success(cateMap);
        return resultVO;
    }
    @GetMapping("/findFreights/{storeId}")
    public ResultVO findFreights(@PathVariable int storeId){
        Map<String,Object> freMap = productService.findFreights(storeId);
        return ResultVOUtil.success(freMap);
    }
    @PostMapping("/changeFreight")
    public ResultVO changeFreight(@RequestBody Freight freight){
        if(freight.getFreId() != null){
            productService.updateFreight(freight);
        }
        productService.createFreight(freight);
        return ResultVOUtil.success();
    }
}
