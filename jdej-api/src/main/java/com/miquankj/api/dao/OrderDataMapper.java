package com.miquankj.api.dao;

import com.miquankj.api.entity.OrderData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface OrderDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderData record);

    int insertSelective(OrderData record);

    OrderData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderData record);

    int updateByPrimaryKey(OrderData record);

//    OrderData selectByDate(@Param("storeId") int storeId,@Param("yesterday") Date yesterday);
//
//    List<OrderData> selectByDates(@Param("storeId") int storeId,@Param("begin") Date begin,@Param("end") Date end);

    OrderData selectByDate(Map<String,Object> map);

    List<OrderData> selectByDates(Map<String,Object> map);
}