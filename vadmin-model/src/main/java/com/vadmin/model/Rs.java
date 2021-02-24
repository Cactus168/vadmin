package com.vadmin.model;

import com.github.pagehelper.PageInfo;
import com.vadmin.common.constant.HttpStatus;
import com.vadmin.common.utils.StringUtils;

import java.util.HashMap;

/**
 * 返回数据
 */
public class Rs extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /** 列表总记录数 */
    private static final String TOTAL_TAG = "total";

    /** 列表数据 */
    private static final String ROWS_TAG = "rows";

    /**
     * 初始化一个新创建的 Rs 对象，使其表示一个空消息。
     */
    public Rs(){}

    /**
     * 初始化一个新创建的 Rs 对象
     * @param code 状态码
     * @param msg 返回内容
     */
    public Rs(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 Rs 对象
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public Rs(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 加入分页列表数据
     * @param pageInfo 分页列表数据
     * @return 成功消息
     */
    public Rs tableData(PageInfo pageInfo){
        super.put(ROWS_TAG, pageInfo.getList());
        super.put(TOTAL_TAG, pageInfo.getTotal());
        return this;
    }

    /**
     * 重置code
     * @author Grug
     * @date  2020/7/31 11:38
     * @param code
     * @return com.vadmin.model.Rs
     */
    public Rs setCode(String code){
        super.put(CODE_TAG, code);
        return this;
    }

    /**
     * 重置msg
     * @author Grug
     * @date  2020/7/31 11:38
     * @param msg
     * @return com.vadmin.model.Rs
     */
    public Rs setMsg(String msg){
        super.put(MSG_TAG, msg);
        return this;
    }
    /**
     * 重置data
     * @author Grug
     * @date  2020/7/31 11:38
     * @param data
     * @return com.vadmin.model.Rs
     */
    public Rs setData(Object data){
        super.put(DATA_TAG, data);
        return this;
    }

    /**
     * 返回成功消息
     * @return 成功消息
     */
    public static Rs success() {
        return Rs.success("操作成功");
    }

    /**
     * 返回成功数据
     * @return 成功消息
     */
    public static Rs success(Object data) {
        return Rs.success("操作成功", data);
    }

    /**
     * 返回成功消息
     * @param msg 返回内容
     * @return 成功消息
     */
    public static Rs success(String msg) {
        return Rs.success(msg, null);
    }

    /**
     * 返回成功消息
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static Rs success(String msg, Object data) {
        return new Rs(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     * @return
     */
    public static Rs error() {
        return Rs.error("操作失败");
    }

    /**
     * 返回错误消息
     * @param msg 返回内容
     * @return 警告消息
     */
    public static Rs error(String msg) {
        return Rs.error(msg, null);
    }

    /**
     * 返回错误消息
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static Rs error(String msg, Object data) {
        return new Rs(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static Rs error(int code, String msg) {
        return new Rs(code, msg, null);
    }
}
