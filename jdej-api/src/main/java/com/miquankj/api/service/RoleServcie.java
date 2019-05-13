package com.miquankj.api.service;

import com.miquankj.api.entity.Role;

/**
 * 角色权限service
 * @author liuyadong
 * @since 2019/5/13
 */
public interface RoleServcie {
    Role findRole(Integer roleId);
}
