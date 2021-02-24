package com.vadmin.service.sys.impl;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.mapper.sys.UserMapper;
import com.vadmin.model.sys.User;
import com.vadmin.service.base.BaseServiceImpl;
import com.vadmin.service.sys.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserServiceImpl
 * @Auther: Grug
 * @Date: 2020/7/31 11:19
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    @Resource
    public UserMapper userMapper;

    /**
     * 重写添加方法
     * @author Grug
     * @date  2020/8/18 15:51
     * @param user
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(User user) {
        int rows = this.userMapper.add(user);
        this.userMapper.addUserRoleIds(user);
        return rows;
    }

    /**
     * 重写修改方法
     * @author Grug
     * @date  2020/8/18 15:51
     * @param user
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int modify(User user) {
        if(user.getRoleIds() != null){
            this.userMapper.removeORolesByUserId(user.getUserId());
            this.userMapper.addUserRoleIds(user);
        }
        return this.userMapper.modify(user);
    }

    /**
     * 给用户分配角色权限
     * @author Grug
     * @date  2020/8/13 16:10
     * @param user
     * @return int
     */
    @Override
    public int addUserRoleIds(User user){
        return this.userMapper.addUserRoleIds(user);
    }

    /**
     * 根据用户id删除角色权限
     * @author Grug
     * @date  2020/8/13 16:11
     * @param userId
     * @return int
     */
    @Override
    public int removeORolesByUserId(Long userId){
        return this.userMapper.removeORolesByUserId(userId);
    }

    /**
     * 根据用户id获取该用户拥有的角色权限id
     * @author Grug
     * @date  2020/8/13 16:12
     * @param userId
     * @return java.util.List<java.lang.Long>
     */
    @Override
    public List<Long> getRoleIdsByUserId(Long userId){
        return this.userMapper.getRoleIdsByUserId(userId);
    }

    /**
     * 修改用户密码
     * @author Grug
     * @date  2020/9/7 16:53
     * @param userName
     * @param password
     * @return int
     */
    @Override
    public int resetUserPwd(String userName, String password){
        return this.userMapper.resetUserPwd(userName, password);
    }

    @Override
    public BaseMapper<User, Long> mapper() {
        return this.userMapper;
    }
}