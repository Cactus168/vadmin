package com.vadmin.service.sys.impl;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.mapper.sys.OrganMapper;
import com.vadmin.model.sys.Organ;
import com.vadmin.service.base.BaseServiceImpl;
import com.vadmin.service.sys.OrganService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * OrganServiceImpl
 *
 * @auther: Grug
 * @date: 2020/8/14 16:07
 */
@Service("organService")
public class OrganServiceImpl extends BaseServiceImpl<Organ, Long> implements OrganService {

    @Resource
    private OrganMapper organMapper;

    @Override
    public BaseMapper<Organ, Long> mapper() {
        return this.organMapper;
    }
}
