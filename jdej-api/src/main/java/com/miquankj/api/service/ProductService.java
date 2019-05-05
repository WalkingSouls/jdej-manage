package com.miquankj.api.service;


import com.miquankj.api.dto.ProductConditiondto;
import com.miquankj.api.entity.Freight;
import com.miquankj.api.entity.Product;
import com.miquankj.api.dto.Productdto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface ProductService {

    void createNewPro(Product product);

    Product findOnePro(Integer productId);

    Map<String,Object> findAllPro(Integer storeId, Integer listType, Integer pageNum, Integer pageSize);

    void updatePro(Product product);

    void changetProStatus(int productId, int operationType);

    Map<String,Object> findByCondition(ProductConditiondto proCondto);

    Map<String,Object> findCates(int storeId);

    Map<String,Object> findFreights(int storeId);

    void updateFreight(Freight freight);

    void createFreight(Freight freight);
}
