package com.miquankj.api.service.impl;

import com.miquankj.api.dao.MtrlTypeMapper;
import com.miquankj.api.entity.MtrlType;
import com.miquankj.api.service.MtrlTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/15
 */
@Service
@Slf4j
public class MtrlTypeServiceImpl implements MtrlTypeService {
    @Autowired
    private MtrlTypeMapper mtrlTypeMapper;


    @Override
    public MtrlType findByGrpId(Integer grpId) {
        return mtrlTypeMapper.selectByGrpId(grpId);
    }
}
