package com.vadmin.controller.sys;

import com.vadmin.controller.BaseController;
import com.vadmin.model.sys.LoginLog;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.LoginLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * LoginLogController
 *
 * @auther: Grug
 * @date: 2020/8/20 10:57
 */
@RestController
@RequestMapping("sys/log/login")
public class LoginLogController extends BaseController<LoginLog, Long> {

    @Resource
    public LoginLogService loginLogService;

    @Override
    protected BaseService<LoginLog, Long> service() {
        return this.loginLogService;
    }
}
