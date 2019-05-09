package com.miquankj.api.service.impl;

import com.miquankj.api.dao.BrandInfoMapper;
import com.miquankj.api.dto.Branddto;
import com.miquankj.api.entity.BrandInfo;
import com.miquankj.api.service.BrandInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/8
 */
@Service
@Slf4j
public class BrandInfoServiceImpl implements BrandInfoService {
    @Autowired
    private BrandInfoMapper brandInfoMapper;

    @Override
    public BrandInfo findOne(Integer id) {
        return brandInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> findBrands() {
        Map<String, Object> map = new HashMap<>();
        List<Branddto> brandList = brandInfoMapper.selectAllBrands();
        List<Branddto> parentBrands = new ArrayList<>();
        List<Branddto> sonBrands = new ArrayList<>();
        if (brandList != null || brandList.size() != 0) {
            brandList.forEach(
                    (x) -> {
                        if (x.getSubId() == 0) {
                            parentBrands.add(x);
                        } else {
                            sonBrands.add(x);
                        }
                    }
            );
            if (parentBrands.size() != 0 && sonBrands.size() != 0) {
                parentBrands.forEach(
                        (x) -> {
                            sonBrands.forEach(
                                    (y) -> {
                                        if (y.getSubId().equals(x.getId())) {
                                            x.getBranddtoList().add(y);
                                        }
                                    }
                            );
                        }
                );
            }
        }
        map.put("brandList", parentBrands);
        return map;
    }
}
