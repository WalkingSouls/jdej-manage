package com.miquankj.api.dao;

import com.miquankj.api.dto.Goodsdto;
import com.miquankj.api.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods goods);

    int insertSelective(Goods goods);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods goods);

    int updateByPrimaryKeyWithBLOBs(Goods goods);

    int updateByPrimaryKey(Goods goods);

    Integer selectCountsByCondition(Map<String,Object> goodsMap);

    List<Goodsdto> selectByCondition(Map<String, Object> goodsMap);

    Integer changetGoodsStatus(HashMap<String,Object> map);
}