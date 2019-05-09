package com.miquankj.api.dao;

import com.miquankj.api.dto.Branddto;
import com.miquankj.api.entity.BrandInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BrandInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrandInfo record);

    int insertSelective(BrandInfo record);

    BrandInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrandInfo record);

    int updateByPrimaryKey(BrandInfo record);

    List<Branddto> selectAllBrands();
}