package com.miquankj.api.service.impl;

import com.miquankj.api.dao.StoreMapper;
import com.miquankj.api.entity.Store;
import com.miquankj.api.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/6
 */
@Service
@Slf4j
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;


    @Override
    public Store findOne(Integer storeId) {
        return storeMapper.selectByPrimaryKey(storeId);
    }
}
