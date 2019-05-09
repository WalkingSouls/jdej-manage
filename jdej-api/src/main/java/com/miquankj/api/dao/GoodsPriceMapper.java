package com.miquankj.api.dao;

import com.miquankj.api.entity.GoodsPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPrice record);

    int insertSelective(GoodsPrice record);

    GoodsPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsPrice record);

    int updateByPrimaryKey(GoodsPrice record);

    List<GoodsPrice> selectByGoodsId(Integer goodsId);
}