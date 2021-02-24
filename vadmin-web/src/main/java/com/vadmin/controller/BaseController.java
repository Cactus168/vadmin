package com.vadmin.controller;
import com.vadmin.common.annotation.Log;
import com.vadmin.common.utils.DateUtils;
import com.vadmin.model.BaseModel;
import com.vadmin.model.LoginUser;
import com.vadmin.model.Rs;
import com.vadmin.model.sys.User;
import com.vadmin.security.SecurityUtils;
import com.vadmin.service.base.BaseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/**
 * Controller 基类
 * @author Grug
 * @date  2020/7/31 10:10
 */
public abstract class BaseController<Model extends BaseModel,Id extends Serializable> {

    /**
     * 在将要返回列表数据前执行此方法
     * @author Grug
     * @date  2020/7/31 10:15
     * @param model
     * @return void
     */
    protected void beforeList(Model model){}

    /**
     * 获取数据列表
     * @author Grug
     * @date  2020/7/31 10:15
     * @param model
     * @return com.vadmin.model.Rs
     */
    @GetMapping("/")
//    @ApiOperation("模糊查询数据")
    public Rs list(Model model){
        this.beforeList(model);
        Rs rs = Rs.success().tableData(this.service().queryByList(model));
        this.afterList(model, rs);
        return rs;
    }

    /**
     * 在将要返回列表数据前执行此方法
     * @author Grug
     * @date  2020/7/31 10:15
     * @param model
     * @param rs
     * @return void
     */
    protected void afterList(Model model, Rs rs){}

    /**
     * 在将要返回数据前执行此方法
     * @author Grug
     * @date  2020/7/31 10:15
     * @param id
     * @return void
     */
    protected void beforeQueryById(Id id){}

    /**
     * 获取数据
     * @author Grug
     * @date  2020/7/31 10:19
     * @param id
     * @return Model
     */
    @GetMapping("/{id}")
//    @ApiOperation("查询某条数据")
    public Rs queryById(@PathVariable("id") Id id){
        this.beforeQueryById(id);
        Rs rs = Rs.success(this.service().queryById(id));
        this.afterQueryById(id, rs);
        return rs;
    }

    /**
     * 在将要返回数据后执行此方法
     * @author Grug
     * @date  2020/7/31 10:15
     * @param id
     * @param rs
     * @return void
     */
    protected void afterQueryById(Id id, Rs rs){}

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:20
     * @param model
     * @return void
     */
    protected void beforeAdd(Model model){};

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:21
     * @param model
     * @return com.vadmin.model.Rs
     */
    @PostMapping("/")
    @Log(operateType = "添加")
//    @ApiOperation("添加数据")
    public Rs add(@Validated @RequestBody Model model){
        model.setCreator(getUser().getRealName());
        model.setCreateDate(DateUtils.getNowDate());
        this.beforeAdd(model);
        Rs rs = Rs.success(this.service().add(model));
        this.afterAdd(model, rs);
        return rs;
    }

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:24
     * @param model
     * @param rs
     * @return void
     */
    protected void afterAdd(Model model, Rs rs) {};

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:25
     * @param model
     * @return void
     */
    protected void beforeModify(Model model) {};

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:25
     * @param model
     * @return com.vadmin.model.Rs
     */
    @PutMapping("/")
    @Log(operateType = "修改")
//    @ApiOperation("修改数据")
    public Rs modify(@Validated @RequestBody Model model) {
        model.setModify(getUser().getRealName());
        model.setModifyDate(DateUtils.getNowDate());
        this.beforeModify(model);
        Rs rs = Rs.success(this.service().modify(model));
        this.afterModify(model, rs);
        return rs;
    }

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:28
     * @param model
     * @param rs
     * @return void
     */
    protected void afterModify(Model model, Rs rs){};

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:29
     * @param ids
     * @return void
     */
    protected void beforeRemove(Id[] ids) {};

    /**
     * 在将要执行跳转前执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:30
     * @param ids
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @DeleteMapping("/{ids}")
    @Log(operateType = "删除")
//    @ApiOperation("删除数据")
    public Map<String, Object> remove(@PathVariable Id[] ids) {
        this.beforeRemove(ids);
        Rs rs = Rs.success(this.service().remove(ids));
        this.afterRemove(ids, rs);
        return rs;
    }

    /**
     * 在将要执行删除执行方法
     * 该方法主要是为了方便初始化一下参数
     * @author Grug
     * @date  2020/7/31 10:33
     * @param ids
     * @param rs
     * @return void
     */
    protected void afterRemove(Id[] ids, Rs rs) {};

    /**
     * 获取当前用户id
     * @author Grug
     * @date  2020/7/30 17:26
     * @param
     * @return java.lang.Long
     */
    protected Long getUserId() {
        return getUser().getUserId();
    }

    /**
     * 获取当前用户
     * @author Grug
     * @date  2020/7/30 17:26
     * @param 
     * @return User
     */
    protected User getUser() {
        LoginUser loginUser = (LoginUser) SecurityUtils.getLoginUser();
        return loginUser.getUser();
    }

    /**
     * 获取当前登录用户
     * @author Grug
     * @date  2020/7/30 17:26
     * @param
     * @return User
     */
    protected LoginUser getLoginUser() {
        return (LoginUser) SecurityUtils.getLoginUser();
    }
    
    /**
     * 获取service类
     * @author Grug
     * @date  2020/7/30 17:18
     * @param 
     * @return com.vadmin.common.base.BaseService<Model,Id>
     */
    protected abstract BaseService<Model,Id> service();
}
