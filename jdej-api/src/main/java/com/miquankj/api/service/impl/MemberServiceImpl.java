package com.miquankj.api.service.impl;

import com.miquankj.api.dao.GrpInfoMapper;
import com.miquankj.api.entity.GrpInfo;
import com.miquankj.api.service.MemberService;
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
    public Map<String, Object> findCustomersByIds(List<Integer> cusIdList, Integer pageNum, Integer pageSize) {
        Integer totalRecord = cusIdList.size();
        ArrayList<GrpInfo> grpInfoList = new ArrayList<>();
        for (int i = pageNum * pageSize; i <= pageSize; i++) {
            GrpInfo grpInfo = grpInfoMapper.selectByPrimaryKey(cusIdList.get(i));
            grpInfoList.add(grpInfo);
        }
        PageUtil<GrpInfo> grpInfoPageUtil = new PageUtil<GrpInfo>();
        Map<String, Object> map = grpInfoPageUtil.objectPageToMap(pageNum, pageSize, totalRecord, grpInfoList);
        return map;
    }

    @Override
    public GrpInfo findApplyDetail(Integer storeId, Integer cliId) {
        GrpInfo grpInfo = grpInfoMapper.selectByPrimaryKey(cliId);
        return grpInfo;
    }
}
