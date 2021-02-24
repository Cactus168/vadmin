package com.vadmin.controller.sys;

import com.vadmin.common.annotation.Log;
import com.vadmin.controller.BaseController;
import com.vadmin.model.Rs;
import com.vadmin.model.sys.Dict;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.DictService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * DictController
 *
 * @auther: Grug
 * @date: 2020/8/16 15:34
 */

@RestController
@RequestMapping("sys/dict")
@Log(moduleName = "数据字典")
public class DictController extends BaseController<Dict, Long> {

    @Resource
    public DictService dictService;

    /**
     * 根据字典类型获取字段数据
     * @author Grug
     * @date  2020/7/31 10:15
     * @param dictType
     * @return com.vadmin.model.Rs
     */
    @GetMapping("/type/{dictType}")
    public Rs getDicts(@PathVariable String dictType){
        Dict dict = new Dict();
        dict.setDictNo(dictType);
        List<Dict> dicts = this.dictService.queryByList(dict).getList();
        if(dicts.size() > 0){
            return Rs.success(dicts.get(0).getDictDatas());
        }
        return Rs.success();
    }

    @Override
    protected BaseService<Dict, Long> service() {
        return this.dictService;
    }
}
