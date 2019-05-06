package com.miquankj.api.service.impl;


import com.miquankj.api.dao.ProductMapper;
import com.miquankj.api.dao.ProductPictureMapper;
import com.miquankj.api.dto.ProductConditiondto;
import com.miquankj.api.entity.Freight;
import com.miquankj.api.entity.Product;
import com.miquankj.api.entity.ProductPicture;
import com.miquankj.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductPictureMapper productPictureMapper;

    @Transactional
    @Override
    public void createNewPro(Product product) {
        productMapper.insert(product);
        List<ProductPicture> pictureList = product.getPictureList();
        if (pictureList != null || pictureList.size() != 0) {
//            pictureList.forEach(e -> productPictureMapper.insert(e));
            for (ProductPicture productPicture : pictureList) {
                productPicture.setProductId(product.getProductId());
                productPictureMapper.insert(productPicture);
            }
        }
    }

    @Override
    public Product findOnePro(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        List<ProductPicture> proPicList = productPictureMapper.selectByProId(productId);
        if(null != proPicList || proPicList.size() != 0){
            product.setPictureList(proPicList);
        }
        return product;
    }

    @Override
    public Map<String, Object> findAllPro(Integer storeId, Integer listType, Integer pageNum, Integer pageSize) {

        return null;
    }

    @Transactional
    @Override
    public void updatePro(Product product) {
        productMapper.deleteByPrimaryKey(product.getProductId());
        createNewPro(product);
    }

    @Override
    public void changetProStatus(int productId, int operationType) {

    }

    @Override
    public Map<String, Object> findByCondition(ProductConditiondto proCondto) {
        return null;
    }

    @Override
    public Map<String, Object> findCates(int storeId) {
        return null;
    }

    @Override
    public Map<String, Object> findFreights(int storeId) {
        return null;
    }

    @Override
    public void updateFreight(Freight freight) {

    }

    @Override
    public void createFreight(Freight freight) {

    }
}
