package com.vadmin.service.sys.impl;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.mapper.sys.OperLogMapper;
import com.vadmin.model.sys.OperLog;
import com.vadmin.service.base.BaseServiceImpl;
import com.vadmin.service.sys.OperLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * OperLogServiceImpl
 *
 * @auther: Grug
 * @date: 2020/8/20 09:18
 */
@Service("operLogService")
public class OperLogServiceImpl extends BaseServiceImpl<OperLog, Long> implements OperLogService {

    @Resource
    public OperLogMapper operLogMapper;

    @Override
    public BaseMapper<OperLog, Long> mapper() {
        return this.operLogMapper;
    }
}
