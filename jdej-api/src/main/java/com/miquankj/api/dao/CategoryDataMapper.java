package com.miquankj.api.dao;


import com.miquankj.api.entity.CategoryData;

import java.util.Date;

public interface CategoryDataMapper {
    int deleteByPrimaryKey(Date cateDate);

    int insert(CategoryData record);

    int insertSelective(CategoryData record);

    CategoryData selectByPrimaryKey(Date cateDate);

    int updateByPrimaryKeySelective(CategoryData record);

    int updateByPrimaryKey(CategoryData record);
}