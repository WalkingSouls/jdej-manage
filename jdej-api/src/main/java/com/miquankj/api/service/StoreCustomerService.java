package com.miquankj.api.service;

import com.miquankj.api.dto.Customerdto;

import java.util.List;

/**
 * 客户店铺中间表
 * @author liuyadong
 * @since 2019/5/13
 */
public interface StoreCustomerService {
    List<Integer> findCusIds(Integer storeId, Integer listType);

    List<Integer> findCusByCondition(Customerdto customerdto);
}
