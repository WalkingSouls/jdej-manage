package com.miquankj.api.service.impl;

import com.miquankj.api.dao.OrderDataMapper;
import com.miquankj.api.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
@Service
public class OrderDataServiceImpl implements OrderDataService {
    @Autowired
    private OrderDataMapper orderDataMapper;


}
