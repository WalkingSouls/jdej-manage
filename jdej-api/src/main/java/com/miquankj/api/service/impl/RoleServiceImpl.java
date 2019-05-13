package com.miquankj.api.service.impl;

import com.miquankj.api.dao.RoleMapper;
import com.miquankj.api.entity.Role;
import com.miquankj.api.service.RoleServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/13
 */
@Service
public class RoleServiceImpl implements RoleServcie {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findRole(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
