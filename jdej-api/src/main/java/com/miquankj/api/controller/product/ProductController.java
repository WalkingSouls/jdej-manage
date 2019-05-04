package com.miquankj.api.controller.product;

import com.miquankj.api.entity.Product;
import com.miquankj.api.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 商品controller
 *
 * @author liuyadong
 * @since 2019/5/4
 */
@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/createNewPro")
    public void createNewPro(@RequestBody Product product){
        productService.createNewPro(product);
    }

    @GetMapping("/selectOne/{productId}")
    @ResponseBody
    public Product findOnePro(@PathVariable Integer productId){
        Product product = productService.findOnePro(productId);
        return product;
    }
}
