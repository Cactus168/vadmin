package com.vadmin.service.base;
import com.github.pagehelper.PageInfo;
import com.vadmin.model.BaseModel;
import java.io.Serializable;
import java.util.List;

/**
 * BaseService
 * @Auther: Grug
 * @Date: 2020/7/31 09:56
 */
public interface BaseService<Model extends BaseModel,Id extends Serializable> {


    /**
     * 增加数据
     * @author Grug
     * @date  2020/7/31 9:50
     * @param model
     * @return int
     */
    int add(Model model);

    /**
     * 批量增加数据
     * @author Grug
     * @date  2020/7/31 9:50
     * @param models
     * @return int
     */
    int addList(List<Model> models);

    /**
     * 删除数据
     * @author Grug
     * @date  2020/7/31 9:51
     * @param ids
     * @return int
     */
    int remove(Id[] ids);

    /**
     * 修改数据
     * @author Grug
     * @date  2020/7/31 9:51
     * @param model
     * @return int
     */
    int modify(Model model);

    /**
     * 根据id获取对象
     * @author Grug
     * @date  2020/7/31 9:51
     * @param id
     * @return Model
     */
    Model queryById(Id id);

    /**
     * 模糊获取数据
     * @author Grug
     * @date  2020/7/31 10:09
     * @param model
     * @return com.github.pagehelper.PageInfo<Model>
     */
    PageInfo<Model> queryByList(Model model);

}
