package com.miquankj.api.service.impl;

import com.miquankj.api.dao.BrandInfoMapper;
import com.miquankj.api.dao.GoodsMapper;
import com.miquankj.api.dao.GoodsPriceMapper;
import com.miquankj.api.dao.StoreMapper;
import com.miquankj.api.dto.GoodsConditiondto;
import com.miquankj.api.dto.Goodsdto;
import com.miquankj.api.entity.Goods;
import com.miquankj.api.entity.GoodsPrice;
import com.miquankj.api.service.GoodsService;
import com.miquankj.api.utils.MapUtil;
import com.miquankj.api.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author liuyadong
 * @since 2019/5/8
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsPriceMapper goodsPriceMapper;

    @Autowired
    private BrandInfoMapper brandInfoMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Transactional
    @Override
    public Integer createNewGoods(Goods goods) {
        // todo goods.setAddCli(); 设置商品录入人
        goodsMapper.insertSelective(goods);
        createNewGoodsPrice(goods);
        return 1;
    }

    private void createNewGoodsPrice(Goods goods) {
        List<GoodsPrice> goodsPriceList = goods.getGoodsPriceList();
        if (goodsPriceList != null || goodsPriceList.size() != 0) {
            goodsPriceList.forEach((x) -> {
                x.setCmsId(goods.getId());
                goodsPriceMapper.insertSelective(x);
            });
        }
    }

    @Transactional
    @Override
    public Integer updateGoods(Goods goods) {
        goodsMapper.deleteByPrimaryKey(goods.getId());
        List<GoodsPrice> goodsPriceList = goods.getGoodsPriceList();
        if(goodsPriceList.size() != 0){
            goodsPriceList.forEach(x->goodsPriceMapper.deleteByPrimaryKey(x.getId()));
        }
        // todo goods.setUpdateCli(); 设置商品修改人
        goods.setUpdateDate(new Date());
        goodsMapper.insert(goods);
        createNewGoodsPrice(goods);
        return 1;
    }

    @Transactional
    @Override
    public Goods findOneGoods(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        List<GoodsPrice> goodsPriceList = goodsPriceMapper.selectByGoodsId(goodsId);
        if (goodsPriceList.size() != 0) {
            goods.setGoodsPriceList(goodsPriceList);
        }
        return goods;
    }

    @Transactional
    @Override
    public Map<String, Object> findAllPro(GoodsConditiondto conditiondto) {
        Map<String, Object> goodsMap = MapUtil.entityToMap(conditiondto);
        int startRecord = conditiondto.getPageNum() * conditiondto.getPageSize();
        goodsMap.put("startRecord",startRecord);
        Integer totalRecord = goodsMapper.selectCountsByCondition(goodsMap);
        List<Goodsdto> goodsList = goodsMapper.selectByCondition(goodsMap);
        int pageNum = conditiondto.getPageNum();
        int pageSize = conditiondto.getPageSize();
        Map<String, Object> map = PageUtil.goodsPageToMap(pageNum, pageSize, totalRecord, goodsList);
        System.out.println("_____________________"+map.size());
        return map;
    }

    @Transactional
    @Override
    public Integer changeGoodsStatus(int storeId, int goodsId, int operationType) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("storeId", storeId);
        map.put("goodsId", goodsId);
        map.put("updateTime",new Date());
        // todo map.put("updateMan",); 添加修改人
        if(operationType != 2 && operationType != -2){
            map.put("state",operationType);
            map.put("recommend",null);
            goodsMapper.changetGoodsStatus(map);
        }else{
            int operation = operationType == 2 ? 1 : 0;
            String recommend = String.valueOf(operation);
            map.put("state",null);
            map.put("recommend",recommend);
            goodsMapper.changetGoodsStatus(map);
        }
        return 1;
    }

}
