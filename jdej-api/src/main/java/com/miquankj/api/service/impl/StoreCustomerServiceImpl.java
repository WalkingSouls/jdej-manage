package com.miquankj.api.service.impl;

import com.miquankj.api.dao.StoreCustomerMapper;
import com.miquankj.api.dto.CusCondidto;
import com.miquankj.api.service.StoreCustomerService;
import com.miquankj.api.utils.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
@Service
@Slf4j
public class StoreCustomerServiceImpl implements StoreCustomerService {
    @Autowired
    private StoreCustomerMapper storeCustomerMapper;

    @Override
    public List<Integer> findCusIds(Integer storeId, Integer listType) {
        List<Integer>  Ids = storeCustomerMapper.selectCusIds(storeId, listType);
        return Ids;
    }

    @Override
    public List<Integer> findCusByCondition(CusCondidto customerdto) {
        Map<String, Object> map = MapUtil.entityToMap(customerdto);
        List<Integer>  Ids = storeCustomerMapper.selectCusByCondition(map);
        return Ids;
    }

    @Override
    public int findCountById(int storeId, int isApply) {
        int applyAmount = storeCustomerMapper.selectCountById(storeId,isApply);
        return applyAmount;
    }
}
