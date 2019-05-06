package com.miquankj.api.service.impl;


import com.miquankj.api.dao.*;
import com.miquankj.api.dto.ProductConditiondto;
import com.miquankj.api.dto.Productdto;
import com.miquankj.api.entity.*;
import com.miquankj.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductPictureMapper productPictureMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private FreightMapper freightMapper;
    @Autowired
    private FreightDetailMapper freightDetailMapper;

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

    @Transactional
    @Override
    public void updatePro(Product product) {
        Integer productId = product.getProductId();
        productPictureMapper.deleteByProId(productId);
        productMapper.deleteByPrimaryKey(productId);
        product.setUpdateTime(new Date());
        createNewPro(product);
    }

    @Override
    public Product findOnePro(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        List<ProductPicture> proPicList = productPictureMapper.selectByProId(productId);
        if ((null != proPicList || proPicList.size() != 0) && product != null) {
            product.setPictureList(proPicList);
        }
        return product;
    }

    @Override
    public Map<String, Object> findAllPro(Integer storeId, Integer listType, Integer pageNum, Integer pageSize) {
        //todo 分页存在问题
        Integer productCounts = productMapper.selectCountsByStoreId(storeId, listType);
        Integer startRecord = pageNum * pageSize;
        List<Productdto> productList = productMapper.selectByStoreId(storeId,listType, startRecord, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("counts",productCounts);
        map.put("productList",productList);
        return map;
    }

    @Override
    public void changetProStatus(int productId, int operationType) {
        productMapper.changeProStatus(productId,operationType);
    }

    @Override
    public Map<String, Object> findByCondition(ProductConditiondto proCondto) {
        return null;
    }

    @Override
    public Map<String, Object> findCates(int storeId) {
        HashMap<String, Object> cateMap = new HashMap<>();
        List<Category> categoryList = categoryMapper.selectCatesByStoreId(storeId);
        categoryList.forEach(e->cateMap.put(e.getCategoryId().toString(),e.getCategoryName()));
        return cateMap;
    }

    @Override
    public Map<String, Object> findFreights(int storeId) {
        HashMap<String, Object> freMap = new HashMap<>();
        List<Freight> freightList = freightMapper.selectFresByStoreId(storeId);
        freightList.forEach(e->freMap.put(e.getFreId().toString(),e.getName()));
        return freMap;
    }

    @Transactional
    @Override
    public void updateFreight(Freight freight) {
        Integer freId = freight.getFreId();
        freightDetailMapper.deleteByFreId(freId);
        freightMapper.deleteByPrimaryKey(freId);
        createFreight(freight);
    }

    @Transactional
    @Override
    public void createFreight(Freight freight) {
        freightMapper.insert(freight);
        List<FreightDetail> freightDetailList = freight.getFreightDetailList();
        if(freightDetailList != null || freightDetailList.size() != 0){
            for (FreightDetail freightDetail: freightDetailList) {
                freightDetail.setFreightId(freight.getFreId());
                freightDetailMapper.insert(freightDetail);
            }
        }

    }
}
