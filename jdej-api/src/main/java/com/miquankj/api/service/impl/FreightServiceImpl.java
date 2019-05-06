package com.miquankj.api.service.impl;

import com.miquankj.api.dao.FreightMapper;
import com.miquankj.api.entity.Freight;
import com.miquankj.api.service.FreightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/6
 */
@Service
@Slf4j
public class FreightServiceImpl implements FreightService {
    @Autowired
    private FreightMapper freightMapper;

    @Override
    public Freight findOne(Integer freightId) {
        return freightMapper.selectByPrimaryKey(freightId);
    }
}
