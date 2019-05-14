package com.miquankj.api.dao;

import com.miquankj.api.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByCondition(Map<String,Object> map);

    Integer selectCountsByCondition(Map<String,Object> map);

    Integer changetOrderStatus(Map<String,Object> map);

    List<Order> selectOrdersByCondition(Map<String,Object> map);

    int selectCounts(Order order);
}