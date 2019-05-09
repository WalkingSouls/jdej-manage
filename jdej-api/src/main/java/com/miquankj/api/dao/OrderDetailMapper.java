package com.miquankj.api.dao;

import com.miquankj.api.entity.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Long detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long detailId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWithBLOBs(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}