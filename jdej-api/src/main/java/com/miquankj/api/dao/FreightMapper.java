package com.miquankj.api.dao;

import com.miquankj.api.entity.Freight;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FreightMapper {
    int deleteByPrimaryKey(Integer freId);

    int insert(Freight record);

    int insertSelective(Freight record);

    Freight selectByPrimaryKey(Integer freId);

    int updateByPrimaryKeySelective(Freight record);

    int updateByPrimaryKey(Freight record);

    List<Freight> selectFresByStoreId(int storeId);
}