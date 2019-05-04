package com.miquankj.api.dao;


import com.miquankj.api.entity.WholeSale;

public interface WholeSaleMapper {
    int deleteByPrimaryKey(Integer saleId);

    int insert(WholeSale record);

    int insertSelective(WholeSale record);

    WholeSale selectByPrimaryKey(Integer saleId);

    int updateByPrimaryKeySelective(WholeSale record);

    int updateByPrimaryKey(WholeSale record);
}