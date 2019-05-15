package com.miquankj.api.service;

import com.miquankj.api.dto.Applydto;
import com.miquankj.api.dto.Condto;
import com.miquankj.api.dto.CusCondidto;
import com.miquankj.api.dto.Dealerdto;

import java.util.List;

/**
 * 客户店铺中间表
 * @author liuyadong
 * @since 2019/5/13
 */
public interface StoreCustomerService {

    List<Integer> findCusByCondition(CusCondidto customerdto);

    int findCountById(int storeId, int isApply);

    List<Integer> findCusIdsCon(Condto consumerdto);

    List<Integer> findCusIds(Dealerdto dealerdto);

    List<Integer> findCusIdsApply(Applydto applydto, int isApply);
}
