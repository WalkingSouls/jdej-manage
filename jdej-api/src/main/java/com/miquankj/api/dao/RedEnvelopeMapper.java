package com.miquankj.api.dao;


import com.miquankj.api.entity.RedEnvelope;

public interface RedEnvelopeMapper {
    int deleteByPrimaryKey(Integer redEnvId);

    int insert(RedEnvelope record);

    int insertSelective(RedEnvelope record);

    RedEnvelope selectByPrimaryKey(Integer redEnvId);

    int updateByPrimaryKeySelective(RedEnvelope record);

    int updateByPrimaryKeyWithBLOBs(RedEnvelope record);

    int updateByPrimaryKey(RedEnvelope record);
}