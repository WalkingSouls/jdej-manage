package com.miquankj.api.service;

import com.miquankj.api.dto.Lendingdto;

import java.util.Map;

/**
 * 借贷service
 * @author liuyadong
 * @since 2019/5/15
 */
public interface LendingService {
    Map<String,Object> findByCon(Lendingdto lendingdto);
}
