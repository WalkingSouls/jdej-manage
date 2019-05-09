package com.miquankj.api.dao;

import com.miquankj.api.entity.NoticeInfo;
import com.miquankj.api.entity.NoticeInfoWithBLOBs;

public interface NoticeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NoticeInfoWithBLOBs record);

    int insertSelective(NoticeInfoWithBLOBs record);

    NoticeInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoticeInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NoticeInfoWithBLOBs record);

    int updateByPrimaryKey(NoticeInfo record);
}