package com.vadmin.controller.sys;

import com.vadmin.common.annotation.Log;
import com.vadmin.controller.BaseController;
import com.vadmin.model.LoginUser;
import com.vadmin.model.Rs;
import com.vadmin.model.sys.Role;
import com.vadmin.model.sys.User;
import com.vadmin.security.SecurityUtils;
import com.vadmin.service.TokenService;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户管理Controller
 * @Auther: Grug
 * @Date: 2020/7/31 17:30
 */
@RestController
@RequestMapping("sys/user")
@Log(moduleName = "用户管理")
@Api(tags = {"用户操作接口"}, description = "userController")
public class UserController extends BaseController<User, Long> {

    @Value("${vadmin.initPassword}")
    public String initPassword;

    @Resource
    public UserService userService;

    @Resource
    public TokenService tokenService;

    @Resource
    public PasswordEncoder passwordEncoder;

    @Override
    protected void afterQueryById(Long id, Rs rs) {
        rs.put("roleIds", this.userService.getRoleIdsByUserId(id));
    }

    @Override
    protected void beforeAdd(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    /**
     * 获取初始密码
     * @author Grug
     * @date  2020/7/31 10:19
     * @return Model
     */
    @GetMapping("/pw")
    @ApiOperation(value = "获取初始密码", notes = "获取初始密码")
    public Rs getPw(){
        return Rs.success("",initPassword);
    }

    /**
     * 获取当前用户相关信息
     * @author Grug
     * @date  2020/7/31 10:15
     * @return com.vadmin.model.Rs
     */
    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取当前用户相关信息", notes = "获取当前用户相关信息")
    public Rs getUserInfo(){
        LoginUser loginUser = getLoginUser();
        Rs rs = Rs.success(loginUser.getUser());
        StringBuilder sb = new StringBuilder();
        for(Role role : loginUser.getRoles()){
            sb.append(role.getRoleName());
            sb.append("/");
        }
        rs.put("organName",loginUser.getOrgan().getOrganName());
        rs.put("roleGroup",sb.delete(sb.length()-1,sb.length()).toString());
        return rs;
    }

    /**
     * 重置密码
     */
    @Log(operateType= "修改密码")
    @PutMapping("/updatePwd")
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "oldPassword", value = "原始密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public Rs updatePwd(String oldPassword, String newPassword) {
        LoginUser loginUser = getLoginUser();
        String userName = loginUser.getUsername();
        String password = loginUser.getPassword();
        if (!SecurityUtils.matchesPassword(oldPassword, password)) {
            return Rs.error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password)) {
            return Rs.error("新密码不能与旧密码相同");
        }
        if (userService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)) > 0) {
            // 更新缓存用户密码
            loginUser.getUser().setPassword(SecurityUtils.encryptPassword(newPassword));
            tokenService.setLoginUser(loginUser);
            return Rs.success();
        }
        return Rs.error("修改密码异常，请联系管理员");
    }


    @Override
    protected BaseService<User, Long> service() {
        return this.userService;
    }
}
