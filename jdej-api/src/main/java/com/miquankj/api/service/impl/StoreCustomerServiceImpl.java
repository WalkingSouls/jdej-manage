package com.miquankj.api.service.impl;

import com.miquankj.api.dao.StoreCustomerMapper;
import com.miquankj.api.dto.Applydto;
import com.miquankj.api.dto.Condto;
import com.miquankj.api.dto.CusCondidto;
import com.miquankj.api.dto.Dealerdto;
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
    public List<Integer> findCusByCondition(CusCondidto customerdto) {
        Map<String, Object> map = MapUtil.entityToMap(customerdto);
        List<Integer>  ids = storeCustomerMapper.selectCusByCondition(map);
        return ids;
    }

    @Override
    public int findCountById(int storeId, int isApply) {
        int applyAmount = storeCustomerMapper.selectCountById(storeId,isApply);
        return applyAmount;
    }

    @Override
    public List<Integer> findCusIdsCon(Condto consumerdto) {
        Map<String, Object> map = MapUtil.entityToMap(consumerdto);
        List<Integer> ids = storeCustomerMapper.selectCusCon(map);
        return ids;
    }

    @Override
    public List<Integer> findCusIds(Dealerdto dealerdto) {
        Map<String, Object> map = MapUtil.entityToMap(dealerdto);
        List<Integer>  ids = storeCustomerMapper.selectCusIds(map);
        return ids;
    }

    @Override
    public List<Integer> findCusIdsApply(Applydto applydto, int isApply) {
        Map<String, Object> map = MapUtil.entityToMap(applydto);
        map.put("isApply",isApply);
        List<Integer>  ids = storeCustomerMapper.selectCusIdsApply(map);
        return ids;
    }
}
