package com.miquankj.api.service;

import com.miquankj.api.entity.Freight;
import com.miquankj.api.entity.Store;

/**
 * @author liuyadong
 * @since 2019/5/6
 */
public interface FreightService {
    Freight findOne(Integer freightId);
}
