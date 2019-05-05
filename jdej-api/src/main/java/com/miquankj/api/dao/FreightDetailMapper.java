package com.miquankj.api.dao;

import com.miquankj.api.entity.FreightDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FreightDetailMapper {
    int deleteByPrimaryKey(Integer freDetailId);

    int insert(FreightDetail record);

    int insertSelective(FreightDetail record);

    FreightDetail selectByPrimaryKey(Integer freDetailId);

    int updateByPrimaryKeySelective(FreightDetail record);

    int updateByPrimaryKey(FreightDetail record);
}