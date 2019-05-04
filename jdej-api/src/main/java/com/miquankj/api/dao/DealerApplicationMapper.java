package com.miquankj.api.dao;


import com.miquankj.api.entity.DealerApplication;

public interface DealerApplicationMapper {
    int deleteByPrimaryKey(Integer num);

    int insert(DealerApplication record);

    int insertSelective(DealerApplication record);

    DealerApplication selectByPrimaryKey(Integer num);

    int updateByPrimaryKeySelective(DealerApplication record);

    int updateByPrimaryKey(DealerApplication record);
}