package com.vadmin.model.sys;

import com.vadmin.model.BaseModel;

import java.util.List;

public class Role extends BaseModel {

    private Long roleId;

    private String roleName;

    private String roleCode;

    private String status;

    private String remark;

    private List<Long> menuIds;

    private List<Long> organIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    public List<Long> getOrganIds() {
        return organIds;
    }

    public void setOrganIds(List<Long> organIds) {
        this.organIds = organIds;
    }
}
