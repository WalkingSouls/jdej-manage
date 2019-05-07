package com.miquankj.api.service;

import com.miquankj.api.entity.RedEnvelope;

import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/7
 */
public interface RedEnvelopeService {

    RedEnvelope findOneByName(int storeId, int redEnvId);

    Map<String,Object> findRedEnvsByStatus(int storeId, int status);
}
