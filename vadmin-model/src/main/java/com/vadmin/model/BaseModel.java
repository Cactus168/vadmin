package com.vadmin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vadmin.common.utils.StringUtils;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * model 基类
 */
public class BaseModel implements Serializable {

    /** 当前记录起始索引 */
    @ApiModelProperty(value = "当前记录起始索引")
    private Integer pageNum;

    /** 每页显示记录数 */
    @ApiModelProperty(value = "每页显示记录数")
    private Integer pageSize;

    /** 排序列 */
    @ApiModelProperty(value = "排序列")
    private String sort;

    /** 排序的方向 "desc" 或者 "asc". */
    @ApiModelProperty(value = "排序的方向 desc 或者 asc")
    private String isAsc;

    /** 创建者 */
    @ApiModelProperty(value = "创建者")
    private String creator;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /** 更新者 */
    @ApiModelProperty(value = "更新者")
    private String modify;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date modifyDate;

    /** 开始时间 */
    @JsonIgnore
    @ApiModelProperty(value = "开始时间")
    private String beginTime;

    /** 结束时间 */
    @JsonIgnore
    @ApiModelProperty(value = "结束时间")
    private String endTime;

    /** 请求参数 */
    @ApiModelProperty(value = "请求参数")
    private Map<String, Object> params;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @JsonIgnore
    public String getOrderBy()
    {
        if (StringUtils.isEmpty(sort))
        {
            return "";
        }
        return sort + " " + isAsc;
    }
}
