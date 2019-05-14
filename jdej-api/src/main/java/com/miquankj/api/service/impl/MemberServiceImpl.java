package com.miquankj.api.service.impl;

import com.miquankj.api.dao.GrpInfoMapper;
import com.miquankj.api.dto.*;
import com.miquankj.api.service.MemberService;
import com.miquankj.api.utils.MapUtil;
import com.miquankj.api.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private GrpInfoMapper grpInfoMapper;

    @Override
    public Map<String, Object> findCusByCon(List<Integer> cusIds, Condto consumerdto) {
        Map<String, Object> map = MapUtil.entityToMap(consumerdto);
        Integer totalRecord = cusIds.size();
        ArrayList<ConReturndto> grpInfoList = new ArrayList<>();
        Integer pageNum = consumerdto.getPageNum();
        Integer pageSize = consumerdto.getPageSize();
        Integer length = pageSize >= cusIds.size() ? cusIds.size() : pageSize;
        for (int i = pageNum * pageSize; i < length; i++) {
            map.put("customerId",cusIds.get(i));
            ConReturndto grpInfo = grpInfoMapper.selectByCon(map);
            grpInfoList.add(grpInfo);
        }
        PageUtil<ConReturndto> grpInfoPageUtil = new PageUtil<>();
        Map<String, Object> grpInfoMap = grpInfoPageUtil.objectPageToMap(pageNum, pageSize, totalRecord, grpInfoList);
        return grpInfoMap;
    }

    @Override
    public Map<String, Object> findCusByDealer(List<Integer> cusIds, Dealerdto dealerdto) {
        Map<String, Object> map = MapUtil.entityToMap(dealerdto);
        Integer totalRecord = cusIds.size();
        ArrayList<DealerReturndto> grpInfoList = new ArrayList<>();
        Integer pageNum = dealerdto.getPageNum();
        Integer pageSize = dealerdto.getPageSize();
        Integer length = pageSize >= cusIds.size() ? cusIds.size() : pageSize;
        for (int i = pageNum * pageSize; i < length; i++) {
            map.put("customerId",cusIds.get(i));
            DealerReturndto grpInfo = grpInfoMapper.selectByDealer(map);
            grpInfoList.add(grpInfo);
        }
        PageUtil<DealerReturndto> grpInfoPageUtil = new PageUtil<>();
        Map<String, Object> grpInfoMap = grpInfoPageUtil.objectPageToMap(pageNum, pageSize, totalRecord, grpInfoList);
        return grpInfoMap;
    }

    @Override
    public Map<String, Object> findCusByApply(List<Integer> cusIds, Applydto applydto) {
        Map<String, Object> map = MapUtil.entityToMap(applydto);
        Integer totalRecord = cusIds.size();
        ArrayList<ApplyReturndto> grpInfoList = new ArrayList<>();
        Integer pageNum = applydto.getPageNum();
        Integer pageSize = applydto.getPageSize();
        Integer length = pageSize >= cusIds.size() ? cusIds.size() : pageSize;
        for (int i = pageNum * pageSize; i < length; i++) {
            map.put("customerId", cusIds.get(i));
            ApplyReturndto grpInfo = grpInfoMapper.selectByApply(map);
            grpInfoList.add(grpInfo);
        }
        PageUtil<ApplyReturndto> grpInfoPageUtil = new PageUtil<>();
        Map<String, Object> grpInfoMap = grpInfoPageUtil.objectPageToMap(pageNum, pageSize, totalRecord, grpInfoList);
        return grpInfoMap;
//        return  null;
    }

    @Override
    public ApplyDetaildto findByPK(Integer customerId) {
        return grpInfoMapper.selectByPK(customerId);
    }
}
