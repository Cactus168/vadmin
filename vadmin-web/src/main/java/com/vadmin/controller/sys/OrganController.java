package com.vadmin.controller.sys;

import com.vadmin.common.annotation.Log;
import com.vadmin.controller.BaseController;
import com.vadmin.model.sys.Organ;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.OrganService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * OrganController
 *
 * @auther: Grug
 * @date: 2020/8/14 16:09
 */
@RestController
@RequestMapping("sys/organ")
@Log(moduleName = "组织机构")
public class OrganController extends BaseController<Organ, Long> {

    @Resource
    public OrganService organService;

    @Override
    protected BaseService<Organ, Long> service() {
        return this.organService;
    }
}
