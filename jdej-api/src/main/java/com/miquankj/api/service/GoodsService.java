package com.miquankj.api.service;

import com.miquankj.api.dto.GoodsConditiondto;
import com.miquankj.api.entity.Goods;

import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/8
 */
public interface GoodsService {
    Integer createNewGoods(Goods goods);

    Integer updateGoods(Goods goods);

    Goods findOneGoods(Integer goodsId);

    Map<String,Object> findAllPro(GoodsConditiondto conditiondto);

    Integer changeGoodsStatus(int storeId, int goodsId, int operationType);
}
