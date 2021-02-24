package com.vadmin.model.sys;

/**
 * RoleMenu
 *
 * @auther: Grug
 * @date: 2020/8/13 16:06
 */
public class RoleMenu {

    private Long roleId;

    private Long menuId;

    public RoleMenu(Long roleId, Long menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
