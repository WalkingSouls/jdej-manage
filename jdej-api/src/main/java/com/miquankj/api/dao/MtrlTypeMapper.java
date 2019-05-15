package com.miquankj.api.dao;

import com.miquankj.api.entity.MtrlType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MtrlTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MtrlType record);

    int insertSelective(MtrlType record);

    MtrlType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MtrlType record);

    int updateByPrimaryKey(MtrlType record);

    MtrlType selectByGrpId(Integer grpId);
}