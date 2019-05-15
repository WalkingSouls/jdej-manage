package com.miquankj.api.dao;

import com.miquankj.api.entity.Lending;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface LendingMapper {
    int deleteByPrimaryKey(Integer ledId);

    int insert(Lending record);

    int insertSelective(Lending record);

    Lending selectByPrimaryKey(Integer ledId);

    int updateByPrimaryKeySelective(Lending record);

    int updateByPrimaryKey(Lending record);

    List<Lending> selectByCon(Map<String,Object> map);

    int selectCounts(Map<String,Object> map);
}