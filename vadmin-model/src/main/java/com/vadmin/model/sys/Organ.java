package com.vadmin.model.sys;

import com.vadmin.model.BaseModel;

/**
 * Organ
 *
 * @auther: Grug
 * @date: 2020/8/14 16:01
 */
public class Organ extends BaseModel {

    private Long organId;

    private Long parentId;

    private String organNo;

    private String organName;

    private String organContent;

    private String status;

    public Long getOrganId() {
        return organId;
    }

    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getOrganNo() {
        return organNo;
    }

    public void setOrganNo(String organNo) {
        this.organNo = organNo;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganContent() {
        return organContent;
    }

    public void setOrganContent(String organContent) {
        this.organContent = organContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
