package com.miquankj.api.dao;

import com.miquankj.api.entity.GrpInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GrpInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GrpInfo record);

    int insertSelective(GrpInfo record);

    GrpInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrpInfo record);

    int updateByPrimaryKeyWithBLOBs(GrpInfo record);

    int updateByPrimaryKey(GrpInfo record);

}