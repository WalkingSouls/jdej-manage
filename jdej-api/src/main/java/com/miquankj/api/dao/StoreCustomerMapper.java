package com.miquankj.api.dao;

import com.miquankj.api.entity.StoreCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface StoreCustomerMapper {
    int deleteByPrimaryKey(Integer stoCusId);

    int insert(StoreCustomer record);

    int insertSelective(StoreCustomer record);

    StoreCustomer selectByPrimaryKey(Integer stoCusId);

    int updateByPrimaryKeySelective(StoreCustomer record);

    int updateByPrimaryKey(StoreCustomer record);

    List<Integer> selectCusIds(@Param("storeId") Integer storeId,@Param("listType") Integer listType);

    List<Integer> selectCusByCondition(Map<String,Object> map);
}