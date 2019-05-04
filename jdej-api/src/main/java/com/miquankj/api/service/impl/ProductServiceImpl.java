package com.miquankj.api.service.impl;


import com.miquankj.api.dao.ProductMapper;
import com.miquankj.api.entity.Product;
import com.miquankj.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void createNewPro(Product product) {
        productMapper.insert(product);
    }

    @Override
    public Product findOnePro(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }
}
