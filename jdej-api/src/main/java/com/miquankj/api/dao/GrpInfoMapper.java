package com.miquankj.api.dao;

import com.miquankj.api.dto.ApplyDetaildto;
import com.miquankj.api.dto.ApplyReturndto;
import com.miquankj.api.dto.ConReturndto;
import com.miquankj.api.dto.DealerReturndto;
import com.miquankj.api.entity.GrpInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface GrpInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GrpInfo record);

    int insertSelective(GrpInfo record);

    GrpInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrpInfo record);

    int updateByPrimaryKeyWithBLOBs(GrpInfo record);

    int updateByPrimaryKey(GrpInfo record);

    ConReturndto selectByCon(Map<String,Object> map);

    DealerReturndto selectByDealer(Map<String,Object> map);

    ApplyReturndto selectByApply(Map<String,Object> map);

    ApplyDetaildto selectByPK(Integer customerId);
}