package com.miquankj.api.service;

import com.miquankj.api.dto.ApplyDetaildto;
import com.miquankj.api.dto.Applydto;
import com.miquankj.api.dto.Condto;
import com.miquankj.api.dto.Dealerdto;
import com.miquankj.api.entity.GrpInfo;

import java.util.List;
import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
public interface MemberService {

    Map<String,Object> findCusByCon(List<Integer> cusIds, Condto consumerdto);

    Map<String,Object> findCusByDealer(List<Integer> cusIds, Dealerdto dealerdto);

    Map<String,Object> findCusByApply(List<Integer> cusIds, Applydto applydto);

    ApplyDetaildto findByPK(Integer customerId);
}
