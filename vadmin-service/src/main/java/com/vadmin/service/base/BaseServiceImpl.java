package com.vadmin.service.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vadmin.common.utils.StringUtils;
import com.vadmin.mapper.BaseMapper;
import com.vadmin.model.BaseModel;
import com.vadmin.service.base.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService 实现类基类
 * @Auther: Grug
 * @Date: 2020/7/31 09:58
 */
public abstract class BaseServiceImpl<Model extends BaseModel,Id extends Serializable> implements BaseService<Model,Id> {

    /**
     * 增加数据
     * @author Grug
     * @date  2020/7/31 9:50
     * @param model
     * @return int
     */
    @Override
    public int add(Model model){
        return this.mapper().add(model);
    }

    /**
     * 批量增加数据
     * @author Grug
     * @date  2020/7/31 9:50
     * @param models
     * @return int
     */
    @Override
    public int addList(List<Model> models){
        return this.mapper().addList(models);
    }

    /**
     * 删除数据
     * @author Grug
     * @date  2020/7/31 9:51
     * @param ids
     * @return int
     */
    @Override
    public int remove(Id[] ids){
        return this.mapper().remove(ids);
    }

    /**
     * 修改数据
     * @author Grug
     * @date  2020/7/31 9:51
     * @param model
     * @return int
     */
    @Override
    public int modify(Model model){
        return this.mapper().modify(model);
    }

    /**
     * 根据id获取对象
     * @author Grug
     * @date  2020/7/31 9:51
     * @param id
     * @return Model
     */
    @Override
    public Model queryById(Id id){
        return this.mapper().queryById(id);
    }

    /**
     * 模糊获取数据
     * @author Grug
     * @date  2020/7/31 10:09
     * @param model
     * @return com.github.pagehelper.PageInfo<Model>
     */
    @Override
    public PageInfo<Model> queryByList(Model model) {
        if (StringUtils.isNotNull(model.getPageNum()) && StringUtils.isNotNull(model.getPageSize())) {
            PageHelper.startPage(model.getPageNum(), model.getPageSize());
            PageHelper.orderBy(model.getOrderBy());
        }
        return new PageInfo(this.mapper().queryByList(model));
    }

    /**
     * 获取mapper类
     * @author Grug
     * @date  2020/7/31 10:08
     * @param
     * @return com.vadmin.common.base.mapper.BaseMapper<Model,Id>
     */
    public abstract BaseMapper<Model,Id> mapper();
}
