package com.vadmin.mapper.sys;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.model.sys.Menu;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Set;

/**
 * MenuMapper
 *
 * @Auther: Grug
 * @Date: 2020/7/31 16:21
 */
public interface MenuMapper extends BaseMapper<Menu, Long> {

    /**
     * 获取当前用户的所属角色
     * @author Grug
     * @date  2020/8/5 16:40
     * @param userId
     * @return java.util.Set<java.lang.String>
     */
    Set<String> getMenuPermsByUserId(long userId);

    /**
     * 获取当前用户菜单路由
     * @author Grug
     * @date  2020/8/5 16:40
     * @param userId
     * @return java.util.List<com.vadmin.model.sys.Menu>
     */
    List<Menu> getMenuRoutersByUserId(long userId);
}
