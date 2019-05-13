package com.miquankj.api.dao;

import com.miquankj.api.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDetailMapper {
    int deleteByPrimaryKey(Long detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long detailId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWithBLOBs(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    List<OrderDetail> selectByOrderId(Integer orderId);

    List<OrderDetail> selectByOrderCondition(@Param("orderNum") String orderNum, @Param("proName") String proName);
}