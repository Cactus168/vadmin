package com.vadmin.controller;

import com.vadmin.model.BaseModel;
import com.vadmin.model.LoginUser;
import com.vadmin.model.Rs;
import com.vadmin.model.sys.Menu;
import com.vadmin.router.Router;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * LoginController
 *
 * @auther: Grug
 * @date: 2020/8/11 17:54
 */
@RestController
public class LoginController extends BaseController<BaseModel, Long> {

    @Resource
    public MenuService menuService;

    /**
     * 获取当前用户相关信息
     * @author Grug
     * @date  2020/7/31 10:15
     * @return com.vadmin.model.Rs
     */
    @GetMapping("/getInfo")
    public Rs getInfo(){
        LoginUser loginUser = getLoginUser();
        Rs rs = Rs.success(loginUser.getUser());
        rs.put("roles",loginUser.getRoles());
        rs.put("permissions",loginUser.getPermissions());
        return rs;
    }

    /**
     * 获取路由
     * @author Grug
     * @date  2020/7/31 10:15
     * @return com.vadmin.model.Rs
     */
    @GetMapping("/getRouters")
    public Rs getRouters(){
        List<Menu> menus = this.menuService.getMenuRoutersByUserId(getUserId());
        Rs rs = Rs.success(Router.buildMenus(Router.getChildPerms(menus, 0)));
        return rs;
    }

    @Override
    protected BaseService<BaseModel, Long> service() {
        return null;
    }
}
