package com.miquankj.api.entity;

public class Permission {
    private Integer permissionId;

    private Byte indexMan;

    private Byte userMan;

    private Byte productMan;

    private Byte orderMan;

    private Byte marktingMan;

    private Byte lendingMan;

    private Byte dataCenter;

    private Byte adminMan;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Byte getIndexMan() {
        return indexMan;
    }

    public void setIndexMan(Byte indexMan) {
        this.indexMan = indexMan;
    }

    public Byte getUserMan() {
        return userMan;
    }

    public void setUserMan(Byte userMan) {
        this.userMan = userMan;
    }

    public Byte getProductMan() {
        return productMan;
    }

    public void setProductMan(Byte productMan) {
        this.productMan = productMan;
    }

    public Byte getOrderMan() {
        return orderMan;
    }

    public void setOrderMan(Byte orderMan) {
        this.orderMan = orderMan;
    }

    public Byte getMarktingMan() {
        return marktingMan;
    }

    public void setMarktingMan(Byte marktingMan) {
        this.marktingMan = marktingMan;
    }

    public Byte getLendingMan() {
        return lendingMan;
    }

    public void setLendingMan(Byte lendingMan) {
        this.lendingMan = lendingMan;
    }

    public Byte getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(Byte dataCenter) {
        this.dataCenter = dataCenter;
    }

    public Byte getAdminMan() {
        return adminMan;
    }

    public void setAdminMan(Byte adminMan) {
        this.adminMan = adminMan;
    }
}