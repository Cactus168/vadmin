package com.vadmin.controller.sys;

import com.vadmin.common.annotation.Log;
import com.vadmin.controller.BaseController;
import com.vadmin.model.Rs;
import com.vadmin.model.sys.Role;
import com.vadmin.model.sys.RoleMenu;
import com.vadmin.model.sys.User;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.RoleService;
import com.vadmin.service.sys.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色管理Controller
 * @Auther: Grug
 * @Date: 2020/7/31 17:30
 */
@RestController
@RequestMapping("sys/role")
@Log(moduleName = "角色管理")
public class RoleController extends BaseController<Role, Long> {

    @Resource
    public RoleService roleService;
    
    /**
     * 获取角色已授权的菜单权限数据
     * @author Grug
     * @date  2020/8/13 16:29
     * @param roleId
     * @return com.vadmin.model.Rs
     */
    @GetMapping("/roleMenusOrgans/{roleId}")
    public Rs getMenusOrgansByRoleId(@PathVariable Long roleId){
        Rs rs = Rs.success();
        rs.put("menus",this.roleService.getMenuIdsByRoleId(roleId));
        rs.put("organs",this.roleService.getOrganIdsByRoleId(roleId));
        return rs;
    }

    /**
     * 给角色授权菜单权限
     * @author Grug
     * @date  2020/8/13 16:29
     * @param role
     * @return com.vadmin.model.Rs
     */
    @PostMapping("/roleMenus")
    @Log(operateType = "分配菜单权限")
    public Rs changeRoleMenus(@RequestBody Role role){
        return Rs.success(this.roleService.addRoleMenuIds(role));
    }

    /**
     * 给角色授权数据权限
     * @author Grug
     * @date  2020/8/13 16:29
     * @param role
     * @return com.vadmin.model.Rs
     */
    @PostMapping("/roleOrgans")
    @Log(operateType = "分配数据权限")
    public Rs changeRoleOrgans(@RequestBody Role role){
        return Rs.success(this.roleService.addRoleOrganIds(role));
    }

    @Override
    protected BaseService<Role, Long> service() {
        return this.roleService;
    }
}
