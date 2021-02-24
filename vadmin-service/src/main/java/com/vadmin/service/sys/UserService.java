package com.vadmin.service.sys;

import com.vadmin.model.sys.User;
import com.vadmin.service.base.BaseService;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    /**
     * 给用户分配角色权限
     * @author Grug
     * @date  2020/8/13 16:10
     * @param user
     * @return int
     */
    int addUserRoleIds(User user);

    /**
     * 根据用户id删除角色权限
     * @author Grug
     * @date  2020/8/13 16:11
     * @param userId
     * @return int
     */
    int removeORolesByUserId(Long userId);

    /**
     * 根据用户id获取该用户拥有的角色权限id
     * @author Grug
     * @date  2020/8/13 16:12
     * @param userId
     * @return java.util.List<java.lang.Long>
     */
    List<Long> getRoleIdsByUserId(Long userId);

    /**
     * 修改用户密码
     * @author Grug
     * @date  2020/9/7 16:53
     * @param userName
     * @param password
     * @return int
     */
    int resetUserPwd(String userName, String password);
}
