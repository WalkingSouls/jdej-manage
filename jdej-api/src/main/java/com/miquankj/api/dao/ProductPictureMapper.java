package com.miquankj.api.dao;


import com.miquankj.api.entity.ProductPicture;

public interface ProductPictureMapper {
    int deleteByPrimaryKey(Integer proPicId);

    int insert(ProductPicture record);

    int insertSelective(ProductPicture record);

    ProductPicture selectByPrimaryKey(Integer proPicId);

    int updateByPrimaryKeySelective(ProductPicture record);

    int updateByPrimaryKey(ProductPicture record);
}