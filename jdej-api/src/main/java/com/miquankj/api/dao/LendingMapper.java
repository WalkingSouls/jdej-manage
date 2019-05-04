package com.miquankj.api.dao;


import com.miquankj.api.entity.Lending;

public interface LendingMapper {
    int deleteByPrimaryKey(Integer ledId);

    int insert(Lending record);

    int insertSelective(Lending record);

    Lending selectByPrimaryKey(Integer ledId);

    int updateByPrimaryKeySelective(Lending record);

    int updateByPrimaryKey(Lending record);
}