package com.vadmin.service.sys.impl;

import com.vadmin.mapper.BaseMapper;
import com.vadmin.mapper.sys.DictMapper;
import com.vadmin.model.sys.Dict;
import com.vadmin.service.base.BaseServiceImpl;
import com.vadmin.service.sys.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * DictServiceImpl
 *
 * @auther: Grug
 * @date: 2020/8/16 15:31
 */
@Service("dictService")
public class DictServiceImpl extends BaseServiceImpl<Dict, Long> implements DictService {

    @Resource
    public DictMapper dictMapper;

    @Override
    public BaseMapper<Dict, Long> mapper() {
        return this.dictMapper;
    }


}
