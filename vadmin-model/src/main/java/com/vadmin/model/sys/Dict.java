package com.vadmin.model.sys;

import com.vadmin.model.BaseModel;

import java.util.List;

/**
 * Dict
 *
 * @auther: Grug
 * @date: 2020/8/16 15:17
 */
public class Dict extends BaseModel {

    private Long dictId;

    private Long parentId;

    private String dictNo;

    private String dictName;

    private String dictKey;

    private String dictLabel;

    private Integer orderNum;

    private String status;

    private String remark;

    private List<Dict> dictDatas;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDictNo() {
        return dictNo;
    }

    public void setDictNo(String dictNo) {
        this.dictNo = dictNo;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Dict> getDictDatas() {
        return dictDatas;
    }

    public void setDictDatas(List<Dict> dictDatas) {
        this.dictDatas = dictDatas;
    }
}
