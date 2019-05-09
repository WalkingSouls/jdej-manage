package com.miquankj.api.service.impl;

import com.miquankj.api.dao.GoodsPriceMapper;
import com.miquankj.api.service.GoodsPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/8
 */
@Slf4j
@Service
public class GoodsPriceServiceImpl implements GoodsPriceService {
    @Autowired
    private GoodsPriceMapper goodsPriceMapper;
}
