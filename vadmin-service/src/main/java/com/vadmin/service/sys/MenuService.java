package com.vadmin.service.sys;

import com.vadmin.model.sys.Menu;
import com.vadmin.service.base.BaseService;

import java.util.List;

public interface MenuService extends BaseService<Menu, Long> {
    /**
     * 获取当前用户菜单路由
     * @author Grug
     * @date  2020/8/5 16:40
     * @param userId
     * @return java.util.List<com.vadmin.model.sys.Menu>
     */
    List<Menu> getMenuRoutersByUserId(long userId);
}
