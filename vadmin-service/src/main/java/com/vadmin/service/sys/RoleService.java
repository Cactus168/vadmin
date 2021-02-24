package com.vadmin.service.sys;

import com.vadmin.model.sys.Role;
import com.vadmin.model.sys.RoleMenu;
import com.vadmin.service.base.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role, Long> {

    /**
     * 给角色分配菜单权限
     * @author Grug
     * @date  2020/8/13 16:10
     * @param role
     * @return int
     */
    int addRoleMenuIds(Role role);

    /**
     * 根据角色id删除菜单权限
     * @author Grug
     * @date  2020/8/13 16:11
     * @param roleId
     * @return int
     */
    int removeMenusByRoleId(Long roleId);

    /**
     * 根据角色id获取该角色拥有的菜单权限id
     * @author Grug
     * @date  2020/8/13 16:12
     * @param roleId
     * @return java.util.List<java.lang.Long>
     */
    List<Long> getMenuIdsByRoleId(Long roleId);

    /**
     * 给角色分配数据权限
     * @author Grug
     * @date  2020/8/13 16:10
     * @param role
     * @return int
     */
    int addRoleOrganIds(Role role);

    /**
     * 根据角色id删除数据访问权限
     * @author Grug
     * @date  2020/8/13 16:11
     * @param roleId
     * @return int
     */
    int removeOrgansByRoleId(Long roleId);

    /**
     * 根据角色id获取该角色拥有的数据权限id
     * @author Grug
     * @date  2020/8/13 16:12
     * @param roleId
     * @return java.util.List<java.lang.Long>
     */
    List<Long> getOrganIdsByRoleId(Long roleId);
}
