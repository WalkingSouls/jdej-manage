package com.miquankj.api.service.impl;

import com.miquankj.api.dao.LendingMapper;
import com.miquankj.api.dto.Lendingdto;
import com.miquankj.api.entity.Lending;
import com.miquankj.api.service.LendingService;
import com.miquankj.api.utils.MapUtil;
import com.miquankj.api.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/15
 */
@Service
@Slf4j
public class LendingServiceImpl implements LendingService {
    @Autowired
    private LendingMapper lendingMapper;


    @Override
    public Map<String, Object> findByCon(Lendingdto lendingdto) {
        int startRecord = lendingdto.getPageNum() * lendingdto.getPageSize();
        Map<String, Object> map = MapUtil.entityToMap(lendingdto);
        int totalRecord = lendingMapper.selectCounts(map);
        map.put("startRecord",startRecord);
        List<Lending> lendingList = lendingMapper.selectByCon(map);
        PageUtil<Lending> pageUtil = new PageUtil<>();
        Map<String, Object> mapTemp = pageUtil.objectPageToMap(lendingdto.getPageNum(), lendingdto.getPageSize(),
                totalRecord, lendingList);
        return mapTemp;
    }
}
