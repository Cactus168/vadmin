package com.vadmin.service.sys.impl;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.mapper.sys.MenuMapper;
import com.vadmin.model.sys.Menu;
import com.vadmin.service.base.BaseServiceImpl;
import com.vadmin.service.sys.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * MenuServiceImpl
 * @Auther: Grug
 * @Date: 2020/7/31 17:26
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu, Long> implements MenuService {

    @Resource
    public MenuMapper menuMapper;

    /**
     * 获取当前用户菜单路由
     * @author Grug
     * @date  2020/8/5 16:40
     * @param userId
     * @return java.util.List<com.vadmin.model.sys.Menu>
     */
    @Override
    public List<Menu> getMenuRoutersByUserId(long userId){
        return this.menuMapper.getMenuRoutersByUserId(userId);
    }

    @Override
    public BaseMapper<Menu, Long> mapper() {
        return this.menuMapper;
    }
}
