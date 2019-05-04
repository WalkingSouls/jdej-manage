package com.miquankj.api.entity;

public class RolePermission {
    private Integer rolePerId;

    private Integer roleId;

    private Integer permissionId;

    private Byte valid;

    public Integer getRolePerId() {
        return rolePerId;
    }

    public void setRolePerId(Integer rolePerId) {
        this.rolePerId = rolePerId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }
}