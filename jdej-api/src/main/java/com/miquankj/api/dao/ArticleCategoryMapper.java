package com.miquankj.api.dao;


import com.miquankj.api.entity.ArticleCategory;

public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(Integer catId);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    ArticleCategory selectByPrimaryKey(Integer catId);

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);
}