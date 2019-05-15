package com.miquankj.api.service;

import com.miquankj.api.entity.MtrlType;

/**
 * 店铺主营service
 * @author liuyadong
 * @since 2019/5/15
 */
public interface MtrlTypeService {
    MtrlType findByGrpId(Integer grpId);
}
