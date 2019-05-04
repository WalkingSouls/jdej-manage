package com.miquankj.api.service;


import com.miquankj.api.entity.Product;

public interface ProductService {

    void createNewPro(Product product);

    Product findOnePro(Integer productId);
}
