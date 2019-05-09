package com.miquankj.api.service;

import com.miquankj.api.entity.BrandInfo;
import com.miquankj.api.entity.Store;

import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/8
 */
public interface BrandInfoService {
    BrandInfo findOne(Integer id);

    Map<String,Object> findBrands();
}
