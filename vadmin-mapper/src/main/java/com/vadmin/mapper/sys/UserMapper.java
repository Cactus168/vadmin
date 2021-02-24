package com.vadmin.mapper.sys;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.model.sys.Role;
import com.vadmin.model.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User,Long> {

    /**
     *
     * @author Grug
     * @date  2020/7/31 11:30
     * @param username
     * @return com.vadmin.model.sys.User
     */
    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Long userId);

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
    int resetUserPwd(@Param("userName") String userName, @Param("password") String password);
}
