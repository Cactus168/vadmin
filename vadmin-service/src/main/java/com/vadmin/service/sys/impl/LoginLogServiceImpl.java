package com.vadmin.service.sys.impl;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.mapper.sys.LoginLogMapper;
import com.vadmin.model.sys.LoginLog;
import com.vadmin.service.base.BaseServiceImpl;
import com.vadmin.service.sys.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * LoginLogServiceImpl
 *
 * @auther: Grug
 * @date: 2020/8/20 10:54
 */
@Service("loginLogService")
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, Long> implements LoginLogService {

    @Resource
    public LoginLogMapper loginLogMapper;

    @Override
    public BaseMapper<LoginLog, Long> mapper() {
        return this.loginLogMapper;
    }
}
