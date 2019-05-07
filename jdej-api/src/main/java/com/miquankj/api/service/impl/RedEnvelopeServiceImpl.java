package com.miquankj.api.service.impl;

import com.miquankj.api.dao.RedEnvelopeMapper;
import com.miquankj.api.entity.RedEnvelope;
import com.miquankj.api.service.RedEnvelopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/7
 */
@Service
public class RedEnvelopeServiceImpl implements RedEnvelopeService {
    @Autowired
    private RedEnvelopeMapper redEnvelopeMapper;


    @Override
    public RedEnvelope findOneByName(int storeId, int redEnvId) {
        return null;
    }
}
