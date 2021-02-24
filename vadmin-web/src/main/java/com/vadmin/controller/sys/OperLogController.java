package com.vadmin.controller.sys;

import com.vadmin.controller.BaseController;
import com.vadmin.model.sys.OperLog;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.OperLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * OperLogController
 *
 * @auther: Grug
 * @date: 2020/8/20 10:59
 */
@RestController
@RequestMapping("sys/log/oper")
public class OperLogController extends BaseController<OperLog, Long> {

    @Resource
    public OperLogService operLogService;

    @Override
    protected BaseService<OperLog, Long> service() {
        return this.operLogService;
    }
}
