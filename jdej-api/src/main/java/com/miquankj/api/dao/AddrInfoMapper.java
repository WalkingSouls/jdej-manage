package com.miquankj.api.dao;

import com.miquankj.api.entity.AddrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AddrInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddrInfo record);

    int insertSelective(AddrInfo record);

    AddrInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddrInfo record);

    int updateByPrimaryKey(AddrInfo record);
}