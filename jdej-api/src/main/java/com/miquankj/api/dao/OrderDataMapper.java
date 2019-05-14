package com.miquankj.api.dao;

import com.miquankj.api.entity.OrderData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface OrderDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderData record);

    int insertSelective(OrderData record);

    OrderData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderData record);

    int updateByPrimaryKey(OrderData record);

    OrderData selectByDate(int storeId, Date yesterday);

    List<OrderData> selectByDates(int storeId, Date begin, Date end);
}