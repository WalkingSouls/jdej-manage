package com.miquankj.api.dao;


import com.miquankj.api.entity.ProductPicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductPictureMapper {
    int deleteByPrimaryKey(Integer proPicId);

    int insert(ProductPicture record);

    int insertSelective(ProductPicture record);

    ProductPicture selectByPrimaryKey(Integer proPicId);

    int updateByPrimaryKeySelective(ProductPicture record);

    int updateByPrimaryKey(ProductPicture record);

    List<ProductPicture> selectByProId(Integer productId);

    int deleteByProId(Integer productId);
}