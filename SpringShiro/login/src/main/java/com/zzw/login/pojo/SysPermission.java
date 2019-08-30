package com.zzw.login.pojo;

public class SysPermission {
    private Integer permissionId;

    private String permissionCode;

    private String permissionName;

    private Integer permissionOrder;

    private String remark;

    private Byte menuPermissionFlag;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public Integer getPermissionOrder() {
        return permissionOrder;
    }

    public void setPermissionOrder(Integer permissionOrder) {
        this.permissionOrder = permissionOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getMenuPermissionFlag() {
        return menuPermissionFlag;
    }

    public void setMenuPermissionFlag(Byte menuPermissionFlag) {
        this.menuPermissionFlag = menuPermissionFlag;
    }
}