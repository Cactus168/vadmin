package com.vadmin.service.sys.impl;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.mapper.sys.RoleMapper;
import com.vadmin.mapper.sys.UserMapper;
import com.vadmin.model.sys.Role;
import com.vadmin.model.sys.RoleMenu;
import com.vadmin.model.sys.User;
import com.vadmin.service.base.BaseServiceImpl;
import com.vadmin.service.sys.RoleService;
import com.vadmin.service.sys.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * UserServiceImpl
 * @Auther: Grug
 * @Date: 2020/7/31 11:19
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

    @Resource
    public RoleMapper roleMapper;

    /**
     * 给角色分配菜单权限
     * @author Grug
     * @date  2020/8/13 16:10
     * @param role
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addRoleMenuIds(Role role){
        this.roleMapper.removeMenusByRoleId(role.getRoleId());
        if(role.getMenuIds().size() > 0){
            return this.roleMapper.addRoleMenuIds(role);
        }
        return 0;
    }

    /**
     * 根据角色id删除菜单权限
     * @author Grug
     * @date  2020/8/13 16:11
     * @param roleId
     * @return int
     */
    @Override
    public int removeMenusByRoleId(Long roleId){
        return this.roleMapper.removeMenusByRoleId(roleId);
    }

    /**
     * 根据角色id获取该角色拥有的菜单权限id
     * @author Grug
     * @date  2020/8/13 16:12
     * @param roleId
     * @return java.util.List<java.lang.Long>
     */
    @Override
    public List<Long> getMenuIdsByRoleId(Long roleId){
       return this.roleMapper.getMenuIdsByRoleId(roleId);
    }

    /**
     * 给角色分配数据访问权限
     * @author Grug
     * @date  2020/8/13 16:10
     * @param role
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addRoleOrganIds(Role role){
        this.roleMapper.removeOrgansByRoleId(role.getRoleId());
        if(role.getOrganIds().size() > 0){
            return this.roleMapper.addRoleOrganIds(role);
        }
        return 0;
    }

    /**
     * 根据角色id删除数据权限
     * @author Grug
     * @date  2020/8/13 16:11
     * @param roleId
     * @return int
     */
    @Override
    public int removeOrgansByRoleId(Long roleId){
        return this.roleMapper.removeOrgansByRoleId(roleId);
    }

    /**
     * 根据角色id获取该角色拥有的数据访问权限id
     * @author Grug
     * @date  2020/8/13 16:12
     * @param roleId
     * @return java.util.List<java.lang.Long>
     */
    @Override
    public List<Long> getOrganIdsByRoleId(Long roleId){
        return this.roleMapper.getOrganIdsByRoleId(roleId);
    }

    @Override
    public BaseMapper<Role, Long> mapper() {
        return this.roleMapper;
    }
}