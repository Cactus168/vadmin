package com.vadmin.service.login.impl;
import com.vadmin.mapper.sys.MenuMapper;
import com.vadmin.mapper.sys.OrganMapper;
import com.vadmin.mapper.sys.UserMapper;
import com.vadmin.model.LoginUser;
import com.vadmin.model.sys.Role;
import com.vadmin.model.sys.User;
import com.vadmin.service.login.LoginService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * LoginService 实现类
 * @Auther: Grug
 * @Date: 2020/7/31 15:44
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    public UserMapper userMapper;

    @Resource
    public MenuMapper menuMapper;

    @Resource
    public OrganMapper organMapper;

    @Override
    public LoginUser loadUserByUsername(String userName) throws UsernameNotFoundException {
        LoginUser loginUser = new LoginUser();
        User user = userMapper.loadUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        //设置当前用户
        loginUser.setUser(user);
        //设置当前用户机构信息
        loginUser.setOrgan(organMapper.queryById(user.getOrganId()));
        // 获取当前用户拥有的角色
        List<Role> roles = userMapper.getUserRolesById(user.getUserId());
        loginUser.setRoles(roles);
        // 获取当前用户拥有的操作权限
        Set<String> perms = menuMapper.getMenuPermsByUserId(user.getUserId());
        loginUser.setPermissions(perms);
        return loginUser;
    }
}
